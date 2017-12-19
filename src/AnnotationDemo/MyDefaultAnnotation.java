package AnnotationDemo;

public @interface MyDefaultAnnotation {
	public String text() default "null";// 设置默认属性
	public String key();
	public String value();
	//使用枚举限制设置的内容，这样设置的默认值为枚举的内容，以后设置值只能为枚举之内的内容
	public MyKey myKey() default MyKey.A;
	// 设置一个数组接收
	public String[] values();
	enum MyKey {
		A, B
	}
}
