package easyqa.tests;

import com.codeborne.selenide.Configuration;
import com.codeborne.selenide.logevents.SelenideLogger;
import io.qameta.allure.selenide.AllureSelenide;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Test;
import pages.*;
import util.Card;

import static com.codeborne.selenide.Selenide.close;
import static com.codeborne.selenide.Selenide.open;

public class FirstTests {

    @BeforeSuite
    public void setUp() {
        SelenideLogger.addListener("AllureSelenide", new AllureSelenide());
        Configuration.browser = "chrome";
        //  Configuration.browserSize="1600x1000";
    }


    @Test
    public void loginAsRegisteredUser()   {

        LoginPage loginPage = open("https://app.geteasyqa.com/users/sign_in",LoginPage.class);
        loginPage.enterLogin("testuniverse@yandex.ru");
        loginPage.enterPassword("testuniverse");
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();
    }

    @Test
    public void openProjects(){
        LoginPage loginPage = open("https://app.geteasyqa.com/users/sign_in",LoginPage.class);
        loginPage.enterLogin("testuniverse@yandex.ru");
        loginPage.enterPassword("testuniverse");
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();
        ProjectsPage projectsPage = dashboardPage.openMyProjects();
        projectsPage.checkProjectsPage();

    }

    @Test
    public void createCard(){
        Card issue = new Card("test2","test description");

        LoginPage loginPage = open("https://app.geteasyqa.com/users/sign_in",LoginPage.class);
        loginPage.enterLogin("testuniverse@yandex.ru");
        loginPage.enterPassword("testuniverse");
        DashboardPage dashboardPage = loginPage.clickLoginBtn();
        dashboardPage.checkUserAuthorized();
        ProjectsPage projectsPage = dashboardPage.openMyProjects();
        projectsPage.checkProjectsPage();
        ProjectDashboardPage projectDashboardPage = projectsPage.openProject();
        projectDashboardPage.checkProjectDashboardPage();
        IssuesPage issuesPage = projectDashboardPage.openIssues();
        issuesPage.checkIssuesPage();
        issuesPage.clikcAddNewIssue();
        issuesPage.addNewIssue(issue.getCardName(), issue.getCardDescription());
        issuesPage.checkIssueAdded(issue.getCardName());
    }

    @AfterMethod
    public void tearDown() throws Exception {
        close();
    }
}

