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
			//�Ӽ��̽�������
			BufferedReader input = new BufferedReader(new InputStreamReader(System.in));
			BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintStream out = new PrintStream(client.getOutputStream());
			System.out.println("������Ϣ");
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
