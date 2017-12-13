package JavaIODemo;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.OutputStream;
import java.io.Serializable;

public class SerializeableDemo {

	public static void main(String[] args) throws FileNotFoundException, IOException, ClassNotFoundException {
//		write
		Person p = new Person();
		p.setI(6);
		p.setName("Èý·á");
		OutputStream os = new FileOutputStream(new File("D:" + File.separator + "d.txt"));
		ObjectOutputStream oos = new ObjectOutputStream(os);
		oos.writeObject(p);
		os.close();
		oos.close();
		//read
		Person per = new Person();
		InputStream in = new FileInputStream(new File("D:" + File.separator + "d.txt"));
		ObjectInputStream ois = new ObjectInputStream(in);
		Object obj = ois.readObject();
		System.out.println(obj);
	}
	
	static class Person implements Serializable {
		int i;
		String name;

		public int getI() {
			return i;
		}

		public void setI(int i) {
			this.i = i;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		@Override
		public String toString() {
			return "Person [i=" + i + ", name=" + name + "]";
		}

	}


}

