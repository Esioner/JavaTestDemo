package CollectionDemo;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;

public class ListDemo {

	public static void main(String[] args) {
		List<Integer> allList = new ArrayList<>();
		Collection<Integer> allCollection = new ArrayList<Integer>();
		allList.add(666);
		allCollection.add(233);
		allList.add(123);
		allCollection.add(321);
		System.out.println("allList:"+allList);
		System.out.println("allCollection:"+allCollection);
		allList.addAll(allCollection);
		System.out.println("allList:"+allList);
		allList.remove(2);
		System.out.println("allList:"+allList);
		//将List转为数组
		allList.toArray();
		System.out.println(allList);
		System.out.println(allList.contains(123));
		List<Integer> list = allList.subList(0, 1);
		System.out.println(list);
	}

}
