package EnumPackage;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Enum_2 {

	public static void main(String[] args) {
		for (Color c : Color.values()) {
			System.out.println("name:" + c.name() + " && ordinal:" + c.ordinal() + "[" + c.getName() + "]");
		}
		// ��֤�Ƚ���
		Set<Color> colorSet = new TreeSet<>();
		colorSet.add(Color.BLUE);
		colorSet.add(Color.RED);
		colorSet.add(Color.GREEN);
		colorSet.add(Color.YELLOW);
		Iterator<Color> iterator = colorSet.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " �� ");
		}
	}

	enum Color {
		// Ϊÿһ��ö�ٶ���ֵ
		RED("��ɫ"), BLUE("��ɫ"), YELLOW("��ɫ"), GREEN("��ɫ");
		private String name;

		private Color(String name) {
			this.setName(name);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}
	}

}
