package EnumPackage;

import java.util.EnumMap;
import java.util.Map;

public class EnumMapDemo {
	public static void main(String args[]) {
		Map<Color, String> coMap = new EnumMap<>(Color.class);
		coMap.put(Color.RED, "��ɫ");
		coMap.put(Color.BLUE, "��ɫ");
		coMap.put(Color.GREEN, "��ɫ");
		System.out.println("=====================���ȫ������=====================");
		for (Color c : Color.values()) {
			System.out.println(c.name() + "-->" + coMap.get(c));
		}
		System.out.println("=====================���ȫ����ֵ=====================");
		for (Color c : coMap.keySet()) {
			System.out.println(c.name() + "-->");
		}
		System.out.println("=====================���ȫ������=====================");
		for (String c : coMap.values()) {
			System.out.println(c + "-->");
		}
	}

	enum Color {
		RED, BLUE, GREEN;
	}
}
