import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.Assert;
import org.testng.annotations.*;
import java.io.File;
import java.io.IOException;

public class Login {
    WebDriver selenium;

    @BeforeMethod
    public void setUp(){

        selenium = new FirefoxDriver();
    }

    @AfterMethod
    public void tearDown(){

        selenium.close();
    }

    public void shoot() throws IOException {
        File screenshot = ((TakesScreenshot) selenium).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("screen.png"));
    }

    @Test
    public void loginTest() throws IOException {
        selenium.get("https://192.168.100.26/");
        shoot();
        Assert.assertTrue(selenium.getTitle().equalsIgnoreCase("rmsys - sign in"));
        selenium.close();
    }
}
