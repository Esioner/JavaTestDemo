package Genericity;
//Í¨Åä·û
public class CommonGenericity {
	public static void main(String[] args) {
		Info<String> i = new Info();
		i.setVar("zhangshan");
		fun(i);
		Info<String> i1 = new Info<>();
		Info<Object> i2 = null;
		i2 = i1;
	}

	public static void fun(Info<?> i) {
//		i.setVar("ÕÅÈý");// Error:The method setVar(capture#1-of ?) in the type Info<capture#1-of ?> is not
//						// applicable for the arguments (String)
		System.out.println(i.getVar());
	}
}

class Info<T> {
	private T var;

	public void setVar(T var) {
		this.var = var;
	}

	public T getVar() {
		return var;
	}
}