package coding_Blocks.Heap;
import java.util.*;
public class Heap {

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

	private void downheapify(int pi) {

		int lci=2*pi+1;
		int rci=lci+1;
		
		int index=pi;
		
		if(size()>lci && data.get(lci)<data.get(index))
			index=rci;
		if(size()>rci && data.get(rci)<data.get(index))
			index=lci;
		
		
		if(index!=pi)
		{
			swap(index , pi);
			downheapify(index);
		}
	
	}
	
	
	
	
	
}
