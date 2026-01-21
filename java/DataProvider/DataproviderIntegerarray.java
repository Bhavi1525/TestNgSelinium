package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataproviderIntegerarray {
	
	
	@Test(dataProvider = "dp2")
	public void Testlogin(Integer i)
	{
		System.out.println(i);
	}
	
	@DataProvider
	public Integer[] dp2()
	{
	Integer[]	data=new Integer[]
			{
				
					1,
					2,
					3
			};
	return data;
	}

}
