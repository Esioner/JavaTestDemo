package AnnotationDemo;

public @interface MyDefaultAnnotation {
	public String text() default "null";// ����Ĭ������
	public String key();
	public String value();
	//ʹ��ö���������õ����ݣ��������õ�Ĭ��ֵΪö�ٵ����ݣ��Ժ�����ֵֻ��Ϊö��֮�ڵ�����
	public MyKey myKey() default MyKey.A;
	// ����һ���������
	public String[] values();
	enum MyKey {
		A, B
	}
}
