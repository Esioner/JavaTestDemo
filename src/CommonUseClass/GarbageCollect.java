package CommonUseClass;

public class GarbageCollect {

	public static void main(String[] args) {
		Garbage garbage = new Garbage();
		System.out.println("chuangjian");
		garbage = null;
		System.gc();
	}
}
class Garbage {
	//��������ķ�������ִ�� gc ֮ǰ����ִ���������
	@Override
	protected void finalize() throws Throwable {
		System.out.println("������");
		super.finalize();
	}
}