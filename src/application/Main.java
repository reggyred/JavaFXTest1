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
		Layout layout3 = new RandomLayout(graph3);
		layout3.execute();

	}

	private void addGraphComponents() {

		Model model = graph.getModel();

		graph.beginUpdate();

		model.addCell("Cell A", CellType.TITLEDPANE);
		model.addCell("Cell B", CellType.RECTANGLE);
		model.addCell("Cell C", CellType.RECTANGLE);
		model.addCell("Cell D", CellType.TRIANGLE);
		model.addCell("Cell E", CellType.TRIANGLE);
		model.addCell("Cell F", CellType.RECTANGLE);
		model.addCell("Cell G", CellType.RECTANGLE);
		model.addCell("Cell H", CellType.LABEL);
		model.addCell("Cell I", CellType.CIRCLE);
		model.addCell("Cell J", CellType.TITLEDPANE);
		model.addCell("Cell K", CellType.TITLEDPANE);

		model.addEdge("Cell A", "Cell B");
		model.addEdge("Cell A", "Cell C");
		model.addEdge("Cell B", "Cell C");
		model.addEdge("Cell C", "Cell D");
		model.addEdge("Cell B", "Cell E");
		model.addEdge("Cell D", "Cell F");
		model.addEdge("Cell D", "Cell G");
		model.addEdge("Cell G", "Cell H");
		model.addEdge("Cell H", "Cell I");
		model.addEdge("Cell I", "Cell J");
		model.addEdge("Cell K", "Cell H");

		graph.endUpdate();

	}

	private void addGraphManyComponents() {

		Model model = graph.getModel();

		graph.beginUpdate();

		for (int i = 0; i < 50; i++) {
			model.addCell(String.valueOf(i), CellType.RECTANGLE);
		}
		for (int i = 1; i < 50; i++) {
			model.addEdge(String.valueOf(i - 1), String.valueOf(i));
		}

		graph.endUpdate();

	}

	private void addGraphComponents2() {

		Model model2 = graph2.getModel();

		graph2.beginUpdate();

		model2.addCell("Cell A", CellType.RECTANGLE);
		model2.addCell("Cell B", CellType.RECTANGLE);
		model2.addCell("Cell C", CellType.RECTANGLE);
		model2.addCell("Cell D", CellType.TRIANGLE);
		model2.addCell("Cell E", CellType.TRIANGLE);
		model2.addCell("Cell F", CellType.RECTANGLE);
		model2.addCell("Cell G", CellType.RECTANGLE);
		model2.addCell("Cell H", CellType.LABEL);
		model2.addCell("Cell I", CellType.RECTANGLE);
		model2.addCell("Cell J", CellType.RECTANGLE);
		model2.addCell("Cell K", CellType.RECTANGLE);

		model2.addEdge("Cell A", "Cell B");
		model2.addEdge("Cell A", "Cell C");
		model2.addEdge("Cell B", "Cell C");
		model2.addEdge("Cell C", "Cell D");
		model2.addEdge("Cell B", "Cell E");
		model2.addEdge("Cell D", "Cell F");
		model2.addEdge("Cell D", "Cell G");
		model2.addEdge("Cell G", "Cell H");
		model2.addEdge("Cell H", "Cell I");
		model2.addEdge("Cell I", "Cell J");
		model2.addEdge("Cell K", "Cell H");

		graph2.endUpdate();

	}
	
	private void addGraphComponents3() {

		Model model3 = graph3.getModel();

		graph3.beginUpdate();

		model3.addCell("Cell A", CellType.RECTANGLE);
		model3.addCell("Cell B", CellType.RECTANGLE);
		model3.addCell("Cell C", CellType.RECTANGLE);
		model3.addCell("Cell D", CellType.TRIANGLE);
		model3.addCell("Cell E", CellType.TRIANGLE);
		model3.addCell("Cell F", CellType.RECTANGLE);
		model3.addCell("Cell G", CellType.RECTANGLE);
		model3.addCell("Cell H", CellType.LABEL);
		model3.addCell("Cell I", CellType.RECTANGLE);
		model3.addCell("Cell J", CellType.RECTANGLE);
		model3.addCell("Cell K", CellType.RECTANGLE);

		model3.addEdge("Cell A", "Cell B");
		model3.addEdge("Cell A", "Cell C");
		model3.addEdge("Cell B", "Cell C");
		model3.addEdge("Cell C", "Cell D");
		model3.addEdge("Cell B", "Cell E");
		model3.addEdge("Cell D", "Cell F");
		model3.addEdge("Cell D", "Cell G");
		model3.addEdge("Cell G", "Cell H");
		model3.addEdge("Cell H", "Cell I");
		model3.addEdge("Cell I", "Cell J");
		model3.addEdge("Cell K", "Cell H");

		graph3.endUpdate();

	}

	public static void main(String[] args) {
		launch(args);
	}
}