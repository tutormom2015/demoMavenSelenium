package demomavenutilities;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class XLUtils {
	
	public static int getRowCount( String xlFilePath, String xlFileName, String xlSheetName) throws IOException {
		
		// create an Obj of  File class to open the file
		File file = new File( xlFilePath + "\\" + xlFileName);
		
		// create an Obj of FileInputStream class to read the excel file
		FileInputStream inputStream = new FileInputStream( file);
		
		Workbook myworkbook = null;
		
		// find the file name extension by spilitting the file at . and finding only the extension
		String fileNameExtension = xlFileName.substring( xlFileName.indexOf('.'));
		
		if( fileNameExtension.equals(".xlsx")) {
			
			myworkbook = new XSSFWorkbook(inputStream);
			
		}
		else if( fileNameExtension.equals(".xls")) {
			myworkbook = new HSSFWorkbook( inputStream);
		}
		
		Sheet mySheet = myworkbook.getSheet(xlSheetName);
		
		int rowsCount = mySheet.getLastRowNum() - mySheet.getFirstRowNum();
		
		return rowsCount;
		
	}
	
	public static int getCoulmnCount( String xlFilePath, String xlFileName, String xlSheetName, int rowNum ) throws IOException {
		// create an Obj of  File class to open the file
		File file = new File( xlFilePath + "\\" + xlFileName);
		
		// create an Obj of FileInputStream class to read the excel file
		FileInputStream inputStream = new FileInputStream( file);
		
		Workbook myworkbook = null;
		
		// find the file name extension by spilitting the file at . and finding only the extension
		String fileNameExtension = xlFileName.substring( xlFileName.indexOf('.'));
		
		if( fileNameExtension.equals(".xlsx")) {
			
			myworkbook = new XSSFWorkbook(inputStream);
			
		}
		else if( fileNameExtension.equals(".xls")) {
			myworkbook = new HSSFWorkbook( inputStream);
		}
		
		Sheet mySheet = myworkbook.getSheet(xlSheetName);
		
		int rowsCount = mySheet.getLastRowNum() - mySheet.getFirstRowNum();
		
		Row row = mySheet.getRow( rowNum);
		
		int colCount = row.getLastCellNum() - row.getFirstCellNum() ;
		
		return colCount;
	}
	
	
	public static String getCoulmnData( String xlFilePath, String xlFileName, String xlSheetName, int rowNum , int colNum ) throws IOException {
		// create an Obj of  File class to open the file
		File file = new File( xlFilePath + "\\" + xlFileName);
		
		// create an Obj of FileInputStream class to read the excel file
		FileInputStream inputStream = new FileInputStream( file);
		
		Workbook myworkbook = null;
		
		// find the file name extension by spilitting the file at . and finding only the extension
		String fileNameExtension = xlFileName.substring( xlFileName.indexOf('.'));
		
		if( fileNameExtension.equals(".xlsx")) {
			
			myworkbook = new XSSFWorkbook(inputStream);
			
		}
		else if( fileNameExtension.equals(".xls")) {
			myworkbook = new HSSFWorkbook( inputStream);
		}
		
		Sheet mySheet = myworkbook.getSheet(xlSheetName);
		
		int rowsCount = mySheet.getLastRowNum() - mySheet.getFirstRowNum();
		
		Row row = mySheet.getRow( rowNum);
		
		String colData = row.getCell(colNum).getStringCellValue();
		
		return colData;
	}

	public static void  setCoulmnData( String xlFilePath, String xlFileName, String xlSheetName, int rowNum , int colNum , String cellValue) throws IOException {
		// create an Obj of  File class to open the file
		File file = new File( xlFilePath + "\\" + xlFileName);
		
		// create an Obj of FileInputStream class to read the excel file
		FileInputStream inputStream = new FileInputStream( file);
		
		Workbook myworkbook = null;
		
		// find the file name extension by spilitting the file at . and finding only the extension
		String fileNameExtension = xlFileName.substring( xlFileName.indexOf('.'));
		
		if( fileNameExtension.equals(".xlsx")) {
			
			myworkbook = new XSSFWorkbook(inputStream);
			
		}
		else if( fileNameExtension.equals(".xls")) {
			myworkbook = new HSSFWorkbook( inputStream);
		}
		
		Sheet mySheet = myworkbook.getSheet(xlSheetName);
		
		int rowsCount = mySheet.getLastRowNum() - mySheet.getFirstRowNum();
	
		Row row = null;
		if( rowNum > rowsCount) {
			row =  mySheet.createRow(rowNum);
		}
		else {
			row = mySheet.getRow(rowNum);
		}
		
		Cell cell = row.createCell(rowsCount);
		cell.setCellValue(cellValue);

		
		// create an Obj of OutputFileStream class to write data to file
		FileOutputStream outputStream = new FileOutputStream( file);
		
		// write workbook to the file
		myworkbook.write(outputStream);
		
		myworkbook.close();

		// close input Stream
		inputStream.close();

		// close the output stream
		outputStream.close();
		
		
		
		
		
		
	}

	
	
	
}
