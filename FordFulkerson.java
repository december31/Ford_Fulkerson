
public class FordFulkerson {

	private FlowEdge[] edgeTo;
	private double maxFlow;
	private boolean[] marked;

	public FordFulkerson(FlowNetwork g, int s, int t) {

		double bottle;
		maxFlow = 0;

		while(hasAugmentingPath(g, s, t)) {
			bottle = Double.POSITIVE_INFINITY;
			for(int v = t; v != s; v = edgeTo[v].other(v)) {
				if(bottle > edgeTo[v].residualCapacityTo(v)) {
					bottle = edgeTo[v].residualCapacityTo(v);
				}
			}

			for(int v = t; v != s; v = edgeTo[v].other(v)) {
				edgeTo[v].addResidualFlowTo(edgeTo[v].other(v), bottle);
			}
			maxFlow += bottle;
		}
		System.out.println(maxFlow);
	}

	public boolean hasAugmentingPath(FlowNetwork g, int s, int t) {
		edgeTo = new FlowEdge[g.numberOfVertex() + 1];
		marked = new boolean[g.numberOfVertex() + 1];

		Queue<Integer> queue = new Queue<>();
		queue.enqueue(s);
		marked[s] = true;
		int v;
		while(!queue.isEmpty()) {
			v = queue.dequeue();
			for (FlowEdge edge : g.adj(v)) {
				int w = edge.other(v);
				if(marked[w] == true) continue;
				if(edge.residualCapacityTo(w) > 0) {
					marked[w] = true;
					edgeTo[w] = edge;
					queue.enqueue(w);
				}
			}
		}
		return marked[t];
	}
	
}