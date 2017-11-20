package app.entities;

import app.entities.cells.Cell;

import java.util.*;
import java.util.stream.Collectors;

public class Organism {

    private String name;
    private List<Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.clusters = new ArrayList<>();
    }

    public List<Cluster> getClusters() {
        return Collections.unmodifiableList(this.clusters);
    }

    public void addCluster(Cluster cluster) {
        this.clusters.add(cluster);
    }

    public Cluster getNextCluster() {
        return this.clusters.remove(0);
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb
                .append(String.format("Organism - %s", this.name)).append(System.lineSeparator())
                .append(String.format("--Clusters: %d", this.clusters.size())).append(System.lineSeparator())
                .append(String.format("--Cells: %d", this.clusters.stream().mapToInt(c -> c.getCells().size()).sum())).append(System.lineSeparator());

        for (Cluster cluster : this.clusters) {
            sb.append(cluster).append(System.lineSeparator());

            List<Cell> sortedCells = cluster.getCells().stream().sorted(Comparator.comparing(Cell::getPositionRow).thenComparing(Cell::getPositionCol)).collect(Collectors.toList());

            for (Cell cell : sortedCells) {
                sb.append(cell).append(System.lineSeparator());
            }
        }

        return sb.toString().trim();
    }
}
