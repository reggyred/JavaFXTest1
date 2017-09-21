package pl.sii.graph;

import java.util.ArrayList;
import java.util.List;

import javafx.geometry.Point2D;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;

public class Cell extends Pane {

	int cellId;
	String cellName;
	String cellGroup;
	int cellLayer;
	int cellOrder;
	String value;
	Point2D position;

	List<Cell> children = new ArrayList<>();
	List<Cell> parents = new ArrayList<>();

	Node view;

	public Cell(int cellId) {
		this.cellId = cellId;
	}

	public Cell(int cellId, int cellLayer, int cellOrder) {
		this.cellId = cellId;
		this.cellLayer = cellLayer;
		this.cellOrder = cellOrder;
		this.getChildren().addAll(new Label(Integer.toString(cellId)));
	}

	public void addCellChild(Cell cell) {
		children.add(cell);
	}

	public List<Cell> getCellChildren() {
		return children;
	}

	public void addCellParent(Cell cell) {
		parents.add(cell);
	}

	public List<Cell> getCellParents() {
		return parents;
	}

	public void removeCellChild(Cell cell) {
		children.remove(cell);
	}

	public void setView(Node view) {

		this.view = view;
		getChildren().add(view);

	}

	public Node getView() {
		return this.view;
	}

	public int getCellId() {
		return cellId;
	}

	public void setOrder(int order) {
		cellOrder = order;
	}

	public void setLayer(int layer) {
		cellLayer = layer;
	}

	public int getOrder() {
		return cellOrder;
	}

	public int getLayer() {
		return cellLayer;
	}
}