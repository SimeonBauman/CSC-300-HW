public class Node<T> {

	public T value;
	public Node<T> next;
	public Node<T> previous;
	
	public Node(T value, Node<T> next, Node<T> previous) {
		this.value = value;
		this.next = next;
		this.previous = previous;
		if(previous != null) {
			previous.next = this;
		}
	}
	
	
	public void setPrevious(Node<T> n) {
		
		this.previous = n;
		
		n.next = this;
	}
}
	
	

