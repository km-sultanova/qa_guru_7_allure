package guru.qa.dodo;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class DodoTest {

    private static final String SMALL_CITY = "Лабытнанги";

    @Test
    @Owner("Karina")
    @DisplayName("Dodo test")
    @Feature("Dodo main page")
    @Story("Choosing another city")
    void testDodoMainPage(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.clickOnCityInHeader();
        steps.clickOnNotBigCity(SMALL_CITY);
        steps.checkCityInHeader(SMALL_CITY);
    }
}
