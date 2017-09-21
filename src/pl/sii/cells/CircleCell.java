package pl.sii.cells;

import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;

import pl.sii.graph.Cell;

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
