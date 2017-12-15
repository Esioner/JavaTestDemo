package EnumPackage;

import java.awt.print.Printable;

public class Enum_1 {

	public static void main(String[] args) {
		Color color = new Color();
		String name = color.getColor(Color.COLOR_BLUE);
		System.out.println(name);
		Colors colors = Colors.BLUE;
		// System.out.println(colors.values());
		// ��ӡö���е���������
		for (Colors c : Colors.values()) {
			System.out.println(c);
		}
		print(colors);
		Colors blue = Colors.BLUE;
		Colors green = Colors.GREEN;
		int i = blue.compareTo(green);
		System.out.println(i);
	}

	private static void print(Colors c) {
		switch (c) {
		// ����ʹ�� Colors.BLUE �@����ʽ���ᱨ��
		case BLUE:
			System.out.println("BLUE");
			break;
		default:
			break;
		}
	}
	
	public enum Colors {
		RED, GREEN, BLUE;
	}

	static class Color {
		public static final String COLOR_RED = "#F00";
		public static final String COLOR_GREEN = "#0F0";
		public static final String COLOR_BLUE = "#00F";

		private String name;

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public String getColor(String str) {
			switch (str) {
			case COLOR_RED:
				return "red";
			case COLOR_GREEN:
				return "green";
			case COLOR_BLUE:
				return "blue";
			default:
				return null;
			}
		}
	}
}
