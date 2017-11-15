package DailyDemo;

public class InnerClassExtension {
	public static void main(String[] args) {
		//抽象类中包含接口
		CommonClass cc = new CommonClass();
		cc.printClass();
		CommonClass.InnerClass ic = cc.new InnerClass();
		ic.printInterface();
		//接口中包含抽象类
		CommonClass2 cc2 = new CommonClass2();
		cc2.printInterface();
		DailyDemo.CommonClass2.InnerClass innerClass = cc2.new InnerClass();
		innerClass.printInnerAbstract();
	}
}
//抽象类中包含接口
abstract class AbstractClass{
	public abstract void printClass();
	interface InnerInterface{
		void printInterface();
	}
}
class CommonClass extends AbstractClass{
	@Override
	public void printClass() {		
		System.out.println("重写抽象类方法");
	}
	class InnerClass implements InnerInterface{
		@Override
		public void printInterface() {			
			System.out.println("内部类实现抽象类内部接口");
		}
	}
}
//接口中包含抽象类
interface InterfaceClass{
	void printInterface();
	abstract class AbstractInnerClass{
		public abstract void printInnerAbstract();
	}
}
class CommonClass2 implements InterfaceClass{
	@Override
	public void printInterface() {
		System.out.println("实现接口的方法");
	}
	public class InnerClass extends AbstractInnerClass{
		@Override
		public void printInnerAbstract() {
			System.out.println("实现接口中抽象类的方法");
		}
	}
}