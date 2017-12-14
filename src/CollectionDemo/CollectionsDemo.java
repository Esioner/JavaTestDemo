package CollectionDemo;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class CollectionsDemo {

	public static void main(String[] args) {
		// ���ز��ɲ����ļ���(������ݵ�ʱ��ᱨ��java.lang.UnsupportedOperationException)
		List<String> emptyList = Collections.emptyList();
		Map<Integer, String> map = Collections.EMPTY_MAP;
		Set<String> emptySet1 = Collections.emptySet();
		Set<String> emptySet2 = Collections.EMPTY_SET;
		// map.put(1, "1");
		// emptyList.add("1");
		// Ϊ�����������
		List<Integer> inList = new ArrayList<>();
		Collections.addAll(inList, 1,2,3,4,5,6);
		System.out.println("Ϊ�����������"+inList);
		//��������
		int key = Collections.binarySearch(inList,1);
		System.out.println("�������ݣ�"+key);
		//�滻����
		Collections.replaceAll(inList, 3, 33);
		System.out.println("�滻���ݣ�"+inList);
		//��ת�����е�����
		Collections.reverse(inList);
		System.out.println("��ת�������ݣ�"+inList);
		//��������
		Collections.sort(inList);
		System.out.println("��������"+inList);
		//����ָ��λ�õ�����
		Collections.swap(inList, 2, 4);
		System.out.println("����ָ��λ�õ����ݣ�"+inList);
	}
}
