package EnumPackage;

public class EnumAbstractDemo {

	public static void main(String[] args) {
		for(Color c:Color.values()) {
			c.print();
		}
	}

	enum Color {
		RED {
			@Override
			public void print() {
				System.out.println("RED");
			}
		},
		BLUE {
			@Override
			public void print() {
				System.out.println("BLUE");
			}
		},
		GREEN {
			@Override
			public void print() {
				System.out.println("GREEN");
			}
		};
		public abstract void print();
	}
}
