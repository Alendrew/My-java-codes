package application;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import model.enums.Type;
import model.exceptions.*;



import javax.swing.JOptionPane;

public class Program {
	static File PROJECTPATH;
	public static void main(String[] args) {
			try {
				PROJECTPATH = new File(JOptionPane.showInputDialog("Enter the project folder: "));
				if(!PROJECTPATH.exists()) {
					throw new InvalidPathException("Invalid Path");
				}
				Type type = Type.valueOf((JOptionPane.showInputDialog("Enter the Type of archive:\n<-SOURCE->\n<-RESULT->")).toUpperCase());
				generate_csv(type);
			}catch(InvalidPathException e) {
				JOptionPane.showMessageDialog(null, "Error: " + e.getMessage());
			}catch(EntryException e) {
				JOptionPane.showMessageDialog(null, "Invalid entry");
			}catch(TypeException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}catch(NullPointerException e) {
				JOptionPane.showMessageDialog(null, "Invalid entry");
			}catch(IllegalArgumentException e) {
				JOptionPane.showMessageDialog(null, "Invalid type");
			}catch(FileException e) {
				JOptionPane.showMessageDialog(null, e.getMessage());
			}
	}
	public static void generate_csv(Type type) {
		if(type == Type.SOURCE) {
			String name = JOptionPane.showInputDialog("Enter the archive name").toUpperCase();
			write(name,PROJECTPATH,register_products());
		}else {
			File newPath = new File(PROJECTPATH + "\\out");
			if(newPath.exists()) {
				deleteFiles(newPath);
				if(newPath.mkdir()) {
					String source = JOptionPane.showInputDialog("Enter the source name").toUpperCase();
					String resultName = JOptionPane.showInputDialog("Enter the result name").toUpperCase();
					write(resultName,newPath,calculate_Total(source));
				}else {
					throw new RuntimeException();
				}
			}else {
				if(newPath.mkdir()) {
					String source = JOptionPane.showInputDialog("Enter the source name").toUpperCase();
					String name = JOptionPane.showInputDialog("Enter the final name").toUpperCase();
					List<String> productsResult = calculate_Total(source);
					write(name,newPath,productsResult);
				}
			}
		}
	}
	public static List<String> calculate_Total(String source){
		List<String> p = new ArrayList<>();
		try(BufferedReader br = new BufferedReader(new FileReader(PROJECTPATH+"\\"+source+".csv"))){
			String[] totals = new String[] {};
			String line;
			line = br.readLine();
			while(line != null) {
				StringBuilder sb = new StringBuilder();
				totals = line.split(";");
				if(totals[1].charAt(0) != 'n') {
					int sum = Integer.parseInt(totals[1])*Integer.parseInt(totals[2]);
					sb.append(totals[0]+";");
					sb.append(sum + System.lineSeparator());
					p.add(sb.toString());
				}
				line = br.readLine();
			}
			return p;
		}catch(IOException e) {
			throw new FileException(e.getMessage());
		}catch(RuntimeException e) {
			throw new InvalidPathException("Invalid Path");
		}
	}
	public static List<String> register_products() {
		List<String> p = new ArrayList<>();
		try{
			int numb = Integer.parseInt(JOptionPane.showInputDialog("How many items?"));
			for(int i = 0; i < numb; i++) {
				StringBuilder sb = new StringBuilder();
				JOptionPane.showMessageDialog(null, "Enter the product #"+(i + 1)+"data:");
				String name = JOptionPane.showInputDialog("Name: ")+";";
				String price = JOptionPane.showInputDialog("Price: ")+";";
				String quantity = JOptionPane.showInputDialog("Quantity: ");
				sb.append(name).append(price).append(quantity);
				sb.append(System.lineSeparator());
				p.add(sb.toString());
			}
			return p;
		}catch(NumberFormatException e) {
			throw new NumberFormatException();
		}
	}
	
	public static void write(String name, File NewPath,List<String> list1) {
		try(BufferedWriter bw = new BufferedWriter(new FileWriter(NewPath + "\\"+name+".csv"))){
			List<String> products = list1;
			for(String p : products) {
				bw.append(p);
			}
		}catch(IOException e) {
			throw new FileException("File Error:" + e.getMessage());
		}catch(RuntimeException e) {
			throw new InvalidPathException("Invalid Path");
		}
	}
	
	public static void deleteFiles(File f) {
		if(f.isDirectory()) {
			File[] files = f.listFiles();
			for (File file : files) {
				deleteFiles(file);
			}
		}
		f.delete();
	}

}
