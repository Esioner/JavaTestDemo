package CommonUseClass;

public class RuntimeDemo {

	public static void main(String[] args) {
		Runtime run = Runtime.getRuntime();
		System.out.println("可用总内存为：" + run.maxMemory());
		System.out.println("可用内存剩余：" + run.freeMemory());
		String string = "zhangsan";
		for (int i = 0; i < 1000; i++) {
			string += " " + i;
		}
		System.out.println("此时可用内存剩余：" + run.freeMemory());
		run.gc();
		System.out.println("GC后此时可用内存剩余：" + run.freeMemory());
		run.exit(1);
	}
}
