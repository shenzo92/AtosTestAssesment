package AtosUtils;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class FileReader {

    public static FileInputStream file;
    public static HSSFWorkbook wb;
    public static HSSFSheet sheet;
    public static XSSFWorkbook Xwb;
    public static XSSFSheet Xsheet;
    public static FileInputStream file_WriteIntoExcel;
    public static HSSFWorkbook wb_WriteIntoExcel;
    public static HSSFSheet sheet_WriteIntoExcel;
    public static ArrayList<String> header = new ArrayList<String>();
    public static ArrayList<String> header_WriteIntoExcel = new ArrayList<String>();
    public static int column;
    public static int rowCount;
    public static int column_WriteIntoExcel;
    public static int rowCount_WriteIntoExcel;
    public static int repeatedRowCount_WriteIntoExcel;
    public static ArrayList<ArrayList<String>> data = new ArrayList<ArrayList<String>>();
    public static ArrayList<String> testCaseIds = new ArrayList<String>();
    public static ArrayList<String> testCaseIds_WriteIntoExcel = new ArrayList<String>();

    public static void openExcell(String filePath, String sheetName) throws IOException {
	file = new FileInputStream(filePath);
	wb = new HSSFWorkbook(file);
	sheet = wb.getSheet(sheetName);
	column = sheet.getRow(0).getLastCellNum();
	rowCount = sheet.getPhysicalNumberOfRows();

    }

    public static void readFields() throws IOException {
	HSSFRow row = sheet.getRow(0);
	header = new ArrayList<String>();
	for (int i = 0; i < column; i++) {
	    HSSFCell cell = row.getCell(i);
	    DataFormatter formatter = new DataFormatter();
	    String val = formatter.formatCellValue(cell);
	    header.add(val);
	}
    }

    public static void readTestdata() throws IOException {
	data = new ArrayList<ArrayList<String>>();
	ArrayList<String> dataList;
	for (int i = 1; i < rowCount; i++) {
	    HSSFRow row = sheet.getRow(i);
	    dataList = new ArrayList<String>();
	    for (int j = 0; j < column; j++) {
		HSSFCell cell = row.getCell(j);
		DataFormatter formatter = new DataFormatter();
		String val = formatter.formatCellValue(cell);
		dataList.add(val);
	    }
	    data.add(dataList);

	}
    }

    public static void closeExcel() throws IOException {
	wb.close();
    }

    public static void openExcell_xlsx(String filePath, String sheetName) throws IOException {
	file = new FileInputStream(filePath);
	Xwb = new XSSFWorkbook(file);
	Xsheet = Xwb.getSheet(sheetName);
	column = Xsheet.getRow(0).getLastCellNum();
	rowCount = Xsheet.getPhysicalNumberOfRows();
    }

    public static void readFields_xlsx() throws IOException {
	XSSFRow row = Xsheet.getRow(0);
	for (int i = 0; i < column; i++) {
	    XSSFCell cell = row.getCell(i);
	    DataFormatter formatter = new DataFormatter();
	    String val = formatter.formatCellValue(cell);
	    header.add(val);
	}
    }

    public static void readTcIds_xlsx() {
	for (int i = 1; i < rowCount; i++) {
	    XSSFRow row = Xsheet.getRow(i);
	    XSSFCell cell = row.getCell(0);
	    DataFormatter formatter = new DataFormatter();
	    String val = formatter.formatCellValue(cell);
	    testCaseIds.add(val);
	}
    }

    public static void readTestdata_xlsx() throws IOException {

	data = new ArrayList<ArrayList<String>>();
	ArrayList<String> dataList;
	for (int i = 1; i < rowCount; i++) {
	    XSSFRow row = Xsheet.getRow(i);
	    dataList = new ArrayList<String>();
	    for (int j = 0; j < column; j++) {
		XSSFCell cell = row.getCell(j);
		DataFormatter formatter = new DataFormatter();
		String val = formatter.formatCellValue(cell);
		dataList.add(val);
	    }
	    data.add(dataList);
	}
    }

    public static void closeExcel_xlsx() throws IOException {
	Xwb.close();
    }

    public static void readTcIds() {
	HSSFCell cell = null;
	for (int i = 1; i < rowCount; i++) {
	    HSSFRow row = sheet.getRow(i);
	    try {
		cell = row.getCell(0);
	    } catch (Exception e) {
		break;
	    }
	    DataFormatter formatter = new DataFormatter();
	    String val = formatter.formatCellValue(cell);
	    testCaseIds.add(val);
	}

    }

}
