package JavaIODemo;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;

public class BufferReaderDemo {

	public static void main(String[] args) throws IOException {
		File file = new File("D:" + File.separator + "a.txt");
		Reader in = new InputStreamReader(new FileInputStream(file));
		BufferedReader br = new BufferedReader(in);
		String str = null;
		while((str = br.readLine())!=null) {
			System.out.println(str);
		}
	}

}
