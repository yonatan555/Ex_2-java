package dataStructure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utils.Point3D;

class DGraphTest {

	@Test
	void testAddNode() {
		DGraph h = new DGraph();
		NodeData a = new NodeData(1, new Point3D(3, 2, 4));
		NodeData b = new NodeData(2, new Point3D(4, 2, 4));
		NodeData c = new NodeData(2, new Point3D(4, 2, 4));
		h.addNode(a);
		h.addNode(b);
		h.addNode(c);
		assertEquals(2, h.nodeSize());
	}

	@Test
	void testConnect() {
		DGraph m = new DGraph();
		NodeData a = new NodeData(1, new Point3D(3, 2, 4));
		NodeData b = new NodeData(2, new Point3D(4, 2, 4));
		m.addNode(a);
		m.addNode(b);
		m.connect(a.getKey(), b.getKey(), 5);
		m.connect(b.getKey(), a.getKey(), 5);
		try {
			m.connect(b.getKey(), a.getKey(), 5);
		} catch (Exception e) {
			System.err.println("This edge is exist");
		}

		assertEquals(2, m.edgesNum);
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

		h.addNode(a);
		h.addNode(b);
		h.addNode(c);
		h.addNode(d);
		h.addNode(e);

		h.connect(a.getKey(), b.getKey(), 5);
		h.connect(a.getKey(), c.getKey(), 5);
		h.connect(e.getKey(), b.getKey(), 5);
		h.connect(d.getKey(), b.getKey(), 5);
		h.connect(b.getKey(), a.getKey(), 5);
		h.connect(d.getKey(), c.getKey(), 5);

		h.removeEdge(a.getKey(), c.getKey());
		h.removeEdge(d.getKey(), c.getKey());
		assertEquals(4, h.edgeSize());
	}

//	@Test
//	void testCopy() {
//		fail("Not yet implemented");
//	}

}
