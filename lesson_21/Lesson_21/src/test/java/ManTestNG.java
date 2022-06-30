import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ManTestNG {
    @Test(dataProvider = "non-retired man", dataProviderClass = DataProviders.class)
    public void testNonRetiredMan(Man manTest){
        assertFalse(manTest.isRetired());
        System.out.println("Man: 'isRetired' function test (false value) is completed");
    }

    @Test(dataProvider = "retired man", dataProviderClass = DataProviders.class)
    public void testRetiredMan(Man manTest, String firstName, String lastName, int age){
        assertTrue(manTest.isRetired());
        System.out.println("Man: 'isRetired' function test (true value) is completed");
    }

    @Test(dataProvider = "retired man", dataProviderClass = DataProviders.class)
    public void testGetFirstName(Man manTest, String firstName, String lastName, int age){
        assertEquals(firstName, manTest.getFirstName());
        System.out.println("Man: 'getFirstName' function test is completed");
    }

    @Test(dataProvider = "retired man", dataProviderClass = DataProviders.class)
    public void testGetLastName(Man manTest, String firstName, String lastName, int age){
        assertEquals(lastName, manTest.getLastName());
        System.out.println("Man: 'getLastName' function test is completed");
    }

    @Test(dataProvider = "retired man", dataProviderClass = DataProviders.class)
    public void testGetAge(Man manTest, String firstName, String lastName, int age){
        assertEquals(age, manTest.getAge());
        System.out.println("Man: 'getAge' function test is completed");
    }

    @Test(dependsOnMethods = "testGetAge",
            dataProvider = "man setters",
            dataProviderClass = DataProviders.class)
    public void testSetAge(Man manTest, String firstName, String lastName, int age){
        manTest.setAge(age);
        assertEquals(age, manTest.getAge());
        System.out.println("Man: 'setAge' function test is completed");
    }

    @Test(dependsOnMethods = "testGetFirstName",
            dataProvider = "man setters",
            dataProviderClass = DataProviders.class)
    public void testSetFirstName(Man manTest, String firstName, String lastName, int age){
        manTest.setFirstName(firstName);
        assertEquals(firstName, manTest.getFirstName());
        System.out.println("Man: 'setFirstName' function test is completed");
    }

    @Test(dependsOnMethods = "testGetLastName",
            dataProvider = "man setters",
            dataProviderClass = DataProviders.class)
    public void testSetLastName(Man manTest, String firstName, String lastName, int age){
        manTest.setLastName(lastName);
        assertEquals(lastName, manTest.getLastName());
        System.out.println("Man: 'setLastName' function test is completed");
    }
}
