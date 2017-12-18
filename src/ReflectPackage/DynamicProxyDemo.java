package ReflectPackage;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class DynamicProxyDemo {
	public static void main(String[] args) {
		// 实例化代理对象操作类
		MyInvocationHandler handler = new MyInvocationHandler();
		Subject subject = (Subject) handler.bind(new RealSubject());
		String info = subject.say("阳", 23);
		System.out.println(info);
	}
}
// 动态代理类
// 1. 实现 InvocationHandler 接口
class MyInvocationHandler implements InvocationHandler {
	private Object obj;
	// 绑定真实主题
	public Object bind(Object object) {
		this.obj = object;
		// 取得代理对象
		return Proxy.newProxyInstance(obj.getClass().getClassLoader(), obj.getClass().getInterfaces(), this);
	}
	@Override
	public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
		// 动态调用方法，传入真实主题和参数
		Object temp = method.invoke(this.obj, args);
		//返回方法的信息
		return temp;
	}
}
// 定义接口
interface Subject {
	public String say(String name, int age);
}
// 真实主题类
class RealSubject implements Subject {
	@Override
	public String say(String name, int age) {
		return "姓名:" + name + "\n年龄:" + age;
	}
}