package Chapter5;
 
import java.io.FileOutputStream; 
import java.io.IOException;
import java.util.Properties;

public class Props1
{
	public static void main(String[] args)
	{
		
		Properties props = System.getProperties();
		listProps(props);
		System.out.println();
		
		props = new Properties();
		props.setProperty("k1", "v1");
		props.setProperty("k2", "v2");
		listProps(props);
		System.out.println();
		
		try (FileOutputStream fos = new FileOutputStream("Chapter5\\myProps1.props"))
		{
			props.store(fos, "test-comment");
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