package JavaInternet;

import java.io.UnsupportedEncodingException;
import java.net.URLDecoder;
import java.net.URLEncoder;

public class URLEncoderDecoderDemo {

	public static void main(String[] args) throws UnsupportedEncodingException {
		String keyWord = "yang��";
		String encod = URLEncoder.encode(keyWord,"UTF-8");
		System.out.println("����֮������ݣ�"+encod);
		String decod = URLDecoder.decode(encod,"UTF-8");
		System.out.println("����֮������ݣ�"+decod);
	}

}
