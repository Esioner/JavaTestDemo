package JavaIODemo;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {
		File file = new File("E:" + File.separator + "Files");
		// 判断是否为目录
		if (file.isDirectory()) {
			System.out.println("该File是目录");
			
		} else {
			System.out.println("该File不是目录");
		}
		print(file);
	}
	//递归列出所有文件
	public static void print(File file) {
		int i =0;
		if (file != null) {
			if (file.isDirectory()) {
				File[] files = file.listFiles();
				if (files != null) {
					for (File f : files) {
						print(f);
						System.out.println();
					}
				}
			} else {
				System.out.println(file.getName());
			}

		}
	}
	//创建文件
	public static void createNewFileAndDir(File file) {
		try {
			// 创建文件夹
			File newDir = new File(file.getPath() + File.separator + "File");
			if (newDir.exists()) {
				newDir.delete();
			}
			System.out.println(newDir.mkdir());
			// 创建文件
			File newFile = new File(newDir.getPath() + File.separator + "File.txt");
			if (newFile.exists()) {
				newFile.delete();
				System.out.println("删除文件");
			}
			System.out.println(newFile.createNewFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//列出所有文件名
	public static void listAllName(File file) {
		String[] filesNames = file.list();
		System.out.println("======================列出所有文件不含路径====================");
		for (String name : filesNames) {
			System.out.println(name);
		}
	}
	//列出所有文件
	public static void listAllFile(File file) {
		File[] files = file.listFiles();
		System.out.println("======================列出所有文件含路径====================");
		for (File f : files) {
			System.out.println(f.getName() + "\t\t路径为：" + f.getAbsolutePath());
		}
	}

}
