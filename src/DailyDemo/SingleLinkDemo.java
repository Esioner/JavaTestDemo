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
		System.out.println("====================删除之前====================");
		link.printNode();
		link.deleteNode("C");
		link.deleteNode("E");
		System.out.println("====================删除之后====================");
		link.printNode();
	}
}
class Link {
	//把节点类定义成内部类
	class Node {
		private String data;
		private Node next;
		
		public Node(String data) {
			this.data = data;
		}
		//增加一个add操作
		public void add(Node newNode) {
			//判断下一节点是否为空，如果为空则把新节点设置在next的位置上
			//如果不为空，则表示想、还有下一个节点，在下一个位置增加
			if (this.next == null) {
				this.next = newNode;
			} else {
				this.next.add(newNode);
			}
		}
		public void print() {
			System.out.print(this.data+"\t");
			//如果下一个节点不为空，则继续打印
			if (this.next != null) {
				this.next.print();
			}
		}
		//内部定义搜索方法
		public boolean search(String data) {
			//判断当前节点的名字是否与查找的一致，如果一致返回true
			if (data.equals(this.data)) {
				return true;
			} else {
				//继续判断下一个，如果下个节点存在，则继续查找，返回下一个的查询结果
				if (this.next != null) {
					return this.next.search(data);
				} else {
					return false;//节点不存在返回false
				}
			}
		}
		//删除节点
		public void delete(Node pre, String data) {
			//找到匹配的节点
			if (data.equals(this.data)) {
				pre.next = this.next;
			} else {
				if (this.next != null) {
					this.next.delete(this, data);//继续向下查找
				}
			}
		}
	};
	/**
	 * 表示根节点
	 */
	private Node rootNode;
	//增加根节点的方法
	public void add(String data) {
//		建立一个新的节点
		Node node = new Node(data);
		//没有根节点，将第一个节点设置为根节点
		if (this.rootNode == null) {
			this.rootNode = node;
		} else {
			//添加到合适的位置
			this.rootNode.add(node);
		}
	}
	//打印全部节点
	public void printNode() {
		//判断是否存在根节点
		if (this.rootNode != null) {
			this.rootNode.print();
		}
	}
	//判断元素是否存在
	public boolean contains(String name) {
		return this.rootNode.search(name);
	}
	//删除节点
	public void deleteNode(String data) {
		//如果节点存在，则直接进行删除操作
		if (this.contains(data)) {
			if (this.rootNode.data.equals(data)) {
				this.rootNode = this.rootNode.next;
			} else {
				this.rootNode.next.delete(rootNode, data);
			}
		}
	}
}
