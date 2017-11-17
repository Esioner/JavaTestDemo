package HttpClientPractice;

import java.io.IOException;


import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpException;
import org.apache.commons.httpclient.HttpMethod;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.GetMethod;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.logging.impl.Log4JLogger;
import org.dom4j.Document;
import org.dom4j.DocumentHelper;
import org.dom4j.Element;

public class httpDemo {
	private static HttpClient mClient = new HttpClient();

	public static void main(String[] args) {
		System.out.println("dayin");
		System.out.println(getContent());
	}

	public static String getContent() {
		String str = null;
		GetMethod getMethod = new GetMethod("https://baike.baidu.com/");
		mClient.setConnectionTimeout(5000);
		mClient.setTimeout(8000);
		mClient.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET, "UTF-8");
		try {
			int statusCode = mClient.executeMethod(getMethod);
			if (statusCode == HttpStatus.SC_OK) {
				str = getMethod.getResponseBodyAsString();
			}
		} catch (HttpException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return str;
	}
	public static void parseData() {
		Document document = DocumentHelper.createDocument();
		Element root=document.getRootElement();
		
	}
}

