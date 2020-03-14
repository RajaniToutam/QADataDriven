package CRMPRO_PO;

import SetUp.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRM_PO_FileProp extends BasePage {
    public CRM_PO_FileProp(WebDriver driver) {
        super(driver);
    }

//////////////////Locaters//////////

    public By UserName_Xpath = By.xpath("//input[@name='username']");
    public By Password_xpath = By.xpath("//input[@name='password']");
    public By Submit_xpath = By.xpath("//input[@type='submit']");

    ////////////////Methods/////////////

    public boolean clickSubmitBtn() {
        try {
            WebElement clickSubmitBtn = (WebElement) (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.visibilityOfElementLocated(Submit_xpath));
            clickSubmitBtn.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean enterUserName(String text){
        try{
            WebElement enterUserName = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.visibilityOfElementLocated(UserName_Xpath));
            enterUserName.sendKeys(text);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean enterPassword(String text){
        try{
            WebElement enterPassword = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.visibilityOfElementLocated(Password_xpath));
            enterPassword.sendKeys(text);
            return true;
        }catch (Exception e){
            return false;
        }


    }
}
