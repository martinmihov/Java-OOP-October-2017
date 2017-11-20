package exam.core;

import exam.entities.cell.Cell;
import exam.entities.cluster.Cluster;
import exam.entities.organism.Organism;
import exam.factories.CellFactory;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class HealthManager {
    private Map<String, Organism> organisms;

    public HealthManager() {
        this.setOrganisms();
    }

    public Map<String, Organism> getOrganisms() {
        return this.organisms;
    }

    private void setOrganisms() {
        this.organisms = new HashMap<>();
    }


    public String checkCondition(String organismName) {
        if (this.organisms.containsKey(organismName)) {
            return this.organisms.get(organismName).toString();
        }
        return null;
    }

    public String createOrganism(String name) {
        if (!this.organisms.containsKey(name)) {
            Organism organism = new Organism(name);
            this.organisms.put(name, organism);
            return String.format("Created organism %s", name);
        }
        return String.format("Organism %s already exists", name);
    }

    public String addCluster(String organismName, String id, int rows, int cols) {
        if (this.organisms.containsKey(organismName)) {
            Organism currentOrganism = this.organisms.get(organismName);

            if (!currentOrganism.getClusters().containsKey(id)) {
                Cluster cluster = new Cluster(id, rows, cols);
                currentOrganism.addCluster(id, cluster);
                return String.format("Organism %s: Created cluster %s", organismName, id);
            }
        }
        return null;
    }

    public String addCell(String organismName, String clusterId, String cellType, String
            cellId, int health, int positionRow, int positionCol, int additionalProperty) {

        if (this.organisms.containsKey(organismName)) {
            Organism currentOrganism = this.organisms.get(organismName);

            if (currentOrganism.getClusters().containsKey(clusterId)) {
                Cluster currentCluster = currentOrganism.getClusters().get(clusterId);

                int clusterRow = currentCluster.getRows();
                int clusterCol = currentCluster.getCols();

                boolean isInRowRange = 0 <= positionRow && positionRow <= clusterRow;
                boolean isInColRange = 0 <= positionCol && positionCol <= clusterCol;
                if (isInRowRange && isInColRange) {
                    Cell cell = CellFactory.createCell(cellType, cellId, health,
                            positionRow, positionCol, additionalProperty);
                    currentCluster.addCell(cell);
                    return String.format("Organism %s: Created cell %s in cluster %s",
                            organismName, cellId, clusterId);
                }
            }
        }
        return null;
    }

    public String activateCluster(String organismName) {
        if (this.organisms.containsKey(organismName)) {
            Organism currentOrganism = this.organisms.get(organismName);

            if (!currentOrganism.getClusters().isEmpty()) {
                String firstClusterId = currentOrganism.getClusters().keySet().iterator().next();
                Cluster activatedCluster = currentOrganism.getClusters().get(firstClusterId);


                if (activatedCluster.getCells().isEmpty() || activatedCluster.getCells().size() == 1) {
                    String output = String.format("Organism %s: Activated cluster %s. Cells left: %d",
                            organismName, activatedCluster.getId(), activatedCluster.getCells().size());

                    currentOrganism.removeCluster(activatedCluster.getId());
                    currentOrganism.addCluster(activatedCluster.getId(), activatedCluster);
                    return output;
                }

                List<Cell> sortedCells = sortCells(activatedCluster);
                Cell firstCell = sortedCells.remove(0);

                if ("RedBloodCell".equals(firstCell.getClass().getSimpleName())
                        || "WhiteBloodCell".equals(firstCell.getClass().getSimpleName())) {

                    moveBloodCell(activatedCluster, sortedCells, firstCell);
                } else if (firstCell.getClass().getSuperclass().getSimpleName().equals("Microbe")) {
                    //firstCell.getClass().getSuperclass().getSimpleName();
                    moveMicrobe(activatedCluster, sortedCells, firstCell);
                }

                String output = String.format("Organism %s: Activated cluster %s. Cells left: %d",
                        organismName, activatedCluster.getId(), activatedCluster.getCells().size());
                currentOrganism.removeCluster(activatedCluster.getId());
                currentOrganism.addCluster(activatedCluster.getId(), activatedCluster);
                return output;
            }
        }
        return null;
    }

    private void moveMicrobe(Cluster activatedCluster, List<Cell> sortedCells, Cell firstCell) {
        List<Cell> copySortedCells = new ArrayList<>();
        for (Cell sortedCell : sortedCells) {
            copySortedCells.add(sortedCell);
        }
        //copySortedCells.addAll(sortedCells);

        for (int index = 0; index < copySortedCells.size(); index++) {
            Cell currentCell = copySortedCells.get(index);

            while (true) {
                currentCell.reduceHealth(firstCell.getEnergy());
                if (currentCell.getHealth() <= 0) {
                    firstCell.changePositionRow(currentCell.getPositionRow());
                    firstCell.changePositionCol(currentCell.getPositionCol());
                    //sortedCells.remove(currentCell);
                    break;
                } else {
                    firstCell.reduceHealth(currentCell.getEnergy());
                    if (firstCell.getHealth() <= 0) {
                        firstCell = currentCell;
                        //sortedCells.remove(currentCell);
                        break;
                    }
                }
            }
        }

        activatedCluster.clearAllCells();
        activatedCluster.addCell(firstCell);
    }

    private void moveBloodCell(Cluster activatedCluster, List<Cell> sortedCells, Cell firstCell) {
        int totalTakenHealth = 0;
        int lastCellRow = sortedCells.get(sortedCells.size() - 1).getPositionRow();
        int lastCellCol = sortedCells.get(sortedCells.size() - 1).getPositionCol();

        for (Cell sortedCell : sortedCells) {
            totalTakenHealth += sortedCell.getHealth();
        }

        firstCell.addHealth(totalTakenHealth);
        firstCell.changePositionRow(lastCellRow);
        firstCell.changePositionCol(lastCellCol);

        activatedCluster.clearAllCells();
        activatedCluster.addCell(firstCell);
    }

    private List<Cell> sortCells(Cluster activatedCluster) {
        return activatedCluster.getCells()
                .stream()
                .sorted((c1, c2) -> {
                    if (Integer.compare(c1.getPositionRow(), c2.getPositionRow()) == 0) {
                        return Integer.compare(c1.getPositionCol(), c2.getPositionCol());
                    }
                    return Integer.compare(c1.getPositionRow(), c2.getPositionRow());
                })
                .collect(Collectors.toList());
    }
}
