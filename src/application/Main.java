package application;

import javafx.application.Application;
import javafx.geometry.Insets;
import javafx.scene.Group;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Accordion;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.TitledPane;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import pl.sii.graph.CellType;
import pl.sii.graph.Graph;
import pl.sii.graph.Model;
import pl.sii.layout.base.Layout;
import pl.sii.layout.basic.BasicLayout;
import pl.sii.layout.random.RandomLayout;

public class Main extends Application {

	Graph graph = new Graph();
	Graph graph2 = new Graph();
	Graph graph3 = new Graph();
	final String[] imageNames = new String[] { "Apples" };
	final Image[] images = new Image[imageNames.length];
	final ImageView[] pics = new ImageView[imageNames.length];
	final TitledPane[] tps = new TitledPane[imageNames.length];

	@Override
	public void start(Stage primaryStage) {
		BorderPane root = new BorderPane();

		graph = new Graph();

		root.setCenter(graph.getScrollPane());

		Scene scene = new Scene(root, 1200, 800);
		scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		// TRIAL AREA//
		final Accordion accordion = new Accordion();

		for (int i = 0; i < imageNames.length; i++) {
			images[i] = new Image(getClass().getResourceAsStream(imageNames[i] + ".jpg"));
			pics[i] = new ImageView(images[i]);
			tps[i] = new TitledPane(imageNames[i], pics[i]);
		}

		accordion.getPanes().addAll(tps);
		accordion.setExpandedPane(tps[0]);
		accordion.resize(200, 200);

		graph2 = new Graph();
		graph3 = new Graph();
		TitledPane view = new TitledPane("My Panel", graph2.getScrollPane());
		final TitledPane myTitledPane1 = new TitledPane("My Panel 1", view);
		VBox vbox1 = new VBox(1);
		vbox1.getChildren().addAll(myTitledPane1, graph3.getScrollPane());
		final TitledPane myTitledPane2 = new TitledPane("My Panel 2", vbox1);
		final TitledPane myTitledPane3 = new TitledPane("My Panel 3", myTitledPane2);
		final TitledPane myTitledPane4 = new TitledPane("My Panel 4", myTitledPane3);
		graph2.getScrollPane().setMaxSize(500, 500);
		graph2.getScrollPane().setMinSize(500, 500);
		
		view.resize(500, 500);
		myTitledPane4.setLayoutX(600);
		myTitledPane4.setLayoutY(0);
		

		primaryStage.setScene(scene);

		primaryStage.show();

		addGraphManyComponents();
		addGraphComponents2();
		addGraphComponents3();
		graph.getCellLayer().getChildren().addAll(myTitledPane4, accordion);
		Layout layout = new RandomLayout(graph);
		layout.execute();
		Layout layout2 = new RandomLayout(graph2);
		layout2.execute();
		Layout layout3 = new BasicLayout(graph3);
		layout3.execute();

	}

	private void addGraphComponents() {

		Model model = graph.getModel();

		graph.beginUpdate();

		model.addCell(1, CellType.TITLEDPANE);
		model.addCell(2, CellType.RECTANGLE);
		model.addCell(3, CellType.RECTANGLE);
		model.addCell(4, CellType.TRIANGLE);
		model.addCell(5, CellType.TRIANGLE);
		model.addCell(6, CellType.RECTANGLE);
		model.addCell(7, CellType.RECTANGLE);
		model.addCell(8, CellType.LABEL);
		model.addCell(9, CellType.CIRCLE);
		model.addCell(10, CellType.TITLEDPANE);
		model.addCell(11, CellType.TITLEDPANE);

		model.addEdge(1, 2);
		model.addEdge(3, 4);
		model.addEdge(2, 5);
		model.addEdge(2, 6);
		model.addEdge(3, 4);
		model.addEdge(4, 7);
		model.addEdge(4, 8);
		model.addEdge(8, 9);
		model.addEdge(9, 10);
		model.addEdge(10, 11);
		model.addEdge(9, 11);

		graph.endUpdate();

	}

	private void addGraphManyComponents() {

		Model model = graph.getModel();

		graph.beginUpdate();

		for (int i = 0; i < 50; i++) {
			model.addCell((i), CellType.RECTANGLE);
		}
		for (int i = 1; i < 50; i++) {
			model.addEdge((i - 1), (i));
		}

		graph.endUpdate();

	}

	private void addGraphComponents2() {

		Model model2 = graph2.getModel();

		graph2.beginUpdate();

		model2.addCell(1, CellType.TITLEDPANE);
		model2.addCell(2, CellType.RECTANGLE);
		model2.addCell(3, CellType.RECTANGLE);
		model2.addCell(4, CellType.TRIANGLE);
		model2.addCell(5, CellType.TRIANGLE);
		model2.addCell(6, CellType.RECTANGLE);
		model2.addCell(7, CellType.RECTANGLE);
		model2.addCell(8, CellType.LABEL);
		model2.addCell(9, CellType.CIRCLE);
		model2.addCell(10, CellType.TITLEDPANE);
		model2.addCell(11, CellType.TITLEDPANE);

		model2.addEdge(1, 2);
		model2.addEdge(3, 4);
		model2.addEdge(2, 5);
		model2.addEdge(2, 6);
		model2.addEdge(3, 4);
		model2.addEdge(4, 7);
		model2.addEdge(4, 8);
		model2.addEdge(8, 9);
		model2.addEdge(9, 10);
		model2.addEdge(10, 11);
		model2.addEdge(9, 11);

		graph2.endUpdate();

	}
	
	private void addGraphComponents3() {

		Model model3 = graph3.getModel();

		graph3.beginUpdate();

		model3.addCell(0, CellType.RECTANGLE, 0, 0);
		model3.addCell(1, CellType.RECTANGLE, 1, 0);
		model3.addCell(2, CellType.RECTANGLE, 1, 1);
		model3.addCell(3, CellType.RECTANGLE, 2, 0);
		model3.addCell(4, CellType.RECTANGLE, 2, 1);
		model3.addCell(5, CellType.RECTANGLE, 2, 2);
		model3.addCell(6, CellType.RECTANGLE, 2, 3);
		model3.addCell(7, CellType.RECTANGLE, 3, 0);
		model3.addCell(8, CellType.RECTANGLE, 3, 1);
		model3.addCell(9, CellType.RECTANGLE, 4, 0);
		model3.addCell(10, CellType.RECTANGLE, 5, 0);
		model3.addCell(11, CellType.RECTANGLE, 5, 1);

		model3.addEdge(0, 1);
		model3.addEdge(0, 2);
		model3.addEdge(2, 3);
		model3.addEdge(2, 3);
		model3.addEdge(3, 4);
		model3.addEdge(4, 7);
		model3.addEdge(4, 8);
		model3.addEdge(8, 9);
		model3.addEdge(9, 10);
		model3.addEdge(10, 11);
		model3.addEdge(9, 11);

		graph3.endUpdate();

	}

	public static void main(String[] args) {
		launch(args);
	}
}