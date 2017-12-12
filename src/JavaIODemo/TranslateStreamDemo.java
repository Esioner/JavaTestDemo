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
		//将字节输出流转换为字符输出流
		Writer out = new OutputStreamWriter(new FileOutputStream(file));
		//将字节输入流转换为字符输入流
		Reader reader = new InputStreamReader(new FileInputStream(file)); 
	}

}
