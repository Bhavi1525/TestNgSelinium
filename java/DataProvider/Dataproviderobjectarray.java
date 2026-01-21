package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Dataproviderobjectarray {
	
	@Test(dataProvider="Dp3")
	public void Objectarray(Object s)
	{
		System.out.println(s);
	}
	
	@DataProvider
	public Object[] Dp3()
	{
		Object[] data = new Object[]
				{
					"bhavani"	,
					1,
					"thulasi"
				};
		return data;
	}

}
