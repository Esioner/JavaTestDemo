package DailyDemo;

import javax.crypto.interfaces.PBEKey;

public class ProxyDesignMode {
	public static void main(String[]args) {
		B b = new B();
		ProxyB proxyB = new ProxyB(b);
		proxyB.work();
		proxyB.done();
	}
}
//定义接口
interface A{
	void work();
	void done();
}
//真实操作
class B implements A{
	@Override public void work() {System.out.println("正在工作。。。");}
	@Override public void done() {System.out.println("工作完成。。。");}
}
//代理操作
class ProxyB implements A{
	private B b; //保存被代理对象
	public ProxyB(B b){this.b = b;}//给被代理对象赋值
	@Override  
	public void work() {
		System.out.println("开始工作");
		b.work();//调用真实操作
		System.out.println("工作结束");
	}
	@Override
	public void done() {
		System.out.println("工作即将完成");
		b.done();//调用代理真实操作
		System.out.println("工作已经完成");
	}
}