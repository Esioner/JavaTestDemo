package JavaInternet;

import java.io.IOException;
import java.net.DatagramPacket;
import java.net.DatagramSocket;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class UDPServer {

	public static void main(String[] args) throws IOException {
		DatagramSocket dSocket = null;
		DatagramPacket dPacket = null;
		dSocket = new DatagramSocket(3000);
		String str = "Hello world";
//		ʵ���� DatagramPacket����,����ָ������,���ݳ���,Ҫ���͵�Ŀ���ַ,���Ͷ˿�
		dPacket = new DatagramPacket(str.getBytes(), str.length(),InetAddress.getByName("localhost"),9000);
		System.out.println("������Ϣ");
		dSocket.send(dPacket);
		dSocket.close();
	}

}
