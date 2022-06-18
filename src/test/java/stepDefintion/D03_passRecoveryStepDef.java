package stepDefintion;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

public class D03_passRecoveryStepDef {

    @Given("user navigate to login page")
    public void navigateLoginPage(){
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/login");
    }


    @When("user click forget password")
    public void forget_password(){
       Hooks. driver.findElement(By.cssSelector("[href=\"/passwordrecovery\"]")).click();
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/passwordrecovery");
    }


    @And("fill Email field")
    public void enterEmail(){
        Hooks.driver.findElement(By.id("Email")).sendKeys("automation@gmail.com");
         Hooks.driver.findElement(By.cssSelector("[name=\"send-email\"]")).click();
    }


    @Then("user get password")
    public void get_password(){
        String expectedResult = "Email with instructions has been sent to you.";
        String actualResult = Hooks.driver.findElement(By.className("content")).getText();
        Assert.assertTrue(actualResult.contains(expectedResult));
    }
}
