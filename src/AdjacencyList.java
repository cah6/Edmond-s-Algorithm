import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Class making it convenient to store the nodes and edges that make up a graph.
 */
public class AdjacencyList {

	//the actual adjacency list, a map from all source nodes to the edges coming out of that source node
	private Map<Node, ArrayList<Edge>> adjacencies = new HashMap<Node, ArrayList<Edge>>();

	/**
	 * Add an edge from source to target node with a certain weight.
	 */
	public void addEdge(Node source, Node target, int weight){
		ArrayList<Edge> list;
		if(!adjacencies.containsKey(source)){
			list = new ArrayList<Edge>();
			adjacencies.put(source, list);
		}else{
			list = adjacencies.get(source);
		}
		list.add(new Edge(source, target, weight));
		if(!adjacencies.containsKey(target)) adjacencies.put(target, new ArrayList<Edge>());
	}

	/**
	 * Get all edges connected to the given node.
	 */
	public ArrayList<Edge> getAdjacent(Node source){
		return adjacencies.get(source);
	}

	/**
	 * Reverse a single edge on the graph, swapping the source and destination nodes.
	 */
	public void reverseEdge(Edge e){
		adjacencies.get(e.from).remove(e);
		addEdge(e.to, e.from, e.weight);
	}

	/**
	 * Replace all edges in the graph with their orientations reversed.
	 */
	public void reverseGraph(){
		adjacencies = getReversedList().adjacencies;
	}

	/**
	 * Return a deep copy of the graph's AdjacencyList, with all directed edges going in the opposite direction.
	 */
	public AdjacencyList getReversedList(){
		AdjacencyList newlist = new AdjacencyList();
		for(ArrayList<Edge> edges : adjacencies.values()){
			for(Edge e : edges){
				newlist.addEdge(e.to, e.from, e.weight);
			}
		}
		return newlist;
	}

	/**
	 * Return all nodes that have edges coming out of them in the graph.
	 */
	public Set<Node> getSourceNodeSet(){
		return adjacencies.keySet();
	}

	/**
	 * Get a Collection of all edges in the graph.
	 */
	public Collection<Edge> getAllEdges(){
		ArrayList<Edge> edges = new ArrayList<Edge>();
		for(ArrayList<Edge> e : adjacencies.values()){
			edges.addAll(e);
		}
		return edges;
	}

	/**
	 * Print a readable version of the list, to check results. Follows the format of the first line printed out.
	 */
	public void printReadable() {
		System.out.println("from -> to : weight = x");
		for (Edge e : getAllEdges()) {
			System.out.println(e.from.name + " -> " + e.to.name + " : weight = " + e.weight);
		}
	}

	/**
	 * Get all edges entering To input node.
	 */
	public ArrayList<Edge> getEnteringEdge(Node To){
		ArrayList<Edge> enteringEdges = new ArrayList<Edge>();
		for (Edge e : getAllEdges()) {
			if(e.to.equals(To)) enteringEdges.add(e);
		}
		return enteringEdges;
	}

	/**
	 * Get all edges entering To input node, sorted.
	 */
	public ArrayList<Edge> getSortedEnteringEdge(Node To){
		ArrayList<Edge> sortedEnteringEdges = getEnteringEdge(To);
		Collections.sort(sortedEnteringEdges, new Comparator<Edge>(){
			public int compare(Edge e1, Edge e2) {
				return e1.weight - e2.weight;
			}
		});
		return sortedEnteringEdges;
	}
}
