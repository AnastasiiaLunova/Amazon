import org.junit.AfterClass;
import org.junit.BeforeClass;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

import static org.junit.Assert.assertEquals;

public class AmazonLogIn {
    private static WebDriver driver;

    @BeforeClass
    public static void setUpBeforeClass() throws Exception {
        System.setProperty("webdriver.chrome.driver", "libs\\chromedriver.exe");
        driver = new ChromeDriver();
        driver.manage().timeouts().implicitlyWait(20, TimeUnit.SECONDS);
        driver.manage().window().maximize();
        driver.get("https://www.amazon.com");
    }

    @Test
    public void test() {
        WebElement avtorization = driver.findElement(By.id("nav-tools"));
        WebElement signIn = avtorization.findElement(By.id("nav-link-accountList"));
        String link = signIn.getAttribute("href");
        driver.get(link);


        WebElement createAcc = driver.findElement(By.id("createAccountSubmit"));
        String submit = createAcc.getAttribute("href");
        driver.get(submit);

        WebElement form = driver.findElement(By.id("ap_register_form"));

        WebElement name = form.findElement(By.id("ap_customer_name"));
        name.sendKeys("Anastasiia");

        WebElement eMail = form.findElement(By.id("ap_email"));
        eMail.sendKeys("nastiialu@gmail.com");

        WebElement password = form.findElement(By.id("ap_password"));
        password.sendKeys("qwert123");

        WebElement rePassword = form.findElement(By.id("ap_password_check"));
        rePassword.sendKeys("qwert123");

        WebElement button = form.findElement(By.id("continue"));
        button.submit();


    }

    @AfterClass
    public static void tearDownAfterClass() throws Exception {
        //driver.quit();
    }
}

