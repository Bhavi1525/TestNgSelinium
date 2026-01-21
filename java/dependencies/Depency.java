package dependencies;

import org.testng.annotations.Test;

    
public class Depency {
	static String Trackingnumber=null;
	
	@Test()
	public void CreateShipment()
	{
		System.out.println(5/0);
		System.out.println("CreateShipment");
		Trackingnumber="AB12YH";
	}
	
	
	@Test(priority=1,dependsOnMethods = {"CreateShipment"},ignoreMissingDependencies = true)
	public void Trackshipment() throws Exception
	{
		if(Trackingnumber!=null)
		System.out.println("Trackshipment");
		else
			throw new Exception("invalid tracking number");
	}
	
	

	@Test(dependsOnMethods = {"CreateShipment","Trackshipment"})
	public void Cancelshipment() throws Exception
	{
		if(Trackingnumber!=null)
		System.out.println("Cancelshipment");
		else
		throw new Exception("invalid tracking number");
	}


}
