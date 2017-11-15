package DailyDemo;

public class AdapterDemo {
	public static void main(String[] args) {
		Window window = new WindowImpl();
		window.open();
		window.close();
	}
}
interface Window {
	void open();
	void close();
	void clean();
	void repair();
}

abstract class WindowAdapter implements Window {
	@Override public void open() {}
	@Override public void close() {}
	@Override public void clean() {}
	@Override public void repair() {}
}
class WindowImpl extends WindowAdapter {
	@Override
	public void open() {
		System.out.println("´ò¿ª");
	}
	@Override
	public void close() {
		System.out.println("¹Ø±Õ");
	}
}