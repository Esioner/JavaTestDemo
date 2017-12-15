package EnumPackage;

import java.util.EnumMap;
import java.util.Map;

public class EnumMapDemo {
	public static void main(String args[]) {
		Map<Color, String> coMap = new EnumMap<>(Color.class);
		coMap.put(Color.RED, "红色");
		coMap.put(Color.BLUE, "蓝色");
		coMap.put(Color.GREEN, "绿色");
		System.out.println("=====================输出全部内容=====================");
		for (Color c : Color.values()) {
			System.out.println(c.name() + "-->" + coMap.get(c));
		}
		System.out.println("=====================输出全部键值=====================");
		for (Color c : coMap.keySet()) {
			System.out.println(c.name() + "-->");
		}
		System.out.println("=====================输出全部内容=====================");
		for (String c : coMap.values()) {
			System.out.println(c + "-->");
		}
	}

	enum Color {
		RED, BLUE, GREEN;
	}
}
