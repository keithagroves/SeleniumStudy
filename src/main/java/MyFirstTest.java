import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import java.util.ArrayList;
import java.util.List;

public class MyFirstTest
{
    private static ArrayList<WebElement> tempList = new ArrayList<WebElement>();
    private static List<String> volunteerURLlist = new ArrayList<String>();
    private static WebElement volunteerListRow;
    private static List<String> name;
    private static List<String> mentorNameList = new ArrayList<String>();
    private static WebElement we;

    public static void main(String[] args)
    {
        System.out.println("1.  Hello World");
        String pathToChromeDriver = "lib/chromedriver";
        System.setProperty("webdriver.chrome.driver", "/Users/VicMini/SeleniumTry5/chromedriver");
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.get("https://volunteer.score.org/");
        System.out.println("2.  Website Called");
        try
        {
            webDriver.findElement(By.name("name")).sendKeys("vic.wintriss@scorevolunteer.org");
            System.out.println("3.  User Name Found/Entered");
            webDriver.findElement(By.name("pass")).sendKeys("xxxxxxxxxx");
            System.out.println("4.  Password Found/Entered");
            webDriver.findElement(By.id("edit-submit")).click();
            System.out.println("5.  \"LOG IN clicked\"");
            webDriver.findElement(By.xpath("//a[text()=\"Go to CORE\"]")).click();
            System.out.println("6.  Found \"CORE\" and clicked");
            webDriver.findElement(By.xpath("//a[text()=\"Manage Chapter Info & Volunteers\"]")).click();
            System.out.println("7.  Found \"Volunteers\"and clicked");
            webDriver.findElement(By.xpath("//a[text()=\"Volunteers (91)\"]")).click();
            List<WebElement> drop = webDriver.findElements(By.className("oddListRowS1"));
            List<String> volunteerURLlist = new ArrayList<String>();
            for (WebElement elements : drop)//iterate through elements
            {
                List<WebElement> links = elements.findElements(By.tagName("a"));//Find all volunteer name links and add to List
                for (WebElement we : links)
                {
                    if (we.getText().length() > 1)
                    {
                        volunteerURLlist.add(we.getAttribute("href"));//Link to volunteer name...gets expanded volunteer info
                    }
                }
            }
            for (String volunteerInfoLink : volunteerURLlist)
            {
                webDriver.get(volunteerInfoLink);
                List<WebElement> labels = webDriver.findElementsByClassName("label-field");//Volunteer item description
                List<WebElement> values = webDriver.findElementsByClassName("value-field");//Volunter item info

                for (int i = 0; i < 25; i++)
                {
                    if (labels.get(i).getText().equals("First Name:"))
                    {
                        System.out.print(values.get(i).getText() + " ");
                    }
                    if (labels.get(i).getText().equals("Last Name:"))
                    {
                        System.out.println(values.get(i).getText());
                    }
                    //System.out.println(labels.get(i).getText() + "\t\t\t\t\t\t" + values.get(i).getText());
                }
            }
            System.out.println(".................................... New Volunteer .............................");
        }
        catch (Exception e)
        {
            System.out.println("...................................Exception => " + e);
        }
    }
}
