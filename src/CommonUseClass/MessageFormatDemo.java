package CommonUseClass;

import java.text.MessageFormat;

public class MessageFormatDemo {
	public static void main(String[] agrs) {
		String str = "ÄãºÃ{0}{1}";
		String strFormat = MessageFormat.format(str, "Esi", "\nJava");
		System.out.println(strFormat);
	}
}
