package dataStructure;

import gui.graph_gui;

import java.util.ArrayList;
import java.util.List;

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
		

		temp.removeEdge(1, 2);
		
		//System.out.println(kd.ID);
		h = temp.copy();
		
		
		
		
		
		
		
		
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
