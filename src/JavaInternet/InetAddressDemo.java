package JavaInternet;

import java.io.IOException;
import java.net.InetAddress;
import java.net.UnknownHostException;

public class InetAddressDemo {

	public static void main(String[] args) throws IOException {
		InetAddress locaAdd = InetAddress.getLocalHost();
		InetAddress remAdd = InetAddress.getByName("www.baidu.com");
		System.out.println("本机IP地址："+locaAdd.getHostAddress());
		System.out.println("百度 Ip 地址："+remAdd.getHostAddress());
		System.out.println("本机是否可达："+locaAdd.isReachable(5000));
	}

}
