package ReflectPackage;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassDemo {

	public static void main(String[] args) throws Exception {
		// 1. 实例化 Class 对象
		// function1();
		// 2. 通过无参构造实例化对象.被实例化对象中必须存在无参构造方法
		// function2();
		// 3. 调用类中的有参构造方法来实例化对象
		// function3();
		// 4. 取得类结构
		// function4();
		// 5. 取得全部方法
		// function5();
		// 5. 取得全部属性
		// function6();
		// 5. 通过反射调用类中的方法
		// function7();
		// 5. 通过反射操作数组
		function8();
	}

	private static void function8() {
		int[] arr = { 1, 2, 3 };
		Class<?> arrClass = arr.getClass().getComponentType();
		System.out.println("类型：" + arrClass.getName());
		System.out.println("长度：" + Array.getLength(arr));
		System.out.println("获取第一个内容：" + Array.get(arr, 0));
		Array.set(arr, 0, 6);
		System.out.println("修改第一个内容：" + Array.get(arr, 0));
		// 根据已有的数组类型来开辟新的数组类型
		Object newArr = Array.newInstance(arrClass, 5);
		System.arraycopy(arr, 0, newArr, 0, Array.getLength(arr));
		for(int i:(int[])newArr) {
			System.out.print(i+"\t");
		}
	}

	private static void function7() throws Exception {
		Class<?> perClass = Class.forName("ReflectPackage.Person");
		// 调用的方法不需要参数
		Method method = perClass.getMethod("sayChina");
		// 必须传入一个实例
		method.invoke(perClass.newInstance());
		// 调用的方法需要两个参数
		Method method2 = perClass.getMethod("sayHello", String.class, int.class);
		// 传入实例和参数
		String text = (String) method2.invoke(perClass.newInstance(), "阳", 20);
		System.out.println(text);
		// 调用 get 和 set 方法
		Object object = null;
		object = perClass.newInstance();
		// set 方法
		Method methodSet = object.getClass().getMethod("setName", String.class);
		methodSet.invoke(object, "阳");
		// get 方法
		Method methodGet = object.getClass().getMethod("getName");
		String name = (String) methodGet.invoke(object);
		System.out.println(name);
		// 通过反射操作属性
		Field nameField = object.getClass().getDeclaredField("name");
		Field ageField = object.getClass().getDeclaredField("age");
		nameField.setAccessible(true);
		nameField.set(object, "阳");
		ageField.setAccessible(true);
		ageField.set(object, 23);
		System.out.println((Person) object);
	}

	private static void function6() throws Exception {
		Class<?> perClass = Class.forName("ReflectPackage.Person");
		System.out.println("getDeclaredFields");
		Field[] fields_1 = perClass.getDeclaredFields();
		for (Field field : fields_1) {
			System.out.println(field.getName());
			System.out.println(Modifier.toString(field.getModifiers()));
			System.out.println("是否可被外部访问：" + field.isAccessible());
		}
		System.out.println("getFields");
		Field[] fields_2 = perClass.getFields();
		for (Field field : fields_2) {
			System.out.println(field.getName());
			System.out.println(Modifier.toString(field.getModifiers()));
			System.out.println("是否可被外部访问：" + field.isAccessible());
		}
	}

	private static void function5() throws Exception {
		Class<?> perClass = Class.forName("ReflectPackage.Person");
		Method[] methods = perClass.getMethods();
		// 输出所有方法
		for (Method me : methods) {
			System.out.println(me);
			// 输出所有参数
			Class<?>[] parameters = me.getParameterTypes();
			for (Class c : parameters) {
				System.out.println(c);
			}
			// 输出异常信息
			Class<?>[] exceptions = me.getExceptionTypes();
			for (Class<?> c : exceptions) {
				System.out.println(c);
			}
		}

	}

	private static void function4() throws Exception {
		// 取得所实现的接口
		Class<?> perClass = Class.forName("ReflectPackage.Person");
		Class<?>[] interfaces = perClass.getInterfaces();
		for (Class c : interfaces) {
			System.out.println(c.getName());
		}
		// 取得父类
		Class superClass = perClass.getSuperclass();
		System.out.println(superClass.getName());
		// 获取所有构造方法
		Constructor<?>[] cons = perClass.getConstructors();
		for (Constructor<?> c : cons) {
			System.out.println(c);
			// 使用 Modifier 还原修饰符,还原权限修饰符
			int mo = c.getModifiers();
			System.out.println(Modifier.toString(mo));
		}
	}

	private static void function3() throws Exception {
		/**
		 * 3. 调用类中的有参构造方法来实例化对象 3_1: 获取 class 中所有的构造方法 3_2:
		 * 向构造方法传递一个对象数组，里面包含构造方法所需的各个参数 3_3: 之后通过 Constructor 实例化对象
		 */
		Class<?> perClass = Class.forName("ReflectPackage.Person");
		Constructor<?>[] constructor = perClass.getConstructors();
		for (Constructor<?> con : constructor) {
			System.out.println(con);
		}
		Person person = (Person) constructor[0].newInstance("张三", 22);
		System.out.println(person);
	}

	private static void function2() throws Exception {
		Class perClass = Class.forName("ReflectPackage.Person");
		Person person = (Person) perClass.newInstance();
		person.setName("阳");
		person.setAge(23);
		System.out.println(person);
	}

	private static void function1() throws ClassNotFoundException {
		// 传入 包名.类名
		Class<?> c1 = Class.forName("ReflectPackage.Person");
		// 根据Object类中的方法实例
		Class<?> c2 = (new Person()).getClass();
		// 通过 .class 实例化
		Class<?> c3 = Person.class;
		System.out.println(c1.getName());
		System.out.println(c2.getName());
		System.out.println(c3.getName());
	}

}
