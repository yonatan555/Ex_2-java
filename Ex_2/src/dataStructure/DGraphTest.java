package dataStructure;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

import utils.Point3D;

class DGraphTest {

	@Test
	void testAddNode() {
		DGraph h = new DGraph();
		NodeData a = new NodeData(1, new Point3D(3,2,4));
		NodeData b = new NodeData(2, new Point3D(4,2,4));
		NodeData c = new NodeData(2, new Point3D(4,2,4));
		h.addNode(a);
		h.addNode(b);
		h.addNode(c);
		assertEquals(2, h.nodeSize());
	}

	@Test
	void testConnect() {
		DGraph h = new DGraph();
		NodeData a = new NodeData(1, new Point3D(3,2,4));
		NodeData b = new NodeData(2, new Point3D(4,2,4));
		h.addNode(a);
		h.addNode(b);
		h.connect(a.getKey(), b.getKey(), 5);
		edge_data ed = h.getEdge(a.getKey(), b.getKey());
	}

	@Test
	void testRemoveNode() {
		fail("Not yet implemented");
	}

	@Test
	void testRemoveEdge() {
		fail("Not yet implemented");
	}

	@Test
	void testCopy() {
		fail("Not yet implemented");
	}

}
