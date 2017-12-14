package CollectionDemo;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/**
 * 一对多关系
 * 
 * @author Lenovo
 *
 */
public class Work_1 {

	public static void main(String[] args) {
		School school1 = new School("学校A");
		Student stu1 = new Student("A", 14);
		Student stu2 = new Student("A1", 14);
		Student stu3 = new Student("A2", 14);
		school1.getAllStudents().add(stu1);
		school1.getAllStudents().add(stu2);
		school1.getAllStudents().add(stu3);
		stu1.setSchool(school1);
		stu3.setSchool(school1);
		stu2.setSchool(school1);
		System.out.println(school1);
		Iterator<Student> iterator = school1.getAllStudents().iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}
	}
	static class School {
		private String name;
		private List<Student> allStudents;

		public School() {
			this.allStudents = new ArrayList<>();
		}

		public School(String name) {
			this();
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public List<Student> getAllStudents() {
			return allStudents;
		}

		public void setAllStudents(List<Student> allStudents) {
			this.allStudents = allStudents;
		}

		@Override
		public String toString() {
			return "School [name=" + name + "]";
		}
	}
	static class Student {
		private String name;
		private int age;
		private School school;

		public Student(String name, int age) {
			this.name = name;
			this.age = age;
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

		public School getSchool() {
			return school;
		}

		public void setSchool(School school) {
			this.school = school;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", age=" + age + ", school=" + school + "]";
		}
	}


}

