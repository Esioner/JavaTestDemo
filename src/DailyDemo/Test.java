package DailyDemo;

public class Test {
	public static void main(String[] args) {
		AppleFactory appleFactory = new AppleFactory();
		Apple apple = (Apple) appleFactory.getInstance();
	}
}

interface FruitFactory {Fruit getInstance();}
class AppleFactory implements FruitFactory{@Override public Fruit getInstance() {return new Apple();}}
class OrangeFactory implements FruitFactory{@Override public Fruit getInstance() {return new Orange();}}

interface Fruit {void eat();}
class Apple implements Fruit {@Override public void eat() {System.out.println("Eat Apple");}}
class Orange implements Fruit {	@Override public void eat() {System.out.println("Eat Orange");}}
