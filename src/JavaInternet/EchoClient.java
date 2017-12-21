package JavaInternet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.net.UnknownHostException;

public class EchoClient {
	public static void main(String[] args) throws Exception {
		Socket client = new Socket("localhost", 8080);
		boolean flag = true;
		while (flag) {
			//从键盘接收数据
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintStream out = new PrintStream(client.getOutputStream());
			System.out.println("输入信息");
			String str = input.readLine();
			out.println(str);
			if ("bye".equals(str)) {
				flag = false;
			} else {
				String echo = buf.readLine();
				System.out.println(echo);
			}
		}
		client.close();
		
	}

}
