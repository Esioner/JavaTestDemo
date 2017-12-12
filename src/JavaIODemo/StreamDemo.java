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
		// �����
		// outputStream();
		// ������
		intputStream();

	}

	public static void intputStream() throws Exception {
		String path = "D:" + File.separator + "abc.txt";
		System.out.println(path);
		File file = new File(path);
		InputStream is = new FileInputStream(file);
		byte[] b = new byte[1024];// �������ȡ�����ݲ���1024���ᵼ�����ݺ���Ŵ����ո�
		byte[] b2 = new byte[(int) file.length()];// ��̬�������鳤�ȣ���֤���ݿ��Զ�ȡ
		int len = is.available();
		// is.read(b2);
		for (int i = 0; i < b2.length; i++) {
			b2[i] = (byte) is.read();
		}
		is.close();
		System.out.println(new String(b2));
		System.out.println(new String(b, 0, len));
		// ���޷���֪�ļ�����ʱ��ȡ�ķ���
		InputStream is2 = new FileInputStream(file);
		int length = 0;
		int temp = 0;
		byte[] b3 = new byte[1024];
		while ((temp = is2.read()) != -1) {
			// ��ÿ�ζ�ȡ��ֵ��ֵ�� temp ��� temp ������ -1�����ʾ�ļ�û�ж���
			b3[length] = (byte) temp;
			length++;
		}
		is2.close();
		System.out.println(new String(b3, 0, length));
	}

	public static void outputStream() throws Exception {
		String path = "D:" + File.separator + "abc.txt";
		System.out.println(path);
		File file = new File(path);// �ļ������ڻ��Զ�����
		String str = "Hello World";
		byte[] b = str.getBytes();
		OutputStream out = new FileOutputStream(file);
		out.write(b, 0, str.length());
		// ������ķ���ʵ�ֵ�Ч����һ�µ�
		for (int i = 0; i < b.length; i++) {
			out.write(b[i]);
		}
		out.close();
		// ׷��������
		String str2 = "\r\n���.";
		byte[] b2 = str2.getBytes();
		OutputStream out2 = new FileOutputStream(file, true);
		out2.write(b2, 0, str2.length());
		out2.close();
	}

}
