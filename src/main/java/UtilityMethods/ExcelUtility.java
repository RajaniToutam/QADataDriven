package UtilityMethods;

import CRM_PO.CRM_PO;
import SetUp.BaseTest;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.channels.FileLockInterruptionException;
import java.util.ArrayList;

public class ExcelUtility extends BaseTest {
    public ExcelUtility() throws Exception {
    }

    private static XSSFWorkbook workBook;
    private static XSSFSheet sheet;
    private static XSSFCell cell;
    private static XSSFRow row;

    public static ArrayList<Object[]> getExcelData() throws Exception {

        ArrayList<Object[]> myData = new ArrayList<Object[]>();
        String filePath = System.getProperty("user.dir") + "\\src\\main\\resources\\NewCustDataFile.xlsx";

        setExcelFile(filePath, 0);

        for (int rowNum = 1; rowNum <= sheet.getLastRowNum(); rowNum++) {

            String userName = sheet.getRow(rowNum).getCell(0).getStringCellValue();
            String password = sheet.getRow(rowNum).getCell(1).getStringCellValue();
            String title = sheet.getRow(rowNum).getCell(2).getStringCellValue();
          //  String value = sheet.getRow(rowNum).getCell(3).getStringCellValue();
           // String text = sheet.getRow(rowNum).getCell(4).getStringCellValue();
            //String status = sheet.getRow(rowNum).getCell(5).getStringCellValue();


            System.out.println("username " + userName);
            System.out.println("password " + password);
            System.out.println("title" + title);
            /*System.out.println("value " + value);
            System.out.println("text " + text);
            System.out.println("Status " + status);*/
            System.out.println("==========================");

            Object[] obj = {userName, password, title};
            myData.add(obj);

        }

      //  workBook.close();;
        return myData;
    }

        public static void setExcelFile (String filePath,int sheetNum) throws Exception {
            try {
                FileInputStream fileInputStream = new FileInputStream(filePath);
                workBook = new XSSFWorkbook(fileInputStream);
                sheet = workBook.getSheetAt(sheetNum);

            } catch (FileNotFoundException e) {

                e.printStackTrace();
            }
        }


    }

