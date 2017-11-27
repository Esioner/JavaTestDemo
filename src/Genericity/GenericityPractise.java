package Genericity;

public class GenericityPractise {
	public static void main(String[] args) {
		Person<Introduction> p = null;
		p = new Person<Introduction>(new Introduction("����","��",26));
		System.out.println(p.getInfo());
	}
}
class Person<T> {
	private T info;
	public Person(T info) {this.setInfo(info);}
	public void setInfo(T info) {this.info = info;}
	public T getInfo() {return info;}
}
interface PersonInfo {
}
class Introduction implements PersonInfo {
	private String name;
	private String sex;
	private int age;
	public Introduction(String name,String sex,int age) {
		this.setAge(age);
		this.setSex(sex);
		this.setName(name);
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public String toString() {
		return "��ϵ��ʽ" + "\n" + "\t|������" + name + "\n" + "\t|�Ա�" + sex + "\n" + "\t|���䣺" + age;
	}
}
class Contact implements PersonInfo {
	private String address;
	private String telephone;
	private String zipcode;
	public Contact(String address, String telephone, String name) {
		this.setAddress(address);
		this.setZipcode(zipcode);
		this.setTelephone(telephone);
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public String getTelephone() {
		return telephone;
	}
	public void setTelephone(String telephone) {
		this.telephone = telephone;
	}
	public String getZipcode() {
		return zipcode;
	}
	public void setZipcode(String zipcode) {
		this.zipcode = zipcode;
	}
	public String toString() {
		return "��ϵ��ʽ" + "\n" + "\t|�绰��" + telephone + "\n" + "\t|��ַ��" + address + "\n" + "\t|�ʱࣺ" + zipcode;
	}
}