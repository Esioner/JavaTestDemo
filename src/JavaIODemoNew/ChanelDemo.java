package JavaIODemoNew;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.nio.ByteBuffer;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;

public class ChanelDemo {

	public static void main(String[] args) throws IOException {
		// 使用 channel 写入文件
		// useChannelWriteText();
		// 使用channel读入文件
		// useChannelReadFile();
		// 内存映射读取文件
		mapRead();
	}

	private static void mapRead() throws IOException {
		File file = new File("D:" + File.separator + "a.txt");
		FileInputStream fis = new FileInputStream(file);
		FileChannel fChannel = fis.getChannel();
		MappedByteBuffer mappedByteBuffer = fChannel.map(FileChannel.MapMode.READ_ONLY, 0, file.length());
		byte[] data = new byte[(int) file.length()];
		int foot = 0;
		while (mappedByteBuffer.hasRemaining()) {
			data[foot++] = mappedByteBuffer.get();
		}
		System.out.println(new String(data));
		fChannel.close();
		fis.close();

	}

	private static void useChannelReadFile() throws IOException {
		File fileFrom = new File("D:" + File.separator + "a.txt");
		File fileTo = new File("D:" + File.separator + "b.txt");
		FileInputStream fisFrom = new FileInputStream(fileFrom);
		FileOutputStream fosTo = new FileOutputStream(fileTo);
		FileChannel fChannel = fisFrom.getChannel();
		FileChannel fChannel2 = fosTo.getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		int temp = 0;
		while ((temp = fChannel.read(byteBuffer)) != -1) {
			byteBuffer.flip();
			fChannel2.write(byteBuffer);
			byteBuffer.clear();
		}
		fChannel.close();
		fChannel2.close();
		fisFrom.close();
		fosTo.close();

	}

	private static void useChannelWriteText() throws IOException {
		String[] info = { "zhangsan ", "lisi ", "王五" };
		File file = new File("D:" + File.separator + "a.txt");
		FileOutputStream fos = new FileOutputStream(file);
		FileChannel fChannel = fos.getChannel();
		ByteBuffer byteBuffer = ByteBuffer.allocate(1024);
		for (int i = 0; i < info.length; i++) {
			byteBuffer.put(info[i].getBytes());
		}
		byteBuffer.flip();
		fChannel.write(byteBuffer);
		byteBuffer.flip();
		fChannel.close();
		fos.close();

	}

}
