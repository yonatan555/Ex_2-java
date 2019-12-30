package algorithms;

import java.util.ArrayList;
import java.util.List;

import dataStructure.DGraph;
import dataStructure.NodeData;
import dataStructure.node_data;
import gui.graph_gui;
import utils.Point3D;

public class addaad {
	public static void main(String[] args) {

		graph_algorithms t = new Graph_Algo();

		DGraph temp = new DGraph();

		Point3D m = new Point3D(1, 3, 4);
		Point3D m1 = new Point3D(2, 4, 5);
		Point3D m2 = new Point3D(3, 5, 6);
		Point3D m3 = new Point3D(4, 6, 7);
		Point3D m4 = new Point3D(5, 6, 7);
		// Point3D m5 = new Point3D (6,6,7);

		NodeData a = new NodeData(1, m);
		NodeData b = new NodeData(2, m1);
		NodeData c = new NodeData(3, m2);
		NodeData d = new NodeData(4, m3);
		NodeData e = new NodeData(5, m4);
		// NodeData f = new NodeData(6,2.5,m5);

		temp.addNode(a);
		temp.addNode(b);
		temp.addNode(c);
		temp.addNode(d);
		temp.addNode(e);

		temp.connect(a.getKey(), b.getKey(), 1);
		temp.connect(b.getKey(), c.getKey(), 3);
		temp.connect(c.getKey(), d.getKey(), 3);
		temp.connect(d.getKey(), e.getKey(), 1);
		temp.connect(b.getKey(), d.getKey(), 1);
		temp.connect(c.getKey(), e.getKey(), 2);

		t.init(temp);
		try {
			t.save("eran");
		} catch (Exception e2) {

			System.out.println("joni");
		}

		Graph_Algo jn = new Graph_Algo();
		jn.init("eran");

	}
}
