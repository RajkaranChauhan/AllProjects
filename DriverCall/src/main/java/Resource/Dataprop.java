package Resource;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;





public class Dataprop {
	
//	public String browser;
	public WebDriver driver;
	protected String URLhomePage;
	   Properties prop;
	

	public    Dataprop() throws IOException
	{
		System.out.println("i'm DataProperties ");
	 prop =new Properties();
	String path=System.getProperty("user.dir")+"\\src\\main\\java\\Resource\\data.properties";
	FileInputStream fis=new FileInputStream(path);
	
	prop.load(fis);
	
	
	}
	
	
	public String getBrowser()
	{
		System.out.println("i'm browser ");
		String browser=prop.getProperty("browser");
		return browser;
	}
	
	public String getURL()
	{
		System.out.println("i'm  get URL");
		URLhomePage=prop.getProperty("URL");
		return URLhomePage;
	}
	

	
		
	
	}


	
	

