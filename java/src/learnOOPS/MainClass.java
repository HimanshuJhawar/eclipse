package learnOOPS;

class Cat{
	
	boolean hasFur;
	String color , breed ;
	int legs,eyes;
	
	public void walk(){
		System.out.println("cat is walking");
	}
	
	public void eat() {
		System.out.println("cat is eating");
	}
	
	public void description() {
		System.out.println("cat has "+ legs+" legs and "+eyes+" eyes");
	}
	
}

public class MainClass {

	public static void main(String[] args) {

		
		Cat cat1 = new Cat();
		Cat cat2 = new Cat();
		cat1.walk();
		cat2.eat();
		
		cat1.legs=4;
		cat2.eyes=2;
		cat1.description();
		cat2.description();
		
	}

}
