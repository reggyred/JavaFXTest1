package pl.sii.graph;

import java.util.ArrayList;
import java.util.List;

import javafx.scene.Node;
import javafx.scene.layout.Pane;

public class CellExtended extends Pane {

    int cellId;

    List<CellExtended> children = new ArrayList<>();
    List<CellExtended> parents = new ArrayList<>();

    Node view;

    public CellExtended(int cellId) {
        this.cellId = cellId;
    }

    public void addCellChild(CellExtended cell) {
        children.add(cell);
    }

    public List<CellExtended> getCellChildren() {
        return children;
    }

    public void addCellParent(CellExtended cell) {
        parents.add(cell);
    }

    public List<CellExtended> getCellParents() {
        return parents;
    }

    public void removeCellChild(CellExtended cell) {
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
}