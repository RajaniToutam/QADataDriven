package SetUp;

import org.openqa.selenium.WebDriver;

public class BasePage {
    public  WebDriver driver;

   // CommonUtilityMehods commonUtilityMehods;

    //Default constructor initializing the driver
    public BasePage(WebDriver driver) {
        this.driver = driver;
      //  commonUtilityMehods = new CommonUtilityMehods(driver);
    }

}

