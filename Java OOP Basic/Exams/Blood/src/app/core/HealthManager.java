package app.core;

import app.entities.Cluster;
import app.entities.Organism;
import app.entities.cells.Cell;
import app.factories.CellFactory;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import static app.utilities.Constants.*;

public class HealthManager {

    private Map<String, Organism> organisms;

    public HealthManager() {
        this.organisms = new LinkedHashMap<>();
    }

    public String checkCondition(String organismName) {
        if (this.organisms.containsKey(organismName)) {
            return this.organisms.get(organismName).toString();
        } else {
            return String.format("Organism %s already exists", organismName);
        }
    }

    public String createOrganism(String name) {
        if (!this.organisms.containsKey(name)) {
            this.organisms.putIfAbsent(name, new Organism(name));
            return String.format("Created organism %s", name);
        } else {
            return String.format("Organism %s already exists", name);
        }
    }

    public String addCluster(String organismName, String id, int rows, int cols) {
        if (this.organisms.containsKey(organismName) && !this.organisms.get(organismName).getClusters().stream()
                .map(Cluster::getId).collect(Collectors.toList()).contains(id)) {
            this.organisms.get(organismName).addCluster(new Cluster(id, rows, cols));
            return String.format("Organism %s: Created cluster %s", organismName, id);
        }
        return null;
    }

    public String addCell(String organismName, String clusterId, String cellType, String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        if (this.organisms.containsKey(organismName) && this.organisms.get(organismName).getClusters().stream()
                .map(Cluster::getId).collect(Collectors.toList()).contains(clusterId) && validateCellPosition(this.organisms.get(organismName).getClusters().stream().filter(c -> c.getId().equals(clusterId)).findFirst().orElse(null), positionRow, positionCol)) {
            Cell cell = null;
            switch (cellType) {
                case BACTERIA:
                    cell = CellFactory.createBacteria(cellId, health, positionRow, positionCol, additionalProperty);
                    break;
                case VIRUS:
                    cell = CellFactory.createVirus(cellId, health, positionRow, positionCol, additionalProperty);
                    break;
                case FUNGI:
                    cell = CellFactory.createFungi(cellId, health, positionRow, positionCol, additionalProperty);
                    break;
                case WHITE_BLOOD_CELL_TYPE:
                    cell = CellFactory.createWhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                    break;
                case RED_BLOOD_CELL_TYPE:
                    cell = CellFactory.createRedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
                    break;
            }
            this.organisms.get(organismName).getClusters().stream().filter(c -> c.getId().equals(clusterId)).findFirst().orElse(null).addCell(cell);
            return String.format("Organism %s: Created cell %s in cluster %s", organismName, cellId, clusterId);
        }
        return null;
    }

    public String activateCluster(String organismName) {
        if (this.organisms.containsKey(organismName) && this.organisms.get(organismName).getClusters().size() != 0) {
            Organism organism = this.organisms.get(organismName);
            Cluster cluster = organism.getNextCluster();

            activate(cluster);
            organism.addCluster(cluster);
            return String.format("Organism %s: Activated cluster %s. Cells left: %d", organismName, cluster.getId(), cluster.getCells().size());
        }
        return null;
    }

    private void activate(Cluster cluster) {
        if (cluster.getCells().size() <= 1) {
            return;
        }
        Cell cell = cluster.getCells()
                .stream()
                .sorted(Comparator.comparing(Cell::getPositionRow).thenComparing(Cell::getPositionCol))
                .findFirst()
                .orElse(null);

        List<Cell> cells = cluster.getCells();
        int startRow = cell.getPositionRow();
        int startCol = cell.getPositionCol() + 1;

        for (int i = cell.getPositionRow(); i < cluster.getRows(); i++) {
            for (int j = (i == startRow ? startCol : 0); j < cluster.getCols(); j++) {
                if (hasCell(cells, i, j)) {
                    Cell currentPositionCell = getCell(cells, i, j);
                    if (cell.getClass().getSuperclass().getSimpleName().equals(MICROBE)) {
                        int counter = 0;
                        while (true) {
                            if (currentPositionCell.getHealth() <= 0 || cell.getHealth() <= 0) {
                                break;
                            }

                            if (counter++ % 2 == 0) {
                                currentPositionCell.takeDamage(cell.getEnergy());
                            } else {
                                cell.takeDamage(currentPositionCell.getEnergy());
                            }
                        }
                        if (cell.getHealth() <= 0) {
                            cluster.removeCell(cell);
                            cell = currentPositionCell;
                        } else {
                            cluster.removeCell(currentPositionCell);
                        }
                    } else {
                        cell.addHealth(currentPositionCell.getHealth());
                        cluster.removeCell(currentPositionCell);
                    }
                    if (cluster.getCells().size() <= 1) {
                        cell.setPositionRow(i);
                        cell.setPositionCol(j);
                        return;
                    }
                }
            }
        }
    }

    private Cell getCell(List<Cell> cells, int row, int col) {
        return cells.stream().filter(c -> c.getPositionRow() == row && c.getPositionCol() == col).iterator().next();
    }

    private boolean hasCell(List<Cell> cells, int row, int col) {
        for (Cell cell : cells) {
            if (cell.getPositionRow() == row && cell.getPositionCol() == col) {
                return true;
            }
        }
        return false;
    }

    private boolean validateCellPosition(Cluster cluster, int positionRow, int positionCol) {
        return positionRow >= 0 && positionRow < cluster.getRows() && positionCol >= 0 && positionCol < cluster.getCols();
    }
}
