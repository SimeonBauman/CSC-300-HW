import java.util.*; 
public class Tree {

	public Node head = new Node();
	
	public Tree(int value) {
		head.value = value;
	}
	
	public void insertNode(int value) {
		boolean searching = true;
		Node currentNode = head;
		while(searching) {
			if(value < currentNode.value) {
				if(currentNode.lessNode == null) {
					Node temp = new Node();
					temp.value = value;
					currentNode.lessNode = temp;
					searching = false;
				}
				else {
					currentNode = currentNode.lessNode;
				}
			}
			else if(value > currentNode.value) {
				if(currentNode.greatNode == null) {
					Node temp = new Node();
					temp.value = value;
					currentNode.greatNode = temp;
					searching = false;
				}
				else {
					currentNode = currentNode.greatNode;
				}
			}
		}
	}

	public void removeNode(int value) {
		boolean searching = true;
		Node currentNode = head;
		while(searching) {
			
			if(value < currentNode.value) {
				if(currentNode.lessNode != null) {
					if(currentNode.lessNode.value == value) {
						currentNode.lessNode = null;
						searching = false;
					}
					else {
						currentNode = currentNode.lessNode;
					}

					
				}
				else {
					System.out.println("couldn't find node");
					searching = false;
				}
				
			}
			else if(value > currentNode.value) {
				if(currentNode.greatNode != null) {
					if(currentNode.greatNode.value == value) {
						currentNode.greatNode = null;
						searching = false;
					}
					else {
						currentNode = currentNode.lessNode;
					}

					
				}
				else {
					System.out.println("couldn't find node");
					searching = false;
				}
				
			}
			}
		}
	
	public void printTree() {
		String printVal = "";
		List<Node> currNodes = new ArrayList<Node>();
		currNodes.add(head);
		printVal += head.value + "\n";
		
		while(currNodes.size() > 0) {
			
				if(currNodes.get(0).lessNode !=null) {
					printVal += currNodes.get(0).lessNode.value + " ";
					currNodes.add(currNodes.get(0).lessNode);
				}
				if(currNodes.get(0).greatNode !=null) {
					printVal += currNodes.get(0).greatNode.value + " ";
					currNodes.add(currNodes.get(0).greatNode);
				}
				printVal += "\n";
				currNodes.remove(0);
			
		}
		System.out.print(printVal);
	}

}


