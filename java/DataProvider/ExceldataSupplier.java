package DataProvider;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Arrays;

import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.testng.annotations.DataProvider;

public class ExceldataSupplier {

	@DataProvider
	public  Object[][] getdata() throws IOException {
		// TODO Auto-generated method stub

		
		File file = new File("C:\\Users\\BhavaniMudraboina\\eclipse-workspace\\TestNGselenium\\Excel\\Test.xlsx");
		FileInputStream fis = new FileInputStream(file);
		System.out.println(file.exists());
		XSSFWorkbook workbook = new XSSFWorkbook(fis);
		XSSFSheet Sheet = workbook.getSheet("Sheet1");
		System.out.println(Sheet.getPhysicalNumberOfRows());
		System.out.println(Sheet.getPhysicalNumberOfRows()-1);
		System.out.println(Sheet.getLastRowNum());
		
		int noofrows = Sheet.getPhysicalNumberOfRows();
		int noofcolomns = Sheet.getRow(0).getLastCellNum();
		
		Object[][] data = new Object[noofrows-1][noofcolomns];
		for(int i=0;i<noofrows-1;i++)
		{
			for(int j=0;j<noofcolomns;j++)
			{
				DataFormatter formate = new DataFormatter();
				data[i][j]=formate.formatCellValue(Sheet.getRow(i+1).getCell(j));
			}
		}
		workbook.close();
		fis.close();
		for(Object[] dataarray:data)
		{
			System.out.println(Arrays.toString(dataarray));
		}
		return data;
	}

}
