package JavaIODemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

public class ZipDemo {

	public static void main(String[] args) throws IOException {
		File file = new File("D:" + File.separator + "a.txt");
		File file2 = new File("D:" + File.separator + "a.zip");
		InputStream is = new FileInputStream(file);
		ZipOutputStream zipOut = new ZipOutputStream(new FileOutputStream(file2));
		zipOut.putNextEntry(new ZipEntry(file.getName()));
		zipOut.setComment("Ñ¹ËõÎÄ¼þ");
		int temp = 0;
		while((temp=is.read())!=-1) {
			zipOut.write(temp);
		}
		is.close();
		zipOut.close();
	}
}
