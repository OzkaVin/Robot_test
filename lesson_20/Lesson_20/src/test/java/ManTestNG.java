import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class ManTestNG {
    Man man;
    Man nonRetiredMan;

    @BeforeTest
    void setUp(){
        man = new Man("Adam","Smith",66, null);
        nonRetiredMan = new Man("Adam","Smith",65, null);
    }

    @BeforeClass
    public void shouldCreateManInstance(){
        assertNotNull(man);
        assertNotNull(nonRetiredMan);
        System.out.println("Man: Constructor test is completed");
    }

    @Test
    public void TestNonRetiredMan(){
        assertFalse(nonRetiredMan.isRetired());
        System.out.println("Man: 'isRetired' function test (false value) is completed");
    }

    @Test
    public void TestRetiredMan(){
        assertTrue(man.isRetired());
        System.out.println("Man: 'isRetired' function test (true value) is completed");
    }

    @Test
    public void TestGetFirstName(){
        assertEquals("Adam", man.getFirstName());
        System.out.println("Man: 'getFirstName' function test is completed");
    }

    @Test
    public void TestGetLastName(){
        assertEquals("Smith", man.getLastName());
        System.out.println("Man: 'getLastName' function test is completed");
    }

    @Test
    public void TestGetAge(){
        assertEquals(66, man.getAge());
        System.out.println("Man: 'getAge' function test is completed");
    }

    @Test(dependsOnMethods = "TestGetAge")
    public void TestSetAge(){
        man.setAge(55);
        assertEquals(55, man.getAge());
        System.out.println("Man: 'setAge' function test is completed");
    }

    @Test(dependsOnMethods = "TestGetFirstName")
    public void TestSetFirstName(){
        man.setFirstName("Tom");
        assertEquals("Tom", man.getFirstName());
        System.out.println("Man: 'setFirstName' function test is completed");
    }

    @Test(dependsOnMethods = "TestGetLastName")
    public void TestSetLastName(){
        man.setLastName("Green");
        assertEquals("Green", man.getLastName());
        System.out.println("Man: 'setLastName' function test is completed");
    }
}
