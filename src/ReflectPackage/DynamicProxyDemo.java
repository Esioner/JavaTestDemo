package ReflectPackage;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyDemo {
	public static void main(String[] args) {
		// ʵ����������������
		MyInvocationHandler handler = new MyInvocationHandler();
		Subject subject = (Subject) handler.bind(new RealSubject());
		String info = subject.say("��", 23);
		System.out.println(info);
	}
}
// ��̬������
// 1. ʵ�� InvocationHandler �ӿ�
class MyInvocationHandler implements InvocationHandler {
	private Object obj;
	// ����ʵ����
	public Object bind(Object object) {
		this.obj = object;
		// ȡ�ô������
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// ��̬���÷�����������ʵ����Ͳ���
		Object temp = method.invoke(this.obj, args);
		//���ط�������Ϣ
		return temp;
	}
}
// ����ӿ�
interface Subject {
	public String say(String name, int age);
}
// ��ʵ������
class RealSubject implements Subject {
	@Override
	public String say(String name, int age) {
		return "����:" + name + "\n����:" + age;
	}
}