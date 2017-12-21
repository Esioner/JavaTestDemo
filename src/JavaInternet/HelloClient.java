package JavaInternet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;
import java.net.UnknownHostException;

public class HelloClient {
	public static void main(String[] args) throws UnknownHostException, IOException {
		Socket socket = new Socket("localhost", 8888);
		BufferedReader buf = new BufferedReader(new InputStreamReader(socket.getInputStream()));
		String str = buf.readLine();
		System.out.println("服务器端输出内容：" + str);
		socket.close();
		buf.close();
	}
}