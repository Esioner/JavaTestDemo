package CommonUseClass;

public class StringBufferDemo {

	public static void main(String[] args) {
		//1.1、字符串连接
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < 5; i++) {	
			sb.append("我是第"+i+"行\n");
		}
		appends(sb);
		System.out.println(sb);
		//1.2、指定位置添加内容
	}
	public static void appends(StringBuffer sb) {
		sb.append("\n张三");
	}
	
	
}
