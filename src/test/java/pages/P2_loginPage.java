package pages;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import stepDefintion.Hooks;

public class P2_loginPage {
    WebDriver driver;

    public P2_loginPage(WebDriver driver) {
        this.driver = driver;

        //create pagefactory
        PageFactory.initElements(driver, this);
    }

    //pagefactory
    @FindBy(id="Email")
    WebElement emailPF;

    public WebElement emailPom(){
        By email = By.name("Email");
        WebElement emailElement = Hooks.driver.findElement(email);
        return emailElement;

    }
    public WebElement passwordPom(){
        By password=By.id("Password");
        WebElement passElement = Hooks.driver.findElement(password);
        return passElement;
    }
    public void loginSteps(String email ,String password)
    {
        //enterEmail using pom
        //pagefactory
        emailPF.clear();
        //emailpom().clear();
        emailPom().sendKeys(email);
        passwordPom().sendKeys(password);

    }
}
