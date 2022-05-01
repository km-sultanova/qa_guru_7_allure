package guru.qa.allure;

import com.codeborne.selenide.Screenshots;
import com.codeborne.selenide.WebDriverRunner;
import io.qameta.allure.Attachment;
import io.qameta.allure.Step;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;

import static com.codeborne.selenide.Selectors.withText;
import static com.codeborne.selenide.Selenide.$;
import static com.codeborne.selenide.Selenide.open;
import static org.openqa.selenium.By.linkText;
import static org.openqa.selenium.By.partialLinkText;

public class WebSteps {

    @Step("Open main page")
    public void openMainPage(){
        open("https://github.com");
    }

    @Step("Search repository {repo}")
    public void searchForRepository(String repo){
        $(".header-search-input").click();
        $(".header-search-input").setValue(repo);
        $(".header-search-input").submit();
    }

    @Step("Click on {repo} link ")
    public void clickOnRepositoryLink(String repo){
        $(linkText(repo)).click();
    }

    @Step("Click on tab Issues")
    public void openIssueTab(){
        $(partialLinkText("Issues")).click();
    }

    @Step("Check if Issue number {number} exists")
    public void shouldSeeIssueWithNumber(int number){
        $(withText("#" + number)).click();
        attachScreenshot();
    }

    @Attachment(value = "My favorite screenshot", type = "image/png", fileExtension = "png")
    public byte[] attachScreenshot(){
        return ((TakesScreenshot)WebDriverRunner.getWebDriver()).getScreenshotAs(OutputType.BYTES);
    }
}
