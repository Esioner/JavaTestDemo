package CommonUseClass;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class RegexDemo {

	public static void main(String[] args) {
		// ��λ����-��λ����-��λ����
		// ��Ҫת��"//"ʵ���ϱ�ʾ"/"
		String regex = "\\d{4}-\\d{2}-\\d{2}";
		String str = "1994-08-17";
		Pattern pattern = Pattern.compile(regex);
		Matcher matcher = pattern.matcher(str);
		if (matcher.matches()) {
			System.out.println("��ʽ�Ϸ�");
		} else {
			System.out.println("��ʽ���Ϸ�");
		}
		String string = "A1ASDS5454FASD5AS5SA4D5ASD3AFGF5E45RQ";
		String regex1 = "\\d+";
		Pattern pattern1 = Pattern.compile(regex1);
		String[] s = pattern1.split(string);
		for (String strs : s) {
			System.out.println(strs);
		}

		//�������滻Ϊ"_"
		String string2 = "A15ASDAS5574FA15WAWE41DASFSAF54A4FS";
		String regex3 = "\\d+";
		Pattern pattern2 = Pattern.compile(regex3);
		Matcher matcher2 = pattern2.matcher(string2);
		String newString = matcher2.replaceAll("_");
		System.out.println(newString);
		
	}

}
