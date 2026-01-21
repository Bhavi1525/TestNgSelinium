package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProviderStringarray {
	
	
	@Test(dataProvider = "Dp1")
	public void TestLogin(String s)
	{
		System.out.println(s);
	}
	
	@DataProvider
	public String[] Dp1()
	{
		String[] data = new String[]
				{
					"Bhavani",
					"thulasi",
					"vaishu"
				};
		return data;
	}

}
