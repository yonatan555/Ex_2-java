package algorithms;

import static org.junit.jupiter.api.Assertions.*;

import java.util.Collection;
import java.util.Iterator;
import java.util.List;

import org.junit.jupiter.api.Test;

import dataStructure.DGraph;
import dataStructure.NodeData;
import dataStructure.edge_data;
import dataStructure.node_data;
import utils.Point3D;

class Graph_AlgoTest {

	@Test
	void testIsConnected() {
		graph_algorithms m = new Graph_Algo();

		DGraph h = new DGraph();
		m.init(h);
		NodeData a = new NodeData(1, new Point3D(3, 2, 4));
		NodeData b = new NodeData(2, new Point3D(4, 2, 4));
		NodeData c = new NodeData(3, new Point3D(4, 2, 4));
		NodeData d = new NodeData(4, new Point3D(4, 2, 4));
		NodeData e = new NodeData(5, new Point3D(4, 2, 4));

		h.addNode(a);
		h.addNode(b);
		h.addNode(c);
		h.addNode(d);
		h.addNode(e);

		h.connect(a.getKey(), b.getKey(), 2);
		h.connect(b.getKey(), c.getKey(), 3);
		h.connect(c.getKey(), d.getKey(), 10);
		h.connect(d.getKey(), e.getKey(), 7);
		h.connect(e.getKey(), a.getKey(), 4);
		h.connect(e.getKey(), d.getKey(), 4);
		h.connect(c.getKey(), e.getKey(), 4);
		h.connect(e.getKey(), b.getKey(), 4);

		assertEquals(true, m.isConnected());
	}

	@Test
	void testShortestPathDist() {
		graph_algorithms m = new Graph_Algo();

		DGraph h = new DGraph();
		m.init(h);
		NodeData a = new NodeData(1, new Point3D(3, 2, 4));
		NodeData b = new NodeData(2, new Point3D(4, 2, 4));
		NodeData c = new NodeData(3, new Point3D(4, 2, 4));
		NodeData d = new NodeData(4, new Point3D(4, 2, 4));
		NodeData e = new NodeData(5, new Point3D(4, 2, 4));
		NodeData f = new NodeData(6, new Point3D(4, 2, 4));

		h.addNode(a);
		h.addNode(b);
		h.addNode(c);
		h.addNode(d);
		h.addNode(e);
		h.addNode(f);
		
		h.connect(a.getKey(), b.getKey(), 1);
		h.connect(b.getKey(), c.getKey(), 1);
		h.connect(c.getKey(), d.getKey(), 1);
		h.connect(d.getKey(), e.getKey(), 1);
		h.connect(e.getKey(), f.getKey(), 1);
		h.connect(f.getKey(), a.getKey(), 5);
		h.connect(b.getKey(), e.getKey(), 1);
		h.connect(c.getKey(), f.getKey(), 3);
		h.connect(a.getKey(), e.getKey(), 4);
		h.connect(f.getKey(), b.getKey(), 7);
		assertEquals(3, m.shortestPathDist(a.getKey(), f.getKey()));
	}

/*	@Test
	void testShortestPath() {
		graph_algorithms t = new Graph_Algo();
		
		DGraph temp = new DGraph();

		Point3D m = new Point3D(1, 3, 4);
		Point3D m1 = new Point3D(2, 4, 5);
		Point3D m2 = new Point3D(3, 5, 6);
		Point3D m3 = new Point3D(4, 6, 7);
		Point3D m4 = new Point3D(5, 6, 7);

		NodeData a = new NodeData(1, m);
		NodeData b = new NodeData(2, m1);
		NodeData c = new NodeData(3, m2);
		NodeData d = new NodeData(4, m3);
		NodeData e = new NodeData(5, m4);
		
		temp.addNode(a);
		temp.addNode(b);
		temp.addNode(c);
		temp.addNode(d);
		temp.addNode(e);
		
		temp.connect(a.getKey(), b.getKey(), 1);
		temp.connect(b.getKey(), c.getKey(), 3);
		temp.connect(c.getKey(), d.getKey(), 3);
		temp.connect(d.getKey(), e.getKey(), 2);
		temp.connect(b.getKey(), d.getKey(), 1);
		temp.connect(c.getKey(), e.getKey(), 2);
		
		t.init(temp);
		
		List<node_data> lis = t.shortestPath(1, 5);
		Iterator<node_data> it = lis.iterator()	;
		int weight = 0 ;
		
		while(it.hasNext() && it.hasNext()) {
			node_data saver = it.next();
			if(!it.hasNext()) break;
			weight += temp.getEdge(saver.getKey(), it.next().getKey()).getWeight();
		}
		
		assertEquals(4, weight);
	}
*/
	// @Test
	// void testTSP() {
	// fail("Not yet implemented");
	// }

}
