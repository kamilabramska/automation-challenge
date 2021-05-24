package browserTesting;



import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Dimension;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class Steps {

    WebDriver driver;

    @Given("^I open Chrome and launch the application$")
    public void openChromeAndLaunchApplication()
    {
        driver = new ChromeDriver();
        driver.manage().deleteAllCookies();
        driver.manage().timeouts().implicitlyWait(60L, TimeUnit.SECONDS);
        driver.manage().timeouts().pageLoadTimeout(60L, TimeUnit.SECONDS);
        driver.manage().window().setSize(new Dimension(1280, 1024));
        driver.get("https://qa-automation-challenge.github.io/sandbox/");
        (new WebDriverWait(driver, 61L)).until(new ExpectedCondition<WebElement>() {
            public WebElement apply(WebDriver d) {
                return d.findElement(By.id("type"));
            }
        });
    }

    @When("^I select type \"(.*)\"$")
    public void selectType(String type)
    {
        Select select = new Select(driver.findElement(By.id("type")));
        select.selectByVisibleText(type);
    }

    @When("^I select support plan \"(.*)\"$")
    public void selectSupportPlan(String plan)
    {
        Select select = new Select(driver.findElement(By.id("support")));
        select.selectByVisibleText(plan);
    }

    @When("^I write monthly duration of \"(.*)\"$")
    public void writeMonthlyDuration (String duration)
    {
        driver.findElement(By.id("duration")).sendKeys(duration);
    }

    @When("^I click on calculate price button")
    public void clickCalculatePriceButton()
    {
        driver.findElement(By.id("calculate")).click();
    }

    @Then("^I validate price is \"(.*)\"$")
    public void	validatePrice(String price) throws InterruptedException {
        Thread.sleep(5*1000);
        Assert.assertEquals(price, driver.findElement(By.id("subscriptionPrice")).getText());
        driver.close();
    }

/*
    @Then("^I attach file \"(.*)\"$")
    public void	attachFile(String file) throws  {
        WebElement uploadElement = driver.findElement(By.id("attachment"));
        uploadElement.sendKeys(file);
    }
*/
}
