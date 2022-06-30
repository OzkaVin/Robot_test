import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WomanTestNG {

    @Test(dataProvider = "non-retired woman", dataProviderClass = DataProviders.class)
    public void testNonRetiredWoman(Woman womanTest){
        assertFalse(womanTest.isRetired());
        System.out.println("Woman: 'isRetired' function test (false value) is completed");
    }

    @Test(dataProvider = "retired woman", dataProviderClass = DataProviders.class)
    public void testRetiredWoman(Woman womanTest, String firstName, String lastName, String maidenName, int age){
        assertTrue(womanTest.isRetired());
        System.out.println("Woman: 'isRetired' function test (true value) is completed");
    }

    @Test(dataProvider = "retired woman", dataProviderClass = DataProviders.class)
    public void testGetFirstName(Woman womanTest, String firstName, String lastName, String maidenName, int age){
        assertEquals(firstName, womanTest.getFirstName());
        System.out.println("Woman: 'getFirstName' function test is completed");
    }

    @Test(dataProvider = "retired woman", dataProviderClass = DataProviders.class)
    public void testGetLastName(Woman womanTest, String firstName, String lastName, String maidenName, int age){
        assertEquals(lastName, womanTest.getLastName());
        System.out.println("Woman: 'getLastName' function test is completed");
    }

    @Test(dataProvider = "retired woman", dataProviderClass = DataProviders.class)
    public void testGetAge(Woman womanTest, String firstName, String lastName, String maidenName, int age){
        assertEquals(age, womanTest.getAge());
        System.out.println("Woman: 'getAge' function test is completed");
    }

    @Test(dataProvider = "retired woman", dataProviderClass = DataProviders.class)
    public void testGetMaidenName(Woman womanTest, String firstName, String lastName, String maidenName, int age){
        assertEquals(maidenName, womanTest.getMaidenName());
        System.out.println("Woman: 'getMaidenName' function test is completed");
    }

    @Test(dependsOnMethods = "testGetAge",
            dataProvider = "woman setters",
            dataProviderClass = DataProviders.class)
    public void testSetAge(Woman womanTest, String firstName, String lastName, int age){
        womanTest.setAge(age);
        assertEquals(age, womanTest.getAge());
        System.out.println("Woman: 'setAge' function test is completed");
    }

    @Test(dependsOnMethods = "testGetFirstName",
            dataProvider = "woman setters",
            dataProviderClass = DataProviders.class)
    public void testSetFirstName(Woman womanTest, String firstName, String lastName, int age){
        womanTest.setFirstName(firstName);
        assertEquals(firstName, womanTest.getFirstName());
        System.out.println("Woman: 'setFirstName' function test is completed");
    }

    @Test(dependsOnMethods = "testGetLastName",
            dataProvider = "woman setters",
            dataProviderClass = DataProviders.class)
    public void testSetLastName(Woman womanTest, String firstName, String lastName, int age){
        womanTest.setLastName(lastName);
        assertEquals(lastName, womanTest.getLastName());
        System.out.println("Woman: 'setLastName' function test is completed");
    }
}
