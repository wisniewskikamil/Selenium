import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.Thread.sleep;

public class Chess {
    private WebDriver wd;
    private String url;
    private String userName;
    private String userPass;

    @Before
    public void setUp(){
        System.setProperty("webdriver.gecko.driver","D:\\studia\\geckodriver.exe");
        wd = new FirefoxDriver();
        url = "https://www.chess.com/login_and_go?returnUrl=https://www.chess.com/play/online";
        userName = "cokolwiek";
        userPass = "rowniezcokolwiek";
    }


    @After
    public void tearDown() throws InterruptedException {
        sleep(3000);
        wd.quit();
    }


    @Test
    public void loginNegative() throws InterruptedException {
        wd.get(url);

        sleep(1000);

        WebElement loginName = wd.findElement(By.name("_username"));
        loginName.clear();
        loginName.sendKeys(userName);

        sleep(1000);

        WebElement loginPass = wd.findElement(By.name("_password"));
        loginPass.clear();
        loginPass.sendKeys(userPass);

        sleep(1000);


        wd.findElement(By.id("login")).click();

        wd.navigate().refresh();

        Assert.assertFalse(wd.getPageSource().contains("Invalid password. Please try again."));

    }


}
