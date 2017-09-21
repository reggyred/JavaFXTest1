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
	final int layerHeight = 75;
	final int orderWidth = 75;
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
				
			}
			if (cell.getOrder() > maxOrder) {
				maxOrder = cell.getOrder();
			}

		}
		ordersInLayers = new int[maxLayer+1];
		for (Cell cell : cells) {
			ordersInLayers[cell.getLayer()]++;
		}

		maxWidth = maxOrder * orderWidth + 80;
		maxHeight = maxLayer * layerHeight + 50;
		

		for (Cell cell : cells) {
			int x;
			int y;
			int cellLayer = cell.getLayer();
			y = maxHeight - 25 - cellLayer*75;
			x = maxWidth / (ordersInLayers[cellLayer]+1)*(cell.getOrder()+1);
			
			cell.relocate(x, y);
		}
		
		
	}

}