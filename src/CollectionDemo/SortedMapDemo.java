package CollectionDemo;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.TreeMap;

public class SortedMapDemo {

	public static void main(String[] args) {
		SortedMap<Integer, String> maps = new TreeMap<>();
		maps.put(0, "zero");
		maps.put(1, "one");
		maps.put(2, "two");
		maps.put(3, "three");
		maps.put(4, "four");
		maps.put(5, "five");
		maps.put(6, "six");
		maps.put(7, "seven");
		maps.put(8, "eight");
		maps.put(9, "nine");
		System.out.println("��һ��Ԫ�ص�key��" + maps.firstKey());
		System.out.println("���һ��Ԫ�ص�key��" + maps.lastKey());
		System.out.println("С��4�ļ��ϣ�" + maps.headMap(4));
		System.out.println("����3С��8�ļ���(������8)��" + maps.subMap(3, 8));
		System.out.println("����7�ļ��ϣ�"+maps.tailMap(7));
	}

}
