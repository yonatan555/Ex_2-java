package dataStructure;

import gui.graph_gui;
import algorithms.Graph_Algo;
import algorithms.graph_algorithms;
import gui.graph_gui;
import utils.Point3D;

public class main {
	public static void main(String[] args) {

		graph_algorithms t = new Graph_Algo();
		DGraph h = new DGraph();
		DGraph temp = new DGraph();
		
		
		

		Point3D m = new Point3D(1, 3, 4);
		Point3D m1 = new Point3D(2, 4, 5);
		Point3D m2 = new Point3D(3, 5, 6);
		Point3D m3 = new Point3D(4, 6, 7);
		Point3D m4 = new Point3D(2, 6, 7);
		// Point3D m5 = new Point3D (6,6,7);

		NodeData a = new NodeData(1, 2.2, m);
		NodeData b = new NodeData(2, 2.5, m1);
		NodeData c = new NodeData(3, 2.5, m2);
		NodeData d = new NodeData(4, 2.5, m3);
		NodeData e = new NodeData(5, 2.5, m4);
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
		
		h = temp.copy();
		
		t.init(h);
		graph_gui grap = new  graph_gui (h);
		

////		t.  = new DGraph();
////		Graph_Algo i = new Graph_Algo();
////		i.m = new DGraph();
//		
//		t.m.addNode(a);
//		t.m.addNode(b);
//		t.m.addNode(c);
//		t.m.addNode(d);
//		t.m.addNode(e);
//		// h.addNode(f);
//
//		t.m.connect(a.ID, b.ID, 0);
//		t.m.connect(b.ID, c.ID, 0);
//		t.m.connect(c.ID, d.ID, 0);
//		// h.connect(b.ID, d.ID, 0);
//		t.m.connect(c.ID, a.ID, 0);
//		t.m.connect(d.ID, b.ID, 0);
//
//		// h.connect(d.ID, e.ID, 0);
//
//		i.m = (DGraph) t.copy();
//		System.out.println(t.isConnected());
//		
//		Graph_Algo ron = new Graph_Algo();
//		
//		ron.init(t.copy());
		
		
	
	
		
	}
}
