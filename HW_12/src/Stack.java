
public class Stack<T> extends SinglyLinkedList<T>{

	public void push(T data) {
		this.prepend(new Node<T>(data,null,null));
	}
	
	public T pop() {
		Node<T> temp = this.firstNode;
		this.remove(this.firstNode.value);
		return temp.value;
	}
	
	public T peek() {
		return this.firstNode.value;
	}
	
	//Inherits is empty and length
}
