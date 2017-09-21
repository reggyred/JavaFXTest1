package pl.sii.cells;

import javafx.scene.control.Label;

import pl.sii.graph.Cell;

public class LabelCell extends Cell {

    public LabelCell(int id) {
        super(id);

        Label view = new Label(Integer.toString(id));

        setView(view);

    }

}