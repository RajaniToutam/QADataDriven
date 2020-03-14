package CRMPRO_TC;

import CRMPRO_PO.CRM_PO_FileProp;
import SetUp.BaseTest;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.*;
import java.util.Properties;

import static org.testng.Assert.assertEquals;

public class CRM_TC_FileProp extends BaseTest {
    public CRM_TC_FileProp() throws Exception {
        super();
    }

    public void CRM_PO_FileProp(WebDriver passDriver){driver = passDriver;}

    @Test
          public void CROM_PO_FileProp() throws InterruptedException, IOException {
        CRM_PO_FileProp CRM_POObj = new CRM_PO_FileProp(driver);

        test = extent.createTest("Login Test");

        Properties prop = new Properties();

        driver.get("https://classic.crmpro.com/login.cfm");
        String myTitle = driver.getTitle();

       /* FileInputStream file = new FileInputStream("\\src\\test\\resources\\Config_EE.properties");
        Properties prop = new Properties();
        prop.load(file);*/

        prop.load(new FileInputStream(System.getProperty("user.dir") + "\\src\\main\\resources\\Login.properties"));
        System.out.println(prop.getProperty("UserName"));


        String UserName = prop.getProperty("UserName");
        assertEquals((CRM_POObj.enterUserName(UserName)), true, "Opps!! unable to enter User name");
        test.log(Status.PASS, "Entered User Name");

        String Password = prop.getProperty("Password");
        assertEquals((CRM_POObj.enterPassword(Password)), true, "Opps!! unable to enter first name");
        test.log(Status.PASS, "Enter Password");

        Assert.assertTrue(CRM_POObj.clickSubmitBtn(), "Opps! not able to click new customer tab");
        test.log(Status.PASS,"Submit button clicked");

        Assert.assertEquals(myTitle, "CRMPRO Log In Screen 123");

        System.out.println("Title is "+ myTitle);


    }
}
