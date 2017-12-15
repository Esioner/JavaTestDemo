package ReflectPackage;

public class Person implements China {
	private String name;
	private int age;

	public Person() {

	}

	public Person(String name) {
		this.setName(name);
	}

	public Person(int age) {
		this.setAge(age);
	}

	public Person(String name, int age) {
		this.setAge(age);
		this.setName(name);
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	@Override
	public String toString() {
		return "Person [name=" + name + ", age=" + age + "]";
	}

	@Override
	public void sayChina() {
		System.out.println("ÄãºÃ");
	}

	@Override
	public String sayHello(String name, int age) {
		return "name:" + name + "age:" + age;
	}

}
