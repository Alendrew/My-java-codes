package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.HashSet;
import java.util.Set;

import entities.LogEntry;


public class Program {

	public static void main(String[] args) {
		try(BufferedReader br = new BufferedReader(new FileReader("C:\\Users\\PlayerPlace\\Downloads\\in.txt"))){
			Set<LogEntry> set = new HashSet<>();
			String line = br.readLine();
			while(line != null) {
				String[] fields = line.split(" ");
				set.add(new LogEntry(fields[0],LocalDateTime.parse(fields[1],DateTimeFormatter.ISO_DATE_TIME)));
				line = br.readLine();
			}
			System.out.println("Total users: " + set.size());
		}catch(IOException e) {
			System.out.println("Error: " + e.getMessage());
		}
	}
}
