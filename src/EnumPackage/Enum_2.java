package EnumPackage;

import java.util.Iterator;
import java.util.Set;
import java.util.TreeSet;

public class Enum_2 {

	public static void main(String[] args) {
		for (Color c : Color.values()) {
			System.out.println("name:" + c.name() + " && ordinal:" + c.ordinal() + "[" + c.getName() + "]");
		}
		// 验证比较器
		Set<Color> colorSet = new TreeSet<>();
		colorSet.add(Color.BLUE);
		colorSet.add(Color.RED);
		colorSet.add(Color.GREEN);
		colorSet.add(Color.YELLOW);
		Iterator<Color> iterator = colorSet.iterator();
		while (iterator.hasNext()) {
			System.out.print(iterator.next() + " 、 ");
		}
	}

	enum Color {
		// 为每一个枚举对象赋值
		RED("红色"), BLUE("蓝色"), YELLOW("黄色"), GREEN("绿色");
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
