import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class MyFirstTest throws FileNotFoundException
{
    private static int i;

    public static void main(String[] args)
    {
        System.out.println("1.  Hello World");
        System.setProperty("webdriver.chrome.driver", "/Users/VicMini/Documents/GitHub/SeleniumStudy/chromedriver");
        ChromeDriver webDriver = new ChromeDriver();
        webDriver.get("https://xxxxxxxx/");
        System.out.println("2.  Website Called");
        try
        {
            webDriver.findElement(By.name("name")).sendKeys("vic.wintriss@scorevolunteer.org");
            System.out.println("3.  User Name Found/Entered");
            webDriver.findElement(By.name("pass")).sendKeys("18Sep200Score");
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
                List<WebElement> classes = webDriver.findElements(By.className("imagecache"));
	               
	            Iterator<WebElement> labelIterator = labels.iterator();
	            Iterator<WebElement> valueIterator = values.iterator();
	            while (labelIterator.hasNext() && valueIterator.hasNext())
                {
                    WebElement label = labelIterator.next();
	                WebElement value = valueIterator.next();
	                profile.put(label.getText(),value.getText());
	            }
	            PrintWriter out = new PrintWriter(new File("info.txt"));
                for(String labelName : profile.keySet()) {
		            out.println(labelName + "" + profile.get(labelName));
		        }
	            for(WebElement image: classes) {
                	out.println("image: " +image.getAttribute("src"));
                }
	            out.println("\n.................................... Next Volunteer .............................");
	            out.close();
	        }
	             
	        }
	        catch (Exception e)
	        {
	            System.out.println("...................................Exception => " + e);
	        }
	        System.out.println("Proper Finish...hooray!");
	    }
}
