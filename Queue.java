import java.util.Iterator;

public class Queue<Item> implements Iterable<Item> {
	private Node head, tail;
	private int n;
	
	
	Queue() {
		head = tail = null;
		n = 0;
	}

	/**
	 * Node
	 */
	public class Node {
		Item elem;
		Node next;
		Node(Item elem, Node next) {
			this.elem = elem;
			this.next = next;
		}
	}

	public int size() {return n;}
	public boolean isEmpty() {return n == 0;}

	public void enqueue(Item item) {
		if(head == null) head = tail = new Node(item, null);
		else {
			tail.next = new Node(item, null);
			tail = tail.next;
		}
		n++;
	}

	public Item dequeue() {
		Item res = head.elem;
		head = head.next;
		n--;
		return res;
	}

	@Override
	public Iterator<Item> iterator() {
		return new QueueIterator();
	}

	/**
	 * QueueIterator
	 */
	public class QueueIterator implements Iterator<Item>{

		Node k = head;

		@Override
		public boolean hasNext() {
			return k != null;
		}

		@Override
		public Item next() {
			Item res = k.elem;
			k = k.next;
			return res;
		}	
	}
}
