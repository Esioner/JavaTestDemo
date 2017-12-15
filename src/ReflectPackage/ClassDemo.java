package ReflectPackage;

import java.lang.reflect.Constructor;
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
		function5();
		// 5. 取得全部属性
		function6();
	}

	private static void function6() {
		// Class<?>
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
			//输出异常信息
			Class<?>[] exceptions = me.getExceptionTypes();
			for(Class<?> c:exceptions) {
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
