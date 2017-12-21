package JavaInternet;

import java.io.IOException;
import java.io.InputStream;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.util.Scanner;

public class URLDemo {

	public static void main(String[] args) throws IOException {
		// 使用 URL
		// useUrl();
		// 使用 URLConnection
		useUrlConnection();
	}

	private static void useUrlConnection() throws IOException {
		URL url = new URL("http://www.baidu.com");
		URLConnection urlConnection = url.openConnection();
		System.out.println("数据长度：" + urlConnection.getContentLength());
		System.out.println("内容类型：" + urlConnection.getContentType());
	}

	private static void useUrl() throws IOException {
		URL url = new URL("http://www.baidu.com");
		InputStream inputStream = url.openStream();
		Scanner scanner = new Scanner(inputStream);
		scanner.useDelimiter("\n");
		while (scanner.hasNext()) {
			System.out.println(scanner.next());
		}
	}

}
