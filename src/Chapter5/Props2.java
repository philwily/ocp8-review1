package Chapter5;
 
import java.io.FileInputStream; 
import java.io.FileOutputStream; 
import java.io.IOException;
import java.util.Properties;

public class Props2
{
	public static void main(String[] args)
	{
		
		Properties props = new Properties();
		
		try (FileInputStream fis = new FileInputStream("Chapter5\\myProps1.props"); 
		     FileOutputStream fos = new FileOutputStream("Chapter5\\myProps2.props"))
		{
			props.load(fis);
			listProps(props);
			props.setProperty("newprop", "newdata");
			listProps(props);
			
			props.store(fos, "my update");
		}
		catch (IOException e)
		{
			e.printStackTrace();
		}
		
		
	}
	
	public static void listProps(Properties props)
	{
		props.list(System.out);
	}
}