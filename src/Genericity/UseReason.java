package Genericity;

/**
 * 设计一个可以表示坐标点的类，坐标由 X Y 组成 坐标可以由小数，整数，字符串组成
 * 
 * @author Administrator
 *
 */
public class UseReason {

	public static void main(String[] args) {
		Point intP = new Point(300, 200);
		System.out.println(intP);
		Point floatP = new Point(2.66, 3.88);
		System.out.println(floatP);
		Point stringP = new Point("东经180度","北纬180度");
		System.out.println(stringP);
		Point mixP = new Point(10, "北纬180度");
		System.out.println(mixP);
	}

}

class Point<T> {
	private T x;
	private T y;

	public Point(T x, T y) {
		this.x = x;
		this.y = y;
	}

	@Override
	public String toString() {
		return "x= " + this.x + "\ny= " + this.y;
	}
}
