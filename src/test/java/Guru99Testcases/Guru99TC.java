package Guru99Testcases;

import Guru99PO.Guru99PO;
import SetUp.BaseTest;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class Guru99TC extends BaseTest {
    public Guru99TC() throws Exception {
        super();
    }

    public Guru99TC(WebDriver passDriver) throws Exception {
        super();
        driver = passDriver;
    }

    @Test
    public void Guru99TC() throws Exception {

        String src = System.getProperty("user.dir") + "\\src\\test\\java\\DataDriven\\CRMDataFile.xlsx";

        Guru99PO guru99POObj = new Guru99PO(driver);

        Workbook workbook;
        Sheet sheet;
        Cell cell;
        Cell currentRowUser;
        Cell NextRowUser;
        boolean flag = true;


        FileInputStream fileInput = new FileInputStream(new File(src)); //load the excel file

        workbook = new XSSFWorkbook(fileInput);
        sheet = workbook.getSheetAt(0);

        for (int i = 1; i <= sheet.getLastRowNum(); i++) {

            test = extent.createTest("Test Passed", "Verify Add New Customer ");
            test.assignCategory("Module 1 - New Customer Tab  ");

            if (flag) {

                cell = sheet.getRow(i).getCell(0);
                System.out.println("EmailID: " + i + cell);

                Assert.assertTrue(guru99POObj.enterTextOnArea(cell.getStringCellValue(), guru99POObj.userID_xpath), "Opps not able to enter username");

                cell = sheet.getRow(i).getCell(1);
                Assert.assertTrue(guru99POObj.enterTextOnArea(cell.getStringCellValue(), guru99POObj.pwd_xpath), "Opps not able to enter pwd");

                Assert.assertTrue(guru99POObj.clickOnLink(guru99POObj.SubmitBtn), "Opps! not able to click login btn");

                Assert.assertTrue(guru99POObj.clickOnLink(guru99POObj.NewCust), "Opps! not able to click new customer tab");

            }

            Assert.assertTrue(guru99POObj.clickOnLink(guru99POObj.NewCust), "Opps! not able to click new customer tab");

            cell = sheet.getRow(i).getCell(2);
            Assert.assertTrue(guru99POObj.enterTextOnArea(cell.getStringCellValue(), guru99POObj.CustName));

            Assert.assertTrue(guru99POObj.clickOnLink(guru99POObj.Gender_xpath));

            cell = sheet.getRow(i).getCell(3);
            Assert.assertTrue(guru99POObj.enterTextOnArea(cell.getStringCellValue(), guru99POObj.DOB_xpath), "Not aBle to enter date");

            cell = sheet.getRow(i).getCell(4);
            Assert.assertTrue(guru99POObj.enterTextOnArea(cell.getStringCellValue(), guru99POObj.Address_xpath), "not able to enter address");

            cell = sheet.getRow(i).getCell(5);
            Assert.assertTrue(guru99POObj.enterTextOnArea(cell.getStringCellValue(), guru99POObj.City_xpath), "not able to enter city");

            cell = sheet.getRow(i).getCell(6);
            Assert.assertTrue(guru99POObj.enterTextOnArea(cell.getStringCellValue(), guru99POObj.State_xpath), "not able to enter state");

            cell = sheet.getRow(i).getCell(7);
            Assert.assertTrue(guru99POObj.enterTextOnArea(cell.getStringCellValue(), guru99POObj.Pincode_xpath), "not able to enter pincode");

            cell = sheet.getRow(i).getCell(8);
            Assert.assertTrue(guru99POObj.enterTextOnArea(cell.getStringCellValue(), guru99POObj.Telephone_xpath), "not able to enter phone");

            cell = sheet.getRow(i).getCell(9);
            Assert.assertTrue(guru99POObj.enterTextOnArea(cell.getStringCellValue(), guru99POObj.EmailID_xpath), "not able to enter email");

            cell = sheet.getRow(i).getCell(10);
            Assert.assertTrue(guru99POObj.enterTextOnArea(cell.getStringCellValue(), guru99POObj.passw1_xpath), "not able to enter passwrd");

            Assert.assertTrue(guru99POObj.clickOnLink(guru99POObj.Submit_xpath));
            System.out.println("New customer successfully added in the system");

            Thread.sleep(3000);

            cell = sheet.getRow(i).createCell(11);
            System.out.println("Status: " + i + cell);
            cell.setCellValue("pass");


            currentRowUser = sheet.getRow(i).getCell(0);
            NextRowUser = sheet.getRow(i + 1).getCell(0);

            System.out.println("current Row User: " + (i) + " " + currentRowUser);
            System.out.println("Next Row User : " + (i + 1) + " " + NextRowUser);

            if (currentRowUser.toString().trim() != NextRowUser.toString().trim()) {
                //set flag to true as next row is different, hence force to login
                flag = true;

            } else {
                //set flag to false as next row is same, hence not required to login, or skip login
                flag = false;
            }

            FileOutputStream fileout = new FileOutputStream(new File(src));
            workbook.write(fileout);
            fileout.flush();
            fileout.close();
        }
    }
}

