package EnumPackage;

import java.util.EnumSet;

import EnumPackage.EnumMapDemo.Color;

public class EnumSetDemo {

	public static void main(String[] args) {
		EnumSet<Color> set = EnumSet.allOf(Color.class);
		print(set);
		// 只设置一个枚举的类型到集合中
		EnumSet<Color> eSet = EnumSet.of(Color.BLUE);
		System.out.println(eSet);
		// 创建只能放入指定枚举类型的集合
		EnumSet<Color> es = EnumSet.noneOf(Color.class);
		es.add(Color.RED);
		es.add(Color.GREEN);
		print(es);
		// 创建不包含指定元素的集合
		EnumSet<Color> esOld = EnumSet.noneOf(Color.class);
		esOld.add(Color.RED);
		esOld.add(Color.GREEN);
		EnumSet<Color> esNew = EnumSet.complementOf(esOld);
		System.out.println("\noldSet");
		print(esOld);
		System.out.println("\nnewSet");
		print(esNew);
		//复制已有内容
		EnumSet<Color> copySet = EnumSet.copyOf(esNew);
		System.out.println("\n复制");
		print(copySet);
	}

	public static void print(EnumSet<Color> set) {
		for (Color c : set) {
			System.out.print(c + "、");
		}
	}

	enum Color {
		RED, BLUE, GREEN, YELLOW;
	}
}
