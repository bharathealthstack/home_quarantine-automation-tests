package HomeQuarantineTests.rwexcel;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

import java.io.File;
import java.io.FileOutputStream;
import java.io.FilenameFilter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class WriteExcelData {

    public static void processTemplateWrite(List uploadHheaderList, List<Object> data) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        System.out.println(workbook);
        String outputFile = "/home/hasher/Downloads/Patient Onboarding Details - SP to Swasth.xlsx";

        Sheet sheet = workbook.createSheet("Request_File_swasth");

        int rownum = 0;
        int cellnum = 0;


        Row row = sheet.createRow(rownum++);

        for(Object Request : uploadHheaderList){

            Cell cell = row.createCell(cellnum++);
            if(Request instanceof  String){
                //System.out.println("Values: " + Request);
                cell.setCellValue((String) Request);
            }
        }
        row = sheet.createRow(rownum++);
        cellnum = 0;
        for(Object Request : data){

            Cell cell = row.createCell(cellnum++);
            if(Request instanceof  String){
                //System.out.println("Values: " + Request);
                cell.setCellValue((String) Request);
            }
        }



        try {
            System.out.println("outputFile:"+outputFile);
            FileOutputStream fos = new FileOutputStream( new File(outputFile));
            //System.out.println("File OS:"+fos);
            workbook.write(fos);
            fos.close();
        } catch (Exception e){

        }

    }

    public static void processTemplateWritePatient(List uploadHheaderList, List<Object> data) throws IOException {
        Workbook workbook = new XSSFWorkbook();
        System.out.println(workbook);
        String outputFile = "/home/hasher/Downloads/Daily Monitoring Sheet.xlsx";

        Sheet sheet = workbook.createSheet("Request_File_swasth");

        int rownum = 0;
        int cellnum = 0;


        Row row = sheet.createRow(rownum++);

        for(Object Request : uploadHheaderList){

            Cell cell = row.createCell(cellnum++);
            if(Request instanceof  String){
                //System.out.println("Values: " + Request);
                cell.setCellValue((String) Request);
            }
        }
        row = sheet.createRow(rownum++);
        cellnum = 0;
        for(Object Request : data){

            Cell cell = row.createCell(cellnum++);
            if(Request instanceof  String){
                //System.out.println("Values: " + Request);
                cell.setCellValue((String) Request);
            }
        }



        try {
            System.out.println("outputFile:"+outputFile);
            FileOutputStream fos = new FileOutputStream( new File(outputFile));
            //System.out.println("File OS:"+fos);
            workbook.write(fos);
            fos.close();
        } catch (Exception e){

        }

    }
}
