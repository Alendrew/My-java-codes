package application;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;

public class Program {

	public static void main(String[] args) {
	
		Locale.setDefault(Locale.US);
		
		List<Integer> l1 = new ArrayList<>();
		l1.add(10);
		l1.add(20);
		l1.add(30);
		l1.add(40);
		
		l1.stream().filter(i -> i > 5).forEach(e -> System.out.print(e + " "));
		

	}

}
