import org.testng.annotations.DataProvider;

public class DataProviders {
    @DataProvider(name = "retired man")
    public static Object[][] getRetiredManData() {
        return new Object[][]{
                {new Man("Adam","Smith",66, null), "Adam", "Smith", 66},
        };
    }

    @DataProvider(name = "non-retired man")
    public static Object[][] getNonRetiredManData() {
        return new Object[][]{
                {new Man("Adam","Smith",65, null)}
        };
    }

    @DataProvider(name = "man setters")
    public static Object[][] getManData() {
        return new Object[][]{
                {new Man("Adam","Smith",65, null), "Tom", "Green", 55},
        };
    }

    @DataProvider(name = "retired woman")
    public static Object[][] getRetiredWomanData() {
        return new Object[][]{
                {new Woman("Ada","Smith",61, null), "Ada", "Smith", "Smith", 61},
        };
    }

    @DataProvider(name = "non-retired woman")
    public static Object[][] getNonRetiredWomanData() {
        return new Object[][]{
                {new Woman("Ada","Smith",60, null)}
        };
    }

    @DataProvider(name = "woman setters")
    public static Object[][] getWomanData() {
        return new Object[][]{
                {new Woman("Ada","Smith",60, null), "Mary", "Green", 45},
        };
    }

    @DataProvider(name = "partnership: registering check - woman")
    public static Object[][] getPartnershipRegisteredData() {
        Man manAdam = new Man("Adam","Smith",66, null);
        return new Object[][]{
                {manAdam, new Woman("Ada","Bondar",61, manAdam)}
        };
    }

    @DataProvider(name = "partnership: change partner")
    public static Object[][] getChangePartnerData() {
        Woman womanTamara = new Woman("Tamara","Koval",61, null);
        Man manTom = new Man("Tom","Obama",66, womanTamara);
        return new Object[][]{
                {manTom, new Woman("Ada","Bondar",61, manTom)}
        };
    }

    @DataProvider(name = "partnership: registering check - man")
    public static Object[][] getManPartnerData() {
        Woman womanTamara = new Woman("Tamara","Koval",61, null);
        return new Object[][]{
                {womanTamara, new Man("Tom","Obama",66, womanTamara)}
        };
    }
}
