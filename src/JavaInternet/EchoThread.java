package JavaInternet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;

public class EchoThread implements Runnable {
	// ���տͻ���
	private Socket client = null;

	public EchoThread(Socket client) {
		this.client = client;
	}
	@Override
	public void run() {
		// ���������
		PrintStream out;
		// ���ڽ��տͻ��˷���������Ϣ
		BufferedReader buf;
		try {
			buf = new BufferedReader(new InputStreamReader(client.getInputStream()));
			// ʵ�����ͻ��������
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
						// ��ͻ��˻�����Ϣ
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
