package guru.qa.dodo;

import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Condition.text;
import static com.codeborne.selenide.Selectors.byText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;

public class WebSteps {

    @Step("Open main page Moscow")
    public void openMainPage(){
        open("https://dodopizza.ru/moscow");
    }

    @Step("Click on city in header")
    public void clickOnCityInHeader(){
        $(".header__about-slogan-text_locality").click();
    }

    @Step("Choose city {city}")
    public void clickOnNotBigCity(String city){
        $("[data-testid='locality-selector-popup__content']").$(byText(city)).click();
    }

    @Step("Check {city} in header")
    public void checkCityInHeader(String city){
        $(".header__about-slogan-text_locality").shouldHave(text(city));
        attachScreenshot();
    }

    @Attachment(value = "Pizza screenshot", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot(){
        return ((TakesScreenshot) WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
