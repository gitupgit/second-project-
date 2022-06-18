package stepDefintion;

import io.cucumber.java.Before;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import pages.P2_loginPage;

import java.util.concurrent.TimeUnit;


public class D02_loginStepDef {
    WebDriver driver;
    P2_loginPage login;

    @Given("navigate to login page")
    public void navigate_Login(){
       Hooks. driver.navigate().to("https://demo.nopcommerce.com/login");
    }


    @When("^user enter \"(.*)\" and \"(.*)\"$")
    public void enter_password(String email, String password) {
        login = new P2_loginPage(Hooks.driver);
        login.loginSteps(email, password);
    }

    @And("click on login btn")
    public void clickLoginbtn() throws InterruptedException {
        login.passwordPom().sendKeys(Keys.ENTER);
        //driver.findElement(By.cssSelector("form > button[type=\"submit\"]"));
        Thread.sleep(3000);
    }

    @Then("user could login successfully")
    public void loginSuccessfully() {
        String expectedResult = "Welcome to our store";
        String actualResult = Hooks.driver.findElement(By.tagName("h2")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }

    @Then("user could not login successfully")
    public void login_Unsuccessfully() {
        String expectedResult = "Login was unsuccessful. Please correct the errors and try again.";
        String actualResult = Hooks.driver.findElement(By.cssSelector("")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
