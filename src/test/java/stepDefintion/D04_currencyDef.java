package stepDefintion;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import java.util.List;

public class D04_currencyDef {
    WebDriver driver;

    @Given("select currency in dropdown box")
    public void select_Currency(){
        WebElement selectElement= Hooks.driver.findElement(By.id("customerCurrency"));
        Select selectObject= new Select(selectElement);
        selectObject.selectByValue("https://demo.nopcommerce.com/changecurrency/6?returnUrl=%2F");
    }
    @Then("currency should be changed")
    public void changeCurrency(){

        String expectedResult = "€";
        int size=Hooks.driver.findElements(By.className("prices")).size();

        for ( int i=0 ;i<size;i++){
            String actualResult=Hooks.driver.findElements(By.className("prices")).get(i).getText();
            Assert.assertTrue(actualResult.contains(expectedResult));
            System.out.println("actual: "+actualResult+actualResult);
        }

    }
}
