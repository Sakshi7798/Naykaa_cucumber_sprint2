package steps;

import io.cucumber.java.Before;
import io.cucumber.java.Scenario;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import pages.HomePage;
import utils.BrowserManager;
import utils.QaProps;
import utils.TestDataReader;

import java.util.HashMap;

public class StepDefinitions {
    private WebDriver driver;
    HomePage homePage;
    String url;
    HashMap<String, String> data;
    Scenario scenario;

    public StepDefinitions(BrowserManager browserManager) {
        this.driver = browserManager.getDriver();
    }

    @Before(order = 1)
    public void before(Scenario scenario) {
        this.scenario = scenario;
    }

    @Given("the user navigates to the home page")
    public void the_user_navigates_to_the_home_page() {
        url = QaProps.getValue("url");
        driver.get(url);
        System.out.println(1 / 0);
        data = TestDataReader.getData(scenario.getName());
    }

    @Given("the user navigates to")
    public void the_user_navigates_to() {
        url = QaProps.getValue("url");
        driver.get(url);
        System.out.println(1 / 0);
        data = TestDataReader.getData(scenario.getName());
    }

    @When("the user enter the product name")
    public void the_user_enter_the_product_name() {
        homePage = new HomePage(driver);
        homePage.getSearchBox().sendKeys(data.get("TypeValue"));
        homePage.getSearchBox().sendKeys(Keys.ENTER);

    }

    @Then("the product results should be displayed")
    public void the_product_results_should_be_displayed() {
        String text = homePage.getSearchResult()
                .getText();
        Assert.assertEquals(text, data.get("TypeValue"));
    }

    @And("User enters {string} and {string}")
    public void userEntersAnd(String arg0, String arg1) {
    }

    @Given("User is on Home Page")
    public void userIsOnHomePage() {
    }

    @When("User Navigate to LogIn Page")
    public void userNavigateToLogInPage() {
    }

    @Then("Message displayed Login Successfully")
    public void messageDisplayedLoginSuccessfully() {
    }

    @Given("User is logged in")
    public void userIsLoggedIn() {
        System.out.println("from background");
    }
}
