package learnOOPS;

class Vehicle{
	
	int wheels;
	int headlights;
	
	Vehicle(int noofwheels){
		wheels=noofwheels;
		headlights=2;
	}
	
	Vehicle(int headlights , int wheels){
		this.headlights=headlights;
		this.wheels=wheels;
	}
}

public class MyConstructor {
	
	MyConstructor(){
		System.out.println("object is now ready");
	}
	
	public static void main(String[] args) {
		
		MyConstructor obj= new MyConstructor();
	    
		Vehicle car = new Vehicle(4);
		Vehicle scooty =new Vehicle(2,2);

		System.out.println(scooty.wheels + " wheels and "+ scooty.headlights +" headlights in scooty");
		System.out.println(car.wheels + " wheels and "+ car.headlights +" headlights in car");

	
	}

}
