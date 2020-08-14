package coding_Blocks.Graphs;
import java.util.*;
public class Graph {
	
	private class Vertex{
		 HashMap<String , Integer> neighbour = new HashMap<>();
	}
	
	 HashMap<String , Vertex> vertices ;
	
	public Graph(){
		vertices = new HashMap<>();
	}
	
	public int numVertex() {
		return this.vertices.size();
	}
	
	public boolean containsVertex(String check) {
		return this.vertices.containsKey(check);
	}
	
	public void addVertex(String add) {
		Vertex vtx = new Vertex();
		vertices.put(add , vtx);
	}
	
	public void removeVertex(String vname) {
		Vertex vtx = vertices.get(vname);
		ArrayList<String> keys = new ArrayList<>(vtx.neighbour.keySet());
		
		for(String key:keys){
			Vertex neighbourVertex = vertices.get(key);
			neighbourVertex.neighbour.remove(vname);
		}
		
		vertices.remove(vname);
	}

	public int numEdges() {
		int number=0;
		Set<String> keys = vertices.keySet();
		for(String key:keys)
		{
			Vertex calculate = vertices.get(key);
			number+=calculate.neighbour.size();
		}
		
		return number/2;
	}
	
	public boolean containsEdge(String vname1 , String vname2) {
		Vertex vtx1 = vertices.get(vname1);
		Vertex vtx2 = vertices.get(vname2);
		
		if(vtx1==null || vtx2==null || !vtx1.neighbour.containsKey(vname2))
			return false;
		
		return true; 
	}
	
	public void addEdge(String vname1 , String vname2 , int length) {
		Vertex vtx1 = vertices.get(vname1);
		Vertex vtx2 = vertices.get(vname2);
		
		if(vtx1==null || vtx2==null || vtx1.neighbour.containsKey(vname2))
			return;
		
		vtx1.neighbour.put(vname2 , length);
		vtx2.neighbour.put(vname1 , length);
	}
	
	public void removeEdge(String vname1 , String vname2) {
		Vertex vtx1 = vertices.get(vname1);
		Vertex vtx2 = vertices.get(vname2);
		
		if(vtx1==null || vtx2==null || !vtx1.neighbour.containsKey(vname2))
			return;
		
		vtx1.neighbour.remove(vname2);
		vtx2.neighbour.remove(vname1);
	}
	
	public void display() {
		ArrayList<String> keys = new ArrayList<>(vertices.keySet());
		for(String key:keys) {
			Vertex vtx=vertices.get(key);
			System.out.println(key+" : "+vtx.neighbour);
		}
	}

	public boolean hasPath(String vname1 , String vname2 , HashMap<String , Boolean> processed){
		
		
		// processed map is used to check that neighbour of vname1 is already checked or not
		processed.put(vname1 , true);
		
		
		// check if vertex exist or not
		Vertex vtx1 = vertices.get(vname1);
		Vertex vtx2 = vertices.get(vname2);
		if(vtx1==null || vtx2==null) return false;
		
		
		// check if there is direct edge or not
		if(containsEdge(vname1 , vname2)) return true;
	
		
		// go to your neighbour and check their is edge or not 
		ArrayList<String> neighbours = new ArrayList<>(vtx1.neighbour.keySet());
		
		for(String neighbour : neighbours)
		{
			if( !processed.containsKey(neighbour) && hasPath(neighbour , vname2 , processed) ) 
				return true;
		}
		
		return false;	
	}

	
	

}