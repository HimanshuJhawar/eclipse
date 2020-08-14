package learnOOPS.Inheritance;

public class MainClass {

	public static void main(String[] args) {

		Teacher t = new Teacher();
		t.name="himanshu";
		t.teach();
		t.eat();
		t.walk();
		
		Singer s = new Singer();
		s.name ="keshav";
		s.eat();
		s.walk();
		s.sing();
	}

}
