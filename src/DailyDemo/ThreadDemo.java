package DailyDemo;

/**
 * 生产者和消费者 生产者： 消费者： 解决数据错乱
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
	 * 加入同步赋值
	 * 
	 * @param name
	 * @param content
	 */
	public synchronized void set(String name, String content) {
		try {
			if (!flag) {//标志位为false，表示不可以生产
				super.wait();
			}
			this.name = name;
			Thread.sleep(300);
			this.content = content;
			flag = false;//修改标志位，表示可以取走
			this.notify();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 加入同步获取锁
	 */
	public synchronized void get() {
		try {
			if (flag) {//标志位为 true ，不可以取走
				super.wait();
			}
			Thread.sleep(300);
			System.out.println(this.name + "-->" + this.content);
			flag = true;//修改标志位，表示可以生产
			super.notify();//唤醒等待线程
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
				this.info.set("张三", "Java 讲师");
				flag = false;
			} else {
				this.info.set("李四", "Java 学员");
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