package HomeQuarantineTests.rwexcel;

import java.io.*;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.openxml4j.opc.OPCPackage;
import org.apache.poi.poifs.filesystem.POIFSFileSystem;
import org.apache.poi.ss.usermodel.*;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadExcelData {

	public static List processTemplateData(String inFileName, String SearchType, String sheetRow, boolean isfileDelRequired) throws IOException {

		File dir = null;
		String filename1 = null;
		String downloadDir = "/home/hasher/Downloads";
		if (SearchType.equalsIgnoreCase("Search")){
			//Read File Name
			dir= new File(downloadDir);
			FilenameFilter filter = new FilenameFilter() {
				public boolean accept(File dir, String name) {
//					return name.startsWith("Request_File_swasth-to-sp");
					return name.startsWith(inFileName);
				}
			};
			String[] children = dir.list(filter);


			if (children == null) {
				System.out.println("Either dir does not exist or is not a directory");
			} else {
				for (int i = 0; i < children.length; i++) {
					filename1 = children[i];
					System.out.println("Found File: " +filename1);
				}
			}
		}else {
			filename1 = inFileName;
		}



		String fileName = downloadDir+"/" + filename1; //Request_File_swasth-to-sp-1596161108066-Request_File.xlsx"; //Read.xls";
		System.out.println("File is called : " + fileName);

		InputStream inputExcelFile = null;
		Workbook wb = null;
		Sheet sheet = null;
		File file = null;
		List<Object> lastRowList = null;
		try {
			file = new File(fileName);

			lastRowList = new ArrayList<Object>();

			System.out.println("File Name: " + file.getName());

			inputExcelFile = new FileInputStream(file);

			System.out.println("Created InputStream of file:" + inputExcelFile);

			wb = ReadExcelData.getWorkbook(inputExcelFile, fileName);
			System.out.println("Created workbook: " + wb);

			sheet = wb.getSheetAt(0);
			System.out.println("Sheet is created:" + sheet);

			int totalRow = 0;
			if(sheetRow == "LastRow"){
				totalRow = sheet.getLastRowNum();
			}else if(sheetRow == "FirstRow"){
				totalRow = sheet.getFirstRowNum();
			}else {
				totalRow = Integer.parseInt(sheetRow);
			}

			System.out.println("Total Rows: " + (totalRow + 1));

			lastRowList = ReadExcelData.getCellData(totalRow,sheet);
			System.out.println("List created [ " + lastRowList + "]");

			return lastRowList;

		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if (inputExcelFile != null)
				inputExcelFile.close();
			if (wb != null)
				wb.close();
			if (file != null && isfileDelRequired)
				file.deleteOnExit();

		}
		return lastRowList;

	}

	@SuppressWarnings("unused")
	public static Workbook getWorkbook(InputStream input, String excelFilePath) throws IOException {
		Workbook workbook = null;
		POIFSFileSystem fs = null;
		OPCPackage opcPackage = null;
		File file = new File(excelFilePath);

		XSSFWorkbook wb = null;
		try {
			System.out.println(input);
			if (excelFilePath.endsWith("xlsx")) {


				InputStream fis = new FileInputStream(file);   //obtaining bytes from the file
				//creating Workbook instance that refers to .xlsx file
				workbook = new XSSFWorkbook(fis);

				OutputStream ofs = new FileOutputStream(new File(excelFilePath));
				workbook = new XSSFWorkbook(OPCPackage.create(ofs));

			} else if (excelFilePath.endsWith("xls")) {
				fs = new POIFSFileSystem(input);
				workbook = new HSSFWorkbook(fs);
			} else {
				throw new IllegalArgumentException("The specified file is not Excel file");
			}
			return workbook;

		} catch (Exception e) {
			System.err.println("Error: " + e);
			return workbook;
		} finally {
			if (fs != null)
				fs.close();
			if (opcPackage != null)
				opcPackage.close();
		}

	}

	public static List getCellData(int totalRow, Sheet sheet) {
		String lCellValue = null;
		List<Object> lastRowList = new ArrayList<Object>();
		try {
			for (int rowInd = totalRow; rowInd <= totalRow; rowInd++) {
				Row row = sheet.getRow(rowInd);
//			for (Row row : sheet) {
				int totalColumns = row.getLastCellNum();

//				for(int i = 0; i < totalColumns; i++) {
//					Cell cell = row.getCell(i);
				for (Cell cell : row) {
					//System.out.println(cell.getCellType());
					switch (cell.getCellType()) {
						case NUMERIC:
							if (DateUtil.isCellDateFormatted(cell)) {
								//DataFormatter�formatter�=�new�DataFormatter();
								DataFormatter DF = new DataFormatter();
								lCellValue = DF.formatCellValue(cell).toString();
								//lCellValue = cell.getDateCellValue().toString() + "";
							} else {
								DecimalFormat df = new DecimalFormat("###.##");
								lCellValue = df.format(cell.getNumericCellValue()).trim().toString();
							}
							break;
						case STRING:
							// System.out.println("CELL_TYPE_STRING:"+cell.getStringCellValue());
							lCellValue = cell.getStringCellValue().trim() + "";
							break;
						case BOOLEAN:
							// System.out.println("CELL_TYPE_BOOL:"+cell.getBooleanCellValue());
							lCellValue = String.valueOf(cell.getBooleanCellValue());
							break;
						case BLANK:
							// System.out.println("CELL_TYPE_BLANK");
							lCellValue = "";
							break;
						case ERROR:
							// System.out.println("CELL_TYPE_ERROR:"+cell.getErrorCellValue());
							lCellValue = cell.getErrorCellValue() + "";
							break;
						default:
							// System.out.println("CELL_TYPE_UNKNOW");
							lCellValue = "";
							break;
					}
					//System.out.println("lCellValue: " + lCellValue);
					lastRowList.add(lCellValue);
				}
			}
			return lastRowList;
		} catch (Exception e) {
			System.err.println(e);
			return lastRowList;
		}

	}

}
