package exam.entities.cluster;

import exam.entities.cell.Cell;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class Cluster {
    private String id;
    private int rows;
    private int cols;
    private List<Cell> cells;

    public Cluster(String id, int rows, int cols) {
        this.setId(id);
        this.setRows(rows);
        this.setCols(cols);
        this.setCells();
    }

    public String getId() {
        return this.id;
    }

    public int getRows() {
        return this.rows;
    }

    public int getCols() {
        return this.cols;
    }

    public List<Cell> getCells() {
        return Collections.unmodifiableList(this.cells);
    }

    private void setId(String id) {
        this.id = id;
    }

    private void setRows(int rows) {
        this.rows = rows;
    }

    private void setCols(int cols) {
        this.cols = cols;
    }

    private void setCells() {
        this.cells = new ArrayList<>();
    }

    public void addCell(Cell cell) {
        this.cells.add(cell);
    }

    public void clearAllCells() {
        this.cells.clear();
    }

    @Override
    public String toString() {
        //----Cluster {clusterId}
        //------Cell {id} [{positionRow},{positionCol}]
        StringBuilder sb = new StringBuilder(String.format("----Cluster %s", this.getId()))
                .append(System.lineSeparator());

        List<Cell> sortedCells = this.cells.stream()
                .sorted((c1, c2) -> {
                    if (Integer.compare(c1.getPositionRow(), c2.getPositionRow()) == 0) {
                        return Integer.compare(c1.getPositionCol(), c2.getPositionCol());
                    }

                    return Integer.compare(c1.getPositionRow(), c2.getPositionRow());
                })
                .collect(Collectors.toList());

        for (Cell cell : sortedCells) {
            sb.append(cell.toString())
                    .append(System.lineSeparator());
        }

        return sb.toString().trim();
    }
}
