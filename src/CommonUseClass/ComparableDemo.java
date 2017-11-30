package CommonUseClass;

import java.util.Arrays;

public class ComparableDemo {

	public static void main(String[] args) {
		Student stu1 = new Student("张三", 15, 80);
		Student stu2 = new Student("李四", 18, 78);
		Student stu3 = new Student("旺儿", 17, 78);
		Student stu4 = new Student("顺6", 14, 95);
		
		Student[] arr = {stu1,stu2,stu3,stu4};
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}

}
class Student implements Comparable<Student> {
	private String name;
	private int score;
	private int age;
	public Student(String name, int age, int score) {
		this.name = name;
		this.age = age;
		this.score = score;
	}
	public int compareTo(Student stu) {
		if (stu.score > this.score) {
			return 1;
		} else if (stu.score == this.score) {
			if (stu.age > this.age) {
				return 1;
			} else if (stu.age < this.age) {
				return -1;
			} else {
				return 0;
			}
		} else if (stu.score < this.score) {
			return -1;
		}
		return -1;
	};
	@Override
	public String toString() {
		return this.name;
	}
}
