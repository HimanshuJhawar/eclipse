package oops;


class Vehicle
{
	
	int wheels , headlights;
	Vehicle(int noOfWheels)
	{
		wheels = noOfWheels;
		headlights=2;
	}
}


public class MyConstructor 
{

	
	MyConstructor()
	{
	 System.out.println("object is now created");
	}
	
    public static void main(String[] args)
    {

		MyConstructor obj=new MyConstructor();
		
		
		Vehicle car = new Vehicle(4);
		Vehicle scooty = new Vehicle(2);
		System.out.println(car.wheels+" wheels "+scooty.wheels+" wheels");
		
		
	}

}
