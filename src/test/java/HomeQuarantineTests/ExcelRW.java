package HomeQuarantineTests;


import org.apache.poi.hssf.model.InternalWorkbook;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.slf4j.Logger;

import java.io.*;
import java.util.Date;

public class ExcelRW {

    private static Sheet sh;
    private static InputStream fis;
    private static FileOutputStream fos;
    private static Cell cell;
    private static HSSFWorkbook workbook;

    public static void main(String[] args) throws Exception {
        Date d = new Date();

        System.out.println("Hello " +d.getTime());
        //System.getProperty("webdriver.chrome.driver","/home/hasher/Downloads/Stage/chromedriver_linux64/chromedriver");
//        System.setProperty("webdriver.chrome.driver", "/home/hasher/Downloads/Stage/home_quarantine-automation-tests/src/test/java/HomeQuarantineTests/drivers/chromedriver");
//        //System.getProperty("webdriver.chrome.driver","./drivers/chromedriver");
//        WebDriver obj = new ChromeDriver();
//        obj.get("https://www.google.com/");
//        String filePath = "/home/hasher/Downloads/Stage/home_quarantine-automation-tests/testdata.xlsx";
//        fis = new FileInputStream(filePath);
//        //POIFSFileSystem poifs = new POIFSFileSystem(fis);
//        System.out.println("File Stream: "+fis);
//        workbook = new HSSFWorkbook();
//
//        System.out.println(workbook);
//        sh = getWorkBookSheet("Sheet1");
        //sh = wb.getSheet("Sheet1");
//        sh = workbook.getSheet("Sheet1");
//        int noOfRows = sh.getLastRowNum();
//        System.out.println(noOfRows);
//
//        try {
//            for(int iRow = 0; iRow <= noOfRows; iRow++){
//                Row row = null;
//                try {
//                    row = sh.getRow(iRow);
//                    int lastColNum = row.getLastCellNum();
//                    System.out.println(lastColNum);
//                } catch (Exception e){
//                    System.err.println("Exception in reading row: " +e);
//
//                }
//            }
//
//        } catch (Exception e){
//            System.err.println("Exception in Creating workbook: " +e);
//        }
    }

    public static Sheet getWorkBookSheet(String SheetName){
        String filePath = "/home/hasher/Downloads/Stage/home_quarantine-automation-tests/testdata.xlsx";
        InputStream inputStream = null;
        Sheet sheet = null;



        return sheet;
    }
}
