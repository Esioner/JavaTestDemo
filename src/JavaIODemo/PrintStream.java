package JavaIODemo;

import java.io.File;
import java.io.FileNotFoundException;

public class PrintStream {

	public static void main(String[] args) throws FileNotFoundException {
		File file = new File("D:" + File.separator + "a.txt");
		java.io.PrintStream ps = new java.io.PrintStream(file);
		ps.print("hello ");
		ps.println("world !");
		ps.println("1 + 1 = 2 ");
		//ʹ�ô�ӡ����ʽ������
		String name = "����";
		int age = 30;
		float score = 990.365f;
		char sex = '��';
		//��ʽ��������ַ����� %s ������ʹ�� %d �� С��ʹ�� %f ���ַ�ʹ�� %c 
		ps.printf("������%s �����䣺%d���Ա�%c���ɼ���%f", name,age,sex,score);
		ps.close();
	}

}
