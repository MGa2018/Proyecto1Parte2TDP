package tp1TDP;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.logging.*;

public class Graph {

	private Map<Integer,Integer> nodes;
	private Map<String,Edge> edges;
	private static Logger logger = Logger.getLogger("tpParte2");
	private static ConsoleHandler ch; 
	
	public Graph() {
		this.nodes = new HashMap<Integer,Integer>();
		this.edges = new HashMap<String,Edge>();
		try {
			ch = new ConsoleHandler();
		} catch (SecurityException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//Edge es una clase que encapsula dos enteros para representar un arco
		ch.setLevel(Level.ALL);
		logger.addHandler(ch);
		logger.setLevel(Level.WARNING);
		logger.info("grafo creado");
	}
	
	public void addEdge(int node1, int node2) {
		logger.fine("Preparando para agregar el arco");
		logger.warning("viendo si el nodo1 existe");
		boolean estaN1 = this.nodes.containsKey(node1);
		if (estaN1)
			logger.fine("el nodo1 existe");
		else
			logger.fine("el nodo1 no existe");
		//De acuerdo al valor de estaN1 se sabe si node1 es un nodo que esta en la ED o no
		logger.warning("viendo si el nodo2 existe");
		boolean estaN2 = this.nodes.containsKey(node2);
		if (estaN2)
			logger.fine("el nodo2 existe");
		else
			logger.fine("el nodo2 no existe");
		//De acuerdo al valor de estaN2 se sabe si node1 es un nodo que esta en la ED o no
		Edge value = null;
		String key = node1+","+node2;
		//Considerar los casos en que estaN1 es falso o verdadero y lo mismo para estaN2.
		if (estaN1 && estaN2) {//si estan los dos nodos
			logger.warning("comprobando que el arco no existe");
			if (edges.get(key)==null){//si el arco no existe
				logger.fine("el arco no existe. Se crea el nuevo arco y se agrega al grafo.");
				Edge edge = new Edge(node1,node2);//crea el arco con sus nodos
			    this.edges.put(key,edge);//lo agrega al mapeo de arcos
			    logger.info("arco agregado");
		   }else {
			   logger.fine("el arco ya existe");
			   logger.info("no se agregó el arco al grafo.");
		   }
		}else
			logger.info("No se agregó el arco porque uno de los vertices no existe.");
	}
	
	public void addNode(int node) {
		logger.fine("Preparando para agregar el nodo");
		logger.warning("el nodo puede ya existir.");
		logger.fine("comprobando que el nodo no existe.");
		boolean estaN = this.nodes.containsKey(node);
		if (!estaN)
			logger.fine("el nodo no existe");
		else
			logger.fine("el nodo ya existe");
		if (!estaN) {
			this.nodes.put(node, node);
			logger.info("se agregó el nodo al grafo.");
		}else
			logger.info("no se agregó el nodo al grafo");
	}
	
	public void removeNode(int node) {
		logger.fine("Preparando para remover el nodo");
		logger.warning("el nodo puede no existir.");
		logger.fine("comprobando si existe el nodo en el grafo...");
		boolean estaN = this.nodes.containsKey(node);
		if (estaN) {
			logger.fine("el nodo existe");
			for (String ee : this.edges.keySet()) { 
				if (ee.contains(node+""))//si contiene la cadena del nodo en el key del mapeo de los arcos
					this.edges.remove(ee);//lo remueve
				logger.fine("arcos asociados al nodo ya eliminados.");
			}
			this.nodes.remove(node);//luego elimina el nodo
			logger.info("se eliminó el nodo del grafo.");
			
		}else {
				logger.fine("el nodo no existe");
				logger.info("no se removió el nodo.");
		}
	}
	//para el remove de edges deberian usar el remove de la clase Map que funciona de una manera analoga al put (revisar documentacion)
	// tambien de una forma similar se puede hacer el add y remove de nodes
	
	public void removeEdge(int node1,int node2) {
		logger.fine("Preparando para remover el arco");
		logger.warning("el nodo1 puede no existir.");
		logger.fine("comprobando si existe el nodo1 en el grafo...");
		boolean estaN1 = this.nodes.containsKey(node1);
		if (estaN1)
			logger.fine("el nodo1 existe");
		else
			logger.fine("el nodo1 no existe");
		logger.warning("el nodo2 puede no existir.");
		logger.fine("comprobando si existe el nodo2 en el grafo...");
		boolean estaN2 = this.nodes.containsKey(node2);
		if (estaN2)
			logger.fine("el nodo2 existe");
		else
			logger.fine("el nodo2 no existe");
		if (estaN1 && estaN2) {
			logger.warning("el arco entre los vertices puede no existir.");
			logger.fine("comprobando si existe el arco entre los vertices en el grafo...");
			if((this.edges.get(node1+","+node2))!=null) {
				logger.fine("El arco existe.");
				this.edges.remove(node1+","+node2);
				logger.info("Arco eliminado.");
			}else {
				logger.fine("el arco no existe");
				logger.info("no se removió el arco del grafo.");
			}
		}else
			logger.info("no se removio el arco del grafo porque uno de los vertices no existe");
	}
}
