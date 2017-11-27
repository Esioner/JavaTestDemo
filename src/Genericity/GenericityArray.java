package Genericity;

public class GenericityArray {
	public static void main(String[] args) {
		Integer i[] = fun(1, 2, 3, 4, 5);
		fun2(i);
	}
	public static <T> T[] fun(T ...arg) {
		return arg;
	}
	public static <T> void fun2(T parm[]) {
		System.out.println("接受泛型数组");
		for (T t : parm) {
			System.out.print(t + "\t");
		}
	}
}
