
public class Queue<T> extends SinglyLinkedList<T> {
	
	public void enqueue(T data) {
		this.append(new Node<T>(data,null,null));
	}
	
	public T dequeue() {
		Node<T> temp = this.firstNode;
		this.remove(this.firstNode.value);
		return temp.value;
	}
	
	public T peek() {
		return this.firstNode.value;
	}
	
	//Inherits is empty and length
}
