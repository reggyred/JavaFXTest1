package pl.sii.layout.basic;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

import pl.sii.graph.Cell;
import pl.sii.graph.Graph;
import pl.sii.layout.base.Layout;

public class BasicLayout extends Layout {

	Graph graph;

	Random rnd = new Random();

	int maxOrder;
	int maxLayer;
	int maxWidth;
	int maxHeight;
	final int layerHeight = 60;
	final int orderWidth = 60;
	int[] ordersInLayers;

	public BasicLayout(Graph graph) {
		super(graph);
		this.graph = graph;
		maxOrder = 0;
		maxLayer = 0;

	}

	public void execute() {

		List<Cell> cells = graph.getModel().getAllCells();

		for (Cell cell : cells) {

			if (cell.getLayer() > maxLayer) {
				maxLayer = cell.getLayer();
				ordersInLayers = new int[maxLayer];
			}
			if (cell.getOrder() > maxOrder) {
				maxOrder = cell.getOrder();
			}

		}
		
		for (Cell cell : cells) {
			ordersInLayers[cell.getLayer()]++;
		}

		maxWidth = maxOrder * orderWidth;
		maxHeight = maxLayer * layerHeight;
		// cell.relocate(x, y);

	}

}