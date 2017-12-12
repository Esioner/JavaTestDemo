package JavaIODemo;

import java.io.IOException;
import java.io.PipedInputStream;
import java.io.PipedOutputStream;

public class PipedStreamDemo {
	public static void main(String[] args) throws IOException {
		Send s = new Send();
		Receive r = new Receive();
		s.getPos().connect(r.getPis());
		new Thread(s).start();
		new Thread(r).start();
	}
}
class Send implements Runnable {
	PipedOutputStream mPos;

	public Send() {
		this.mPos = new PipedOutputStream();
	}

	@Override
	public void run() {
		String str = "Hello World";
		try {
			this.mPos.write(str.getBytes());
			this.mPos.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	public PipedOutputStream getPos() {
		return mPos;
	}
}
class Receive implements Runnable {
	private PipedInputStream mPis;
	public Receive() {
		this.mPis = new PipedInputStream();
	}
	@Override
	public void run() {
		byte[] b = new byte[1024];
		int len = 0;
		try {
			len = mPis.read(b);
			mPis.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		System.out.println(new String(b, 0, len));
	}
	public PipedInputStream getPis() {
		return mPis;
	}
}