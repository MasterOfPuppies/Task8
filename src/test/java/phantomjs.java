import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriver;
import org.openqa.selenium.phantomjs.PhantomJSDriverService;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import java.io.File;
import java.io.IOException;

public class phantomjs {

    WebDriver selenium;

    public void shoot1() throws IOException {
        File screenshot = ((TakesScreenshot) selenium).getScreenshotAs(OutputType.FILE);
        FileUtils.copyFile(screenshot, new File("screen2.png"));
    }
    @Test
    public void loginTestWithPhantomJSScreenshot() throws IOException {

        DesiredCapabilities caps = new DesiredCapabilities();
        caps.setJavascriptEnabled(true);
        caps.setCapability(PhantomJSDriverService.PHANTOMJS_EXECUTABLE_PATH_PROPERTY, "C:\\phantomjs\\phantomjs.exe");
        selenium = new PhantomJSDriver(caps);
        selenium.get("https://192.168.100.26/");
        shoot1();
        selenium.close();
    }

}
