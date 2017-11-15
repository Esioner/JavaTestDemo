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
//����ӿ�
interface A{
	void work();
	void done();
}
//��ʵ����
class B implements A{
	@Override public void work() {System.out.println("���ڹ���������");}
	@Override public void done() {System.out.println("������ɡ�����");}
}
//�������
class ProxyB implements A{
	private B b; //���汻�������
	public ProxyB(B b){this.b = b;}//�����������ֵ
	@Override  
	public void work() {
		System.out.println("��ʼ����");
		b.work();//������ʵ����
		System.out.println("��������");
	}
	@Override
	public void done() {
		System.out.println("�����������");
		b.done();//���ô�����ʵ����
		System.out.println("�����Ѿ����");
	}
}