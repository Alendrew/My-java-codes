package application;

import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class Program {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		Set<Integer> set = new HashSet<>();
		char[] letters = {'A','B','C'};
		for(int i = 0; i < 3; i++) {
			System.out.printf("How many students for course %c?\n",letters[i]);
			int op = sc.nextInt();
			for(int j = 0; j < op; j++) {
				set.add(sc.nextInt());
			}
		}
		System.out.println("Total Students: " + set.size());
		sc.close();
	}
}
