package actionPages;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.testng.Assert;
import utils.WebDriverStart;

import java.util.List;

public class NHSCheckerPage {

     static WebDriver driver;
     static Actions actions;

    public NHSCheckerPage(WebDriver driver) {
        NHSCheckerPage.driver = driver;
        actions = new Actions(driver);
        // TODO Auto-generated constructor stub
    }

    @FindBy(id = "radio-wales")
    private static WebElement selectWales;

    @FindBy(id = "next-button")
    private static WebElement startBtn;

    @FindBy(id = "next-button")
    private static WebElement nextBtn;

    @FindBy(id = "radio-yes")
    private static WebElement selectYes;

    @FindBy(id = "radio-yes")
    private static WebElement selectNo;

    @FindBy(id = "yes-universal")
    private static WebElement universalCreditYes;

    @FindBy(id = "different-benefit")
    private static WebElement universalCreditNo;

    @FindBy(xpath = "//input[@id='dob-day']")
    private static WebElement dayOfBirth;

    @FindBy(xpath = "//input[@id='dob-month']")
    private static WebElement monthOfBirth;

    @FindBy(xpath = "//input[@id='dob-year']")
    private static WebElement yearOfBirth;

    @FindBy(xpath = "//input[@id='radio-yes']")
    private static WebElement yesOption;

    @FindBy(xpath = "//input[@id='radio-yes']")
    private static WebElement noOption;

    @FindBy(xpath = "//span[contains(text(),'savings')]")
    private static WebElement savingsAmount;

    @FindBy(xpath= "//*/text()[normalize-space(.)='You get help with NHS costs']/parent::*")
    private static WebElement whatYouGetFree;
    //*/text()[normalize-space(.)='You get help with NHS costs']/parent::*
    //main[@id='content']/div[2]/div/div[2]/h2
    //main[@id='content']/div[3]/div/div/h2
    @FindBy(xpath = "//li[normalize-space()='NHS prescriptions']")
    private static WebElement NHS_Prescriptions;
    //li[normalize-space()='NHS prescriptions']

    @FindBy(xpath = "//h3[text()='You get money off:']/following-sibling::ul/li")
    private static List<WebElement> whatYouGetMoneyOff;

    @FindBy(xpath = "//span[@id='prescription-tick']")
    private static WebElement prescription;

    @FindBy(xpath = "//li[normalize-space()='sight tests']")
    private static WebElement sightTests;
    //li[normalize-space()='sight tests']

    @FindBy(xpath = "//div[@id='error-summary']/div/ul/li/a/span")
    private static WebElement dateError;

    public static void selectCountry(String country) {
        try {
            selectWales.click();
        } catch (Exception e) {
            throw e;
        }
    }

    public static void clickStartButton() {
        try {
            WebDriverStart.waitToClickElement(startBtn);
            WebDriverStart.scrollToViewOfElement(startBtn);
            startBtn.click();
        } catch (Exception e) {
            throw e;
        }
    }

    public static void clickNext() {
        try {
            nextBtn.click();
        } catch (Exception e) {
            throw e;
        }
    }

    public static void setSelectYes() {
        try {
            selectYes.click();
        } catch (Exception e) {
            throw e;
        }
    }

    public static void setSelectNo() {
        try {
            selectNo.click();
        } catch (Exception e) {
            throw e;
        }
    }

    public static String validateBOD() {
        try {
            return dateError.getText();
        } catch (Exception e) {
            throw e;
        }
    }
    public static void enterDateOfBirth(String dob) throws InterruptedException {
        dayOfBirth.clear();
        monthOfBirth.clear();
        yearOfBirth.clear();
        try {
            Thread.sleep(4);
            dayOfBirth.sendKeys(dob.split("-")[0]);
            monthOfBirth.sendKeys(dob.split("-")[1]);
            yearOfBirth.sendKeys(dob.split("-")[2]);
        } catch (Exception e) {
            throw e;
        }
    }

    public static void selectPartnerTaxClaim(String partner_TaxClaim) {
        try {
            selectYesOrNo(partner_TaxClaim);
        } catch (Exception e) {
            throw e;
        }
    }

    public static void selectPartnerPaid(String partner_paid) {
        try {
            selectYesOrNo(partner_paid);
        } catch (Exception e) {
            throw e;
        }
    }

    public static void selectPartnerUnivalCredit(String univaral_credit) {
        try {
            if (univaral_credit.equalsIgnoreCase("yes"))
                universalCreditYes.click();
            else
                universalCreditNo.click();
        } catch (Exception e) {
            throw e;
        }
    }

    public static void selectYesOrNo(String option) {
        if (option.equalsIgnoreCase("yes"))
            yesOption.click();
        else
            noOption.click();
    }

    public static void displayResult() {
        Assert.assertEquals(NHS_Prescriptions.getText(),"NHS prescriptions");
        Assert.assertEquals(sightTests.getText(), "sight tests");
        Assert.assertEquals(whatYouGetFree.getText(), "Based on what you've told us\n" +
                "You get help with NHS costs");
    }
}
