package iterator_test.tests;

import iterator_test.app.ListIterator;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;

public class ListIteratorTest {

    private ListIterator listIterator;

    @Before
    public void initialize() throws OperationNotSupportedException {
        listIterator = new ListIterator("I am", "You are");
    }

    //region Constructor
    @Test
    public void constructorTestWithOneElementShouldNotHaveNext() throws Exception {
        // Act
        Assert.assertTrue(!listIterator.hasNext());
    }

    @Test
    public void constructorTestWithNoElementShouldNotHaveNext() throws Exception {
        // Arrange
        ListIterator listIterator = new ListIterator();

        // Act
        Assert.assertTrue(!listIterator.hasNext());
    }

    @Test(expected = OperationNotSupportedException.class)
    public void constructorTestWithNullShouldThrowException() throws Exception {
        // Arrange
        ListIterator listIterator = new ListIterator(null);

        // Act
        Assert.assertTrue(!listIterator.hasNext());
    }
    //endregion

    //region move
    @Test
    public void movingToNextIndexWhichIsPresentShouldReturnTrue() {
        // Arrange
        boolean expectedValue = true;

        // Assert
        Assert.assertTrue(listIterator.move() == expectedValue);
    }

    @Test
    public void movingToNextIndexWhichIsNotPresentShouldReturnFalse() throws Exception {
        // Arrange
        listIterator = new ListIterator();
        boolean expectedValue = false;

        // Assert
        Assert.assertTrue(listIterator.move() == expectedValue);
    }

    @Test
    public void movingToNextIndexIfNoElementsArePresentShouldReturnFalse() throws Exception {
        // Arrange
        listIterator = new ListIterator();
        boolean expectedValue = false;

        // Assert
        Assert.assertTrue(listIterator.move() == expectedValue);
    }
    //endregion

    //region hasNext
    @Test
    public void hasNextThereIsNextShouldReturnTrue() {
        // Arrange
        boolean expectedValue = true;

        // Assert
        Assert.assertTrue(listIterator.hasNext() == expectedValue);
    }

    @Test
    public void hasNextThereIsNoNextShouldReturnFalse() throws Exception {
        // Arrange
        boolean expectedValue = false;
        listIterator = new ListIterator();

        // Assert
        Assert.assertTrue(listIterator.hasNext() == expectedValue);
    }
    //endregion hasNext

    //region print
    @Test
    public void printCurrentIndexAtBeginning() {
        // Arrange
        String expectedValue = "I am";

        // Assert
        Assert.assertEquals(expectedValue, listIterator.print());
    }

    @Test
    public void printAtNextInternalIndex() {
        // Arrange
        String expectedValue = "You are";

        // Act
        listIterator.move();

        // Assert
        Assert.assertEquals(expectedValue, listIterator.print());
    }

    @Test
    public void printIfNoElementsAreStoredShouldThrowException() throws Exception {
        // Arrange
        listIterator = new ListIterator();
        boolean expectedValue = false;

        // Act
        boolean actualValue = listIterator.move();

        // Assert
        Assert.assertTrue(expectedValue == actualValue);
    }
    //endregion
}