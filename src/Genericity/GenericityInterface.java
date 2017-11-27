package Genericity;

public class GenericityInterface {
	public static void main(String[] args) {
		InfoInterface<String> info = null;
		info = new InfoImpl<String>("����");
		System.out.println(info.getVar());
	}
}

// �ڽӿ��϶��巺��
interface InfoInterface<T> {
	public T getVar();
}

// ���巺�͵�����
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
