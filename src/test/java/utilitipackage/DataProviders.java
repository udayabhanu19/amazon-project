package utilitipackage;
import java.io.IOException;

import org.testng.annotations.DataProvider;
public class DataProviders {
	@DataProvider(name="data")
	public String[][] getData() throws IOException {
		String path = System.getProperty("./src/test/resources/New Microsoft Office Excel Worksheet.xlsx");
		int row =ExcelUtilities.getRowCount(path, "Sheet1");
		int cell = ExcelUtilities.getCellCount(path, "Sheet1",0);
		String data[][] = new String[row][cell];
		for(int i=1;i<=row;i++) {
			for(int j=0;j<=cell;j++) {
				data[i-1][j] = ExcelUtilities.getCellData(path,"Sheet1", i, j);
			}
		}
		return data;
		
	}

}
