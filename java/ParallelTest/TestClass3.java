package ParallelTest;

import org.testng.annotations.Test;

public class TestClass3 {
	
	
	@Test
	public void TestMethod9()
	{
		System.out.println("TestClass3>>>>TestMethod9 "+Thread.currentThread().getId());
	}
	
	@Test
	public void TestMethod10()
	{
		System.out.println("TestClass3>>>>TestMethod10 "+Thread.currentThread().getId());
	}
	
	@Test
	public void TestMethod11()
	{
		System.out.println("TestClass3>>>>TestMethod11 "+Thread.currentThread().getId());
	}
	
	@Test
	public void TestMethod12()
	{
		System.out.println("TestClass3>>>>TestMethod12 "+Thread.currentThread().getId());
	}

}
