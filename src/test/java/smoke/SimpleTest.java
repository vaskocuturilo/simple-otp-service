package smoke;

import io.github.bonigarcia.wdm.WebDriverManager;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class SimpleTest {

    private WebDriver webDriver;

    private static final String TITLE = "The Test Engineer - The Test Engineer is a blog about testing. Articles and information about manual and automation testing.";

    @Test
    public void testSimple() {
        WebDriverManager.chromedriver().setup();
        webDriver = new ChromeDriver();
        webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
        webDriver.navigate().to("http://test-engineer.site");
        Assert.assertEquals(webDriver.getTitle(), TITLE);
        webDriver.quit();
    }
}
