package Genericity;

public class ByFunReturnBean {
	public static void main(String[] args) {
		InfoBean<Integer> i = fun(30);
		System.out.println(i.toString());
	}
	public static <T extends Number> InfoBean<T> fun(T parm) {
		InfoBean<T> temp = new InfoBean<T>();
		temp.setVar(parm);
		return temp;
	}
}
class InfoBean<T extends Number> {
	private T var;
	public T getVar() {
		return var;
	}
	public void setVar(T var) {
		this.var = var;
	}
	public String toString() {
		return this.var.toString();
	}
}
