package stepDefintion;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.openqa.selenium.By;
import org.testng.Assert;

import java.util.ArrayList;

public class D08_followUsStepDef {


    @Given("click facebook")
    public void clickFacebook(){
        Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.facebook.com/nopCommerce\"]")).click();
    }

    @Then("navigate to facebook tab")
    public void facebookTab() throws InterruptedException {
        Thread.sleep(2000);
        ArrayList <String> Tabs=new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(Tabs.get(1));
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.facebook.com/nopCommerce");

        Hooks.driver.close();
        Hooks.driver.switchTo().window(Tabs.get(0));
    }


    @Given("click twitter icon")
    public void clickTwitter(){
        Hooks.driver.findElement(By.cssSelector("a[href=\"https://twitter.com/nopCommerce\"]")).click();
    }

    @Then("navigate to twitter link")
    public void twitterLink(){
        ArrayList <String> Tabs=new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(Tabs.get(1));
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://twitter.com/nopCommerce");

        Hooks.driver.close();
        Hooks.driver.switchTo().window(Tabs.get(0));
    }

    @Given("click Rss icon")
    public void clickRss(){
        Hooks.driver.findElement(By.cssSelector("a[href=\"/news/rss/1\"]")).click();
    }

    @Then("navigate to Rss link")
    public void RssLink(){
        ArrayList <String> Tabs=new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(Tabs.get(1));
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://demo.nopcommerce.com/news/rss/1");

        Hooks.driver.close();
        Hooks.driver.switchTo().window(Tabs.get(0));
    }

    @Given("click youtube icon")
    public void clickYoutube(){
        Hooks.driver.findElement(By.cssSelector("a[href=\"http://www.youtube.com/user/nopCommerce\"]")).click();
    }

    @Then("navigate to youtube link")
    public void youtubeLink(){
        ArrayList <String> Tabs=new ArrayList<>(Hooks.driver.getWindowHandles());
        Hooks.driver.switchTo().window(Tabs.get(1));
        Assert.assertEquals(Hooks.driver.getCurrentUrl(),"https://www.youtube.com/user/nopCommerce");

        Hooks.driver.close();
        Hooks.driver.switchTo().window(Tabs.get(0));
    }


}
