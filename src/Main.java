/**
 * Driver for Edmonds algorithm. Makes the test graphs, run the algorithm on them, then gives the results.
 */
public class Main {

	public static void main(String[] args) {
		Edmonds algo = new Edmonds();
		AdjacencyList test2 = makeThirdTestCase();
		AdjacencyList mst = algo.getMinBranching(new Node("r"), test2);
		mst.printReadable();
		int rumortime = algo.getMinTreeRumorTime(mst);
		System.out.print(rumortime);
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
		adjacencies.addEdge(v2, v1, 2); adjacencies.addEdge(v2, v3, 7); adjacencies.addEdge(v2, v7, 7); adjacencies.addEdge(v2, v5, 5); //edges from v2
		adjacencies.addEdge(v3, v4, 5); //edges from v3
		adjacencies.addEdge(v4, v5, 10); adjacencies.addEdge(v4, v10, 2); adjacencies.addEdge(v4, v11, 3); //edges from v4
		adjacencies.addEdge(v5, v6, 6); //edges from v5
		adjacencies.addEdge(v6, v8, 6); adjacencies.addEdge(v6, v9, 10); //edges from v6
		adjacencies.addEdge(v7, v8, 9); adjacencies.addEdge(v7, r, 2); 
		adjacencies.addEdge(v8, v1, 11); adjacencies.addEdge(v8, v9, 9); //edges from v8
		adjacencies.addEdge(v11, v3, 10); adjacencies.addEdge(v11, v10, 4); //edges from v11
		return adjacencies;
	}
		
	//returns second test case, made by us with picture included in report.
	private static AdjacencyList makeSecondTestCase() {
		Node r = new Node("r");
		Node a = new Node("a"); Node b = new Node("b"); Node c = new Node("c"); Node d = new Node("d");
		Node e = new Node("e"); Node f = new Node("f"); Node g = new Node("g"); Node h = new Node("h");
		Node i = new Node("i"); Node j = new Node("j"); Node k = new Node("k"); Node l = new Node("l");
		Node m = new Node("m"); Node n = new Node("n"); Node o = new Node("o"); Node p = new Node("p");
		Node q = new Node("q"); Node s = new Node("s"); Node t = new Node("t");
		AdjacencyList adjacencies = new AdjacencyList();
		adjacencies.addEdge(r, a, 5); adjacencies.addEdge(r, f, 5); adjacencies.addEdge(r, e, 5); //edges from r
		adjacencies.addEdge(a, b, 5); //edges from a
		adjacencies.addEdge(b, c, 5); adjacencies.addEdge(b, r, 15);  //edges from b
		adjacencies.addEdge(c, d, 5); //edges from c
		adjacencies.addEdge(d, i, 5); adjacencies.addEdge(d, b, 15); //edges from d
		adjacencies.addEdge(e, j, 5); adjacencies.addEdge(e, a, 10); //edges from e
		adjacencies.addEdge(f, b, 10); adjacencies.addEdge(f, j, 10); adjacencies.addEdge(f, g, 5); adjacencies.addEdge(f, k, 5); //edges from f
		adjacencies.addEdge(g, c, 10); adjacencies.addEdge(g, h, 5); //edges from g
		adjacencies.addEdge(h, m, 5); adjacencies.addEdge(h, d, 10); //edges from h
		adjacencies.addEdge(i, n, 5); //edges from i
		adjacencies.addEdge(j, o, 5); //edges from j
		adjacencies.addEdge(k, o, 10); adjacencies.addEdge(k, l, 5); //edges from k
		adjacencies.addEdge(l, p, 10); adjacencies.addEdge(l, m, 5); //edges from l
		adjacencies.addEdge(m, q, 10); adjacencies.addEdge(m, i, 10); adjacencies.addEdge(m, t, 5); //edges from m
		adjacencies.addEdge(n, d, 15); adjacencies.addEdge(n, t, 5); //edges from n
		adjacencies.addEdge(o, p, 5); //edges from o
		adjacencies.addEdge(p, q, 5); //edges from p
		adjacencies.addEdge(q, s, 5); //edges from q
		adjacencies.addEdge(s, n, 10); adjacencies.addEdge(s, p, 15); adjacencies.addEdge(s, t, 5); //edges from s
		//edges from t
		return adjacencies;
	}
	
	//returns third test case, made by us with picture included in report. same nodes and edges as test case 2, but edges have different weights
	private static AdjacencyList makeThirdTestCase() {
		Node r = new Node("r");
		Node a = new Node("a"); Node b = new Node("b"); Node c = new Node("c"); Node d = new Node("d");
		Node e = new Node("e"); Node f = new Node("f"); Node g = new Node("g"); Node h = new Node("h");
		Node i = new Node("i"); Node j = new Node("j"); Node k = new Node("k"); Node l = new Node("l");
		Node m = new Node("m"); Node n = new Node("n"); Node o = new Node("o"); Node p = new Node("p");
		Node q = new Node("q"); Node s = new Node("s"); Node t = new Node("t");
		AdjacencyList adjacencies = new AdjacencyList();
		adjacencies.addEdge(r, a, 15); adjacencies.addEdge(r, f, 15); adjacencies.addEdge(r, e, 15); //edges from r
		adjacencies.addEdge(a, b, 15); //edges from a
		adjacencies.addEdge(b, c, 15); adjacencies.addEdge(b, r, 5);  //edges from b
		adjacencies.addEdge(c, d, 15); //edges from c
		adjacencies.addEdge(d, i, 15); adjacencies.addEdge(d, b, 5); //edges from d
		adjacencies.addEdge(e, j, 15); adjacencies.addEdge(e, a, 10); //edges from e
		adjacencies.addEdge(f, b, 10); adjacencies.addEdge(f, j, 10); adjacencies.addEdge(f, g, 15); adjacencies.addEdge(f, k, 15); //edges from f
		adjacencies.addEdge(g, c, 10); adjacencies.addEdge(g, h, 15); //edges from g
		adjacencies.addEdge(h, m, 15); adjacencies.addEdge(h, d, 10); //edges from h
		adjacencies.addEdge(i, n, 15); //edges from i
		adjacencies.addEdge(j, o, 15); //edges from j
		adjacencies.addEdge(k, o, 10); adjacencies.addEdge(k, l, 15); //edges from k
		adjacencies.addEdge(l, p, 10); adjacencies.addEdge(l, m, 15); //edges from l
		adjacencies.addEdge(m, q, 10); adjacencies.addEdge(m, i, 10); adjacencies.addEdge(m, t, 15); //edges from m
		adjacencies.addEdge(n, d, 5); adjacencies.addEdge(n, t, 15); //edges from n
		adjacencies.addEdge(o, p, 15); //edges from o
		adjacencies.addEdge(p, q, 15); //edges from p
		adjacencies.addEdge(q, s, 15); //edges from q
		adjacencies.addEdge(s, n, 10); adjacencies.addEdge(s, p, 5); adjacencies.addEdge(s, t, 15); //edges from s
		//edges from t
		return adjacencies;
	}


}
