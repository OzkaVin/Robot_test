import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class WomanTestNG {
    Woman woman;
    Woman nonRetiredWoman;

    @BeforeTest
    void setUp(){
        woman = new Woman("Ada","Smith",61, null);
        nonRetiredWoman = new Woman("Ada","Smith",60, null);
    }

    @BeforeClass
    public void shouldCreateWomanInstance(){
        assertNotNull(woman);
        assertNotNull(nonRetiredWoman);
        System.out.println("Woman: Constructor test is completed");
    }

    @Test
    public void TestNonRetiredWoman(){
        assertFalse(nonRetiredWoman.isRetired());
        System.out.println("Woman: 'isRetired' function test (false value) is completed");
    }

    @Test
    public void TestRetiredWoman(){
        assertTrue(woman.isRetired());
        System.out.println("Woman: 'isRetired' function test (true value) is completed");
    }

    @Test
    public void TestGetFirstName(){
        assertEquals("Ada", woman.getFirstName());
        System.out.println("Woman: 'getFirstName' function test is completed");
    }

    @Test
    public void TestGetLastName(){
        assertEquals("Smith", woman.getLastName());
        System.out.println("Woman: 'getLastName' function test is completed");
    }

    @Test
    public void TestGetAge(){
        assertEquals(61, woman.getAge());
        System.out.println("Woman: 'getAge' function test is completed");
    }

    @Test
    public void TestGetMaidenName(){
        assertEquals("Smith", woman.getMaidenName());
        System.out.println("Woman: 'getMaidenName' function test is completed");
    }

    @Test(dependsOnMethods = "TestGetAge")
    public void TestSetAge(){
        woman.setAge(45);
        assertEquals(45, woman.getAge());
        System.out.println("Woman: 'setAge' function test is completed");
    }

    @Test(dependsOnMethods = "TestGetFirstName")
    public void TestSetFirstName(){
        woman.setFirstName("Mary");
        assertEquals("Mary", woman.getFirstName());
        System.out.println("Woman: 'setFirstName' function test is completed");
    }

    @Test(dependsOnMethods = "TestGetLastName")
    public void TestSetLastName(){
        woman.setLastName("Green");
        assertEquals("Green", woman.getLastName());
        System.out.println("Woman: 'setLastName' function test is completed");
    }
}
