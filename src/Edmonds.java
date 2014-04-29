import java.util.ArrayList;
import java.util.Iterator;
import java.util.Set;

/**
 * The actual algorithm, encapsulated into it's own class.
 */
public class Edmonds {

	//helper variable that will store nodes that create a cycle
	private ArrayList<Node> cycle;

	/**
	 * Computes the minimum conversation tree from the given root node and adjacency list.
	 * @param root - root node to start conversation at
	 * @param list - pre-made AdjacencyList representing the input graph. Must contain root node.
	 * @return AdjacencyList with only the edges of the minimum conversation tree.
	 */
	public AdjacencyList getMinBranching(Node root, AdjacencyList list){
		AdjacencyList reverse = list.getReversedList();
		// remove all edges entering the root
		if(reverse.getAdjacent(root) != null){
			reverse.getAdjacent(root).clear();
		}
		AdjacencyList outEdges = new AdjacencyList();
		// for each node, select the edge entering it with smallest weight
		Set<Node> nodes = list.getSourceNodeSet();
		//check every node 
		Iterator<Node> it = nodes.iterator();
		while(it.hasNext()){
			Node current = it.next();
			//if it is not the root, select the smallest entering edge 
			//put the smallest entering edge into the new adjacent graph
			if(!current.equals(root)){
				ArrayList<Edge> enteringEdges = list.getSortedEnteringEdge(current);
				if(enteringEdges.size() == 0) continue;
				Edge smallestOne = enteringEdges.get(0);
				outEdges.addEdge(smallestOne.from, smallestOne.to, smallestOne.weight);
			}
		}

		// detect cycles
		ArrayList<ArrayList<Node>> cycles = new ArrayList<ArrayList<Node>>();
		cycle = new ArrayList<Node>();
		getCycle(root, outEdges);
		cycles.add(cycle);
		for(Node n : outEdges.getSourceNodeSet()){
			if(!n.visited){
				cycle = new ArrayList<Node>();
				getCycle(n, outEdges);
				cycles.add(cycle);
			}
		}

		// for each cycle formed, modify the path to merge it into another part of the graph
		AdjacencyList outEdgesReverse = outEdges.getReversedList();

		for(ArrayList<Node> x : cycles){
			if(x.contains(root)) continue;
			mergeCycles(x, list, reverse, outEdges, outEdgesReverse);
		}
		return outEdges;
	}

	/**
	 * Once a cycle is found, merge the nodes containing the cycle into one node, with all internal edges removed and all external edges coming into
	 * the cycle instead coming into the new node.
	 */
	private void mergeCycles(ArrayList<Node> cycle, AdjacencyList list, AdjacencyList reverse, AdjacencyList outEdges, AdjacencyList outEdgesReverse){
		ArrayList<Edge> cycleAllInEdges = new ArrayList<Edge>();
		Edge minInternalEdge = null;
		// find the minimum internal edge weight
		for(Node n : cycle){
			for(Edge e : reverse.getAdjacent(n)){
				if(cycle.contains(e.to)){
					if(minInternalEdge == null || minInternalEdge.weight > e.weight){
						minInternalEdge = e;
						continue;
					}
				}else{
					cycleAllInEdges.add(e);
				}
			}
		}
		// find the incoming edge with minimum modified cost
		Edge minExternalEdge = null;
		int minModifiedWeight = 0;
		for(Edge e : cycleAllInEdges){
			if(minInternalEdge == null) continue;
			if(outEdgesReverse.getAdjacent(e.from).size() == 0 ) continue;
			int w = e.weight - (outEdgesReverse.getAdjacent(e.from).get(0).weight - minInternalEdge.weight);
			if(minExternalEdge == null || minModifiedWeight > w){
				minExternalEdge = e;
				minModifiedWeight = w;
			}
		}
		// add the incoming edge and remove the inner-circuit incoming edge
		Edge removing = null;
		if(minExternalEdge != null){
			removing = outEdgesReverse.getAdjacent(minExternalEdge.from).get(0);
			outEdgesReverse.getAdjacent(minExternalEdge.from).clear();
			outEdgesReverse.addEdge(minExternalEdge.to, minExternalEdge.from, minExternalEdge.weight);
			ArrayList<Edge> adj = outEdges.getAdjacent(removing.to);
			for(Iterator<Edge> i = adj.iterator(); i.hasNext(); ){
				if(i.next().to == removing.from){
					i.remove();
					break;
				}
			}
			outEdges.addEdge(minExternalEdge.to, minExternalEdge.from, minExternalEdge.weight);}
	}

	/**
	 * Given a certain node and AdjacencyList of edges, find all cycles from this node and add those nodes to the
	 * private "cycles" variable.
	 */
	private void getCycle(Node n, AdjacencyList outEdges){
		n.visited = true;
		cycle.add(n);
		if(outEdges.getAdjacent(n) == null) return;
		for(Edge e : outEdges.getAdjacent(n)){
			if(!e.to.visited){
				getCycle(e.to, outEdges);
			}
		}
	}

	/**
	 * Calculate the total rumor time of the input MST.
	 */
	public int getMinTreeRumorTime(AdjacencyList mst){
		int rumortime = 0;
		ArrayList<Edge> mstEdges = (ArrayList<Edge>) mst.getAllEdges();
		for(Edge e : mstEdges){
			rumortime += e.weight;
		}
		return rumortime;
	}
}


