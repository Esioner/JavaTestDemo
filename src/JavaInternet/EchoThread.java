package JavaInternet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class EchoThread implements Runnable {
	// 接收客户端
	private Socket client = null;

	public EchoThread(Socket client) {
		this.client = client;
	}
	@Override
	public void run() {
		// 定义输出流
		PrintStream out;
		// 用于接收客户端发送来的信息
		BufferedReader buf;
		try {
			buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
			// 实例化客户端输出流
			out = new PrintStream(client.getOutputStream());
			boolean flag = true;
			while (flag) {
				String str = buf.readLine();
				if (str == null || "".equals(str)) {
					flag = false;
				} else {
					if ("bye".equals(str)) {
						flag = false;
					} else {
						// 向客户端回显信息
						out.println("ECHO:" + str);
					}
				}
			}
			out.close();
			client.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
