package pages;

import com.codeborne.selenide.Condition;
import com.codeborne.selenide.SelenideElement;
import io.qameta.allure.Step;
import org.openqa.selenium.support.FindBy;

public class IssuesPage {

    @FindBy(xpath = "//h2[.='Issues summary']")
    public SelenideElement issuesHeader;
    @FindBy(xpath = "//a[.='Add new issue']")
    public SelenideElement addNewIssueBtn;

    @FindBy(id = "issue_summary")
    public SelenideElement issueSummary;

    @FindBy(id = "issue_description")
    public SelenideElement issueDescription;

    @FindBy(id = "type-view")
    public SelenideElement IssueTypeSelector;

    @FindBy(xpath = "//label[.='Bug']")
    public SelenideElement IssueTypeBug;

    @FindBy(id = "issue_priority")
    public SelenideElement IssuePrioritySelector;

    @FindBy(xpath = "//label[.='High']")
    public SelenideElement IssuePriorityHigh;

    @FindBy(xpath = "//label[.='Low']")
    public SelenideElement IssuePriorityLow;

    @FindBy(xpath = "//label[.='Normal']")
    public SelenideElement IssuePriorityNormal;

    @FindBy(name = "commit")
    public SelenideElement issueSaveBtn;

    @FindBy(xpath = "//div[@class='card_message']")
    public SelenideElement cardName;


    @Step
    public void checkIssuesPage(){
        issuesHeader.shouldBe(Condition.visible);
        addNewIssueBtn.shouldBe(Condition.visible);
    }

    @Step
    public void clikcAddNewIssue(){
        addNewIssueBtn.click();
    }

    @Step
    public void setIssueTypeBug(){
        IssueTypeSelector.click();
        IssueTypeBug.click();
    }

    @Step
    public void setIssuePriorityHigh(){
        IssuePrioritySelector.click();
        IssuePriorityHigh.click();
    }

    @Step
    public void setIssuePriority(String priority){
        IssuePrioritySelector.click();
        switch (priority) {
            case "Low":
                IssuePriorityLow.click();
                break;
            case "Normal":
                IssuePriorityNormal.click();
                break;
            case "High":
                IssuePriorityHigh.click();
                break;
        }
    }

    @Step
    public void addNewIssue(String issueName, String issueDesc, String issuePriority){
        issueSummary.click();
        issueSummary.sendKeys(issueName);
        issueDescription.click();
        issueDescription.sendKeys(issueDesc);
        setIssueTypeBug();
        setIssuePriority(issuePriority);
        issueSaveBtn.click();
    }

    @Step
    public void checkIssueAdded(String issueName){
        cardName.shouldBe(Condition.text(issueName));
    }
}
