package guru.qa.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.Feature;
import io.qameta.allure.Owner;
import io.qameta.allure.Story;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class SelenideTest {

    @Test
    @Owner("Karina")
    @DisplayName("Selenide Step Test")
    @Feature("Github repository issues")
    @Story("View created tasks")
    void testGithubIssue(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        //km-sultanova/qa_guru_7_allure
        open("https://github.com");
        $(".header-search-input").click();
        $(".header-search-input").sendKeys("km-sultanova/qa_guru_7_allure");
        $(".header-search-input").submit();

        $(linkText("1km-sultanova/qa_guru_7_allure")).click();
        $(partialLinkText("Issues")).click();
        $(withText("2")).click();
    }
}
