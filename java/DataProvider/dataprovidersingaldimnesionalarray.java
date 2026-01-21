package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class dataprovidersingaldimnesionalarray {
	
	@Test(dataProvider = "Dp4")
	public void signaldimensional(String[] s)
	{
		System.out.println(s[0]+" >>  "+s[1]);
	}
	
	@DataProvider
	public String[][] Dp4()
	{
		String[][] data=new String[][]
				{
			{"abc","123"},
			{"pqr","456"},
			{"xyz","789"}
			
				};
				return data;
	}

}
