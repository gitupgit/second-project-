package stepDefintion;

import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import java.util.Locale;

public class D06_hoverCategoriesStepDef {
    String subCategory;


    @When("select main category and subcategory")
    public void selectCategories() throws InterruptedException {

        Actions action=new Actions(Hooks.driver);
        WebElement com=Hooks.driver.findElement(By.cssSelector("a[href=\"/computers\"]"));  //ul[class=\"top-menu mobile\"]
        String s=com.getText();
        System.out.println("text is " +s);
        action.moveToElement(com).build().perform();

        Thread.sleep(2000);
        WebElement desktop= Hooks.driver.findElement(By.cssSelector("a[href=\"/desktops\"]"));   //ul[class=\"top-menu mobile\"]
        subCategory= desktop.getText().toLowerCase().trim();
        System.out.println("text is "+subCategory );
        desktop.click();
    }

    @Then("go to subcategory page")
    public void subCategory(){
        String title=Hooks.driver.findElement(By.className("page-title")).getText().toLowerCase().trim();
        Assert.assertEquals(subCategory,title);

    }
}
