package SetUp;

import SetUp.BasePage;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.List;
import java.util.Set;

public class CommonUtilityMehods {

    private WebDriver driver;
    public CommonUtilityMehods(WebDriver driver){
        this.driver = driver;
    }


    public boolean clickOnLink(By by) {

        try {
            driver.findElement(by).click();
          /* WebElement webElement = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
            webElement.click();*/
           return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean enterOnTextInput(By by, String text) {
        try {
            /*WebElement webElement =  (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.visibilityOfElementLocated(by));
            webElement.sendKeys(text);*/
           driver.findElement(by).sendKeys(text);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public boolean selectFromDropDown(By dropdown, By ddtext) {
        try {
            WebElement element = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.visibilityOfElementLocated(dropdown));
            element.click();

            WebElement element1 = (new WebDriverWait(driver, 60))
                    .until(ExpectedConditions.visibilityOfElementLocated(ddtext));
            element1.click();
            return true;
        } catch (Exception e) {
            e.printStackTrace();
            return false;
        }

    }


    public boolean clickFromDropDown(By by,String value){
        try {
            Thread.sleep(2000);
         //value  driver.findElement(By.xpath("//div[@class= 'ui active visible selection upward dropdown']")).click();
           // System.out.println("Locator "+ by);
            List<WebElement> dropDownList = driver.findElements(by);
            System.out.println("Total dropDownBtn " + dropDownList.size());

            for (WebElement element : dropDownList) {
                Actions action = new Actions(driver);
                action.moveToElement(element);

                String dropDownNames = element.getText();
                System.out.println("dropdown name" + dropDownNames);
                System.out.println("value"+ value);
                if (dropDownNames.contains(value)) {
                  //  element.getAttribute("true");
                    element.click();
                    return true;
                } else {
                    continue;
                }
            }
                return false;

            }catch(Exception e){
                return false;
            }
        }
    }

