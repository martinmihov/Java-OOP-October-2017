package database.tests;

import database.app.Database;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.Arrays;
import java.util.stream.Collectors;

public class DatabaseTest {

    private Database database;

    @Before
    public void initialize() throws OperationNotSupportedException {
        this.database = new Database(1,2,3,4);
    }

    //region Constructor
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithMoreElementsShouldThrowException() throws Exception {
        database = new Database(1,2,3,4,5,6,7,8,9,1,1,1,1,1,1,1,1);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithNoElementsShouldThrowException() throws Exception {
        database = new Database();
    }
    //endregion

    //region add
    @Test
    public void addingElementShouldBeTheLastElement() throws Exception {
        // Arrange
        int elementToBeAdded = 5;
        int expectedIndex = 4;

        // Act
        this.database.add(elementToBeAdded);

        // Assert
        Assert.assertTrue(this.database.getElements()[expectedIndex] == elementToBeAdded);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingNullElementShouldThrowException() throws Exception {
        // Arrange
        Integer elementToBeAdded = null;

        // Act
        this.database.add(elementToBeAdded);
    }

    @Test
    public void addingMaxValueElementShouldBeTheLastElement() throws Exception {
        // Arrange
        int elementToBeAdded = Integer.MAX_VALUE;
        int expectedIndex = 4;

        // Act
        this.database.add(elementToBeAdded);

        // Assert
        Assert.assertTrue(this.database.getElements()[expectedIndex] == elementToBeAdded);
    }

    @Test
    public void addingMinValueElementShouldBeTheLastElement() throws Exception {
        // Arrange
        int elementToBeAdded = Integer.MIN_VALUE;
        int expectedIndex = 4;

        // Act
        this.database.add(elementToBeAdded);

        // Assert
        Assert.assertTrue(this.database.getElements()[expectedIndex] == elementToBeAdded);
    }
    //endregion

    //region remove
    @Test
    public void collectionLengthAfterRemovalShouldBeLesser() throws Exception {
        // Arrange
        int expectedArrayLength = database.getElements().length - 1;

        // Act
        database.remove();

        // Assert
        Assert.assertTrue(database.getElements().length == expectedArrayLength);
    }

    @Test
    public void removedElementShouldNotExistsAfterRemoval() throws Exception {
        // Arrange
        String expectedElementsAfterRemoval = "1 2 3";

        // Act
        database.remove();
        String elementsAfterRemoval =
                Arrays.stream(database.getElements())
                        .map(Object::toString)
                        .collect(Collectors.joining(" "));

        // Assert
        Assert.assertEquals(elementsAfterRemoval, expectedElementsAfterRemoval);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeIfNoElementsPresentShouldThrowException() throws Exception {
        // Arrange
        this.database = new Database(1);

        // Act
        database.remove();
        database.remove();
    }

    //endregion

    @Test
    public void getElements() throws Exception {
        // Arrange
        String expectedElements = "1 2 3 4";
        String actualElements =
                Arrays.stream(database.getElements())
                        .map(Object::toString)
                        .collect(Collectors.joining(" "));

        // Assert
        Assert.assertEquals(actualElements, expectedElements);

    }

}