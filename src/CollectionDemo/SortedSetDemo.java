package CollectionDemo;

import java.util.Comparator;
import java.util.SortedSet;
import java.util.TreeSet;

import org.apache.commons.httpclient.methods.multipart.StringPart;

public class SortedSetDemo {
	public static void main(String[] args) {
		SortedSet<String> allSet = new TreeSet<String>();
		allSet.add("a");
		allSet.add("b");
		allSet.add("c");
		allSet.add("d");
		allSet.add("e");
		allSet.add("f");
		System.out.println("初始化的集合" + allSet);
		Comparator comparator = allSet.comparator();
		System.out.println("集合中的第一个元素：" + allSet.first());
		System.out.println("返回从开始到指定元素的集合：" + allSet.headSet("d"));
		System.out.println("返回最后一个元素：" + allSet.last());
		System.out.println("返回指定对象间的元素：" + allSet.subSet("b", "d"));
		System.out.println("返回指定元素到最后的集合：" + allSet.tailSet("d"));
	}
}
