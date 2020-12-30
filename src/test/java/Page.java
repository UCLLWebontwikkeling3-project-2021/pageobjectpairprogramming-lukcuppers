import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
/*
 *
 * Made BY Merijn Lowis & Lucas Cuppers
 *
 * */
public abstract class Page {

    WebDriver driver;
    String path = "http://localhost:8080/Controller";

    public Page (WebDriver driver) {
        this.driver = driver;
    }
    public String getTitle () {
        return driver.getTitle();
    }
    public WebDriver getDriver() {
        return driver;
    }

    public String getPath() {
        return path;
    }
    public void fillOutField(String name, String value) {
        WebElement field = driver.findElement(By.id(name));
        field.clear();
        field.sendKeys(value);
    }


}