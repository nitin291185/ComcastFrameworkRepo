package Practice_data_driven_testing;

import org.testng.annotations.Test;

public class ReadRunTimeMavenParameterTest1 {
	@Test
	
		
		public void runtimeParameterTest()
		{
		String url = System.getProperty("url");
		String UN = System.getProperty("username");
		String PW = System.getProperty("password");
		String BROWSER = System.getProperty("browser");
			System.out.println("ENV Data==>URL==>"+url);
			System.out.println("Browser Data==>==>"+BROWSER);
			System.out.println("username Data====>"+UN);
			System.out.println("Pasword Data====>"+PW);
		}
	}


