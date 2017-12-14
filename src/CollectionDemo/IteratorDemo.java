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
		//����˫�����
		//��ǰ������
		ListIterator<String> listIterator = all.listIterator();
		while(listIterator.hasNext()) {
			String str = listIterator.next();
			System.out.print(str);
			//�޸�Ԫ��
			listIterator.set(str+"_");
		}
		//���Ԫ��,��ӵ���һ��
		listIterator.add("z");
		System.out.println();
		//�ɺ���ǰ���
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
				// ɾ��Ԫ��
				iterator.remove();
				// ����������ɾ�����ᱨ�� all.remove(str);
			} else {
				System.out.print(str);
			}
		}
	}

}
