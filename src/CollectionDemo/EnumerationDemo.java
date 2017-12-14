package CollectionDemo;

import java.util.Enumeration;
import java.util.Vector;

public class EnumerationDemo {

	public static void main(String[] args) {
		Vector<String> all = new Vector<>();
		all.add("a");all.add("b");all.add("c");
		Enumeration<String> enumeration = all.elements();
		while (enumeration.hasMoreElements()) {
			String string = (String) enumeration.nextElement();
			System.out.print(string+"\t");
		}
	}

}
