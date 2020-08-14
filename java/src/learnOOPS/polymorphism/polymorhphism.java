package learnOOPS.polymorphism;

public class polymorhphism {

	public static void main(String[] args) {

		Dog d = new Dog();
		Pet p = new Pet();
		Animal a = new Animal();
		
		p = d;
		a = d;
		
		d.walk();
		p.walk();
	//	a.walk();
	}

}
