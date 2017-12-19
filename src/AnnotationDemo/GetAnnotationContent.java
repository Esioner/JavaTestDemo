package AnnotationDemo;

import java.lang.reflect.Method;

public class GetAnnotationContent {
	public static void main(String[] args) throws Exception {
		Class<?> c = Class.forName("AnnotationDemo.MyClass");
		Method me = c.getMethod("toString");
		if (me.isAnnotationPresent(MyDefAnnotationReflect.class)) {
			MyDefAnnotationReflect mda = me.getAnnotation(MyDefAnnotationReflect.class);
			String key = mda.key();
			String value = mda.value();
			System.out.println("key = " + key);
			System.out.println("value = " + value);
		} else {
			System.out.println("error");
		}
	}
}

@interface MyDefAnnotationReflect {
	public String key() default "yang";

	public String value() default "Yang";
}

class MyClass {
	@SuppressWarnings("unchecked")
	@Deprecated
	@Override
	// 使用自定义 Annotation 并设置两个属性内容
	@MyDefAnnotationReflect(key = "hello", value = "world")
	public String toString() {
		return "HelloWorld";
	}
}