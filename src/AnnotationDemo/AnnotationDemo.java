package AnnotationDemo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationDemo {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		//要知道 SimpleBeanOne 中toString 的所有 Annotation ，则先通过反射找到此方法
		Class<?> simClass = Class.forName("AnnotationDemo.SimpleBeanOne");
		Method me = simClass.getMethod("toString");
		Annotation[] annos = me.getAnnotations();
		//因为只有 	@Deprecated 使用了 RUNTIME 声明，只有它可以被取得
		for(Annotation an :annos) {
			System.out.println(an);
		}
	}
}
class SimpleBeanOne{
	@SuppressWarnings("unchecked")
	@Deprecated
	@Override
	public String toString() {
		return "Hello World";
	}
}
