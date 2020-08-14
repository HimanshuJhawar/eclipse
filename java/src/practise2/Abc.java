package practise2;
import java.math.*;
import java.util.*;
public class Abc {
	
	static int resP=0,resN=0;
	
	public static void main(String[] args) {
     
		ArrayList<Integer> a=new ArrayList<>();
		ArrayList<Integer> b=new ArrayList<>();

		a.add(1);
		a.add(2);
		a.add(4);
		a.add(5);
		
		b.add(2);
		b.add(1);
		b.add(5);
		b.add(4);

		System.out.println(a.equals(b));
	}
		
}
