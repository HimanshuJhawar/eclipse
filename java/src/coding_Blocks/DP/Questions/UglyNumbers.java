package coding_Blocks.DP.Questions;

import java.util.*;

public class UglyNumbers {

	public static void main(String[] args) {

		Scanner sc=new Scanner(System.in);
		ArrayList<Long> primeNumbers = new ArrayList<>();
		primeNumbers = PrimeUpto1000000(primeNumbers);

		
		int t=sc.nextInt();
		ArrayList<Integer> al = new ArrayList<>();
		
		for(int i=1 ; i<=t ; i++)
		{
			int n=sc.nextInt();
			int temp=n;
			
			// if we have already solve for (n) in the previous test cases , then we wont solve again
			if(n>al.size())
			{
				
				int start;

				// for i>1
				if(al.size()!=0) start=al.get(al.size()-1) + 1;
				// for i==1
				else start = 1;
				
				// how many more numbers to add
				int size=al.size();
				
				// (start) will start from next number of last checked number
				// temp-size will tell how many more number to add
				for(int j=start ; j < start + (temp-size)  ;  j++)
				{
					boolean condition = IsItInCondition(j , primeNumbers);	
					
					// if number i.e. (j) is in conditions , then add this number
					if(condition)
					{
						al.add(j);
					}
					// else increase limit of (j) so that we can add minimum reqd elements in arraylist
					else
					{
						temp++;
					}
				}
			}
			
			// sysout number
			System.out.println(al.get(n-1));
//			System.out.println(al);
		}
		
		
		
	}
	
	// checking number is acceptable or not
	static boolean IsItInCondition(int number , ArrayList<Long> primeNumbers)
	{
		boolean temp=true;
		for(long i:primeNumbers)
		{
			// if prime number > number , then break
			if(i>number) break;
			
			// if this number is divisible by prime number other than 2,3,5
			// then this number is not acceptable according to questions condition
			if(number%i==0)
				temp=false;
		}
		
		return temp;
	}
	
	// finding all prime numbers upto 10000
	static ArrayList<Long> PrimeUpto1000000(ArrayList<Long> primeNumbers)
	{
		for(long i=1 ; i<=1000000 ; i++)
		{
			boolean prime=true;
			for(int j=2 ; j<=Math.sqrt(i) ; j++)
			{
				if(i%j==0)
				{
					prime=false;
					break;
				}
			}
			
			if(prime)
				primeNumbers.add(i);
		}
		
		// remove 1 from list
		primeNumbers.remove(0);
		// remove 2 from list
		primeNumbers.remove(0);
		// remove 3 from list
		primeNumbers.remove(0);
		// remove 5 from list
		primeNumbers.remove(0);

		return primeNumbers;
	}

}
