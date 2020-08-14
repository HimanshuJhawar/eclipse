package coding_Blocks.cb_Section10_Stacks_OOPS.practise_Stacks_Queues;

import java.util.Scanner;
import java.util.Stack;

public class PlayingWithCards {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int Q=sc.nextInt();
		Stack<Integer> ai_previous=new Stack<>();
		
		int prime[]=new int[Q];
		prime=getPrime(prime,Q);

		for(int i=0 ; i<N ; i++)
			ai_previous.push(sc.nextInt());
		
		for(int i=0 ; i<Q ; i++)
		{
			Stack<Integer> ai=new Stack<>();
			Stack<Integer> bi=new Stack<>();

			while(!ai_previous.isEmpty())
			{
			if(ai_previous.peek()%prime[i]==0)
				bi.push(ai_previous.pop());
			else
				ai.push(ai_previous.pop());
			}
			
			while(!bi.isEmpty())
				System.out.println(bi.pop());
			
			changing_stack(ai_previous , ai);	
		}
		
		while(!ai_previous.isEmpty())
			System.out.println(ai_previous.pop());
	
	}	

		
	static int[] getPrime(int [] prime , int Q)
	{
		prime[0]=2;
		int i=1;
			for(int k=3 ; k<1000000 ; k++)
			{
				boolean check=true;
				for(int j=2 ; j<k ; j++)
				{
					if(k%j==0)
					{
						check=false;
						break;
					}
				}
				
				if(check)
				{
					if(i==Q) break;
					prime[i]=k;
					i++;
				}
			}			
		
		
		return prime;
	}
	
	
	static void changing_stack(Stack<Integer> ai_previous , Stack<Integer> ai)
	{
		if(ai.size()==0) return;
		
		int temp=ai.pop();
		changing_stack(ai_previous , ai);
		ai_previous.push(temp);

	}
	
	
	
	
}
