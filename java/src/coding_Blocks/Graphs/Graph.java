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
	
	public boolean containsEdges(String vname1 , String vname2) {
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
	
	public boolean hasPath(String vname1 , String vname2) {
		return hasPath(vname1 , vname2 , vname1 , vname1);
	}
	public boolean hasPath(String vname1 , String vname2 , String jaha_se_aayi , String actual){
		
		Vertex vtx1 = new Vertex();
		vtx1 = vertices.get(vname1);
		Vertex vtx2 = new Vertex();
		vtx2 = vertices.get(vname2);
		
		if(vtx1==null || vtx2==null) return false;
		
		if(vtx1.neighbour.containsKey(vname2)) return true;
	
		ArrayList<String> keys = new ArrayList<>(vtx1.neighbour.keySet());

		boolean result = false;
		for(String key:keys){
			if(key!=jaha_se_aayi && key!=actual)
				result = hasPath(key , vname2 , vname1 , actual);
		}
		
		return result;	
	}

	
	

}