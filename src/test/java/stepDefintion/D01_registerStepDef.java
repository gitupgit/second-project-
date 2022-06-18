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
import org.testng.asserts.SoftAssert;
import java.util.concurrent.TimeUnit;

import static stepDefintion.Hooks.*;

public class D01_registerStepDef {
    WebDriver driver;

    @Given("navigate to Register")
    public void navigate_Register_page() {
        Hooks.driver.findElement(By.className("ico-register")).click();
        Hooks.driver.navigate().to("https://demo.nopcommerce.com/register");
    }


    @When("user Fill his Data")
    public void fillData() {
        //01 select gender
        Hooks. driver.findElement(By.id("gender-male")).click();
        //02 First Name
        Hooks.driver.findElement(By.id("FirstName")).sendKeys("soha");
        //03 Last Name
        Hooks.driver.findElement(By.id("LastName")).sendKeys("Hosny");
        //04 select Day
        Hooks.driver.findElement(By.xpath
         ("//div[//@name=\"DateOfBirthDay\"]//option[@value=\"1\"]")).click();
        //05 select Month
        Hooks.driver.findElement(By.cssSelector
                ("[name=\"DateOfBirthMonth\"] [value=\"5\"]")).click();
        //06 select Year
        Hooks.driver.findElement(By.xpath
                ("//div[//@name=\"DateOfBirthYear\"]//option[@value=\"5\"]")).click();
        //07 write Email
        Hooks.driver.findElement(By.id("Email")).sendKeys("automation@gmail.com");
        //08 write password
        Hooks.driver.findElement(By.id("Password")).sendKeys("123456");
        //09 confirm password
        Hooks.driver.findElement(By.id("ConfirmPassword")).sendKeys("123456");

    }

    @And("click Register")
    public void clickRegister() {
       Hooks. driver.findElement(By.id("register-button")).click();
    }

    @Then("user should register successfully")
    public void Register() {
        SoftAssert soft = new SoftAssert();
        Hooks.driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

        //First Assert
        String expectedResult = "Your registration completed";
        String actualResult = Hooks.driver.findElement(By.className("result")).getText();
        soft.assertTrue(actualResult.contains(expectedResult), "ErrorMessages:first assertion");

        //Second Assert
        String color = Hooks.driver.findElement(By.className("result")).getCssValue("color");
        String expectColor = "rgba(76, 177, 124, 1)";

        System.out.println(color + "  c o l o r ");
        soft.assertTrue(color.equals(expectColor));

        //Assert all
        soft.assertAll();


    }
}