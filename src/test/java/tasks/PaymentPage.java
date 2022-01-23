package tasks;

import net.serenitybdd.screenplay.Actor;
import net.serenitybdd.screenplay.Task;
import net.serenitybdd.screenplay.actions.*;
import net.thucydides.core.annotations.Step;
import org.openqa.selenium.By;
import ui.HomePageElements;
import ui.PaymentPageElements;
import static net.serenitybdd.screenplay.Tasks.instrumented;

public class PaymentPage implements Task {

    private String phone="";
    private String name ="";
    private String amount ="";
    private String client = "";


    public PaymentPage(String phone, String name, String amount, String client) {
        this.phone = phone;
        this.name = name;
        this.amount = amount;
        this.client = client;

    }

    @Override
    @Step("{0} deposite to the eribank")
    public <T extends Actor> void performAs(T actor) {
        actor.attemptsTo(
                Click.on(HomePageElements.PAYMENT_BTN),
                //click payment button
                Click.on(PaymentPageElements.PHONE_FIELD),
                //click phone field
                SendKeys.of(this.phone).into(PaymentPageElements.PHONE_FIELD),
                Click.on(PaymentPageElements.NAME_FIELD),
                //click name field
                SendKeys.of(this.name).into(PaymentPageElements.NAME_FIELD),
                SendKeys.of(this.amount).into(PaymentPageElements.AMOUNT_SCROLL),
                Click.on(PaymentPageElements.COUNTRY_BTN),
                //click country field
                Click.on(By.xpath("//android.widget.TextView[@text='"+this.client+"']")),
                Click.on(PaymentPageElements.PAYMENT_BTN),
                //click payment button
                Click.on(PaymentPageElements.CONFIRM_BTN)
                //click confirm button
        );
    }
    public static PaymentPage type(String phone, String name, String amount, String client){
        return  instrumented(PaymentPage.class,phone,name,amount,client);
    }
}
