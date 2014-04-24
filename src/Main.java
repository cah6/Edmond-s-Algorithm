/**
 * Driver for Edmonds algorithm. Makes the test graphs, run the algorithm on them, then gives the results.
 * 
 * @author christianhenry
 *
 */
public class Main {
	
	public static void main(String [] args){
		EdmondsAlgo algo = new EdmondsAlgo();
		
		AdjacencyList test1 = makeExample();
		
		test1.printReadable();
	}
	
	//Example provided in handout.
	private static AdjacencyList makeExample() {
		Node r = new Node("r");
		Node u = new Node("u");
		Node v = new Node("v");
		AdjacencyList adjacencies = new AdjacencyList();
		adjacencies.addEdge(r, u, 3);
		adjacencies.addEdge(r, v, 2);
		adjacencies.addEdge(u, v, 1);
		return adjacencies;
	}
	
	//Test case provided in handout.
	private static AdjacencyList makeFirstTestCase() {
		Node r = new Node("r");
		Node v1 = new Node("v1"); Node v2 = new Node("v2"); Node v3 = new Node("v3");
		Node v4 = new Node("v4"); Node v5 = new Node("v5"); Node v6 = new Node("v6");
		Node v7 = new Node("v7"); Node v8 = new Node("v8"); Node v9 = new Node("v9");
		Node v10 = new Node("v10"); Node v11 = new Node("v11");
		AdjacencyList adjacencies = new AdjacencyList();
		adjacencies.addEdge(r, v1, 4); adjacencies.addEdge(r, v2, 3); adjacencies.addEdge(r, v3, 2); //edges from r
		adjacencies.addEdge(v1, v7, 8); //edges from v1
		adjacencies.addEdge(v2, v7, 7); adjacencies.addEdge(v2, v5, 5); //edges from v2
		adjacencies.addEdge(v3, v4, 5); //edges from v3
		adjacencies.addEdge(v4, v5, 10); adjacencies.addEdge(v4, v10, 2); adjacencies.addEdge(v4, v11, 3); //edges from v4
		adjacencies.addEdge(v5, v6, 6); //edges from v5
		adjacencies.addEdge(v6, v8, 6); adjacencies.addEdge(v6, v9, 10); //edges from v6
		adjacencies.addEdge(r, v5, 2); adjacencies.addEdge(v8, v10, 9); //edges from v7
		adjacencies.addEdge(v8, v1, 11); adjacencies.addEdge(v8, v9, 9); //edges from v8
		adjacencies.addEdge(v11, v3, 10); //edges from v11
		return adjacencies;
	}
}
