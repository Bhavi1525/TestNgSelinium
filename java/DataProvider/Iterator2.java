package DataProvider;

import java.util.HashSet;
import java.util.Iterator;
import java.util.Set;

import org.testng.annotations.DataProvider;

public class Iterator2 {
	
	
	@org.testng.annotations.Test(dataProvider="Dp7")
	public void Test(Object[] s)
	{
		System.out.println(s[0]+">>>>"+s[1]);
	}
	@DataProvider
    public Iterator<Object[]> Dp7()
    {
    	Set<Object[]>data=new HashSet<>();
    	data.add(new Object[] {"bhavani",123});
    	data.add(new Object[] {"thulasi",456});
    	return data.iterator();
    }

}
