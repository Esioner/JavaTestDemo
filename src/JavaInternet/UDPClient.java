package JavaInternet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;

public class UDPClient {
	//UDP �ͻ���
	public static void main(String[] args) throws IOException {
		DatagramSocket ds = null;
		byte[] bs = new byte[1024];
		DatagramPacket dPacket = null;
		ds = new DatagramSocket(9000);
		dPacket = new DatagramPacket(bs, 1024);
		System.out.println("�ȴ���������");
		ds.receive(dPacket);
		String str = new String(dPacket.getData(), 0, dPacket.getLength())+"from"+dPacket.getAddress().getHostAddress()+":"+dPacket.getPort();
		System.out.println(str);
		ds.close();
	}

}
