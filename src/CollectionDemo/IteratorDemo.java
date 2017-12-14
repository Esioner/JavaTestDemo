package CollectionDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.ListIterator;

public class IteratorDemo {

	public static void main(String[] args) {
		List<String> all = new ArrayList<String>();
		all.add("a");
		all.add("b");
		all.add("c");
		all.add("d");
		all.add("e");
		all.add("f");
		all.add("g");
		all.add("h");
		all.add("i");

//		iterator(all);
		listIterator(all);
	}

	private static void listIterator(List<String> all) {
		//进行双向迭代
		//由前向后输出
		ListIterator<String> listIterator = all.listIterator();
		while(listIterator.hasNext()) {
			String str = listIterator.next();
			System.out.print(str);
			//修改元素
			listIterator.set(str+"_");
		}
		//添加元素,添加到第一个
		listIterator.add("z");
		System.out.println();
		//由后向前输出
		while(listIterator.hasPrevious()) {
			String str = listIterator.previous();
			System.out.print(str+"\t");
		}
	}

	private static void iterator(List<String> all) {
		Iterator<String> iterator = all.iterator();
		while (iterator.hasNext()) {
			String str = iterator.next();
			if ("b".equals(str)) {
				// 删除元素
				iterator.remove();
				// 不可以这样删除，会报错 all.remove(str);
			} else {
				System.out.print(str);
			}
		}
	}

}
