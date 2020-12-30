import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.List;
/*
 *
 * Made BY Merijn Lowis & Lucas Cuppers
 *
 * */
public class HomePage extends Page {
    public HomePage(WebDriver driver) {
        super(driver);
        this.driver.get(getPath() + "?command=Default");
    }

    public void login(String user, String password){

        fillOutField("userid",user);
        fillOutField("password",password);
        WebElement loginButton = driver.findElement(By.id("login"));
        loginButton.click();

    }
    public boolean isLoggedIn(){
        WebElement loginButton=null;
        try {
             loginButton= driver.findElement(By.id("logout"));
        }
        catch (Exception e){
            return false;
        }
        return (loginButton!=null);
    }
    public void goToContacts(){
            WebElement a =null;

            List<WebElement> allA= driver.findElements(By.tagName("a"));
            for (WebElement a1: allA ) {
                if(a1.getText().equals("Contacts")){
                    a=a1;
                    a.click();
                   // System.out.println("gevonden jaaaaa!");
                    break;
                }
            }


    }
}