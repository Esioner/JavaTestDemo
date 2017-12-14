package CollectionDemo;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class MapDemo {

	public static void main(String[] args) {
		Map<Integer, String> maps = new HashMap<Integer, String>();
		// 添加元素
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
			System.out.println("搜索的 key 存在");
		} else {
			System.out.println("搜索的 key 不存在");
		}
		if (maps.containsValue("one")) {
			System.out.println("搜索的 value 存在");
		} else {
			System.out.println("搜索的 value 不存在");
		}
		// 输出所有的 key
		System.out.println(maps.toString());
		Set<Integer> keySets = maps.keySet();
		Iterator<Integer> keyIterator = keySets.iterator();
		while (keyIterator.hasNext()) {
			Integer integer = keyIterator.next();
			System.out.print(integer + "\t");
		}
		System.out.println();
		// 输出所有的 value
		Collection<String> valuesCollection = maps.values();
		Iterator<String> valuesIterator = valuesCollection.iterator();
		while (valuesIterator.hasNext()) {
			String str = valuesIterator.next();
			System.out.print(str + "\t");
		}
		// map使用 Iterator 进行输出
		Set<Map.Entry<Integer, String>> mapSets = maps.entrySet();
		Iterator<Map.Entry<Integer, String>> iterator = mapSets.iterator();
		while (iterator.hasNext()) {
			Map.Entry<Integer, String> entry = iterator.next();
			System.out.println(entry.getKey()+"->"+entry.getValue());
		}
		//map 使用 foreach 进行输出
		for(Map.Entry<Integer, String> entry:maps.entrySet()) {
			System.out.println(entry.getKey()+"->"+entry.getValue());
		}
	}

}
