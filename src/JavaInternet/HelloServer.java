package JavaInternet;

import java.io.IOException;
import java.io.PrintStream;
import java.net.ServerSocket;
import java.net.Socket;

public class HelloServer {
	public static void main(String[] args) throws IOException {
		ServerSocket server = new ServerSocket(8888);
		System.out.println("服务器运行，等待客户端链接");
		Socket socket = server.accept();
		String str = "hello world";
		PrintStream out = new PrintStream(socket.getOutputStream());
		out.println(str);
		out.close();
		socket.close();
		server.close();
	}
}
