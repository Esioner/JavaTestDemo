package EnumPackage;

public class EnumInterfaceDemo {

	public static void main(String[] args) {
		for (Color c : Color.values()) {
			c.print();
		}
	}
	enum Color implements Print {
		RED {
			public void print() {
				System.out.println("RED");
			}
		},
		BLUE {
			public void print() {
				System.out.println("BLUE");
			}
		},
		GREEN {
			public void print() {
				System.out.println("GREEN");
			}
		};
	}
	interface Print {
		void print();
	}
}
