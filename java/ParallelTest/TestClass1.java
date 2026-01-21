package ParallelTest;

import org.testng.annotations.Test;

public class TestClass1 {
	
	
	@Test
	public void TestMethod1()
	{
		System.out.println("TestClass1>>>>TestMethod1 "+Thread.currentThread().getId());
	}
	
	@Test
	public void TestMethod2()
	{
		System.out.println("TestClass1>>>>TestMethod2 "+Thread.currentThread().getId());
	}
	
	@Test
	public void TestMethod3()
	{
		System.out.println("TestClass1>>>>TestMethod3 "+Thread.currentThread().getId());
	}
	
	@Test
	public void TestMethod4()
	{
		System.out.println("TestClass1>>>>TestMethod4 "+Thread.currentThread().getId());
	}
	

}
