package JavaIODemoNew;

import java.nio.IntBuffer;

public class Buffer_1 {

	public static void main(String[] args) {
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
		while(buffer.hasRemaining()) {
			int x = buffer.get();
			System.out.print(x+"��");
		}
	}

}
