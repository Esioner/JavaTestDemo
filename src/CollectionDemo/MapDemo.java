package CollectionDemo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {
		Map<Integer, String> maps = new HashMap<Integer, String>();
		// ���Ԫ��
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
		if (maps.containsKey(3)) {
			System.out.println("������ key ����");
		} else {
			System.out.println("������ key ������");
		}
		if (maps.containsValue("one")) {
			System.out.println("������ value ����");
		} else {
			System.out.println("������ value ������");
		}
		// ������е� key
		System.out.println(maps.toString());
		Set<Integer> keySets = maps.keySet();
		Iterator<Integer> keyIterator = keySets.iterator();
		while (keyIterator.hasNext()) {
			Integer integer = keyIterator.next();
			System.out.print(integer + "\t");
		}
		System.out.println();
		// ������е� value
		Collection<String> valuesCollection = maps.values();
		Iterator<String> valuesIterator = valuesCollection.iterator();
		while (valuesIterator.hasNext()) {
			String str = valuesIterator.next();
			System.out.print(str + "\t");
		}
		// mapʹ�� Iterator �������
		Set<Map.Entry<Integer, String>> mapSets = maps.entrySet();
		Iterator<Map.Entry<Integer, String>> iterator = mapSets.iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, String> entry = iterator.next();
			System.out.println(entry.getKey()+"->"+entry.getValue());
		}
		//map ʹ�� foreach �������
		for(Map.Entry<Integer, String> entry:maps.entrySet()) {
			System.out.println(entry.getKey()+"->"+entry.getValue());
		}
	}

}
