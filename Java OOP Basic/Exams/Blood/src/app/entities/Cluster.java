package app.entities;

import app.entities.cells.Cell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Cluster {
    private String id;
    private int rows;
    private int cols;
    private List<Cell> cells;

    public Cluster(String id, int rows, int cols) {
        this.id = id;
        this.rows = rows;
        this.cols = cols;
        this.cells = new ArrayList<>();
    }

    public int getCols() {
        return this.cols;
    }

    public int getRows() {
        return this.rows;
    }

    public void addCell(Cell cell) {
        this.cells.add(cell);
    }

    public void removeCell(Cell cell) {
        this.cells.remove(cell);
    }

    public String getId() {
        return this.id;
    }

    public List<Cell> getCells() {
        return Collections.unmodifiableList(this.cells);
    }

    @Override
    public String toString() {
        return String.format("----Cluster %s", this.id);
    }
}