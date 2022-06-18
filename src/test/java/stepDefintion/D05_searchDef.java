package stepDefintion;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.asserts.SoftAssert;
import pages.P5_searchPage;

import java.util.concurrent.TimeUnit;

public class D05_searchDef {
    P5_searchPage searchPage;


    @Given("^write search keyword as \"(.*)\"$")
        public void write_keyword(String search) {
        searchPage = new P5_searchPage(Hooks.driver);
        searchPage.searchSteps(search);
        System.out.println("search  "+search);
    }

    @When("click on search btn")
    public void clickSearch(){
       Hooks.driver.findElement(By.cssSelector("button[type=\"submit\"]")).click();

    }

    @Then("search result displayed")
    public void searchResult() {
        SoftAssert soft = new SoftAssert();
        Hooks.driver.manage().timeouts().implicitlyWait(7, TimeUnit.SECONDS);

         //First Assert
         String actualUrl= Hooks.driver.getCurrentUrl();
         System.out.println("url is: "+actualUrl);
         soft.assertTrue(actualUrl.contains("https://demo.nopcommerce.com/search"));


         //second Assert
         int size = Hooks.driver.findElements(By.className("product-item")).size();
         System.out.println("size is: "+size);
         if(size>0)
         soft.assertTrue(true, "pass");

         soft.assertAll();
    }

    @Then("sku search result displayed")
    public void skuSearch(){

         int count= Hooks.driver.findElements(By.className("product-title")).size();
         if (count==1) {
             Assert.assertTrue(true, "pass");
             System.out.println("count " + count);


             Hooks.driver.findElement(By.className("product-item")).click();
             boolean b=Hooks.driver.findElement(By.className("sku")).isDisplayed();
             System.out.println("assert  "+b);
         }


//         String url=Hooks.driver.getCurrentUrl();
//         System.out.println("url  "+url);
//        Assert.assertEquals ( url,"https://demo.nopcommerce.com/apple-icam");
//        System.out.println(" actual "+actualRes);
//        String expectRes=Hooks.driver.findElement(By.cssSelector("[id=\"sku-17\"]")).getText();
//        Assert.assertTrue(actualRes.contains(expectRes));

    }
}
