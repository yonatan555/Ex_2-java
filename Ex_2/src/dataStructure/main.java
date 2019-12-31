package dataStructure;

import gui.graph_gui;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.ArrayList;
import java.util.List;

import algorithms.Graph_Algo;
import algorithms.graph_algorithms;
import gui.graph_gui;
import utils.Point3D;

public class main {
	public static void main(String[] args) {

	/*	graph_algorithms t = new Graph_Algo();
		
		DGraph h = new DGraph();
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
		 //NodeData f =null ; //new NodeData(6,2.5,m5);
		
		
		
		temp.addNode(a);
		temp.addNode(b);
		temp.addNode(c);
		temp.addNode(d);
		temp.addNode(e);
		
		temp.connect(a.getKey(), b.getKey(), 22);
		temp.connect(e.getKey(), b.getKey(), 3);
		temp.connect(c.getKey(), d.getKey(), 3);
		temp.connect(d.getKey(), e.getKey(), 1);
		temp.connect(b.getKey(), d.getKey(), 1);
		temp.connect(a.getKey(), e.getKey(), 2);
		

		temp.removeEdge(2, 5);
		
		
		h = temp.copy();
		*/
		DGraph h = new DGraph();
		
		NodeData a = new NodeData(1, new Point3D(3, 2, 4));
		NodeData b = new NodeData(2, new Point3D(4, 2, 4));
		NodeData c = new NodeData(3, new Point3D(4, 2, 4));
		NodeData d = new NodeData(4, new Point3D(4, 2, 4));
		NodeData e = new NodeData(5, new Point3D(4, 2, 4));
		NodeData f = new NodeData(6, new Point3D(4, 2, 4));
		NodeData g = new NodeData(7, new Point3D(4, 2, 4));
		NodeData i = new NodeData(8, new Point3D(4, 2, 4));
		
		h.addNode(a);
		h.addNode(b);
		h.addNode(c);
		h.addNode(d);
		h.addNode(e);
		h.addNode(f);
		h.addNode(g);
		h.addNode(i);
		
		h.connect(a.getKey(), b.getKey(), 5);
		h.connect(a.getKey(), c.getKey(), 5);
		h.connect(e.getKey(), b.getKey(), 5);
		h.connect(d.getKey(), b.getKey(), 5);
		h.connect(b.getKey(), a.getKey(), 5);
		h.connect(d.getKey(), c.getKey(), 5);
		
		h.removeNode(g.getKey());
		h.removeNode(g.getKey());
		
		h.removeEdge(a.getKey(), g.getKey());
		h.removeEdge(d.getKey(), c.getKey());
		
		
		
		
		/*
		t.init(h);
		System.out.println(t.shortestPathDist(1, 5));
		
		graph_gui grap = new  graph_gui (h);
		List<Integer> targets = new ArrayList<Integer>();
		targets.add(1);
		targets.add(3);
		targets.add(4);
		
		List<node_data> lis = t.shortestPath(1, 5);
		for (int i = 0; i < lis.size(); i++) {
			System.out.print(lis.get(i).getKey()+",");
		}*/
		


		
	
	
		
	}
}
