import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class FlowNetwork {
	private int numberOfVertex;
	private int numberOfEdge;
	private Bag<FlowEdge>[] adj;
	
	public FlowNetwork(int numberOfVertex) {
		this.numberOfVertex = numberOfVertex;
		for(int i = 0; i < numberOfVertex; i++) {
			adj[i] = new Bag<>();
		}
	}

	@SuppressWarnings("unchecked")
	public FlowNetwork(String filePath) {
		try {
			Scanner scanner = new Scanner(new File(filePath));
			numberOfVertex = scanner.nextInt();
			numberOfEdge = scanner.nextInt();
			adj = (Bag<FlowEdge>[]) new Bag<?>[numberOfVertex];
			for(int i = 0; i < numberOfVertex; i++) {
				adj[i] = new Bag<>();
			}
			for(int i = 0; i < numberOfEdge; i++) {
				addEdge(new FlowEdge(
					scanner.nextInt(),
					scanner.nextInt(),
					scanner.nextDouble()
				));
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public void addEdge(FlowEdge flowEdge) {
		adj[flowEdge.from()].add(flowEdge);
		adj[flowEdge.to()].add(flowEdge);
	}

	public Iterable<FlowEdge> edges() {
		Bag<FlowEdge> list = new Bag<>();
		for(int v = 0; v < numberOfVertex; v++) {
			for (FlowEdge flowEdge : adj[v]) {
				if(flowEdge.to() != v) {
					list.add(flowEdge);
				}
			}
		}
		return list;
	}

	public Iterable<FlowEdge> adj(int v) {
		return adj[v];
	}

	public int numberOfVertex() {return numberOfVertex;}
	public void setNumberOfVertex(int numberOfVertex) {this.numberOfVertex = numberOfVertex;}
	public int numberOfEdge() {return numberOfEdge;}
	public void setNumberOfEdge(int numberOfEdge) {this.numberOfEdge = numberOfEdge;}
	public Bag<FlowEdge>[] getAdj() {return adj;}
	public void setAdj(Bag<FlowEdge>[] adj) {this.adj = adj;}

}
