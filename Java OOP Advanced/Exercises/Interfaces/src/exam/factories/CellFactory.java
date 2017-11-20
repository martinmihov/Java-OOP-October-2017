package exam.factories;

import exam.entities.cell.Cell;
import exam.entities.cell.bloodCell.RedBloodCell;
import exam.entities.cell.bloodCell.WhiteBloodCell;
import exam.entities.cell.microbe.Bacteria;
import exam.entities.cell.microbe.Fungi;
import exam.entities.cell.microbe.Virus;

public final class CellFactory {

    public static Cell createCell(String cellType, String id, int health,
                                  int positionRow, int positionCol, int additionalProperty) {
        switch (cellType) {
            case "WhiteBloodCell":
                return new WhiteBloodCell(id, health, positionRow, positionCol, additionalProperty);
            case "RedBloodCell":
                return new RedBloodCell(id, health, positionRow, positionCol, additionalProperty);
            case "Bacteria":
                return new Bacteria(id, health, positionRow, positionCol, additionalProperty);
            case "Virus":
                return new Virus(id, health, positionRow, positionCol, additionalProperty);
            case "Fungi":
                return new Fungi(id, health, positionRow, positionCol, additionalProperty);
            default:
                return null;
        }
    }
}
