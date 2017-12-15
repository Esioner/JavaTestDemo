package ReflectPackage;

import java.lang.reflect.Constructor;
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
		function5();
		// 5. ȡ��ȫ������
		function6();
	}

	private static void function6() {
		// Class<?>
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
			//����쳣��Ϣ
			Class<?>[] exceptions = me.getExceptionTypes();
			for(Class<?> c:exceptions) {
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
