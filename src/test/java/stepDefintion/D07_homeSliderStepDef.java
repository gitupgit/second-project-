package stepDefintion;

import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.By;
import org.testng.Assert;
import pages.P07_sliderpage;

public class D07_homeSliderStepDef {

    //P07_sliderpage sliderpage = new P07_sliderpage();

    @When("click first slider")
    public void firstSlider() {
       // sliderpage.slider("1").click();

        Hooks.driver.findElement(By.xpath("(//a[@href=\"http://demo.nopcommerce.com/\"])[1]")).click();

    }


    @Then("open link of slider1")
    public void getPageOfSlider() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/iphone"));
        System.out.println("pass");
    }

    @When("click second slider")
    public void secondSlider() {
        // sliderpage.slider("2").click();

        Hooks.driver.findElement(By.xpath("(//a[@href=\"http://demo.nopcommerce.com/\"])[2]")).click();
    }


    @Then("open link of slider2")
    public void getPageOfSlider2() throws InterruptedException {
        Thread.sleep(2000);
        Assert.assertTrue(Hooks.driver.getCurrentUrl().contains("https://demo.nopcommerce.com/nokia-lumia-1020"));
        System.out.println("pass");
    }



}