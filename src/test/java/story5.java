import domain.model.MyService;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import java.util.Random;

import static org.junit.Assert.*;
/*
 *
 * Made BY Merijn Lowis & Lucas Cuppers
 *
 * */
public class story5 {



    private WebDriver driver;
    private String path = "http://localhost:8080/Controller";

    @Before
    public void init() {
        System.setProperty("webdriver.chrome.driver", "/home/lucas/Documents/UCLL/web2/chromedriver");
        driver = new ChromeDriver();
    }
    @After
    public void clean() {
        driver.quit();
    }
    @Test
    public void ifUserNotloggedInRedirectHome(){
        new ContactPage(driver);
        String title = driver.getTitle();
        assertEquals(title,"Home");
    }

    @Test
    public  void fromHomeToContact(){
        HomePage page=new HomePage(driver);

        assertFalse(page.isLoggedIn());

        page.login("asd","123");
        assertTrue(page.isLoggedIn());
        page.goToContacts();
        assertEquals(driver.getTitle(),"Contacts");
    }
    @Test
    public  void fromContactToHome(){
        HomePage page=new HomePage(driver);

        assertFalse(page.isLoggedIn());

        page.login("asd","123");
        assertTrue(page.isLoggedIn());
        ContactPage contactPage=new ContactPage(driver);
        assertEquals(driver.getTitle(),"Contacts");
        contactPage.goToHome();
        assertEquals(driver.getTitle(),"Home");


    }

    @Test
    public void allContactsShownForUser(){

        HomePage page=new HomePage(driver);

        assertFalse(page.isLoggedIn());

        page.login("asd","123");
        assertTrue(page.isLoggedIn());
        ContactPage contactPage=new ContactPage(driver);
        assertEquals(driver.getTitle(),"Contacts");
        MyService service=new MyService();
        int startingAmount=contactPage.getAmountOfContacts();
        int random= (int) (Math.random() * (10 - 1 + 1)) + 1;
        for(int i=0;i<random;i++)
            contactPage.addContact("Ikke","Toch","i@me.com","+329999999");
        assertEquals(startingAmount+random,contactPage.getAmountOfContacts());

    }


}
