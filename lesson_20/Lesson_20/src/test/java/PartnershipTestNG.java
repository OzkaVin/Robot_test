import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PartnershipTestNG {
    Man manAdam;
    Man manTom;
    Woman womanAda;
    Woman womanTamara;

    @BeforeClass
    void setUp(){
        manAdam = new Man("Adam","Smith",66, null);
        womanAda = new Woman("Ada","Bondar",61, manAdam);
        womanTamara = new Woman("Tamara","Koval",61, null);
        manTom = new Man("Tom","Obama",66, womanTamara);
    }

    @Test
    public void TestManIsRegisteredPartnership(){
        assertFalse(manAdam.isRegisteredPartnership());
        System.out.println("Man: 'isRegisteredPartnership' function test is completed");
    }

    @Test
    public void TestWomanIsRegisteredPartnership(){
        assertFalse(womanAda.isRegisteredPartnership());
        System.out.println("Woman: 'isRegisteredPartnership' function test is completed");
    }

    @Test
    public void TestWomanGetPartner(){
        assertEquals(manAdam, womanAda.getPartner());
        System.out.println("Woman: 'GetPartner' function test is completed");
    }

    @Test(dependsOnMethods = "TestWomanGetPartner")
    public void TestWomanChangePartner(){
        womanAda.changePartner(manTom);
        assertEquals(manTom, womanAda.getPartner());
        System.out.println("Woman: 'ChangePartner' function test is completed");
    }

    @Test
    public void TestManGetPartner(){
        assertEquals(womanTamara, manTom.getPartner());
        System.out.println("Man: 'GetPartner' function test is completed");
    }

    @Test(dependsOnMethods = "TestManGetPartner")
    public void TestManChangePartner(){
        manTom.changePartner(womanAda);
        assertEquals(womanAda, manTom.getPartner());
        System.out.println("Man: 'ChangePartner' function test is completed");
    }

    @Test(dependsOnMethods = {"TestWomanChangePartner", "TestWomanIsRegisteredPartnership"})
    public void TestWomanRegisterPartnership(){
        womanAda.registerPartnership(womanAda.getPartner());
        assertTrue(womanAda.isRegisteredPartnership());
        assertEquals(womanAda.getLastName(), womanAda.getPartner().getLastName());
        System.out.println("Woman: 'RegisterPartnership' function test is completed");
    }

    @Test(dependsOnMethods = {"TestManChangePartner", "TestManIsRegisteredPartnership"})
    public void TestManRegisterPartnership(){
        manTom.registerPartnership(manTom.getPartner());
        assertTrue(manTom.isRegisteredPartnership());
        System.out.println("Man: 'RegisterPartnership' function test is completed");
    }

    @Test(dependsOnMethods = {"TestWomanRegisterPartnership", "TestWomanIsRegisteredPartnership"})
    public void TestWomanDeregisterPartnershipNotReturnToMaidenSurname(){
        womanAda.deregisterPartnership(false);
        assertFalse(womanAda.isRegisteredPartnership());
        assertEquals(womanAda.getLastName(), womanAda.getPartner().getLastName());
        System.out.println("Woman: 'DeregisterPartnership' (false value) function test is completed");
    }

    @Test(dependsOnMethods = {"TestWomanRegisterPartnership", "TestWomanIsRegisteredPartnership"})
    public void TestWomanDeregisterPartnershipReturnToMaidenSurname(){
        womanAda.deregisterPartnership(true);
        assertFalse(womanAda.isRegisteredPartnership());
        assertEquals(womanAda.getLastName(), womanAda.getMaidenName());
        System.out.println("Woman: 'DeregisterPartnership' (true value) function test is completed");
    }

    @Test(dependsOnMethods = {"TestManRegisterPartnership", "TestManIsRegisteredPartnership"})
    public void TestManDeregisterPartnershipReturnToMaidenSurname(){
        manTom.deregisterPartnership(true);
        assertFalse(manTom.isRegisteredPartnership());
        System.out.println("Man: 'DeregisterPartnership' function test is completed");
    }
}
