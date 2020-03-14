package CRM_PO;

import SetUp.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRM_PO_fileProperty extends BasePage {
    public CRM_PO_fileProperty(WebDriver driver) {
        super(driver);
    }

//////////////////Locaters//////////

    public By UserName_xpath = By.xpath("//input[@name = 'email']");
    public By Password_xpath = By.xpath("// input[@name = 'password']");
    public By Login_xpath = By.xpath("// div[text() = 'Login']");
    ////////////////Methods/////////////

    public boolean clickLoginBtn() {
        try {
            driver.findElement(Login_xpath).click();
              return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean enterUserName(String text){
        try{
            driver.findElement(UserName_xpath).sendKeys(text);
            return true;
        }catch (Exception e){
            return false;
        }
    }

    public boolean enterPassword(String text){
        try{
            driver.findElement(Password_xpath).sendKeys(text);
            return true;
        }catch (Exception e){
            return false;
        }


    }
}
