package JavaIODemo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayStreamDemo {

	public static void main(String[] args) throws IOException {
		//ʹ���ڴ��������ɴ�д��ĸת����Сд��ĸ
		String str = "HELLOWORLD";
		ByteArrayInputStream bais = new ByteArrayInputStream(str.getBytes());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int temp = 0;
		while((temp = bais.read())!=-1) {
			char c = (char) temp;
			baos.write(Character.toLowerCase(c));
		}
		String newStr = baos.toString();//��ȡ����
		bais.close();
		baos.close();
		System.out.println(newStr);
	}

}
