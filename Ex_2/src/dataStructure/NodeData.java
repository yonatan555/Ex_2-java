package dataStructure;

import utils.Point3D;

public class NodeData implements node_data {
	int ID;
	double weight;
	int tag;
	String metadata;
	Point3D point;

	public NodeData() {
		this.ID = 0;
		this.weight = 0;
		this.metadata = null;
		this.tag = 0;
		this.point = point.ORIGIN;
	}

	public NodeData(int id, double weight, Point3D point) {
		this.ID = id;
		this.weight = weight;
		this.point = new Point3D(point);
	}

	public NodeData(int id, double weight, String metadata, int tag, Point3D point) {
		this.ID = id;
		this.weight = weight;
		this.point = new Point3D(point);
		this.metadata = metadata;
		this.tag = tag;
	}

	@Override
	public int getKey() {
		return this.ID;
	}

	@Override
	public Point3D getLocation() {
		return point;
	}

	@Override
	public void setLocation(Point3D p) {
		this.point = new Point3D(p);

	}

	@Override
	public double getWeight() {
		return this.weight;
	}

	@Override
	public void setWeight(double w) {
		this.weight = w;

	}

	@Override
	public String getInfo() {
		return this.metadata;
	}

	@Override
	public void setInfo(String s) {
		this.metadata = s;

	}

	@Override
	public int getTag() {
		return this.tag;
	}

	@Override
	public void setTag(int t) {
		this.tag = t;

	}
	public node_data copy(NodeData other) {
		
		NodeData n = new NodeData();
		
		n.ID = other.ID;
		n.tag = other.tag;
		n.weight = other.weight;
		n.metadata = new String(other.metadata);
		n.point = new Point3D(other.point);
		
		return n ; 
	}
}
