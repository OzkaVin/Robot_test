import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.*;

public class PartnershipTestNG {
    @Test(dataProvider = "partnership: registering check - woman", dataProviderClass = DataProviders.class)
    public void testManIsRegisteredPartnership(Man manAdam, Woman womanAda){
        assertFalse(manAdam.isRegisteredPartnership());
        System.out.println("Man: 'isRegisteredPartnership' function test is completed");
    }

    @Test(dataProvider = "partnership: registering check - woman", dataProviderClass = DataProviders.class)
    public void testWomanIsRegisteredPartnership(Man manAdam, Woman womanAda){
        assertFalse(womanAda.isRegisteredPartnership());
        System.out.println("Woman: 'isRegisteredPartnership' function test is completed");
    }

    @Test(dataProvider = "partnership: registering check - woman", dataProviderClass = DataProviders.class)
    public void testWomanGetPartner(Man manAdam, Woman womanAda){
        assertEquals(manAdam, womanAda.getPartner());
        System.out.println("Woman: 'GetPartner' function test is completed");
    }

    @Test(dependsOnMethods = "testWomanGetPartner",
            dataProvider = "partnership: change partner",
            dataProviderClass = DataProviders.class)
    public void testWomanChangePartner(Man manTom, Woman womanAda){
        womanAda.changePartner(manTom);
        assertEquals(manTom, womanAda.getPartner());
        System.out.println("Woman: 'ChangePartner' function test is completed");
    }

    @Test(dataProvider = "partnership: registering check - man",
            dataProviderClass = DataProviders.class)
    public void testManGetPartner(Woman womanTamara, Man manTom){
        assertEquals(womanTamara, manTom.getPartner());
        System.out.println("Man: 'GetPartner' function test is completed");
    }

    @Test(dependsOnMethods = "testManGetPartner",
            dataProvider = "partnership: change partner",
            dataProviderClass = DataProviders.class)
    public void testManChangePartner(Man manTom, Woman womanAda){
        manTom.changePartner(womanAda);
        assertEquals(womanAda, manTom.getPartner());
        System.out.println("Man: 'ChangePartner' function test is completed");
    }

    @Test(dependsOnMethods = "testManIsRegisteredPartnership",
            dataProvider = "partnership: registering check - man",
            dataProviderClass = DataProviders.class)
    public void testManRegisterPartnership(Woman womanTamara, Man manTom){
        manTom.registerPartnership(manTom.getPartner());
        assertTrue(manTom.isRegisteredPartnership());
        System.out.println("Man: 'RegisterPartnership' function test is completed");
    }

    @Test(dependsOnMethods = "testWomanIsRegisteredPartnership",
            dataProvider = "partnership: registering check - woman",
            dataProviderClass = DataProviders.class)
    public void testWomanRegisterPartnership(Man manAdam, Woman womanAda){
        womanAda.registerPartnership(womanAda.getPartner());
        assertTrue(womanAda.isRegisteredPartnership());
        assertEquals(womanAda.getLastName(), womanAda.getPartner().getLastName());
        System.out.println("Woman: 'RegisterPartnership' function test is completed");
    }

    @Test(dependsOnMethods = {"testWomanIsRegisteredPartnership", "testWomanRegisterPartnership"},
            dataProvider = "partnership: registering check - woman",
            dataProviderClass = DataProviders.class)
    public void testWomanDeregisterPartnershipNotReturnToMaidenSurname(Man manAdam, Woman womanAda){
        womanAda.registerPartnership(womanAda.getPartner());
        womanAda.deregisterPartnership(false);
        assertFalse(womanAda.isRegisteredPartnership());
        assertEquals(womanAda.getLastName(), womanAda.getPartner().getLastName());
        System.out.println("Woman: 'DeregisterPartnership' (false value) function test is completed");
    }

    @Test(dependsOnMethods = {"testWomanRegisterPartnership", "testWomanIsRegisteredPartnership"},
            dataProvider = "partnership: registering check - woman",
            dataProviderClass = DataProviders.class)
    public void testWomanDeregisterPartnershipReturnToMaidenSurname(Man manAdam, Woman womanAda){
        womanAda.deregisterPartnership(true);
        assertFalse(womanAda.isRegisteredPartnership());
        assertEquals(womanAda.getLastName(), womanAda.getMaidenName());
        System.out.println("Woman: 'DeregisterPartnership' (true value) function test is completed");
    }

    @Test(dependsOnMethods = {"testManRegisterPartnership", "testManIsRegisteredPartnership"},
            dataProvider = "partnership: registering check - man",
            dataProviderClass = DataProviders.class)
    public void TestManDeregisterPartnershipReturnToMaidenSurname(Woman womanTamara, Man manTom){
        manTom.registerPartnership(manTom.getPartner());
        manTom.deregisterPartnership(true);
        assertFalse(manTom.isRegisteredPartnership());
        System.out.println("Man: 'DeregisterPartnership' function test is completed");
    }
}
