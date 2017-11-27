package Genericity;

public class ByFunReturnBean {
	public static void main(String[] args) {
		InfoBean<Integer> i = fun(30);
		System.out.println(i.toString());
		InfoBean<String> i1 = new InfoBean();
		i1.setVar("张三");
		InfoBean<String> i2 = new InfoBean();
		i2.setVar("李四");
		add(i1,i2);
	}
	public static <T extends Number> InfoBean<T> fun(T parm) {
		InfoBean<T> temp = new InfoBean<T>();
		temp.setVar(parm);
		return temp;
	}
	public static <T> void add(InfoBean<T> i1, InfoBean<T> i2) {System.out.println(i1.toString() + i2.toString());}
}
class InfoBean<T> {
	private T var;
	public T getVar() {return var;}
	public void setVar(T var) {this.var = var;}
	public String toString() {return this.var.toString();}
}
