package pl.sii.layout.base;

import pl.sii.graph.Graph;

public abstract class Layout {

	Graph graph;
	int maxLayers;
	int maxOrders;
	
	
    public Layout(Graph graph) {

        this.graph = graph;

    }


    public abstract void execute();

}