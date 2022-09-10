package application;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

import entities.Mycomparator;
import entities.Product;

public class Program {

	public static int compareProducts(Product p1, Product p2) {
		return p1.getPrice().compareTo(p2.getPrice());
	}
	public static void main(String[] args) {
		List<Product> products = new ArrayList<>();
		products.add(new Product("TV", 1000.00));
		products.add(new Product("MOUSE", 1500.00));
		products.add(new Product("KEYBOARD", 2000.00));
		
		Comparator<Product> c1 = (p1,p2) -> {
			return p1.getPrice().compareTo(p2.getPrice());
		};
		
		products.sort(c1);
		products.sort(Program::compareProducts);
		for(Product p : products) {
			System.out.println(p.priceTag());
		}
		
	}
}
