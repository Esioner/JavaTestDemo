package JavaIODemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.PrintStream;

public class SystemStream {

	public static void main(String[] args) throws IOException {
		String str = "hello";
		OutputStream os = System.out;
		os.write(str.getBytes());
		System.out.println();
		System.err.println(str);
		InputStream is = System.in;
		byte[] b = new byte[1024];
		System.out.println("���������ݣ�");
		int len = is.read(b);
		System.out.println(new String(b, 0, len));
		is.close();
//		// ����ض���
		File file = new File("D:" + File.separator + "a.txt");
//		System.setOut(new PrintStream(new FileOutputStream(file)));
//		System.out.println("�Ҽĳ��������£�ˮ��ֱ��ҹ����");
//		System.out.println("���");
		//�����ض���
		System.setIn(new FileInputStream(file));
		InputStream input = System.in;
		byte[] bs = new byte[1024];
		int length = input.read(bs);
		System.out.println(new String(bs,0,length));
	}
}
