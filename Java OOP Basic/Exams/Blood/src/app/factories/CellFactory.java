package app.factories;

import app.entities.cells.*;

public final class CellFactory {

    private CellFactory() {}

    public static Cell createRedBloodCell(String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        return new RedBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
    }

    public static Cell createWhiteBloodCell(String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        return new WhiteBloodCell(cellId, health, positionRow, positionCol, additionalProperty);
    }

    public static Cell createBacteria(String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        return new Bacteria(cellId, health, positionRow, positionCol, additionalProperty);
    }

    public static Cell createFungi(String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        return new Fungi(cellId, health, positionRow, positionCol, additionalProperty);
    }

    public static Cell createVirus(String cellId, int health, int positionRow, int positionCol, int additionalProperty) {
        return new Virus(cellId, health, positionRow, positionCol, additionalProperty);
    }
}
