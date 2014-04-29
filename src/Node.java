
/**
 * Class representing a single node on the graph.
 */
public class Node implements Comparable<Node> {
	
	final String name; //value given to this node when it is made
    boolean visited = false;
    
    public Node(final String argName) {
        name = argName;
    }
    
    public int compareTo(final Node argNode) {
        return argNode == this ? 0 : -1;
    }
    
    /**
     * Test equivalence of nodes by their name.
     */
    public boolean equals(Node target){
    	return this.name.equals(target.name);
    }

}
