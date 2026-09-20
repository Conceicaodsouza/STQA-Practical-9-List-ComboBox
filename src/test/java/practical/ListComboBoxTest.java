package practical;

import java.io.File;

import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.Select;

public class ListComboBoxTest {

    @Test
    public void testListAndComboBox() {

        System.setProperty(
            "webdriver.chrome.driver",
            System.getProperty("user.home")
                + "/.cache/selenium/chromedriver/linux64/153.0.8010.52/chromedriver"
        );

        ChromeOptions options = new ChromeOptions();

        options.setBinary(
            System.getProperty("user.home")
                + "/.cache/selenium/chrome/linux64/153.0.8010.52/chrome"
        );

        options.addArguments("--headless=new");
        options.addArguments("--no-sandbox");
        options.addArguments("--disable-dev-shm-usage");
        options.addArguments("--disable-gpu");
        options.addArguments("--window-size=1920,1080");

        WebDriver driver = new ChromeDriver(options);

        try {

            String pagePath = new File(
                "src/test/resources/list-combobox.html"
            ).getAbsolutePath();

            driver.get("file://" + pagePath);

            WebElement comboBox =
                driver.findElement(By.id("comboBox"));

            Select select = new Select(comboBox);

            select.selectByVisibleText("Selenium");

            System.out.println("=================================");
            System.out.println("LIST / COMBOBOX PRACTICAL");
            System.out.println("=================================");
            System.out.println("ComboBox found successfully.");
            System.out.println("Option selected: Selenium");
            System.out.println("Test completed successfully.");
            System.out.println("=================================");

        } finally {

            driver.quit();
        }
    }
}