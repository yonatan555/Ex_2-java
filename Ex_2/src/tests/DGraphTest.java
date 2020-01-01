package tests;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import dataStructure.DGraph;
import dataStructure.NodeData;
import utils.Point3D;

class DGraphTest {

	@Test
	void testAddNode() {
		DGraph h = new DGraph();
		for (int i = 0; i <1000000; i++) {
			Point3D y = new Point3D(1,2,3);
			NodeData x = new NodeData(i, y);
			h.addNode(x);
		}		
		assertEquals(1000000, h.nodeSize());
	}

	@Test
	void testConnect() {
		
		DGraph m = new DGraph();
		Point3D y = new Point3D(1,2,3);
		for (int i = 1; i <=1000000; i++) {
			NodeData x = new NodeData(i, y);
			m.addNode(x);
		}		
		for(int i = 1 ; i <= 1000000 ;i++ ) {
			m.connect(i, i+1, 2);
			m.connect(i, i+2, 2);
			m.connect(i, i+3, 2);
			m.connect(i, i+4, 2);
			m.connect(i, i+5, 2);
			m.connect(i, i+6, 2);
			m.connect(i, i+7, 2);
			m.connect(i, i+8, 2);
			m.connect(i, i+9, 2);
			m.connect(i, i+10, 2);
		}
		assertEquals(10000000, m.edgeSize());
	
	}

	@Test
	void testRemoveNode() {
		DGraph h = new DGraph();
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
		h.removeNode(a.getKey());
		h.removeNode(e.getKey());
		assertEquals(4, h.vertex.size());
	}

	@Test
	void testRemoveEdge() {
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
		
		
		h.removeEdge(a.getKey(), g.getKey());
		h.removeEdge(d.getKey(), c.getKey());
		assertEquals(4, h.edgeSize());
	}


}
