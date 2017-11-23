package DailyDemo;

public class ExceptionDemo {
	public static void main(String[] args) {
		Math m = new Math();
		try {
			System.out.println(m.div(10, 5));
			throw new MyException("�Զ����쳣");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
class Math {
	public int div(int i, int j) throws Exception {
		System.out.println("====���㿪ʼ====");
		int temp = 0;
		try {
			temp = i / j;
		} catch (Exception e) {
			throw e;
		} finally {
			System.out.println("====�������====");
		}
		return temp;
	}
}
class MyException extends Exception {
	public MyException(String msg) {
		super(msg);
	}
}
