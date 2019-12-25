package dataStructure;


import algorithms.Graph_Algo;
import utils.Point3D;

public class main {
	public static void main(String[] args) {
			
		Graph_Algo t = new Graph_Algo();
		DGraph h =  new DGraph();
		t.m = h ;
		
				
				
				Point3D m = new Point3D (1,3,4);
				Point3D m1 = new Point3D (2,4,5);
				Point3D m2 = new Point3D (3,5,6);
				Point3D m3 = new Point3D (4,6,7);
				Point3D m4 = new Point3D (2,6,7);
				/*Point3D m5 = new Point3D (6,6,7);
				*/
				NodeData a = new NodeData(1,2.2,m);
				NodeData b = new NodeData(2,2.5,m1);
				NodeData c = new NodeData(3,2.5,m2);
				NodeData d = new NodeData(4,2.5,m3);
				NodeData e = new NodeData(5,2.5,m4);
			/*	NodeData f = new NodeData(6,2.5,m5);
				*/
				h.addNode(a);
				h.addNode(b);
				h.addNode(c);
				h.addNode(d);
				h.addNode(e);
				/*h.addNode(f);
				*/
				
				h.connect(a.ID, b.ID ,0);
				h.connect(b.ID, c.ID ,0);
				h.connect(c.ID, d.ID ,0);
				//h.connect(b.ID, d.ID, 0);
				h.connect(c.ID, a.ID, 0);
				h.connect(d.ID, b.ID, 0);
				
				//h.connect(d.ID, e.ID, 0);
		
				
		System.out.println(t.isConnected());
		
	}
}
