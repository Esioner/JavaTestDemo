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
	//创建对象的方法，在执行 gc 之前会先执行这个方法
	@Override
	protected void finalize() throws Throwable {
		System.out.println("被回收");
		super.finalize();
	}
}