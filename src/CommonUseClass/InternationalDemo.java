package CommonUseClass;

import java.util.ListResourceBundle;
import java.util.Locale;
import java.util.ResourceBundle;

import javax.xml.crypto.Data;

public class InternationalDemo {

	public static void main(String[] args) {
		// properties 文件要放在 src 根目录下
		Locale zhLocale = new Locale("zh", "CN");
		ResourceBundle zhBundle = ResourceBundle.getBundle("Message", zhLocale);
		System.out.println(zhBundle.getString("info"));
		Locale usLocale = new Locale("en", "US");
		ResourceBundle enBundle = ResourceBundle.getBundle("Message", usLocale);
		System.out.println(enBundle.getString("info"));
		Locale frLocale = new Locale("fr", "FR");
		ResourceBundle frBundle = ResourceBundle.getBundle("Message", frLocale);
		System.out.println(frBundle.getString("info"));
		
	}

}

class Message_zh_CN extends ListResourceBundle {
	private final Object[][] data = { { "info", "你好, {0}" } };
	@Override
	protected Object[][] getContents() {
		return data;
	}

}
