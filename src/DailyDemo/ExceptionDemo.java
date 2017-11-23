package DailyDemo;

public class ExceptionDemo {
	public static void main(String[] args) {
		Math m = new Math();
		try {
			System.out.println(m.div(10, 5));
			throw new MyException("自定义异常");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
class Math {
	public int div(int i, int j) throws Exception {
		System.out.println("====计算开始====");
		int temp = 0;
		try {
			temp = i / j;
		} catch (Exception e) {
			throw e;
		} finally {
			System.out.println("====计算结束====");
		}
		return temp;
	}
}
class MyException extends Exception {
	public MyException(String msg) {
		super(msg);
	}
}
