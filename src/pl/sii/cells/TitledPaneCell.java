package pl.sii.cells;

import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TitledPane;

import pl.sii.graph.Cell;

public class TitledPaneCell extends Cell {

    public TitledPaneCell(int id, String header, Node content) {
        super(id);

        TitledPane view = new TitledPane(header, content);
        view.setPrefSize(100, 100);
        view.resize(100,100);
        view.setExpanded(true);
       // view.setCollapsible(true);
        setView(view);

    }

}