package DailyDemo;

/**
 * �����ߺ������� �����ߣ� �����ߣ� ������ݴ���
 * 
 * @author Administrator
 */
public class ThreadDemo {

	public static void main(String[] args) {
		Info info = new Info();
		Producer pro = new Producer(info);
		Consumer con = new Consumer(info);
		new Thread(pro).start();
		new Thread(con).start();
	}

}

class Info {
	private String name;
	private String content;
	private boolean flag = false;

	/**
	 * ����ͬ����ֵ
	 * 
	 * @param name
	 * @param content
	 */
	public synchronized void set(String name, String content) {
		try {
			if (!flag) {//��־λΪfalse����ʾ����������
				super.wait();
			}
			this.name = name;
			Thread.sleep(300);
			this.content = content;
			flag = false;//�޸ı�־λ����ʾ����ȡ��
			this.notify();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * ����ͬ����ȡ��
	 */
	public synchronized void get() {
		try {
			if (flag) {//��־λΪ true ��������ȡ��
				super.wait();
			}
			Thread.sleep(300);
			System.out.println(this.name + "-->" + this.content);
			flag = true;//�޸ı�־λ����ʾ��������
			super.notify();//���ѵȴ��߳�
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}

class Producer implements Runnable {
	Info info;

	public Producer(Info info) {
		this.info = info;
	}

	@Override
	public void run() {
		boolean flag = false;
		for (int i = 0; i < 50; i++) {
			if (flag) {
				this.info.set("����", "Java ��ʦ");
				flag = false;
			} else {
				this.info.set("����", "Java ѧԱ");
				flag = true;
			}
		}
	}
}

class Consumer implements Runnable {
	Info info;

	public Consumer(Info info) {
		this.info = info;
	}

	@Override
	public void run() {
		for (int i = 0; i < 50; i++) {
			this.info.get();
		}
	}
}