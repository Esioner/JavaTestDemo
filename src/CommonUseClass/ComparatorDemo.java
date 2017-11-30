package CommonUseClass;

import java.util.Arrays;
import java.util.Comparator;

public class ComparatorDemo {
	public static void main(String[] args) {
		Teacher te1 = new Teacher("张一", 34);
		Teacher te2 = new Teacher("王二", 31);
		Teacher te3 = new Teacher("张三", 36);
		Teacher te4 = new Teacher("李四", 38);
		Teacher te5 = new Teacher("王五", 32);
		Teacher[] arr = {te1,te2,te3,te4,te5};
		Arrays.sort(arr,new TeacherCompartor());//排序并制定规则
		System.out.println(Arrays.toString(arr));
	}
}
// 定义比较规则
class TeacherCompartor implements Comparator<Teacher> {

	@Override
	public int compare(Teacher o1, Teacher o2) {
		if (o1.equals(o2)) {
			return 0;
		} else if (o1.getAge() > o2.getAge()) {
			return 1;
		} else {
			return -1;
		}
	}
}
class Teacher {
	private String name;
	private int age;
	public Teacher(String name, int age) {
		this.name = name;
		this.age = age;
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj) {
			return true;
		}
		if (!(obj instanceof Teacher)) {
			return false;
		}
		Teacher teacher = (Teacher) obj;
		if (this.name.equals(teacher.name)) {
			if (teacher.age == this.age) {
				return true;
			}
		}
		return false;
	}
	@Override
	public String toString() {
		return this.name + "\t" + this.age;
	}
	public int getAge() {
		return age;
	}
	public String getName() {
		return name;
	}
}