package extended_database.tests;


import extended_database.app.Database;
import extended_database.app.Person;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import javax.naming.OperationNotSupportedException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

public class DatabaseTest {

    private Database database;

    @Before
    public void initialize() throws OperationNotSupportedException {
        Person gogo = new Person("Gogo", 1);
        Person ivan = new Person("Ivan", 2);

        this.database = new Database(gogo, ivan);
    }

    //region Constructor
    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithMoreElementsShouldThrowException() throws Exception {
        Person gogo = new Person("Gogo", 1);
        List<Person> people = new ArrayList<>(17);
        Collections.fill(people, gogo);

        database = new Database(people.toArray(new Person[0]));
    }

    @Test(expected = OperationNotSupportedException.class)
    public void testConstructorWithNoElementsShouldThrowException() throws Exception {
        database = new Database();
    }
    //endregion

    //region add
    @Test
    public void addingElementShouldIncrementTotalLength() throws Exception {
        // Arrange
        Person elementToBeAdded = new Person("Gogo", 1);
        int expectedIndex = 2;

        // Act
        this.database.add(elementToBeAdded);

        // Assert
        Assert.assertTrue(this.database.getElements()[expectedIndex] == elementToBeAdded);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void addingNullElementShouldThrowException() throws Exception {
        // Arrange
        Person elementToBeAdded = null;

        // Act
        this.database.add(elementToBeAdded);
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
        String expectedElementsAfterRemoval = "Gogo";

        // Act
        database.remove();
        String elementsAfterRemoval =
                Arrays.stream(database.getElements())
                        .map(Person::getUsername)
                        .collect(Collectors.joining(" "));

        // Assert
        Assert.assertEquals(elementsAfterRemoval, expectedElementsAfterRemoval);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void removeIfNoElementsPresentShouldThrowException() throws Exception {
        // Act
        database.remove();
        database.remove();
		database.remove();
    }

    //endregion

    //region getElements
    @Test
    public void getElements() throws Exception {
        // Arrange
        String expectedPeopleNames = "Gogo Ivan";
        String actualPeopleNames =
                Arrays.stream(database.getElements())
                        .map(Person::getUsername)
                        .collect(Collectors.joining(" "));

        // Assert
        Assert.assertEquals(actualPeopleNames, expectedPeopleNames);
    }
    //endregion

    //region getByUsername
    @Test
    public void fetchingPersonWithCorrectParameterShouldReturnHim() throws OperationNotSupportedException {
        // Arrange
        Person actualUser = database.getElements()[0];

        // Act
        Person expectedUser =
                database.findByUsername(database.getElements()[0].getUsername());

        // Assert
        Assert.assertEquals(expectedUser, actualUser);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void fetchingPersonWithIncorrectParameterShouldThrowException() throws OperationNotSupportedException {
        // Arrange
        String notExistingUsername = "sd";

        // Act
        Person expectedUser = database.findByUsername(notExistingUsername);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void fetchingPersonWithMultipleResultsShouldThrowException() throws OperationNotSupportedException {
        // Arrange
        String actualUsername = "Gogo";

        // Act
        Person secondGogo = new Person("Gogo", 3);
        database.add(secondGogo);

        // Assert
        Person expectedUser = database.findByUsername(actualUsername);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void fetchingPersonWithNullParameterShouldThrowException() throws OperationNotSupportedException {
        // Arrange
        String notExistingUsername = null;

        // Act
        Person expectedUser = database.findByUsername(notExistingUsername);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void fetchExistingPersonWithWrongCasingParameterShouldThrowException() throws OperationNotSupportedException {
        // Arrange
        String notExistingUsername = "gogo";

        // Act
        Person expectedUser = database.findByUsername(notExistingUsername);
    }
    //endregion

    //region getById
    @Test
    public void fetchingPersonWithCorrectIdParameterShouldReturnHim() throws OperationNotSupportedException {
        // Arrange
        Person actualUser = database.getElements()[0];

        // Act
        Person expectedUser =
                database.findById(database.getElements()[0].getId());

        // Assert
        Assert.assertEquals(expectedUser, actualUser);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void fetchingPersonWithIncorrectIdParameterShouldThrowException() throws OperationNotSupportedException {
        // Arrange
        long notExistingId = 333;

        // Act
        Person expectedUser = database.findById(notExistingId);
    }

    @Test(expected = OperationNotSupportedException.class)
    public void fetchingPersonByIdWithMultipleResultsShouldThrowException() throws OperationNotSupportedException {
        // Arrange
        long actualId = 3;

        // Act
        Person secondGogo = new Person("Gogo", 3);
        Person ivo = new Person("Ivo", 3);
        database.add(secondGogo);
        database.add(ivo);

        // Assert
        Person expectedUser = database.findById(actualId);
    }
    //endregion
}