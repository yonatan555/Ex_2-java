package dataStructure;

import utils.Point3D;

public class EdgeData implements edge_data {
	int src;
	int dest;
	double weight;
	int tag;
	String metadata;

	public EdgeData(int src, int dest, double weight) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
	}

	public EdgeData(int src, int dest, double weight, String metadata, int tag) {
		this.src = src;
		this.dest = dest;
		this.weight = weight;
		this.metadata = metadata;
		this.tag = tag;
	}

	@Override
	public int getSrc() {
		return this.src;
	}

	@Override
	public int getDest() {
		return this.dest;
	}

	@Override
	public double getWeight() {
		return weight;
	}

	@Override
	public String getInfo() {
		return metadata;
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

}
