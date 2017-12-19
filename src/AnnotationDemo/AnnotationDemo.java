package AnnotationDemo;

import java.lang.annotation.Annotation;
import java.lang.reflect.Method;

public class AnnotationDemo {
	public static void main(String[] args) throws ClassNotFoundException, NoSuchMethodException, SecurityException {
		//Ҫ֪�� SimpleBeanOne ��toString ������ Annotation ������ͨ�������ҵ��˷���
		Class<?> simClass = Class.forName("AnnotationDemo.SimpleBeanOne");
		Method me = simClass.getMethod("toString");
		Annotation[] annos = me.getAnnotations();
		//��Ϊֻ�� 	@Deprecated ʹ���� RUNTIME ������ֻ�������Ա�ȡ��
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
