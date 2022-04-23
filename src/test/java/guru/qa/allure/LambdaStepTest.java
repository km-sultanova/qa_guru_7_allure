package guru.qa.allure;

import com.codeborne.selenide.WebDriverRunner;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.nio.charset.StandardCharsets;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static io.qameta.allure.Allure.step;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class LambdaStepTest {

    private static final String REPOSITORY = "km-sultanova/qa_guru_7_allure";
    private static final int ISSUE_NUMBER = 2;

    @Test
    @Owner("Karina")
    @DisplayName("Lambda Step test")
    @Feature("Github repository issues")
    @Story("View created tasks")
    void testGithubIssue(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        step("Open main page", () -> {
            open("https://github.com");
        });
        step("Search repository " + REPOSITORY, ()->{
            $(".header-search-input").click();
            $(".header-search-input").setValue(REPOSITORY);
            $(".header-search-input").submit();
        });
        step("Follow repository link " + REPOSITORY, ()-> {
            $(linkText(REPOSITORY)).click();
        });
        step("Click on tab Issues", ()->{
            $(partialLinkText("Issues")).click();
        });
        step("Check if Issue number " + ISSUE_NUMBER + " exists", ()->{
            $(withText("#" + ISSUE_NUMBER)).click();
            Allure.getLifecycle().addAttachment(
                    "Исходники страницы",
                    "text/html",
                    "html",
                    WebDriverRunner.getWebDriver().getPageSource().getBytes(StandardCharsets.UTF_8)
            );
        });
    }
}
