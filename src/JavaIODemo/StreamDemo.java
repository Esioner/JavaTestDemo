package JavaIODemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class StreamDemo {

	public static void main(String[] args) throws Exception {
		// 输出流
		// outputStream();
		// 输入流
		intputStream();

	}

	public static void intputStream() throws Exception {
		String path = "D:" + File.separator + "abc.txt";
		System.out.println(path);
		File file = new File(path);
		InputStream is = new FileInputStream(file);
		byte[] b = new byte[1024];// 如果被读取的内容不足1024，会导致内容后跟着大量空格
		byte[] b2 = new byte[(int) file.length()];// 动态设置数组长度，保证内容可以读取
		int len = is.available();
		// is.read(b2);
		for (int i = 0; i < b2.length; i++) {
			b2[i] = (byte) is.read();
		}
		is.close();
		System.out.println(new String(b2));
		System.out.println(new String(b, 0, len));
		// 当无法得知文件长度时读取的方法
		InputStream is2 = new FileInputStream(file);
		int length = 0;
		int temp = 0;
		byte[] b3 = new byte[1024];
		while ((temp = is2.read()) != -1) {
			// 将每次读取的值赋值给 temp 如果 temp 不等于 -1，则表示文件没有读完
			b3[length] = (byte) temp;
			length++;
		}
		is2.close();
		System.out.println(new String(b3, 0, length));
	}

	public static void outputStream() throws Exception {
		String path = "D:" + File.separator + "abc.txt";
		System.out.println(path);
		File file = new File(path);// 文件不存在会自动创建
		String str = "Hello World";
		byte[] b = str.getBytes();
		OutputStream out = new FileOutputStream(file);
		out.write(b, 0, str.length());
		// 和上面的方法实现的效果是一致的
		for (int i = 0; i < b.length; i++) {
			out.write(b[i]);
		}
		out.close();
		// 追加新内容
		String str2 = "\r\n你好.";
		byte[] b2 = str2.getBytes();
		OutputStream out2 = new FileOutputStream(file, true);
		out2.write(b2, 0, str2.length());
		out2.close();
	}

}
