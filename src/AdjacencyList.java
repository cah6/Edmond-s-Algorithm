import java.util.Map;
import java.util.HashMap;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.Collection;

/**
 * Class making it convenient to store the nodes and edges that make up a graph.
 * 
 * @author christianhenry
 *
 */
public class AdjacencyList {

	//the actual adjacency list, a map from all source nodes to the edges coming out of that source node
   private Map<Node, ArrayList<Edge>> adjacencies = new HashMap<Node, ArrayList<Edge>>();

   /**
    * Add an edge from source to target node with a certain weight.
    */
   public void addEdge(Node source, Node target, int weight) {
       ArrayList<Edge> list;
       //if our adjacency list does not contain the source node,
       if(!adjacencies.containsKey(source)) {
    	   //make a new list and map the source node to it
           list = new ArrayList<Edge>();
           adjacencies.put(source, list);
       }
       //if the adjacency list does have the source node,
       else {
    	   //get the list of edges coming out of the source node
           list = adjacencies.get(source);
       }
       //in any case, add the edge to this source node's list
       list.add(new Edge(source, target, weight));
   }

   /**
    * Get all edges connected to the given node.
    */
   public ArrayList<Edge> getAdjacent(Node source){
       return adjacencies.get(source);
   }

//   public void reverseEdge(Edge e){
//       adjacencies.get(e.from).remove(e);
//       addEdge(e.to, e.from, e.weight);
//   }

//   public void reverseGraph(){
//       adjacencies = getReversedList().adjacencies;
//   }

//   public AdjacencyList getReversedList(){
//       AdjacencyList newlist = new AdjacencyList();
//       for(ArrayList<Edge> edges : adjacencies.values()){
//           for(Edge e : edges){
//               newlist.addEdge(e.to, e.from, e.weight);
//           }
//       }
//       return newlist;
//   }

   public Set<Node> getSourceNodes(){
       return adjacencies.keySet();
   }

   public Collection<Edge> getAllEdges(){
       ArrayList<Edge> edges = new ArrayList<Edge>();
       for(List<Edge> e : adjacencies.values()){
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
}