package guru.qa.allure;

import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.*;
import io.qameta.allure.selenide.AllureSelenide;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class AnnotatedStepTest {

    private static final String REPOSITORY = "km-sultanova/qa_guru_7_allure";
    private static final int ISSUE_NUMBER = 2;

    @Test
    @Owner("Karina")
    @DisplayName("Annotated Step Test")
    @Feature("Github repository issues")
    @Story("View created tasks")
    void testGithubIssue(){
        SelenideLogger.addListener("allure", new AllureSelenide());
        WebSteps steps = new WebSteps();

        steps.openMainPage();
        steps.searchForRepository(REPOSITORY);
        steps.clickOnRepositoryLink(REPOSITORY);
        steps.openIssueTab();
        steps.shouldSeeIssueWithNumber(ISSUE_NUMBER);
    }
}
