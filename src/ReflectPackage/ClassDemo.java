package ReflectPackage;

import java.lang.reflect.Array;
import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;

public class ClassDemo {

	public static void main(String[] args) throws Exception {
		// 1. ʵ���� Class ����
		// function1();
		// 2. ͨ���޲ι���ʵ��������.��ʵ���������б�������޲ι��췽��
		// function2();
		// 3. �������е��вι��췽����ʵ��������
		// function3();
		// 4. ȡ����ṹ
		// function4();
		// 5. ȡ��ȫ������
		// function5();
		// 5. ȡ��ȫ������
		// function6();
		// 5. ͨ������������еķ���
		// function7();
		// 5. ͨ�������������
		function8();
	}

	private static void function8() {
		int[] arr = { 1, 2, 3 };
		Class<?> arrClass = arr.getClass().getComponentType();
		System.out.println("���ͣ�" + arrClass.getName());
		System.out.println("���ȣ�" + Array.getLength(arr));
		System.out.println("��ȡ��һ�����ݣ�" + Array.get(arr, 0));
		Array.set(arr, 0, 6);
		System.out.println("�޸ĵ�һ�����ݣ�" + Array.get(arr, 0));
		// �������е����������������µ���������
		Object newArr = Array.newInstance(arrClass, 5);
		System.arraycopy(arr, 0, newArr, 0, Array.getLength(arr));
		for(int i:(int[])newArr) {
			System.out.print(i+"\t");
		}
	}

	private static void function7() throws Exception {
		Class<?> perClass = Class.forName("ReflectPackage.Person");
		// ���õķ�������Ҫ����
		Method method = perClass.getMethod("sayChina");
		// ���봫��һ��ʵ��
		method.invoke(perClass.newInstance());
		// ���õķ�����Ҫ��������
		Method method2 = perClass.getMethod("sayHello", String.class, int.class);
		// ����ʵ���Ͳ���
		String text = (String) method2.invoke(perClass.newInstance(), "��", 20);
		System.out.println(text);
		// ���� get �� set ����
		Object object = null;
		object = perClass.newInstance();
		// set ����
		Method methodSet = object.getClass().getMethod("setName", String.class);
		methodSet.invoke(object, "��");
		// get ����
		Method methodGet = object.getClass().getMethod("getName");
		String name = (String) methodGet.invoke(object);
		System.out.println(name);
		// ͨ�������������
		Field nameField = object.getClass().getDeclaredField("name");
		Field ageField = object.getClass().getDeclaredField("age");
		nameField.setAccessible(true);
		nameField.set(object, "��");
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
			System.out.println("�Ƿ�ɱ��ⲿ���ʣ�" + field.isAccessible());
		}
		System.out.println("getFields");
		Field[] fields_2 = perClass.getFields();
		for (Field field : fields_2) {
			System.out.println(field.getName());
			System.out.println(Modifier.toString(field.getModifiers()));
			System.out.println("�Ƿ�ɱ��ⲿ���ʣ�" + field.isAccessible());
		}
	}

	private static void function5() throws Exception {
		Class<?> perClass = Class.forName("ReflectPackage.Person");
		Method[] methods = perClass.getMethods();
		// ������з���
		for (Method me : methods) {
			System.out.println(me);
			// ������в���
			Class<?>[] parameters = me.getParameterTypes();
			for (Class c : parameters) {
				System.out.println(c);
			}
			// ����쳣��Ϣ
			Class<?>[] exceptions = me.getExceptionTypes();
			for (Class<?> c : exceptions) {
				System.out.println(c);
			}
		}

	}

	private static void function4() throws Exception {
		// ȡ����ʵ�ֵĽӿ�
		Class<?> perClass = Class.forName("ReflectPackage.Person");
		Class<?>[] interfaces = perClass.getInterfaces();
		for (Class c : interfaces) {
			System.out.println(c.getName());
		}
		// ȡ�ø���
		Class superClass = perClass.getSuperclass();
		System.out.println(superClass.getName());
		// ��ȡ���й��췽��
		Constructor<?>[] cons = perClass.getConstructors();
		for (Constructor<?> c : cons) {
			System.out.println(c);
			// ʹ�� Modifier ��ԭ���η�,��ԭȨ�����η�
			int mo = c.getModifiers();
			System.out.println(Modifier.toString(mo));
		}
	}

	private static void function3() throws Exception {
		/**
		 * 3. �������е��вι��췽����ʵ�������� 3_1: ��ȡ class �����еĹ��췽�� 3_2:
		 * ���췽������һ���������飬����������췽������ĸ������� 3_3: ֮��ͨ�� Constructor ʵ��������
		 */
		Class<?> perClass = Class.forName("ReflectPackage.Person");
		Constructor<?>[] constructor = perClass.getConstructors();
		for (Constructor<?> con : constructor) {
			System.out.println(con);
		}
		Person person = (Person) constructor[0].newInstance("����", 22);
		System.out.println(person);
	}

	private static void function2() throws Exception {
		Class perClass = Class.forName("ReflectPackage.Person");
		Person person = (Person) perClass.newInstance();
		person.setName("��");
		person.setAge(23);
		System.out.println(person);
	}

	private static void function1() throws ClassNotFoundException {
		// ���� ����.����
		Class<?> c1 = Class.forName("ReflectPackage.Person");
		// ����Object���еķ���ʵ��
		Class<?> c2 = (new Person()).getClass();
		// ͨ�� .class ʵ����
		Class<?> c3 = Person.class;
		System.out.println(c1.getName());
		System.out.println(c2.getName());
		System.out.println(c3.getName());
	}

}
