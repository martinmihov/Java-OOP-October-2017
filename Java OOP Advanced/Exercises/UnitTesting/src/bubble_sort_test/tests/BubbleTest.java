package bubble_sort_test.tests;

import bubble_sort_test.app.Bubble;
import org.junit.Assert;
import org.junit.Test;

import java.util.Arrays;

public class BubbleTest {

    @Test
    public void testMixedValuesShouldSortCorrectly() {
        // Arrange
        int[] inputArray = {2, 5, 1, 8, 12, 3, 7};
        String expected = "[1, 2, 3, 5, 7, 8, 12]";

        // Act
        Bubble.sort(inputArray);

        // Assert
        Assert.assertEquals(expected, Arrays.toString(inputArray));
    }

    @Test
    public void testDecreasingValuesShouldSortCorrectly() {
        // Arrange
        int[] inputArray = {4, 3, 2, 1};
        String expected = "[1, 2, 3, 4]";

        // Act
        Bubble.sort(inputArray);

        // Assert
        Assert.assertEquals(expected, Arrays.toString(inputArray));
    }

    @Test
    public void testDecreasingWithDuplicatesShouldSortCorrectly() {
        // Arrange
        int[] inputArray = {4, 3, 2, 1, 2, 3, 2};
        String expected = "[1, 2, 2, 2, 3, 3, 4]";

        // Act
        Bubble.sort(inputArray);

        // Assert
        Assert.assertEquals(expected, Arrays.toString(inputArray));
    }

    @Test
    public void testZeroValuesShouldSortCorrectly() {
        // Arrange
        int[] inputArray = {0,0};
        String expected = "[0, 0]";

        // Act
        Bubble.sort(inputArray);

        // Assert
        Assert.assertEquals(expected, Arrays.toString(inputArray));
    }

    @Test
    public void testIntMaxValueValuesShouldSortCorrectly() {
        // Arrange
        int[] inputArray = {Integer.MAX_VALUE, 0};
        String expected = String.format("[0, %d]", Integer.MAX_VALUE);

        // Act
        Bubble.sort(inputArray);

        // Assert
        Assert.assertEquals(expected, Arrays.toString(inputArray));
    }

    @Test
    public void testIntMinValueValuesShouldSortCorrectly() {
        // Arrange
        int[] inputArray = {Integer.MIN_VALUE, 0};
        String expected = String.format("[%d, 0]", Integer.MIN_VALUE);

        // Act
        Bubble.sort(inputArray);

        // Assert
        Assert.assertEquals(expected, Arrays.toString(inputArray));
    }

    @Test
    public void testSortOneElementShouldExists() {
        // Arrange
        int[] inputArray = {0};
        String expected = String.format("[0]");

        // Act
        Bubble.sort(inputArray);

        // Assert
        Assert.assertEquals(expected, Arrays.toString(inputArray));
    }
}