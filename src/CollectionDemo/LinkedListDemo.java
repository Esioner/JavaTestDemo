package CollectionDemo;

import java.util.LinkedList;

public class LinkedListDemo {

	public static void main(String[] args) {
		LinkedList<String> link = new LinkedList<>();
		link.add("a");
		link.add("b");
		link.add("c");
		System.out.println("��ʼ������" + link);
		// ����ͷ��β
		link.addFirst("d");
		link.addLast("e");
		System.out.println("����ͷ��β����" + link);
		// �ҵ�����ͷ
		String str0 = link.element();
		System.out.println(str0);
		// �ҵ���ɾ������ͷ
		String str1 = link.peek();
		System.out.println(str1);
		System.out.println("�ҵ���ɾ������ͷ��" + link);
		// �ҵ���ɾ����ͷ
		String str2 = link.poll();
		System.out.println(str2);
		System.out.println("�ҵ�ɾ������ͷ��" + link);
		// ѭ��ȡ������
		String str3;
		for (int i = 0; i < (link.size()+1); i++) {
			str3 = link.poll();
			System.out.print(str3+"��");
		}
		System.out.println(link);

	}

}
