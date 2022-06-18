package stepDefintion;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import java.time.Duration;


public class D09_wishListStepDef {

    @When("click on wish icon")
    public void clickWish(){
        Hooks.driver.findElements(By.cssSelector("button[class=\"button-2 add-to-wishlist-button\"]")).get(2).click();

    }


    @Then("notification bar visible")
    public void itemAdded() throws InterruptedException {

       String background= Hooks.driver.findElement(By.cssSelector("[class=\"bar-notification success\"]")).getCssValue("background-color");
        System.out.println(background);
        Thread.sleep(2000);
        Assert.assertTrue(background.contains("rgba(75, 176, 122, 1)"));
    }



    @And("get number of added items")
    public void noOfItems(){

        WebElement greenBar=Hooks.driver.findElement(By.cssSelector("[class=\"bar-notification-container\"]"));

        //explicit
        WebDriverWait wait=new WebDriverWait(Hooks.driver, Duration.ofSeconds(10));
        wait.until(ExpectedConditions.invisibilityOf(greenBar));

        Hooks.driver.findElement(By.cssSelector("span[class=\"wishlist-label\"]")).click();

       String value= Hooks.driver.findElement(By.className("qty-input")).getAttribute("value");
       int quantity=Integer.parseInt(value);

       Assert.assertTrue(quantity>0);
       System.out.println(quantity);

    }
}
