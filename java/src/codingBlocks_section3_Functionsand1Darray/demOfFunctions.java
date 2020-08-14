package codingBlocks_section3_Functionsand1Darray;

public class demOfFunctions {

	public static int val=100;
	
	public static void main(String[] args) {

		int a=2;
		int b=4;
		
		//function call
		addition(a,b);
		
		
		
		//global scope
		System.out.println("global scope");
		System.out.println(val);
		int val=200;
		System.out.println(val);
		System.out.println(demOfFunctions.val);
		
		
		
	}
	
	//function defination
	public static void addition(int c , int d) {
		int e=c+d;
		System.out.println(e);
		
	}
	

}
