package pl.sii.model;

import java.util.ArrayList;

import javafx.geometry.Point2D;

public class Block {

	static int nextID = 0;
	int blockID;
	String blockName;
	String blockGroup;
	BlockType blockType;
	int blockLayer;
	int blockOrder;
	String value;
	Point2D position;

	ArrayList<Integer> blockParents = new ArrayList<Integer>();
	ArrayList<Integer> blockChilds = new ArrayList<Integer>();

	public Block(String blockName, String blockGroup, BlockType blockType, int blockLayer, int blockOrder,
			String value) {
		blockID = nextID;
		nextID++;
		this.blockName = blockName;
		this.blockGroup = blockGroup;
		this.blockType = blockType;
		this.blockLayer = blockLayer;
		this.blockOrder = blockOrder;
		this.value = value;
		position = new Point2D(0, 0);
	}

	public void setBlockLayer(int layer) {
		blockLayer = layer;
	}

	public int getBlockLayer() {
		return blockLayer;
	}

	public void setBlockOrder(int order) {
		blockOrder = order;
	}

	public int getBlockOrder() {
		return blockOrder;
	}

	public void setPosition(Point2D position) {
		this.position = position;
	}

	public void setPosition(float x, float y) {
		position = new Point2D(x, y);
	}

	public Point2D getPosition() {
		return position;
	}
	
	public double getPositionX() {
		return position.getX();
	}
	
	public double getPositionY() {
		return position.getY();
	}

}
