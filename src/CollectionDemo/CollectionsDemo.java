package CollectionDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsDemo {

	public static void main(String[] args) {
		// 返回不可操作的集合(添加数据的时候会报错：java.lang.UnsupportedOperationException)
		List<String> emptyList = Collections.emptyList();
		Map<Integer, String> map = Collections.EMPTY_MAP;
		Set<String> emptySet1 = Collections.emptySet();
		Set<String> emptySet2 = Collections.EMPTY_SET;
		// map.put(1, "1");
		// emptyList.add("1");
		// 为集合添加内容
		List<Integer> inList = new ArrayList<>();
		Collections.addAll(inList, 1,2,3,4,5,6);
		System.out.println("为集合添加内容"+inList);
		//检索内容
		int key = Collections.binarySearch(inList,1);
		System.out.println("检索内容："+key);
		//替换内容
		Collections.replaceAll(inList, 3, 33);
		System.out.println("替换内容："+inList);
		//翻转集合中的内容
		Collections.reverse(inList);
		System.out.println("反转集合内容："+inList);
		//集合排序
		Collections.sort(inList);
		System.out.println("集合排序："+inList);
		//交换指定位置的内容
		Collections.swap(inList, 2, 4);
		System.out.println("交换指定位置的内容："+inList);
	}
}
