public class App {
	public static void main(String[] args) throws Exception {
		String filePath = "data2.txt";
		FlowNetwork g = new FlowNetwork(filePath);
		new FordFulkerson(g,0,6);
	}
}
