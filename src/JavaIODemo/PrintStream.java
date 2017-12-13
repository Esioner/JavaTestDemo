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
		//使用打印流格式化代码
		String name = "张三";
		int age = 30;
		float score = 990.365f;
		char sex = '男';
		//格式化输出，字符串用 %s 、整数使用 %d 、 小数使用 %f 、字符使用 %c 
		ps.printf("姓名：%s ；年龄：%d；性别：%c；成绩：%f", name,age,sex,score);
		ps.close();
	}

}
