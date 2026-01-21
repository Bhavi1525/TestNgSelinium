package DataProvider;

import org.testng.annotations.Test;

public class Dataproviderclassmethod {
	
	@Test(dataProvider = "Dataproviderclass",dataProviderClass = Dataproviderclass.class)
	public void test(String s) {
		System.out.println(s);
	}

}
