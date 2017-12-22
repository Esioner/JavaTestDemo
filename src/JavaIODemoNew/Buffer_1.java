package JavaIODemoNew;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.nio.IntBuffer;
import java.nio.channels.FileChannel;
import java.nio.channels.FileLock;

public class Buffer_1 {

	public static void main(String[] args) throws Exception {
		// buffer_1();
		// �����ӻ�����
		// createInbuffer();
		// �ļ���
		fileLock();
	}

	private static void fileLock() throws Exception {
		File file = new File("D:" + File.separator + "a.txt");
		FileOutputStream fos = new FileOutputStream(file);
		FileChannel fChannel = fos.getChannel();
		FileLock fileLock = fChannel.tryLock();
		if (fileLock != null) {
			System.out.println(file.getName() + "�ļ����� 10 ��");
			Thread.sleep(10000);
			fileLock.release();
			System.out.println("�ļ�����");
		}
		fChannel.close();
		fos.close();
	}

	private static void createInbuffer() {
		IntBuffer buffer = IntBuffer.allocate(10);
		// �������
		for (int i = 0; i < 10; i++) {
			buffer.put(i * 2 + 1);
		}
		// ����ָ���λ��
		buffer.position(2);
		buffer.limit(6);
		IntBuffer suBuffer = buffer.slice();
		for (int i = 0; i < suBuffer.capacity(); i++) {
			int temp = suBuffer.get(i);
			suBuffer.put(temp - 1);
		}
		// ���軺����
		buffer.flip();
		// ����Limit
		buffer.limit(buffer.capacity());
		System.out.println("���������е�����");
		while (buffer.hasRemaining()) {
			int x = buffer.get();
			System.out.print(x + "��");
		}

	}

	public static void buffer_1() {
		IntBuffer buffer = IntBuffer.allocate(10);
		System.out.println("1��д������֮ǰ�� position��limit��capacity��");
		System.out.println("position:" + buffer.position());
		System.out.println("limit:" + buffer.limit());
		System.out.println("capacity:" + buffer.capacity());
		int temp[] = { 5, 7, 9 };
		buffer.put(3);
		buffer.put(temp);
		System.out.println("2��д������֮��� position��limit��capacity��");
		System.out.println("position:" + buffer.position());
		System.out.println("limit:" + buffer.limit());
		System.out.println("capacity:" + buffer.capacity());
		buffer.flip();
		System.out.println("3��׼���������ʱ�� position��limit��capacity��");
		System.out.println("position:" + buffer.position());
		System.out.println("limit:" + buffer.limit());
		System.out.println("capacity:" + buffer.capacity());
		System.out.println("������������");
		while (buffer.hasRemaining()) {
			int x = buffer.get();
			System.out.print(x + "��");
		}
	}
}
