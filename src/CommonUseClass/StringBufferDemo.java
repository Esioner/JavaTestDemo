package CommonUseClass;

public class StringBufferDemo {

	public static void main(String[] args) {
		//1.1���ַ�������
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 5; i++) {	
			sb.append("���ǵ�"+i+"��\n");
		}
		appends(sb);
		System.out.println(sb);
		//1.2��ָ��λ���������
	}
	public static void appends(StringBuffer sb) {
		sb.append("\n����");
	}
	
	
}
