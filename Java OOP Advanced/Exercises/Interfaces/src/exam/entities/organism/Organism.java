package exam.entities.organism;

import exam.entities.cluster.Cluster;

import java.util.*;
import java.util.stream.Collectors;

public class Organism {
    private String name;
    private Map<String, Cluster> clusters;

    public Organism(String name) {
        this.name = name;
        this.setClusters();
    }

    private String getName() {
        return this.name;
    }

    public Map<String, Cluster> getClusters() {
        return Collections.unmodifiableMap(this.clusters);
    }

    public void setName(String name) {
        this.name = name;
    }

    private void setClusters() {
        this.clusters = new LinkedHashMap<>();
    }

    public void addCluster(String clusterId, Cluster cluster) {
        this.clusters.put(clusterId, cluster);
    }

    public void removeCluster(String clusterId) {
        this.clusters.remove(clusterId);
    }

    public Cluster activateCluster() {
        return this.clusters.remove(0);
    }

    @Override
    public String toString() {
        //Organism - {name}
        //--Clusters: {clusters count}
        //--Cells: {cells count}

        StringBuilder sb = new StringBuilder(String.format("Organism - %s", this.getName()))
                .append(System.lineSeparator())
                .append(String.format("--Clusters: %d", this.clusters.size()))
                .append(System.lineSeparator())
                .append(String.format("--Cells: %d", this.getCellsCount()))
                .append(System.lineSeparator());

        for (Cluster cluster : this.clusters.values()) {
            sb.append(cluster.toString())
                    .append(System.lineSeparator());
        }
        return sb.toString().trim();
    }

    private long getCellsCount() {
        int totalCellsCount = 0;
        for (Map.Entry<String, Cluster> clusterEntry : clusters.entrySet()) {
            totalCellsCount += clusterEntry.getValue().getCells().size();
        }
        return totalCellsCount;
    }
}
