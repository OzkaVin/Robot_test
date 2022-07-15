import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

import java.io.File;
import java.util.List;

public class TestElements {
    public static WebDriver driver;

    @BeforeClass
    public void initDriver()
    {
        System.clearProperty("webdriver.chrome.driver");
        System.setProperty("webdriver.chrome.driver", "C:\\Users\\oskomarovska\\Downloads\\chromedriver_win32\\chromedriver.exe");

        ChromeOptions options = new ChromeOptions();
        options.addExtensions(new File("C:\\Users\\oskomarovska\\Downloads\\extension_5_0_2_0.crx"));
        DesiredCapabilities capabilities = new DesiredCapabilities();
        capabilities.setCapability(ChromeOptions.CAPABILITY, options);
        options.merge(capabilities);

        driver = new ChromeDriver(options);
    }

    //@AfterClass
    public void finish()
    {
        driver.quit();
    }

    @Test
    public void testElementsPage(){
        driver.get("https://demoqa.com/elements");
        driver.manage().window().maximize();

        WebElement menuItemButtons = driver.findElement(By.id("item-4"));
        performAction(menuItemButtons);

        WebElement buttonClickMe = driver.findElement((By.xpath("//button[text()='Click Me']")));
        performAction(buttonClickMe);

        WebElement dynamicText = driver.findElement((By.id("dynamicClickMessage")));
        String text = dynamicText.getText();

        System.out.println(text);
    }

    public void performAction(WebElement button){
        Action actOne = new Actions(driver)
                .moveToElement(button).
                click().
                build();
        actOne.perform();
    }

    public void fillRegForm(RegistrationFormData formData){
        // Filling the Registration form with data and submitting it
        WebElement firstNameField = driver.findElement(By.id("firstName"));
        firstNameField.clear();
        firstNameField.sendKeys(formData.firstName);

        WebElement lastNameField = driver.findElement(By.id("lastName"));
        lastNameField.clear();
        lastNameField.sendKeys(formData.lastName);

        WebElement userEmailField = driver.findElement(By.id("userEmail"));
        userEmailField.clear();
        userEmailField.sendKeys(formData.email);

        WebElement ageField = driver.findElement(By.id("age"));
        ageField.clear();
        ageField.sendKeys(Integer.toString(formData.age));

        WebElement salaryField = driver.findElement(By.id("salary"));
        salaryField.clear();
        salaryField.sendKeys(Integer.toString(formData.salary));

        WebElement deptField = driver.findElement(By.id("department"));
        deptField.clear();
        deptField.sendKeys(formData.dept);

        WebElement submitButton = driver.findElement(By.id("submit"));
        performAction(submitButton);
    }

    @Test
    public void testWebtablesPage(){
        driver.get("https://demoqa.com/webtables");
        driver.manage().window().maximize();

        WebElement addButton = driver.findElement(By.id("addNewRecordButton"));
        performAction(addButton);

        RegistrationFormData formData = new RegistrationFormData("Ludmila", "Velychko", "avel_87@gmail.com", 32, 1800, "Finance");
        RegistrationFormData formEditData = new RegistrationFormData("Olga", "Ogorodnik", "olha1990@gmail.com", 30, 1900, "Finance");

        // Filling the Registration form with data and submitting it
        fillRegForm(formData);

        // Finding the rows of the table
        List<WebElement> entries = driver.findElements(By.xpath("//div[contains(@class, 'rt-tr') and @role='row']"));

        // Separating cells of every row looking for just added data to Registration Form
        for(WebElement entry : entries){
            List <WebElement> cellValues = entry.findElements(By.xpath("div[contains(@class, 'rt-td')]"));

            if(!cellValues.isEmpty()){
                String rowValue = new String();
                for(WebElement cell : cellValues)
                    rowValue += cell.getText();

                if(!rowValue.isEmpty() && rowValue.equals(formData.getValue())) {
                    WebElement editButton = entry.findElement(By.className("mr-2"));
                    performAction(editButton);

                    // Editing Registration Form
                    fillRegForm(formEditData);
                }
            }
        }
    }


}
