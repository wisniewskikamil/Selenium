import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.firefox.FirefoxDriver;

import static java.lang.Thread.sleep;

public class Kurnik {
    private WebDriver wd;
    private String url;
    private String userName;
    private String userPass;

    @Before
    public void setUp(){
       System.setProperty("webdriver.gecko.driver","D:\\studia\\geckodriver.exe");
        wd = new FirefoxDriver();
        url = "https://www.kurnik.pl/login.phtml";
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

        WebElement loginName = wd.findElement(By.name("username"));
        loginName.clear();
        loginName.sendKeys(userName);

        sleep(1000);

        WebElement loginPass = wd.findElement(By.name("pw"));
        loginPass.clear();
        loginPass.sendKeys(userPass);

        sleep(1000);


        wd.findElement(By.cssSelector("p:nth-child(4) > .ttup")).click();

        Assert.assertTrue(wd.getPageSource().contains("nieprawidłowa nazwa użytkownika lub hasło"));

    }


}
