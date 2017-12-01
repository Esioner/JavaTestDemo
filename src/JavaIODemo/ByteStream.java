package JavaIODemo;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStream;

public class ByteStream {

	public static void main(String[] args) {

		startOutput();
		startInput();

	}
	//字节输入流
	public static void startInput() {
		
	}
	//字节输出流
	public static void startOutput() {
		// 1. 使用File找到一个文件
		File file = new File("E:" + File.separator + "a.txt");
		// 2. 通过子类实例化父类对象
		OutputStream ops = null;
		try {
			ops = new FileOutputStream(file);
			// 3. 进行写操作
			String str = "正在练习 OutputStream ";
//			byte[] b = str.getBytes();
//			ops.write(b);
			int i = 666;
			ops.write(i);
		} catch (Exception e) {
		} finally {
			// 关闭输出流
			if (ops != null) {
				try {
					ops.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		}
	}
}
