package dataStructure;

import java.util.Collection;
import java.util.Hashtable;

public class DGraph implements graph{
	Hashtable<Integer,node_data> vertex;
	Hashtable<node_data,Hashtable<Integer, edge_data>> edge;
	public DGraph() {
		this.edge = new Hashtable<node_data, Hashtable<Integer,edge_data>>();
		this.vertex= new Hashtable<Integer, node_data>();
	}

	@Override
	public node_data getNode(int key) {
		return vertex.get(key);
	}

	@Override
	public edge_data getEdge(int src, int dest) {
		return edge.get(src).get(dest);
	}

	@Override
	public void addNode(node_data n) {
		vertex.put(n.getKey(), n);
		edge.put(n, new Hashtable<Integer, edge_data>());
	}

	@Override
	public void connect(int src, int dest, double w) {
		EdgeData ED = new EdgeData(src,dest,w);
		edge.get(getNode(src)).put(dest,ED);
		
	}

	@Override
	public Collection<node_data> getV() {
		return vertex.values();
	}

	@Override
	public Collection<edge_data> getE(int node_id) {
		return edge.get(node_id).values();
	}

	@Override
	public node_data removeNode(int key) {
		edge.get(key).remove(key);
		return vertex.remove(key);
	}

	@Override
	public edge_data removeEdge(int src, int dest) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int nodeSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int edgeSize() {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int getMC() {
		// TODO Auto-generated method stub
		return 0;
	}

}
