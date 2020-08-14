package coding_Blocks.cb_Section10_Stacks_OOPS.practise_Stacks_Queues;
import java.util.*;

public class ImportanceOfTime {

	public static void main(String[] args) {

		
		
		Scanner sc=new Scanner(System.in);
		
		Queue<Integer> q=new LinkedList<>();
		
		int N=sc.nextInt();
		int []call=new int[N];
		int []ideal=new int[N];

		for(int i=0 ; i<N ; i++)
		{
			call[i]=sc.nextInt();
		    q.add(call[i]);
		}
		
		for(int i=0 ; i<N ; i++)
			ideal[i]=sc.nextInt();

		int time=0;
		
		for(int i=0 ; i<N ; i++)
		{
			if(q.peek()==ideal[i])
			{
				q.poll();
				time++;
			}
			else
			{
				while(q.peek()!=ideal[i])
				{
					int front=q.poll();
					q.add(front);
					time++;
				}
			}
			
		}
		
		System.out.println(time);
		
		
	}

}
