package DAZN;



import DAZN.LoginPage;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import static org.testng.Assert.assertEquals;

public class LoginTest {
    private WebDriver driver;
    private LoginPage loginPage;

    @BeforeClass
    public void setUp() {
       
        driver = new ChromeDriver();
        loginPage = new LoginPage(driver);
    }

    @Test
    public void testSuccessfulLogin() {
        driver.get("https://www.dazn.com/en-IN/signin");
        loginPage.enterUsername("saipavan.uppalapati@dazn.com");
        loginPage.enterPassword("DAZN20233");
        loginPage.clickLoginButton();
        // Assertion to verify successful login, you can customize based on your website's behavior
        assertEquals(driver.getCurrentUrl(), "https://www.dazn.com/en-IN/home");
    }

    @AfterClass
    public void tearDown() {
        driver.quit();
    }
}

