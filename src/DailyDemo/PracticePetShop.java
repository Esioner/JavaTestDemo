package DailyDemo;

/**
 * 在宠物商店中有多种（由用户决定数量）宠物，表示出这种关系，并可以通过宠物的关键字查到相应的宠物的信息 1.
 * 宠物的信息自行设计，可以设计名字，年龄，颜色三种属性 2. 宠物类别很多，宠物应该是个标准 3.
 * 在宠物商店中，只要是符合此宠物标准的都应该可以放到宠物商店之中 4. 宠物商店中要保存多种宠物，是个宠物的对象数组
 * 
 * @author Administrator
 *
 */
public class PracticePetShop {

	public static void main(String[] args) {
		PetShop petShop = new PetShop(6);
		petShop.addPet(new Dog("拉布拉多", "黄色", 3));
		petShop.addPet(new Dog("金毛", "金色", 2));
		petShop.addPet(new Dog("中华田园犬", "黑色", 1));
		petShop.addPet(new Cat("白猫", "白色", 3));
		petShop.addPet(new Cat("黑猫", "黑色", 3));
		petShop.addPet(new Cat("花猫", "彩色", 3));
		print(petShop.search("猫"));
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
		int count = 0;// 记录下多少符合查询结果
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