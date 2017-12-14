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
		System.out.println("��ʼ���ļ���" + allSet);
		Comparator comparator = allSet.comparator();
		System.out.println("�����еĵ�һ��Ԫ�أ�" + allSet.first());
		System.out.println("���شӿ�ʼ��ָ��Ԫ�صļ��ϣ�" + allSet.headSet("d"));
		System.out.println("�������һ��Ԫ�أ�" + allSet.last());
		System.out.println("����ָ��������Ԫ�أ�" + allSet.subSet("b", "d"));
		System.out.println("����ָ��Ԫ�ص����ļ��ϣ�" + allSet.tailSet("d"));
	}
}
