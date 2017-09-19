package com.fxgraph.cells;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import com.fxgraph.graph.Cell;

public class CircleCell extends Cell {

	public CircleCell(String id) {
		super(id);
		
		double radius = 35;
		Circle view = new Circle(radius);
		
		view.setStroke(Color.BLACK);
		view.setFill(Color.AZURE);
		
		setView(view);
	}

}
