package CommonUseClass;

public class CloneObject {

	public static void main(String[] args) {
		ObjectDemo obj1 = new ObjectDemo();
		try {
			ObjectDemo obj2= (ObjectDemo) obj1.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
class ObjectDemo implements Cloneable {
	@Override
	public Object clone() throws CloneNotSupportedException {
		//����Ŀ�¡�����ɸ������
		return super.clone();
	}
}
