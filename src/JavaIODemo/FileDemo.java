package JavaIODemo;

import java.io.File;
import java.io.IOException;

public class FileDemo {

	public static void main(String[] args) {
		File file = new File("E:" + File.separator + "Files");
		// �ж��Ƿ�ΪĿ¼
		if (file.isDirectory()) {
			System.out.println("��File��Ŀ¼");
			
		} else {
			System.out.println("��File����Ŀ¼");
		}
		print(file);
	}
	//�ݹ��г������ļ�
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
	//�����ļ�
	public static void createNewFileAndDir(File file) {
		try {
			// �����ļ���
			File newDir = new File(file.getPath() + File.separator + "File");
			if (newDir.exists()) {
				newDir.delete();
			}
			System.out.println(newDir.mkdir());
			// �����ļ�
			File newFile = new File(newDir.getPath() + File.separator + "File.txt");
			if (newFile.exists()) {
				newFile.delete();
				System.out.println("ɾ���ļ�");
			}
			System.out.println(newFile.createNewFile());
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	//�г������ļ���
	public static void listAllName(File file) {
		String[] filesNames = file.list();
		System.out.println("======================�г������ļ�����·��====================");
		for (String name : filesNames) {
			System.out.println(name);
		}
	}
	//�г������ļ�
	public static void listAllFile(File file) {
		File[] files = file.listFiles();
		System.out.println("======================�г������ļ���·��====================");
		for (File f : files) {
			System.out.println(f.getName() + "\t\t·��Ϊ��" + f.getAbsolutePath());
		}
	}

}
