package AnnotationDemo;

public class OwnDefineAnnotationDemo {
	
	//只要注解设置了属性，则必须为其设置内容
	@MyDefaultAnnotation(text = "你好",key="1",value="China",values= {"你好","1","China"})
	public static void main(String[] args) {
		
		
	}
}
