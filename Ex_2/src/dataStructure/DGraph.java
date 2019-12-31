			package dataStructure;

import java.io.Serializable;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;

import utils.Point3D;

public class DGraph implements graph,Serializable {

	public Hashtable<Integer, node_data> vertex;
	public Hashtable<node_data, Hashtable<Integer, edge_data>> edge;

	static int MC = 0;
	int edgesNum = 0;

	public DGraph() {
		this.edge = new Hashtable<node_data, Hashtable<Integer, edge_data>>();
		this.vertex = new Hashtable<Integer, node_data>();
		MC++;
	}

	@Override
	public node_data getNode(int key) {
		MC++;
		return vertex.get(key);
	}

	@Override
	public edge_data getEdge(int src, int dest) {
		MC++;
		return edge.get(src).get(dest);
	}

	@Override
	public void addNode(node_data n) {
		if(vertex.contains(n.getKey())) throw new RuntimeException("this node allready exist");
		MC++;
		vertex.put(n.getKey(), n);
		edge.put(n, new Hashtable<Integer, edge_data>());
	}

	@Override
	public void connect(int src, int dest, double w) {
		if(src == dest)  throw new RuntimeException("This is the same node");					// if it is the same node 
		if(this.getNode(src) != null && this.getNode(dest) != null) {
			
		Collection<edge_data> i = this.getE(src);
		Iterator<edge_data> it =  i.iterator();
		while(!(i.isEmpty()) && it.hasNext()  ) {        										// check if the edge is exist
		if(it.next().getDest() == dest) throw new RuntimeException("this edge allready exist");
		}
		
		MC++; 
		edgesNum++;
		EdgeData ED = new EdgeData(src, dest, w);
		node_data m = vertex.get(src);
		edge.get(m).put(dest, ED);
	}
		else { 
			throw new RuntimeException("one of the nodes does not exist");
		}
	}

	@Override
	public Collection<node_data> getV() {
		MC++;
		return vertex.values();
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		MC++;
		node_data m = vertex.get(node_id);
		return edge.get(m).values();
	}

	@Override
	public node_data removeNode(int key) {
		
		MC++;
		Collection<node_data> v = getV();				//check if the node is exist and remove it
		Iterator<node_data> ite = v.iterator();
		while (ite.hasNext()) {
			node_data m = ite.next();
			if (edge.get(m).containsKey(key)) {
				edge.get(m).remove(key);
				edgesNum--;
			}
		}
		int counter = edge.get(getNode(key)).size();
		edge.remove(getNode(key));
		edgesNum -= counter;
		return vertex.remove(key);
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		MC++;
		edgesNum--;
		return edge.get(getNode(src)).remove(dest);
	}

	@Override
	public int nodeSize() {
		MC++;
		return this.vertex.size();
	}

	@Override
	public int edgeSize() {
		MC++;
		return edgesNum;
	}

	@Override
	public int getMC() {
		return this.MC;
	}

	public DGraph copy() {
		
		DGraph m = new DGraph();

		Collection<node_data> node = this.getV();
		Iterator<node_data> it = node.iterator();
		while (it.hasNext()) {
			NodeData n = new NodeData();
			n = (NodeData) it.next();
			m.addNode(new NodeData(n.getKey(), n.metadata, n.getTag(),
					new Point3D(n.point.x(), n.point.y(), n.point.z())));
			Collection<edge_data> edge = this.getE(n.getKey());
			Iterator<edge_data> ite = edge.iterator();
			while (ite.hasNext()) {
				EdgeData ed = new EdgeData();
				ed = (EdgeData) ite.next();
				m.connect(n.getKey(), ed.getDest(), ed.getWeight());
			}
		}
		return m;
	}
}