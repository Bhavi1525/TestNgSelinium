package DataProvider;

import org.testng.annotations.DataProvider;

public class objectsingaldimensionalarray {
	
	
	@org.testng.annotations.Test(dataProvider ="Dp5" )
	public void Test(Object[] s)
	{
		for(int i=0;i<s.length;i++)
		{
			System.out.println(s[i]);
		}
		System.out.println(">>>>>");
	}
	
	@DataProvider
	public Object Dp5()
	{
		Object data=new Object[][]
				
				{
			{"bhavani" ,1,"thulasi"},
			{"anusha",123},
			{"vaishu",456,"ganga",678}
	
			
				};
				return data;
				
	}

}
