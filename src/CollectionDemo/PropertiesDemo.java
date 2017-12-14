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
		System.out.println("1���Դ��ڣ�"+ pro.getProperty("1"));
		System.out.println("3���Բ����ڣ�"+ pro.getProperty("3"));
		System.out.println("4���Բ����ڣ�"+ pro.getProperty("4","four"));
		//�����Ա��浽��ͨ�ļ���
		File file = new File("D:"+File.separator+"properties.properties");
		OutputStream out = new FileOutputStream(file);
		pro.store(out, "����");
		//����ͨ�ļ���ȡ����
		InputStream in = new FileInputStream(file);
		pro.load(in);
		System.out.println(pro.getProperty("1"));
		//�������ļ����浽 XML ��
		File file2 = new File("D:"+File.separator+"properties.xml");
		OutputStream out2 = new FileOutputStream(file2);				
		pro.storeToXML(out2, "XML");
		out.close();
		//�� XML �ļ��ж�ȡ����
		pro.loadFromXML(new FileInputStream(file2));
		System.out.println(pro.getProperty("2"));
		
	}
}
