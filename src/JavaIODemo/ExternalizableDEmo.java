package JavaIODemo;

import java.io.Externalizable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInput;
import java.io.ObjectInputStream;
import java.io.ObjectOutput;
import java.io.ObjectOutputStream;
import java.io.OutputStream;

public class ExternalizableDEmo {

	public static void main(String[] args) throws IOException, ClassNotFoundException {
		// Ð´
		Person p = new Person();
		p.setAge(22);
		p.setName("Esioner");
		File file = new File("D:" + File.separator + "e.txt");
		OutputStream out = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(out);
		oos.writeObject(p);
		// ¶Á
		InputStream is = new FileInputStream(file);
		ObjectInputStream ois = new ObjectInputStream(is);
		Object obj = ois.readObject();
		System.out.println(obj);
	}

	static class Person implements Externalizable {
		private String name;
		private int age;
		public Person() {}

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
		public void writeExternal(ObjectOutput out) throws IOException {
			out.writeObject(this.name);
			out.writeInt(this.age);
		}

		@Override
		public void readExternal(ObjectInput in) throws IOException, ClassNotFoundException {
			this.name = (String) in.readObject();
			this.age = in.readInt();
		}

	}

}
