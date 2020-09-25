package tp1TDP;

public class ejercicioD {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Graph grafo = new Graph();
		grafo.addEdge(2,3);
		grafo.addNode(1);
		grafo.addNode(2);
		grafo.addNode(2);
		grafo.addEdge(1, 2);
		grafo.addEdge(1, 2);
		grafo.removeEdge(1, 2);
		grafo.removeNode(1);
		grafo.removeNode(2);
		grafo.removeEdge(4, 6);
		grafo.removeNode(7);
		
	}

}
