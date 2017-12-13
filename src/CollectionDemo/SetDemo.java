package CollectionDemo;

import java.util.HashSet;
import java.util.Set;
import java.util.TreeSet;

public class SetDemo {
	public static void main(String[] args) {
//		hashSet();
		treeSet();

	}

	private static void treeSet() {
		Person p1 = new Person("二", 20);
		Person p2 = new Person("三", 32);
		Person p3 = new Person("四", 23);
		Person p4 = new Person("三", 24);
		Person p5 = new Person("四", 15);
		Person p6 = new Person("四", 23);
		Person p7 = new Person("四", 23);
		Person p8 = new Person("四", 15);
		Set<Person> treeSet = new TreeSet<>();
		treeSet.add(p1);
		treeSet.add(p2);
		treeSet.add(p3);
		treeSet.add(p4);
		treeSet.add(p5);
		treeSet.add(p6);
		treeSet.add(p7);
		treeSet.add(p8);
		System.out.println(treeSet);
	}

	// private static void hashSet() {
	// Set<String> allSet = new HashSet<>();
	// allSet.add("A");
	// allSet.add("B");
	// allSet.add("B");
	// allSet.add("C");
	// allSet.add("C");
	// allSet.add("D");
	// allSet.add("E");
	// System.out.println(allSet);
	// }
	static class Person implements Comparable<Person> {
		int age;
		String name;

		public Person(String name, int age) {
			this.name = name;
			this.age = age;
		}

		@Override
		public int hashCode() {
			return this.name.hashCode() * this.age;
		}

		@Override
		public boolean equals(Object obj) {
			if (this == obj) {
				return true;
			}
			if (!(obj instanceof Person)) {
				return false;
			}
			Person person = (Person) obj;
			if (this.name.equals(person.name) && this.age == person.age) {
				return true;
			} else {
				return false;
			}
		}
		
		@Override
		public String toString() {
			return "Person [age=" + age + ", name=" + name + "]";
		}

		@Override
		public int compareTo(Person o) {
			if (this.age > o.age) {
				return 1;
			} else if (this.age < o.age) {
				return -1;
			} else {
				return 0;
			}
		}
	}
}
