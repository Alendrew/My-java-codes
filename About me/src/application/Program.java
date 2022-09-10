package application;

import model.entities.Dev;

public class Program {

	public static void main(String[] args) {
		
		System.out.println("👋 Hi, I’m André Alencar(@Alendrew)");
		
        System.out.println("👀 I’m interested in Mobile application development");
        
        System.out.println("📫 How to reach me -> https://www.linkedin.com/in/dev-alencar/");
        
        Dev andre = skills();
        
        System.out.println(andre.toString());
        
	}
	
	public static Dev skills(){
		
        String frontEnd = "HTML, CSS, JavaScript";
        
        String backEnd = "Java, Data Structures in C, MySQL, UML";
        
        return new Dev(frontEnd,backEnd);
        
	}   
	
}
