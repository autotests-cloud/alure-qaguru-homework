package qaguru.allure;

import com.codeborne.selenide.Configuration;
import org.junit.jupiter.api.Test;

public class BaseStepTests {

    private final String USERNAME = System.getProperty("qaguru.username");
    private final String PASSWORD = System.getProperty("qaguru.password");

    private final String REPOSITORY = "eroshenkoam/allure-example";
    private final String ISSUE_TITLE = "новая Issue";

    private final BaseSteps steps = new BaseSteps();

    @Test
    public void testIssueCreate() {
        Configuration.baseUrl = "https://github.com";
        steps.loginAsUser(USERNAME, PASSWORD);
        steps.navigateToRepositoryIssues(REPOSITORY);
        steps.createNewIssueWithTitle(ISSUE_TITLE);
        steps.shouldSeeIssueWithTitle(ISSUE_TITLE);
    }

}
