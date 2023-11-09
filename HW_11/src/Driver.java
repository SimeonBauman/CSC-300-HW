
public class Driver {
	public static void main(String[] args){
		SinglyLinkedList<String> s =  new SinglyLinkedList<String>();
		s.append(new Node<String>("Peter", null,null));
		s.append(new Node<String>("Andrew", null,null));
		s.append(new Node<String>("James", null,null));
		s.append(new Node<String>("John", null,null));
		s.append(new Node<String>("Philip", null,null));
		s.append(new Node<String>("Bartholomew", null,null));
		s.append(new Node<String>("Thomas", null,null));
		s.append(new Node<String>("Matthew", null,null));
		s.append(new Node<String>("James", null,null));
		s.append(new Node<String>("Thaddaeus", null,null));
		s.append(new Node<String>("Simon", null,null));
		s.append(new Node<String>("Judas", null,null));
		s.print();
		
		s.remove("Judas");
		s.print();
		
		s = SinglyLinkedList.sort(s);
		s.printReversed();
		
	}
}
