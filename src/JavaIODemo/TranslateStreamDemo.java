package JavaIODemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;

public class TranslateStreamDemo {

	public static void main(String[] args) throws FileNotFoundException {
		String path = "D:" + File.separator + "abc.txt";
		File file = new File(path);
		//���ֽ������ת��Ϊ�ַ������
		Writer out = new OutputStreamWriter(new FileOutputStream(file));
		//���ֽ�������ת��Ϊ�ַ�������
		Reader reader = new InputStreamReader(new FileInputStream(file)); 
	}

}
