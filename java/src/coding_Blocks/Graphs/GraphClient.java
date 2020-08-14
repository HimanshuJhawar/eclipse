package coding_Blocks.Graphs;

public class GraphClient {

	public static void main(String[] args) {
		Graph graph = new Graph();
		
		graph.addVertex("A");
		graph.addVertex("B");
		graph.addVertex("C");
		graph.addVertex("D");
		graph.addVertex("E");
		graph.addVertex("F");
		graph.addVertex("G");

		
		graph.addEdge("A" , "B" , 2);
		graph.addEdge("A" , "D" , 3);
		graph.addEdge("C" , "B" , 1);
		graph.addEdge("C" , "D" , 4);
		graph.addEdge("D" , "E" , 6);
		graph.addEdge("E" , "F" , 2);
		graph.addEdge("F" , "G" , 8);
		graph.addEdge("E" , "G" , 9);

//		graph.display();
		System.out.println(graph.hasPath("D" , "E"));

	}

}
