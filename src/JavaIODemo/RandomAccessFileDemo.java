package JavaIODemo;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.RandomAccessFile;

public class RandomAccessFileDemo {
	public static RandomAccessFile raf = null;
	public static File file = new File("E:" + File.separator + "Files" + File.separator + "random.txt");

	public static void main(String[] args) {

		writeContent();
		readContent();
	}

	/**
	 * 写入数据
	 */
	public static void writeContent() {
		try {
			raf = new RandomAccessFile(file, "rw");
			String name = null;
			name = "张三";
			int age;
			age = 30;
			raf.writeBytes(name);
			raf.writeInt(age);
			name = "李四";
			age = 31;
			raf.writeBytes(name);
			raf.writeInt(age);
			name = "王五";
			age = 32;
			raf.writeBytes(name);
			raf.writeInt(age);
//			raf.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		
	}

	public static void readContent() {
		String name = null;
		int age = 0;
		byte[] b = new byte[8];
		try {
			raf.skipBytes(12);
			for(int i=0;i<b.length;i++) {
				b[i]=raf.readByte();
			}
			name = new String(b);
			age = raf.readInt();
			System.out.println(name+"\t\t"+age);
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
}
