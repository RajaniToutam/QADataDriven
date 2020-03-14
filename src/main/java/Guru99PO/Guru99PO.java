package Guru99PO;

import SetUp.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Guru99PO extends BasePage {

    public Guru99PO(WebDriver driver) {
        super(driver);
    }
    //UserID:mngr47659
    //Pwd: 123456@

    ////////////Locators///////////
    public By userID_xpath = By.xpath("//input[@name='uid']");
    public By pwd_xpath = By.xpath("//input[@name='password']");
    public By SubmitBtn = By.xpath("//input[@name='btnLogin']");
    public By NewCust = By.xpath("//a[text()='New Customer']");
    public By CustName = By.xpath("//input[@name='name']");
    public By Gender_xpath = By.xpath("//input[@value='f']");
    public By DOB_xpath = By.xpath("//input[@id = 'dob']");
    public By Address_xpath = By.xpath("//textarea[@name= 'addr']");
    public By City_xpath = By.xpath("//input[@name= 'city']");
    public By State_xpath = By.xpath("//input[@name= 'state']");
    public By Pincode_xpath = By.xpath("//input[@name= 'pinno']");
    public By Telephone_xpath = By.xpath("//input[@name= 'telephoneno']");
    public By EmailID_xpath = By.xpath("//input[@name= 'emailid']");
    public By passw1_xpath = By.xpath("//input[@name= 'password']");
    public By Submit_xpath = By.xpath("//input[@type= 'submit']");
    /////////////////////////Methods////////////////////

    public boolean clickOnLink(By by) {
        try {
            WebElement webElement = (WebElement) (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
            webElement.click();
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean enterTextOnArea(String data, By by){
        try{
            WebElement webElement = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
            webElement.sendKeys(data);
            return true;
        }catch (Exception e){
            return false;
        }
    }



}
