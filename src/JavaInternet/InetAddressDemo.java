package JavaInternet;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {

	public static void main(String[] args) throws IOException {
		InetAddress locaAdd = InetAddress.getLocalHost();
		InetAddress remAdd = InetAddress.getByName("www.baidu.com");
		System.out.println("����IP��ַ��"+locaAdd.getHostAddress());
		System.out.println("�ٶ� Ip ��ַ��"+remAdd.getHostAddress());
		System.out.println("�����Ƿ�ɴ"+locaAdd.isReachable(5000));
	}

}
