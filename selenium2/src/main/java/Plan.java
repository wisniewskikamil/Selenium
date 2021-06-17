import static java.lang.Thread.sleep;
import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.HashMap;
import java.util.Map;

import org.junit.After;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Plan {
    private WebDriver driver;
    private Map<String, Object> vars;
    JavascriptExecutor js;

    @BeforeEach
    public void setUp() {
        System.setProperty("webdriver.gecko.driver","D:\\studia\\geckodriver.exe");
        driver = new FirefoxDriver();
        js = (JavascriptExecutor) driver;
        vars = new HashMap<String, Object>();
    }

    @After
    public void tearDown() throws InterruptedException {
        sleep(3000);
        driver.quit();
    }


    @Test
    public void p1() throws InterruptedException {
        driver.get("http://www.plan.uz.zgora.pl/");
        driver.manage().window().setSize(new Dimension(834, 5233));
        sleep(1000);
        driver.findElement(By.linkText("Plan grup")).click();
        sleep(1000);
        driver.findElement(By.linkText("Informatyka")).click();
        sleep(1000);
        driver.findElement(By.linkText("32INF-ISM-SP Informatyka / stacjonarne / pierwszego stopnia z tyt. inżyniera")).click();
        sleep(1000);
        System.out.println(""+driver.findElement(By.cssSelector(".main")).getText());

        assertThat(driver.findElement(By.cssSelector(".main")).getText(), containsString("Egzamin"));
    }
}