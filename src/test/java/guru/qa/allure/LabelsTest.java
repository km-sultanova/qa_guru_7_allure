package guru.qa.allure;

import io.qameta.allure.*;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;


public class LabelsTest {

    @Test
    @Owner("Karina")
    @Severity(SeverityLevel.BLOCKER)
    @DisplayName("My favorite test")
    @Feature("Repository issues")
    @Story("View created tasks")
    @Link(value = "Testing", url = "https://github.com")
    void testGithubIssue(){
    }


}
