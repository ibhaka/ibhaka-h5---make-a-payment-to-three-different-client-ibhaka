package steps;

import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.abilities.BrowseTheWeb;
import net.serenitybdd.screenplay.actors.OnStage;
import net.serenitybdd.screenplay.actors.OnlineCast;
import net.serenitybdd.screenplay.ensure.Ensure;
import net.thucydides.core.annotations.Managed;
import org.junit.Before;
import org.openqa.selenium.WebDriver;
import tasks.LoginToEriBank;
import tasks.LogoutFromEribank;
import tasks.PaymentPage;
import ui.HomePageElements;

public class PaymentSteps {
    @Managed(driver = "Appium")
    public WebDriver herMobileDevice;

    String actorName="ibhaka";
    Actor actor = Actor.named(actorName);

    @Before
    public void set_the_stage() {
        OnStage.setTheStage(new OnlineCast());
    }

    @Given("User login with username and password")
    public void user_login_with_username_and_password() {
        actor.can(BrowseTheWeb.with(herMobileDevice));
        actor.attemptsTo(LoginToEriBank.login("company","company"));
        //login the app with username and password
    }

    @When("User makes payment with {string} {string} {string} {string}")
    public void user_makes_payment_with(String phone, String name, String amount,String client) {
        actor.attemptsTo(PaymentPage.type(phone, name, amount,client));
        //make payment with user information
    }

    @And("User should see balance by {string}")
    public void user_should_see_balance_by() {
        actor.attemptsTo(
                Ensure.that(HomePageElements.TOTAL_BALANCE).attribute("content-desc").startsWith("Your balance is")
                //balance check
        );
    }
    @Then("User will logout")
    public void userWillLogout() {
        actor.attemptsTo(LogoutFromEribank.logout());
        //logout
    }









}


