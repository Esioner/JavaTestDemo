package JavaIODemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.SequenceInputStream;

public class SequenceInputStreamDemo {

	public static void main(String[] args) throws IOException {
		String path = "D:" + File.separator;
		File a = new File(path + "a.txt");
		File b = new File(path + "b.txt");
		File c = new File(path + "c.txt");
		InputStream is1 = new FileInputStream(a);
		InputStream is2 = new FileInputStream(b);
		SequenceInputStream sis = new SequenceInputStream(is1, is2);
		OutputStream os = new FileOutputStream(c);
		int temp = 0;
		while ((temp = sis.read()) != -1) {
			os.write(temp);
		}
		is1.close();
		is2.close();
		os.close();
		sis.close();
	}

}
