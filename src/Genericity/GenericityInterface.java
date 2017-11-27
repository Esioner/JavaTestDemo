package Genericity;

public class GenericityInterface {
	public static void main(String[] args) {
		InfoInterface<String> info = null;
		info = new InfoImpl<String>("张三");
		System.out.println(info.getVar());
	}
}

// 在接口上定义泛型
interface InfoInterface<T> {
	public T getVar();
}

// 定义泛型的子类
class InfoImpl<T> implements InfoInterface<String> {
	private String var;

	public InfoImpl(String var) {
		this.setVar(var);
	}

	public void setVar(String var) {
		this.var = var;
	}

	@Override
	public String getVar() {
		return this.var;
	}
}
