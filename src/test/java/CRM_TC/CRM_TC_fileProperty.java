package CRM_TC;

import CRM_PO.CRM_PO_fileProperty;
import SetUp.BaseTest;
import SetUp.ReadPropFile;
import com.aventstack.extentreports.Status;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.Properties;

public class CRM_TC_fileProperty extends BaseTest {
    CRM_TC_fileProperty() throws Exception{
        super();
    }



    @Test
    public void CRM_TC_fileProperty() throws Exception {
        //Reading user name & password from properties file:
        ReadPropFile readPropFile = new ReadPropFile();      //Reading user name & password from properties file:
        CRM_PO_fileProperty crm_po_filePropertyOBJ = new CRM_PO_fileProperty(driver);


        //Properties properties = new Properties();

        test = extent.createTest("Login test");
        test.assignCategory("Login");

        String username = readPropFile.getUsername();
        Assert.assertTrue(crm_po_filePropertyOBJ.enterUserName(username), "Unable to enter username");
        test.log(Status.PASS, "Enter User Name");

        String password = readPropFile.getPassword();
        Assert.assertTrue(crm_po_filePropertyOBJ.enterPassword(password), "Unable to enter password");
        test.log(Status.PASS, "Enter password");

        Assert.assertTrue(crm_po_filePropertyOBJ.clickLoginBtn(), "unable to click on login");
        test.log(Status.PASS, "clicked on login");
    }
}
