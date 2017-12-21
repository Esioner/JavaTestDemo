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
//		实例化 DatagramPacket对象,根据指定内容,数据长度,要发送的目标地址,发送端口
		dPacket = new DatagramPacket(str.getBytes(), str.length(),InetAddress.getByName("localhost"),9000);
		System.out.println("发送消息");
		dSocket.send(dPacket);
		dSocket.close();
	}

}
