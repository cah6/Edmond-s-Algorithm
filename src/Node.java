
/**
 * Class representing a single node on the graph. 
 * 
 * @author christianhenry
 *
 */
public class Node implements Comparable<Node> {
    
	String name; //value given to this node when it is made
    boolean visited = false;
    
    public Node(String argName) {
        name = argName;
    }
    
    public int compareTo(final Node argNode) {
        return argNode == this ? 0 : -1;
    }
 }
