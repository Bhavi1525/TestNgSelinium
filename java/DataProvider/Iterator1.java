package DataProvider;

import java.util.HashSet;
import java.util.Set;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class Iterator1 {
	
	@Test(dataProvider = "Dp6")
	public void Iterator(String s)
	{
		System.out.println(s);
	}
	@DataProvider
	
	public java.util.Iterator<String> Dp6()
	{
	Set<String>	data=new HashSet<>();
	data.add("bhavani");
	data.add("thualsi");
	return data.iterator();
	
	}

}
