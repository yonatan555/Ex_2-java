package gui;

import javax.swing.JFrame;

import dataStructure.DGraph;
import dataStructure.NodeData;
import utils.Point3D;

public class Main {

	public static void main(String[] args) {
		DGraph temp = new DGraph();

		Point3D m = new Point3D(1, 3, 4);
		Point3D m1 = new Point3D(2, 4, 5);
		Point3D m2 = new Point3D(3, 5, 6);
		Point3D m3 = new Point3D(4, 6, 7);
		Point3D m4 = new Point3D(2, 6, 7);
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

		temp.connect(a.getKey(), b.getKey(), 2);
		temp.connect(b.getKey(), c.getKey(), 2);
		temp.connect(c.getKey(), d.getKey(), 2);
		temp.connect(d.getKey(), e.getKey(), 2);
		
		graph_gui window = new graph_gui(temp);
		
		window.setVisible(true);
	}

}
