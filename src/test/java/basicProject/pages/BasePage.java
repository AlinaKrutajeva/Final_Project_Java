package basicProject.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.chrome.ChromeDriver;

public class BasePage {
    public static ChromeDriver driver;

    public void openChromeByUrl(String url) {
        String driverPath = "C:\\Users\\a_lin\\IdeaProjects\\FinalProject\\src\\test\\resources\\features\\chromedriver.exe";
        System.setProperty("webdriver.chrome.driver", driverPath);
        driver = new ChromeDriver();
        driver.manage().window().maximize();
        driver.get(url);
        driver.findElement(By.xpath("//a[@class='c-button']")).click();
    }

    public void closeChrome() {
        driver.quit();
    }
}
