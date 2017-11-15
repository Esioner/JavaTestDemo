package DailyDemo;

public class SingleLinkDemo {
	public static void main(String[] args) {
		Link link = new Link();
		link.add("A");
		link.add("B");
		link.add("C");
		link.add("D");
		link.add("E");
		link.add("F");
		link.add("G");
		System.out.println("====================ɾ��֮ǰ====================");
		link.printNode();
		link.deleteNode("C");
		link.deleteNode("E");
		System.out.println("====================ɾ��֮��====================");
		link.printNode();
	}
}
class Link {
	//�ѽڵ��ඨ����ڲ���
	class Node {
		private String data;
		private Node next;
		
		public Node(String data) {
			this.data = data;
		}
		//����һ��add����
		public void add(Node newNode) {
			//�ж���һ�ڵ��Ƿ�Ϊ�գ����Ϊ������½ڵ�������next��λ����
			//�����Ϊ�գ����ʾ�롢������һ���ڵ㣬����һ��λ������
			if (this.next == null) {
				this.next = newNode;
			} else {
				this.next.add(newNode);
			}
		}
		public void print() {
			System.out.print(this.data+"\t");
			//�����һ���ڵ㲻Ϊ�գ��������ӡ
			if (this.next != null) {
				this.next.print();
			}
		}
		//�ڲ�������������
		public boolean search(String data) {
			//�жϵ�ǰ�ڵ�������Ƿ�����ҵ�һ�£����һ�·���true
			if (data.equals(this.data)) {
				return true;
			} else {
				//�����ж���һ��������¸��ڵ���ڣ���������ң�������һ���Ĳ�ѯ���
				if (this.next != null) {
					return this.next.search(data);
				} else {
					return false;//�ڵ㲻���ڷ���false
				}
			}
		}
		//ɾ���ڵ�
		public void delete(Node pre, String data) {
			//�ҵ�ƥ��Ľڵ�
			if (data.equals(this.data)) {
				pre.next = this.next;
			} else {
				if (this.next != null) {
					this.next.delete(this, data);//�������²���
				}
			}
		}
	};
	/**
	 * ��ʾ���ڵ�
	 */
	private Node rootNode;
	//���Ӹ��ڵ�ķ���
	public void add(String data) {
//		����һ���µĽڵ�
		Node node = new Node(data);
		//û�и��ڵ㣬����һ���ڵ�����Ϊ���ڵ�
		if (this.rootNode == null) {
			this.rootNode = node;
		} else {
			//��ӵ����ʵ�λ��
			this.rootNode.add(node);
		}
	}
	//��ӡȫ���ڵ�
	public void printNode() {
		//�ж��Ƿ���ڸ��ڵ�
		if (this.rootNode != null) {
			this.rootNode.print();
		}
	}
	//�ж�Ԫ���Ƿ����
	public boolean contains(String name) {
		return this.rootNode.search(name);
	}
	//ɾ���ڵ�
	public void deleteNode(String data) {
		//����ڵ���ڣ���ֱ�ӽ���ɾ������
		if (this.contains(data)) {
			if (this.rootNode.data.equals(data)) {
				this.rootNode = this.rootNode.next;
			} else {
				this.rootNode.next.delete(rootNode, data);
			}
		}
	}
}
