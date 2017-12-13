package CollectionDemo;

import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		LinkedList<String> link = new LinkedList<>();
		link.add("a");
		link.add("b");
		link.add("c");
		System.out.println("初始化链表：" + link);
		// 增加头和尾
		link.addFirst("d");
		link.addLast("e");
		System.out.println("增加头和尾链表：" + link);
		// 找到链表头
		String str0 = link.element();
		System.out.println(str0);
		// 找到不删除链表头
		String str1 = link.peek();
		System.out.println(str1);
		System.out.println("找到不删除链表头：" + link);
		// 找到并删除表头
		String str2 = link.poll();
		System.out.println(str2);
		System.out.println("找到删除链表头：" + link);
		// 循环取出数据
		String str3;
		for (int i = 0; i < (link.size()+1); i++) {
			str3 = link.poll();
			System.out.print(str3+"、");
		}
		System.out.println(link);

	}

}
