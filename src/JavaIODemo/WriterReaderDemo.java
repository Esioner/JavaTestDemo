package JavaIODemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Reader;
import java.io.Writer;

public class WriterReaderDemo {

	public static void main(String[] args) throws Exception {
		// write();
		read();
	}

	public static void write() throws IOException {
		String path = "D:" + File.separator + "writer.txt";
		File file = new File(path);
		Writer writer = new FileWriter(file);
		String str = "小酱软件科技";
		writer.write(str);
		writer.close();
		// 使用追加文件的内容
		Writer writerAppend = new FileWriter(file, true);
		writerAppend.write("\r\n" + str);
		writerAppend.close();
	}

	public static void read() throws Exception {
		String path = "D:" + File.separator + "writer.txt";
		File file = new File(path);
		Reader reader = new FileReader(file);
		char[] c = new char[1024];
		int len = reader.read(c);
		reader.close();
		System.out.println(len);
		System.out.println(new String(c, 0, len));
		// 使用循环的方式读取内容
		Reader read = new FileReader(file);
		int length = 0;
		char[] ch = new char[1024];
		int temp = 0;
		//这里read.read()没有传参数
		while ((temp = read.read()) != -1) {
			ch[length] = (char) temp;
			length++;
		}
		read.close();
		System.out.println(new String(ch,0,length));
	}
}
