package utilitipackage;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.ss.usermodel.CellStyle;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ExcelUtilities {
	public static FileInputStream fi;	
	public static FileOutputStream fo;
	public static XSSFWorkbook wb;
	public static XSSFSheet ws;
	public static XSSFRow row;
	public static XSSFCell cell;
	public static DataFormatter dataformatter;
	public static CellStyle style;
	public static int getRowCount(String xlfile,String xlsheet) throws IOException {
		fi = new FileInputStream(xlfile);
	    wb = new XSSFWorkbook(fi);
	    ws = wb.getSheet(xlsheet);
	   int rowcount = ws.getLastRowNum();
	   wb.close();
	   fi.close();
	   return rowcount;
	}
	public static int getCellCount(String xlfile , String xlsheet, int rowcount) throws IOException {
		fi=new FileInputStream(xlfile);
		wb = new XSSFWorkbook(fi);
		ws = wb.getSheet(xlsheet);
		 row =ws.getRow(rowcount);
		 int cellcount=row.getLastCellNum();
		 wb.close();
         fi.close();
         return cellcount;
	}
	public static String getCellData(String xlfile , String xlsheet,int rowcount,int cellcount) throws IOException  {
		fi=new FileInputStream(xlfile);
		wb=new XSSFWorkbook(fi);
		ws= wb.getSheet(xlsheet);
		row = ws.getRow(rowcount);
		cell = row.getCell(cellcount);
		String data;
		try {
			dataformatter = new DataFormatter();
			data = dataformatter.formatCellValue(cell);
		}
		catch(Exception e) {
			data="";
		}
		wb.close();
       fi.close();
       return data;
		
		
		
	}

}
