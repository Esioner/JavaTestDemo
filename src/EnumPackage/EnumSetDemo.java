package EnumPackage;

import java.util.EnumSet;

import EnumPackage.EnumMapDemo.Color;

public class EnumSetDemo {

	public static void main(String[] args) {
		EnumSet<Color> set = EnumSet.allOf(Color.class);
		print(set);
		// ֻ����һ��ö�ٵ����͵�������
		EnumSet<Color> eSet = EnumSet.of(Color.BLUE);
		System.out.println(eSet);
		// ����ֻ�ܷ���ָ��ö�����͵ļ���
		EnumSet<Color> es = EnumSet.noneOf(Color.class);
		es.add(Color.RED);
		es.add(Color.GREEN);
		print(es);
		// ����������ָ��Ԫ�صļ���
		EnumSet<Color> esOld = EnumSet.noneOf(Color.class);
		esOld.add(Color.RED);
		esOld.add(Color.GREEN);
		EnumSet<Color> esNew = EnumSet.complementOf(esOld);
		System.out.println("\noldSet");
		print(esOld);
		System.out.println("\nnewSet");
		print(esNew);
		//������������
		EnumSet<Color> copySet = EnumSet.copyOf(esNew);
		System.out.println("\n����");
		print(copySet);
	}

	public static void print(EnumSet<Color> set) {
		for (Color c : set) {
			System.out.print(c + "��");
		}
	}

	enum Color {
		RED, BLUE, GREEN, YELLOW;
	}
}
