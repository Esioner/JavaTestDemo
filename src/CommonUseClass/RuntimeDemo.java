package CommonUseClass;

public class RuntimeDemo {

	public static void main(String[] args) {
		Runtime run = Runtime.getRuntime();
		System.out.println("�������ڴ�Ϊ��" + run.maxMemory());
		System.out.println("�����ڴ�ʣ�ࣺ" + run.freeMemory());
		String string = "zhangsan";
		for (int i = 0; i < 1000; i++) {
			string += " " + i;
		}
		System.out.println("��ʱ�����ڴ�ʣ�ࣺ" + run.freeMemory());
		run.gc();
		System.out.println("GC���ʱ�����ڴ�ʣ�ࣺ" + run.freeMemory());
		run.exit(1);
	}
}
