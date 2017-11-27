package Genericity;

public class GenericityMix {
	public static void main(String[] args) {
		B<A<String,Integer>> b = null;
		A<String,Integer> a = null;
		a = new A<String,Integer>("张三",26);
		b = new B<A<String,Integer>>(a);
		System.out.println("A的内容："+a);
		System.out.println("B的内容："+b.getInfo());
	}
}
class A<T, V> {
	private T var;
	private V value;
	public A(T var, V value) {
		this.var = var;
		this.value = value;
	}
	public T getVar() {return var;}
	public void setVar(T var) {this.var = var;}
	public V getValue() {return value;}
	public void setValue(V value) {this.value = value;}
	public String toString() {return this.var + "\t"+this.value;}
}
class B<S> {
	private S info;
	public B(S info) {this.info = info;}
	public S getInfo() {return info;}
	public void setInfo(S info) {this.info = info;}
}
