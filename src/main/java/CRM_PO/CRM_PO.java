package CRM_PO;

import SetUp.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

public class CRM_PO extends BasePage {
    public CRM_PO(WebDriver driver) {
        super(driver);
    }

///////////////////////////Locaters//////////
    public By UserName_xpath = By.xpath("//input[@name = 'email']");
    public By Password_xpath = By.xpath("// input[@name = 'password']");
    public By Login_xpath = By.xpath("// div[text() = 'Login']");
    public By Task_xpath = By.xpath("//span[text() = 'Tasks']");
    public By NewBtn_xpath = By.xpath("//button[@class = 'ui linkedin button']//i[@class = 'edit icon']");
    public By Title_xpath = By.xpath("//input[@name = 'title']");
    public By AssignedTo_xpath = By.xpath("//div[@class = 'ui fluid selection dropdown']");
    public By AssignedTo1_xpath = By.xpath("(//div[@role = 'option'])[1]");
    public By Type_xpath = By.xpath("//div[@class= 'ui active visible selection upward dropdown']");
    public By Type1_xpath = By.xpath("(//div[@role= 'option'])[4]");

    public By Contact_xpath = By.xpath("//div[@name = 'contact']");

    public By Deal_xpath = By.xpath("//div[@name = 'deal']");
    public By Case_xpath = By.xpath("//div[@name = 'case']");
    public By CloseDate_xpath = By.xpath("//input[@class= 'calendarField']");
    public By Tag_xpath = By.xpath("//div[@class= 'ui active visible fluid multiple search selection dropdown'] or //div[@name = 'case']");
    public By Desc_xpath = By.xpath("//textarea[@name = 'description']");
    public By Completion_xpath = By.xpath("//input[@name = 'completion']");
    public By Priority_xpath = By.xpath("//div[@name = 'priority']//option[text() = 'High']");
    public By Identifier_xpath = By.xpath("//input[@name = 'identifier']");
    public By Status_xpath = By.xpath("//div[@name = 'status']");
    public By SaveBtn_xpath = By.xpath("//button[@class = 'ui linkedin button']");


    public boolean selectFromDropDown() {
        try {
            WebElement element = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.visibilityOfElementLocated(Type_xpath));
            element.click();

            WebElement element1 = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.visibilityOfElementLocated(Type1_xpath));
            element1.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }
}