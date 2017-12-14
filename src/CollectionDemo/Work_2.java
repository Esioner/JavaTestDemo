package CollectionDemo;

import java.util.ArrayList;
import java.util.List;

public class Work_2 {

	public static void main(String[] args) {
		Course c1 = new Course("English", 3);
		Course c2 = new Course("Math", 3);
		Student s1 = new Student("A", 10);
		Student s2 = new Student("B", 11);
		Student s3 = new Student("C", 12);
		Student s4 = new Student("D", 13);
		// 第一個课程有三个人参加
		c1.getAllStudents().add(s1);
		c1.getAllStudents().add(s2);
		c1.getAllStudents().add(s3);
		s1.getAllCourses().add(c1);
		s2.getAllCourses().add(c1);
		s3.getAllCourses().add(c1);
		// 第二個课程有四个人参加
		c2.getAllStudents().add(s1);
		c2.getAllStudents().add(s2);
		c2.getAllStudents().add(s3);
		c2.getAllStudents().add(s4);
		s1.getAllCourses().add(c2);
		s2.getAllCourses().add(c2);
		s3.getAllCourses().add(c2);
		s4.getAllCourses().add(c2);
		System.out.println(c1);
		System.out.println(c2);
	}

	static class Student {
		private String name;
		private int age;
		private List<Course> allCourses;

		public Student(String name, int age) {
			this.allCourses = new ArrayList<>();
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

		public List<Course> getAllCourses() {
			return allCourses;
		}

		public void setAllCourses(List<Course> allCourses) {
			this.allCourses = allCourses;
		}

		@Override
		public String toString() {
			return "Student [name=" + name + ", age=" + age + "]";
		}

	}

	static class Course {
		private String name;
		private int credit;
		private List<Student> allStudents;

		public Course(String name, int credit) {
			this.allStudents = new ArrayList<>();
			this.setName(name);
			this.setCredit(credit);
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public int getCredit() {
			return credit;
		}

		public void setCredit(int credit) {
			this.credit = credit;
		}

		public List<Student> getAllStudents() {
			return allStudents;
		}

		public void setAllStudents(List<Student> allStudents) {
			this.allStudents = allStudents;
		}

		@Override
		public String toString() {
			return "Course [name=" + name + ", credit=" + credit + "]";
		}

	}
}
