
public class SinglyLinkedList<T> {
	public Node<T>[] nodes;
	public Node<T> firstNode;
	public Node<T> lastNode;
	public int size = 0;
	
	public void append(Node<T> n) {
		Node<T>[] temp = new Node[size+1];
		lastNode = n;
		for(int i = 0; i < size; i++) {
			temp[i] = nodes[i];
		}
		temp[size] = n;
		
		if(size>0)
			n.setPrevious(temp[size-1]);
		else 
			firstNode = n;
		
		nodes = temp;
		size++;
	}

	public void prepend(Node<T> n) {
		Node<T>[] temp = new Node[size+1];
		temp[0] = n;
		firstNode = n;
		for(int i = 0; i < size; i++) {
			temp[i+1] = nodes[i];
		}
		if(temp.length > 1)
		temp[1].setPrevious(n);
		
		
		nodes = temp;
		size++;
		
	}
	
	public void insertAfter(Node<T> n, T after) {
		Node<T>[] temp = new Node[size + 1];
		
		for(int i = 0; i<size; i++) {
			temp[i] = nodes[i];
		}
		temp[size] = n;
		Node<T> After = search(after);
		if(After != lastNode) {
			After.next.setPrevious(n);
		}
		else {
			this.lastNode = n;
		}
		n.setPrevious(After);
		nodes = temp;
		size++;
		
	}
	
	public void remove(T val) {
		Node<T> n = this.search(val);
		if(n.equals(lastNode)) {
			n.previous.next = null;
			lastNode = n.previous;
			
		}
		else if(n.equals(firstNode)) {
			n.next.previous = null;
			firstNode = n.next;
		}
		else {
			n.next.setPrevious(n.previous);
		}
		
		size--;
	}
	
	public void print() {
		int i =0;
		Node<T> currentNode = firstNode;
		
		while (i<size) {
			
			System.out.print(currentNode.value + ", ");
			currentNode = currentNode.next;
			i++;
		}
		
		System.out.println();
	}

	public void printReversed() {
		int i =0;
		Node<T> currentNode = lastNode;
		
		while (i<size) {
			if(currentNode != null) {
				
			
			System.out.print(currentNode.value + ", ");
			currentNode = currentNode.previous;
			}
			i++;
		}
		
		System.out.println();
	}
	
	public Node<T> search(T s) {
		for(int i =0; i<size;i++) {
			if(nodes[i].value == s) {
				return nodes[i];
			}
		}
		return null;
	}

	public int getLength() {
		return size;
	}
	
	public boolean isEmpty() {
		if(size ==0) {
			return true;
		}
		return false;
	}
	
	public static SinglyLinkedList<String> sort(SinglyLinkedList<String> s) {
		SinglyLinkedList<String> n = new SinglyLinkedList<String>();
		
		for(int i = 0; i < s.getLength(); i++) {
			for(int j = 0; j < s.getLength()-1; j++) {
				int num =1;
				int Min = Math.min(s.nodes[j].value.length(),s.nodes[j+1].value.length());
				for(int k = 0; k < num; k++) {
					if(s.nodes[j].value.charAt(k) > s.nodes[j+1].value.charAt(k) ){
						Node<String> Temp = s.nodes[j];
						s.nodes[j] = s.nodes[j+1];
						s.nodes[j+1] = Temp;
						
					}
					if(s.nodes[j].value.charAt(k) == s.nodes[j+1].value.charAt(k) && num < Min-1 ) {
						num++;
					}
				}
			}
		}
		
		for(int i =0; i < s.getLength();i++) {
			
			n.append(new Node<String>(s.nodes[i].value,null,null));
		}
		
		
		return n;
	}

}
