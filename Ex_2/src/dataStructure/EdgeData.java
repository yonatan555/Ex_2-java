package dataStructure;

import utils.Point3D;

public class EdgeData implements edge_data {
	double weight;
	NodeData src;
	NodeData dest;
	String metadata;
	int tag;
	
	public EdgeData(NodeData src,NodeData dest,double weight) {
		this.src = new NodeData(src.ID,src.weight,src.point);
		this.dest =  new NodeData(dest.ID,dest.weight,dest.point); ;
		this.weight = weight ;
	}
	public EdgeData(NodeData src,NodeData dest,double weight,String metadata,int tag) {
		this.src = new NodeData(src.ID,src.weight,src.point);
		this.dest =  new NodeData(dest.ID,dest.weight,dest.point); ;
		this.weight = weight ;
		this.metadata = metadata;
		this.tag = tag;
	}
	
	@Override
	public int getSrc() {
		return this.src.ID;
	}

	@Override
	public int getDest() {
		return this.dest.ID;
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
		this.metadata = s ;
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
