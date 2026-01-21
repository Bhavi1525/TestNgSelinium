package DataProvider;

import org.testng.annotations.DataProvider;

public class Dataproviderclass {
	
	@DataProvider
	public String[] Dataproviderclass()
	{
		
	String[]	data=new String[]
			{
				"bhavani",
				"thulasi",
				"vaishu"
				
			};
	return data;
	
	 

}
	
	
	@DataProvider
	public Integer[] Dataproviderclass1()
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