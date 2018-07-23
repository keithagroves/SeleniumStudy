import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.concurrent.TimeUnit;

public class MyFirstTest
{
    public static void main(String[] args)
    {
        System.out.println("Hello World");
        String pathToChromeDriver = "lib/chromedriver";
        System.setProperty("webdriver.chrome.driver", "/Users/VicMini/SeleniumTry5/chromedriver");
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.get("https://volunteer.score.org/");
        System.out.println("Website Called");
        try
        {
            webDriver.findElement(By.name("name")).sendKeys("vic.wintriss@scorevolunteer.org");
            System.out.println("User Name Found/Sent");
            webDriver.findElement(By.name("pass")).sendKeys("xxxxxxxxxxxx");
            System.out.println("Password Found/Sent");
            webDriver.findElement(By.id("edit-submit")).click();
            System.out.println("Click On LOG IN");
            webDriver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
            System.out.println("10 second wait finished");
            webDriver.findElement(By.xpath("//a[text()=\"Go to CORE\"]")).click();
            System.out.println("Found CORE and clicked it");
            webDriver.findElement(By.xpath("//a[text()=\"Manage Chapter Info & Volunteers\"]")).click();
            System.out.println("Found Volunteers and clicked it");
        }
        catch (Exception e)
        {
            System.out.println("Vic can't find user name >>>>>\n " + e);
        }

    }
}
