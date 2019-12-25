package algorithms;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Hashtable;
import java.util.Iterator;
import java.util.List;

import javax.swing.GrayFilter;
import javax.swing.text.StyledEditorKit.ItalicAction;
import javax.xml.soap.Node;

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

	public DGraph m;

	@Override
	public void init(graph g) {
		this.m = (DGraph) g;
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
		this.m.getNode(src).setWeight(0);
		Collection<edge_data> edge = this.m.getE(src);
		int count = edge.size();
		Iterator<edge_data> ite = edge.iterator();
		int i = 0;
		edge_data arr[] = new edge_data[count];
		while (ite.hasNext()) {
			edge_data ed = new EdgeData();
			ed = ite.next();
			arr[i] = ed;
			i++;
		}
		Collection<edge_data> ed = this.m.getE(arr[0].getDest());

		return 0;
	}

	@Override
	public List<node_data> shortestPath(int src, int dest) {
		return null;
	}

	@Override
	public List<node_data> TSP(List<Integer> targets) {
		// TODO Auto-generated method stub
		return null;
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
			//	m.edge.get(n).put(ed.getDest(),
				//		new EdgeData(ed.getSrc(), ed.getDest(), ed.getWeight(), ed.getInfo(), ed.getTag()));
				m.connect(n.getKey(), ed.getDest(), ed.getWeight());
			}
		}

		return m;
	}

}
