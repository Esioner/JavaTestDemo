package DailyDemo;

public class InnerClassExtension {
	public static void main(String[] args) {
		//�������а����ӿ�
		CommonClass cc = new CommonClass();
		cc.printClass();
		CommonClass.InnerClass ic = cc.new InnerClass();
		ic.printInterface();
		//�ӿ��а���������
		CommonClass2 cc2 = new CommonClass2();
		cc2.printInterface();
		DailyDemo.CommonClass2.InnerClass innerClass = cc2.new InnerClass();
		innerClass.printInnerAbstract();
	}
}
//�������а����ӿ�
abstract class AbstractClass{
	public abstract void printClass();
	interface InnerInterface{
		void printInterface();
	}
}
class CommonClass extends AbstractClass{
	@Override
	public void printClass() {		
		System.out.println("��д�����෽��");
	}
	class InnerClass implements InnerInterface{
		@Override
		public void printInterface() {			
			System.out.println("�ڲ���ʵ�ֳ������ڲ��ӿ�");
		}
	}
}
//�ӿ��а���������
interface InterfaceClass{
	void printInterface();
	abstract class AbstractInnerClass{
		public abstract void printInnerAbstract();
	}
}
class CommonClass2 implements InterfaceClass{
	@Override
	public void printInterface() {
		System.out.println("ʵ�ֽӿڵķ���");
	}
	public class InnerClass extends AbstractInnerClass{
		@Override
		public void printInnerAbstract() {
			System.out.println("ʵ�ֽӿ��г�����ķ���");
		}
	}
}