package algorithms;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.swing.GrayFilter;
import javax.swing.text.StyledEditorKit.ItalicAction;

import dataStructure.DGraph;
import dataStructure.EdgeData;
import dataStructure.NodeData;
import dataStructure.edge_data;
import dataStructure.graph;
import dataStructure.node_data;
import utils.Point3D;

/**
 * This empty class represents the set of graph-theory algorithms which should
 * be implemented as part of Ex2 - Do edit this class.
 * 
 * @author
 *
 */
public class Graph_Algo implements graph_algorithms, Serializable {

	public graph m;

	@Override
	public void init(graph g) {
		this.m = g;
	}

	@Override
	public void init(String file_name) { // init from fiile

		Graph_Algo gr = null;

		try {
			FileInputStream file = new FileInputStream(file_name);
			ObjectInputStream in = new ObjectInputStream(file);

			gr = (Graph_Algo) in.readObject();

			in.close();
			file.close();

			System.out.println("Object has been deserialized");
			System.out.println(gr.m);
		} catch (IOException ex) {
			System.out.println("IOException is caught");
		} catch (ClassNotFoundException ex) {
			System.out.println("ClassNotFoundException is caught");
		}
	}

	@Override
	public void save(String file_name) { // save to file

		try {
			FileOutputStream file = new FileOutputStream(file_name);
			ObjectOutputStream out = new ObjectOutputStream(file);

			out.writeObject(this);

			out.close();
			file.close();

			System.out.println("Object has been serialized");
		} catch (IOException ex) {
			System.out.println("IOException is caught");
		}
	}

	@Override
	public boolean isConnected() {
		boolean flag = false;
		boolean flag1 = false;
		Collection<node_data> node = this.m.getV();
		Iterator<node_data> it = node.iterator();
		while (it.hasNext()) {
			flag = false;
			flag1 = false;
			node_data m = it.next();
			Iterator<node_data> it1 = node.iterator();
			while (it1.hasNext()) {
				node_data n = it1.next();
				if (this.m.getE(n.getKey()) == null)
					return false;
				Collection<edge_data> edge = this.m.getE(n.getKey());
				Iterator<edge_data> ited = edge.iterator();
				while (ited.hasNext()) {
					edge_data ed = ited.next();
					if (m.getKey() == ed.getDest())
						flag = true;
					if (m.getKey() == ed.getSrc())
						flag1 = true;
				}
			}
			if (flag == false || flag1 == false)
				return false;
		}

		return flag && flag1;
	}

	@Override
	public double shortestPathDist(int src, int dest) {
		boolean flag = false ;
		boolean flag1 = false;
		Collection<node_data> n = this.m.getV();
		Iterator<node_data> checker = n.iterator();
		Iterator<node_data> checker1 = n.iterator();
		while(checker.hasNext()) {
			if(checker.next().getKey() == src) flag = true;
			if(checker1.next().getKey() == dest) flag1 = true;

		}
		if(flag1 && flag) {
			this.m.getNode(src).setWeight(0);
			Iterator<node_data> ite = n.iterator();
			while(ite.hasNext()) {
				Collection<node_data> node = this.m.getV();
				Iterator<node_data> it = node.iterator();
				while (it.hasNext()) {
					shortestPathDist1(it.next().getKey());
				}
				this.m.getNode(src).setWeight(0);
				ite.next();
			}
			return this.m.getNode(dest).getWeight();
		}
		else {
			System.out.println("src and dest dont exist");
			return 0;
		}
	}

	private void shortestPathDist1(int src) {
		String s="";
		int id=0;
		Collection<edge_data> edge = this.m.getE(src);
		int count = edge.size();
		Iterator<edge_data> ite = edge.iterator();
		int i = 0;
		edge_data arr[] = new edge_data[count];
		while (ite.hasNext()) {
			arr[i] = ite.next();
			i++;
		}
		for (int j = 0; j < arr.length; j++) {
			if(this.m.getNode(arr[j].getDest()).getWeight()>(arr[j].getWeight()+this.m.getNode(arr[j].getSrc()).getWeight())) { 
				this.m.getNode(arr[j].getDest()).setWeight((arr[j].getWeight()+this.m.getNode(arr[j].getSrc()).getWeight()));
				s = "" + (arr[j].getSrc());
				this.m.getNode(arr[j].getDest()).setInfo(s);
			}
		}
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {       //return the list from the end to start
		shortestPathDist(src, dest);
		List<node_data> list = new ArrayList<node_data>();
		int key_node = 0;
		list.add(this.m.getNode(dest));
		node_data n = new NodeData();
		n=this.m.getNode(dest);
		while(n!=this.m.getNode(src)) {
			key_node = Integer.parseInt((n.getInfo()));
			list.add(this.m.getNode(key_node));
			n=this.m.getNode(key_node);		
		}

		return list;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		List<node_data> list = new ArrayList<node_data>();
		Collection<node_data> node = this.m.getV();
		int size = node.size();
		Iterator<node_data> it = node.iterator();
		while(it.hasNext()) {
			if(this.m.getE(it.next().getKey()).size()!=size-1) return null;
		}
		double count=0;
		double min=Double.MAX_VALUE;
		Iterator<Integer> itersrc = targets.iterator();
		edge_data edge = new EdgeData();
		while(itersrc.hasNext()) {
			Collection<edge_data> ed = this.m.getE(itersrc.next());
			Iterator<edge_data> iteed = ed.iterator();
			while(iteed.hasNext()) {
				edge = iteed.next();
				if(targets.contains(edge.getDest())) {
				count+=edge.getWeight();
			}
				if(count<min) {
					min = count;
				}
		}
			count=0;
		}

		return list;
	}

	@Override
	public graph copy() {

		DGraph m = new DGraph();

		Collection<node_data> node = this.m.getV();
		Iterator<node_data> it = node.iterator();
		while (it.hasNext()) {
			NodeData n = new NodeData();
			n = (NodeData) it.next();
			m.addNode(new NodeData(n.getKey(), n.getWeight(), n.metadata, n.getTag(),
					new Point3D(n.point.x(), n.point.y(), n.point.z())));
			Collection<edge_data> edge = this.m.getE(n.getKey());
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
