package coding_Blocks.Heap;
import java.util.*;
public class KthDistance {

	public static void main(String[] args) {
		
		Scanner sc=new Scanner(System.in);
		
		KthDistance m = new KthDistance();
		Heap heap = m.new Heap();
		
		int q=sc.nextInt();
		int k=sc.nextInt();
		
		for(int i=1 ; i<=q ; i++)
		{	
			int n=sc.nextInt();
			if(n==1)
			{
				int x=sc.nextInt();
				int y=sc.nextInt();
				int dist=x*x + y*y;
				heap.add(dist);
			}
			else
			{			
				int a[]=new int[k];

				for(int j=0 ; j<k ; j++)
					a[j]=heap.remove();;	
				
				System.out.println(a[k-1]);
				
				for(int j=0 ; j<k ; j++)
					heap.add(a[j]);					
			}
		}
			
		
	}

	private class Heap {

		ArrayList<Integer> data = new ArrayList<>();

		public void add(int item)
		{
			data.add(item);
			upheapify(data.size()-1);
		}


		private void upheapify(int ci) 
		{
			int pi=(ci-1)/2;
			
			if(data.get(ci) < data.get(pi))
			{
				swap(pi , ci);
				upheapify(pi);
			}
		}
		
		private void swap(int i , int j)
		{
			int ith=data.get(i);
			int jth=data.get(j);
			
			data.set(i, jth);
			data.set(j, ith);
		}
		
		public void display()
		{
			System.out.println(data);
		}
		
		public int size()
		{
			return this.data.size();
		}
		
		public boolean isEmpty()
		{
			return this.size()==0;
		}
		
		public int remove()
		{
			if(size()==1)
				return data.remove(0);
			
			swap(0 , data.size()-1);
			int removed=data.remove(data.size()-1);	
			downheapify(0);
			return removed;
		}

		private void downheapify(int pi)
		{

			int lci=2*pi+1;
			int rci=lci+1;
			
			int index=pi;
			
			if(size()>rci && data.get(lci)>data.get(rci))
				index=rci;
			else if(size()>rci && data.get(lci)<data.get(rci))
				index=lci;
			else if(size()>lci)
				index=lci;
			
			
			if(data.get(index)<data.get(pi))
			{
				swap(index , pi);
				upheapify(index);
			}
		
		}
		
   	 }


}

