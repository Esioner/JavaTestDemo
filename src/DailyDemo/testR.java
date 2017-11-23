package DailyDemo;

public class testR {
	public static void main(String[] args) {
		MyRunnable1 r1 = new MyRunnable1();
		// MyRunnable2 r2 = new MyRunnable2();
		Thread thre1 = new Thread(r1, "r1");
		// Thread thre2 = new Thread(r2, "r2");
		// thre2.start();
		thre1.start();
		thre1.setDaemon(true);
		System.out.println("********");
		System.exit(0);
	}
}

class MyRunnable1 implements Runnable {

	@Override
	public void run() {
		int i = 0;
		while (true) {
			try {
				Thread.sleep(2000);
				System.out.println("thre2 = " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
	}
}

class MyRunnable2 implements Runnable {

	@Override
	public void run() {
		for (int i = 0; i < 100; i++) {
			try {
				Thread.sleep(2000);
				System.out.println("thre2 = " + i);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}

}
