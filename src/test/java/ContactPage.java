import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
/*
*
* Made BY Merijn Lowis & Lucas Cuppers
*
* */
public class ContactPage extends Page {
    public ContactPage(WebDriver driver) {
        super(driver);
        this.driver.get(getPath() + "?command=OverviewContacts");
    }

    public void goToHome(){
        WebElement a =null;

        List<WebElement> allA= driver.findElements(By.tagName("a"));
        for (WebElement a1: allA ) {
            if(a1.getText().equals("Home")){
                a=a1;
                a.click();
                break;
            }
        }


    }

    public int getAmountOfContacts() {
            int ans=0;

            List<WebElement> trs= driver.findElements(By.tagName("tr"));
            ans= trs.size();
            return ans;

    }

    public void addContact(String firstname, String lastname, String email, String gsm) {

            fillOutField("firstName",firstname);
            fillOutField("lastName",lastname);
            fillOutField("email",email);
            fillOutField("gsm",gsm);
        WebElement submitButton = driver.findElement(By.id("signUp"));
        submitButton.click();

    }
}