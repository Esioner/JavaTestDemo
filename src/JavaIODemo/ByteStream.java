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
	//�ֽ�������
	public static void startInput() {
		
	}
	//�ֽ������
	public static void startOutput() {
		// 1. ʹ��File�ҵ�һ���ļ�
		File file = new File("E:" + File.separator + "a.txt");
		// 2. ͨ������ʵ�����������
		OutputStream ops = null;
		try {
			ops = new FileOutputStream(file);
			// 3. ����д����
			String str = "������ϰ OutputStream ";
//			byte[] b = str.getBytes();
//			ops.write(b);
			int i = 666;
			ops.write(i);
		} catch (Exception e) {
		} finally {
			// �ر������
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
