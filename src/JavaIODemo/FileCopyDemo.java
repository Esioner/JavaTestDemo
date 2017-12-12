package JavaIODemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class FileCopyDemo {

	public static void main(String[] args) throws IOException {
		String path = "D:" + File.separator;
		File fromFile = new File(path + "abc.txt");
		File toFile = new File(path + "abcCopy.txt");
		// ¶Á
		byte[] b = new byte[1024];
		int temp = 0;
		InputStream is = new FileInputStream(fromFile);
		OutputStream out = new FileOutputStream(toFile);
		while((temp=is.read())!=-1) {
			out.write(temp);
		}
		is.close();
		out.close();
	}
}
