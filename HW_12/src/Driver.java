
public class Driver {
	public static void main(String[] args) {
		
		Stack<Integer> s = new Stack<Integer>();
		
		s.push(5);
		s.push(7);
		System.out.println(s.peek());
		System.out.println(s.pop());
		System.out.println(s.peek());
		
		Queue<Integer> q = new Queue<Integer>();
		q.enqueue(324);
		q.enqueue(93);
		System.out.println(q.peek());
		q.dequeue();
		System.out.println(q.peek());
	}
}
