package JavaInternet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class EchoServer {

	public static void main(String[] args) throws IOException {
		openServerWithThread();

	}

	private static void openServerWithThread() throws IOException {
		ServerSocket serverSocket = new ServerSocket(8080);
		boolean f = true;
		while (f) {
			System.out.println("���������У��ȴ��ͻ�������");
			Socket client = serverSocket.accept();
			new Thread(new EchoThread(client)).start();
		}
		serverSocket.close();
	}

	public static void openServer() throws IOException {
		while (true) {
			System.out.println("����������");
			ServerSocket serverSocket = new ServerSocket(8081);
			Socket client = serverSocket.accept();
			BufferedReader buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
			PrintStream out = new PrintStream(client.getOutputStream());
			boolean flag = true;
			while (flag) {
				String str = buf.readLine();
				if (str == null || "".equals(str)) {
					flag = false;
				} else {
					if ("bye".equals(str)) {
						flag = false;
					} else {
						// ��ͻ��˻�����Ϣ
						out.println("ECHO:" + str);
					}
				}
				out.close();
				client.close();
			}
			serverSocket.close();
		}
	}
}
