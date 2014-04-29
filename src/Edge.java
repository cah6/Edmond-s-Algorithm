/**
 * Object representing an edge in the graph.
 */
public class Edge implements Comparable<Edge>{
	
	//Nodes that this edge connects
	final Node from, to;
	//value of this edge
    final int weight;
    
    public Edge(final Node argFrom, final Node argTo, final int argWeight){
        from = argFrom;
        to = argTo;
        weight = argWeight;
    }
    
    public int compareTo(final Edge argEdge){
        return weight - argEdge.weight;
    }

}
