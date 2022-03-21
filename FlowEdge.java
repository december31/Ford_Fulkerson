public class FlowEdge {
	private final int v;
	private final int w;
	private final double capacity;
	private double flow;
	public FlowEdge(int v, int w, double capacity) {
		this.v = v;
		this.w = w;
		this.capacity = capacity;
		this.flow = 0;
	}

	public FlowEdge(int v, int w, double capacity, double flow) {
		this.v = v;
		this.w = w;
		this.capacity = capacity;
		this.flow = flow;
	}

	public FlowEdge(FlowEdge flowEdge) {
		this.v = flowEdge.v;
		this.w = flowEdge.w;
		this.capacity = flowEdge.capacity;
		this.flow = flowEdge.flow;
	}

	public int from() {return v;}
	public int to() {return w;}
	public double capacity() {return capacity;}
	public double flow() {return flow;}

	public int other(int vertex) {
		if(vertex == v) return w;
		return v;
	}

	public double residualCapacityTo(int vertex) {
		if(vertex == v) return flow;
		return capacity - flow;
	}

	public void addResidualFlowTo(int vertex, double delta) {
		if(vertex == v) flow += delta;
		else if(vertex == w) flow -= delta;
	}

	@Override
	public String toString() {
		return "FlowEdge [capacity=" + capacity + ", v=" + v + ", w=" + w + "]";
	}

	
}
