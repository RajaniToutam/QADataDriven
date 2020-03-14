package CRM_TC;

import CRM_PO.CRM_PO;
import SetUp.BaseTest;
import SetUp.CommonUtilityMehods;
import UtilityMethods.ExcelUtility;
import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.Iterator;

public class CRM_TC extends BaseTest {

    //reading data from excel file
    @DataProvider
    public Iterator<Object[]> getTestData() throws Exception {
        ArrayList<Object[]> data = ExcelUtility.getExcelData();
        return data.iterator();
    }


    @Test(dataProvider = "getTestData")
    private void checkLogin(String username, String password, String title) throws Exception {

        test = extent.createTest("CRM Login Test");
        test.assignCategory("Login");

        CRM_PO crm_poObj = new CRM_PO(driver);
        CommonUtilityMehods commonUtilityMehodsObj = new CommonUtilityMehods(driver);

        Assert.assertTrue(commonUtilityMehodsObj.enterOnTextInput(crm_poObj.UserName_xpath, username), "Unable to enter username");

        Assert.assertTrue(commonUtilityMehodsObj.enterOnTextInput(crm_poObj.Password_xpath, password), "Unable to enter pwd");

        Assert.assertTrue(commonUtilityMehodsObj.clickOnLink(crm_poObj.Login_xpath), "Unable to click submit button");

        Assert.assertTrue(commonUtilityMehodsObj.clickOnLink(crm_poObj.Task_xpath), "Unable to click Task button");

        Assert.assertTrue(commonUtilityMehodsObj.clickOnLink(crm_poObj.NewBtn_xpath), "Unable to click New button");

        Assert.assertTrue(commonUtilityMehodsObj.enterOnTextInput(crm_poObj.Title_xpath, title), "Unable  to enter title");

    //   Assert.assertTrue(commonUtilityMehodsObj.selectFromDropDown(crm_poObj.AssignedTo_xpath, crm_poObj.AssignedTo1_xpath), "Unable to click on Assigned to");
        Assert.assertTrue(crm_poObj.selectFromDropDown(),"Unable to select type");

     //  Assert.assertTrue(commonUtilityMehodsObj.selectFromDropDown(crm_poObj.Type_xpath, crm_poObj.Type1_xpath), "Unable to select type");

//        Assert.assertTrue(commonUtilityMehodsObj.enterOnTextInput(crm_poObj.Contact_xpath, status), "Unable to enter on contact field");

  //      Assert.assertTrue(commonUtilityMehodsObj.clickFromDropDown(crm_poObj.Status_xpath, status), "Unable to enter on status field");

        Assert.assertTrue(commonUtilityMehodsObj.clickOnLink(crm_poObj.SaveBtn_xpath), "Unable to save the changes");

    }
}
