package JavaIODemo;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;

public class ByteArrayStreamDemo {

	public static void main(String[] args) throws IOException {
		//使用内存操作流完成大写字母转换成小写字母
		String str = "HELLOWORLD";
		ByteArrayInputStream bais = new ByteArrayInputStream(str.getBytes());
		ByteArrayOutputStream baos = new ByteArrayOutputStream();
		int temp = 0;
		while((temp = bais.read())!=-1) {
			char c = (char) temp;
			baos.write(Character.toLowerCase(c));
		}
		String newStr = baos.toString();//获取内容
		bais.close();
		baos.close();
		System.out.println(newStr);
	}

}
