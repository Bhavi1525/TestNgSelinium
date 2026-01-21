package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Indices {
	
	@Test(dataProvider = "Testlogin")
	public void indices(String s)
	{
		System.out.println(s);
	}
	
	
	@DataProvider(indices = {0,2})
	public String[] Testlogin()
	
	{
		String[] data = new String[]
				{
						"bhavani",
						"thulasi",
						"vaishu",
						"ganga"
				};
		return data;
	}

}
