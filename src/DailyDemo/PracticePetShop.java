package DailyDemo;

/**
 * �ڳ����̵����ж��֣����û����������������ʾ�����ֹ�ϵ��������ͨ������Ĺؼ��ֲ鵽��Ӧ�ĳ������Ϣ 1.
 * �������Ϣ������ƣ�����������֣����䣬��ɫ�������� 2. �������ܶ࣬����Ӧ���Ǹ���׼ 3.
 * �ڳ����̵��У�ֻҪ�Ƿ��ϴ˳����׼�Ķ�Ӧ�ÿ��Էŵ������̵�֮�� 4. �����̵���Ҫ������ֳ���Ǹ�����Ķ�������
 * 
 * @author Administrator
 *
 */
public class PracticePetShop {

	public static void main(String[] args) {
		PetShop petShop = new PetShop(6);
		petShop.addPet(new Dog("��������", "��ɫ", 3));
		petShop.addPet(new Dog("��ë", "��ɫ", 2));
		petShop.addPet(new Dog("�л���԰Ȯ", "��ɫ", 1));
		petShop.addPet(new Cat("��è", "��ɫ", 3));
		petShop.addPet(new Cat("��è", "��ɫ", 3));
		petShop.addPet(new Cat("��è", "��ɫ", 3));
		print(petShop.search("è"));
	}

	public static void print(Pet[] p) {
		for (Pet pet : p) {
			System.out.println(pet.getName() + "\t" + pet.getAge() + "\t" + pet.getColor());
		}
	}
}

class PetShop {
	private Pet[] pets;
	private int position;

	public PetShop(int i) {
		if (i > 0) {
			pets = new Pet[i];
		} else {
			pets = new Pet[1];
		}
	}

	public boolean addPet(Pet pet) {
		if (position < pets.length) {
			pets[position] = pet;
			position++;
			return true;
		} else {
			return false;
		}
	}

	public Pet[] search(String keyword) {
		Pet[] pet = null;
		int count = 0;// ��¼�¶��ٷ��ϲ�ѯ���
		for (int i = 0; i < pets.length; i++) {
			if (pets[i] != null) {
				if (pets[i].getName().indexOf(keyword) != -1 || pets[i].getColor().indexOf(keyword) != -1) {
					count++;
				}
			}
		}
		pet = new Pet[count];
		int f = 0;
		for (int i = 0; i < pets.length; i++) {
			if (pets[i].getName().indexOf(keyword) != -1 || pets[i].getColor().indexOf(keyword) != -1) {
				pet[f] = pets[i];
				f++;
			}
		}
		return pet;
	}
}

interface Pet {
	String getName();

	String getColor();

	int getAge();

}

class Cat implements Pet {
	private String name;
	private String color;
	private int age;

	public Cat(String name, String color, int age) {
		this.name = name;
		this.color = color;
		this.age = age;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}

class Dog implements Pet {

	private String name;
	private String color;
	private int age;

	public Dog(String name, String color, int age) {
		this.name = name;
		this.color = color;
		this.age = age;
	}

	@Override
	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	@Override
	public String getColor() {
		return color;
	}

	public void setColor(String color) {
		this.color = color;
	}

	@Override
	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}
}