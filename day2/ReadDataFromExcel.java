package week5.day2;

import java.io.IOException;

import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class ReadDataFromExcel {

	public static String[][]  readingData() throws IOException {
		// TODO Auto-generated method stub
		//to open workbook
		XSSFWorkbook xb= new XSSFWorkbook("./DataDriven/CreateLead.xlsx");
		//to open worksheet
		XSSFSheet xs= xb.getSheetAt(0);
		
		//to get row count	
		int rowcount = xs.getLastRowNum();
		System.out.println("Row count is"+rowcount);
		
		//to get column number
		short columncount = xs.getRow(0).getLastCellNum();
		System.out.println("Column count is"+columncount);
		
		//string variable to read data
		String[][] data= new String[rowcount][columncount];
		
		//to get data in cell
		for (int i=1;i<=rowcount;i++)
		{
			XSSFRow row = xs.getRow(i);
			for(int j=0;j<columncount;j++)
			{
				String stringCellValue = row.getCell(j).getStringCellValue();
				System.out.println(stringCellValue);
				data[i-1][j]=stringCellValue;
			}
		}
		
		xb.close();
		return data;
	}

}
