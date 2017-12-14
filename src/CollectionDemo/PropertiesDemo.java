package CollectionDemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.Properties;

public class PropertiesDemo {

	public static void main(String[] args) throws IOException {
		Properties pro = new Properties();
		pro.setProperty("1", "one");
		pro.setProperty("2", "two");
		System.out.println("1属性存在："+ pro.getProperty("1"));
		System.out.println("3属性不存在："+ pro.getProperty("3"));
		System.out.println("4属性不存在："+ pro.getProperty("4","four"));
		//将属性保存到普通文件中
		File file = new File("D:"+File.separator+"properties.properties");
		OutputStream out = new FileOutputStream(file);
		pro.store(out, "属性");
		//从普通文件读取属性
		InputStream in = new FileInputStream(file);
		pro.load(in);
		System.out.println(pro.getProperty("1"));
		//将属性文件保存到 XML 中
		File file2 = new File("D:"+File.separator+"properties.xml");
		OutputStream out2 = new FileOutputStream(file2);				
		pro.storeToXML(out2, "XML");
		out.close();
		//从 XML 文件中读取属性
		pro.loadFromXML(new FileInputStream(file2));
		System.out.println(pro.getProperty("2"));
		
	}
}
