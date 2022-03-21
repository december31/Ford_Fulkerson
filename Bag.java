import java.util.Iterator;

public class Bag<Key> implements Iterable<Key>{
	private Node<Key> head;
	private int n;

	private static class Node<Key> {
		Key data;
		Node<Key> next;

		Node(Key data, Node<Key> next) {
			this.data = data;
			this.next = next;
		}
	}


	public Bag() {}

	public void add(Key data) {
		if(head == null) head = new Node<>(data, null);
		else head = new Node<Key>(data, head);
		n++;
	}

	public int size() {return n;}
	public boolean isEmpty() {return n == 0;}

	@Override
	public Iterator<Key> iterator() {
		return new BagIterator();
	}

	/**
	 * BagIterator
	 */
	public class BagIterator implements Iterator<Key>{

		Node<Key> k = head;
		@Override
		public boolean hasNext() {
			return k != null;
		}

		@Override
		public Key next() {
			Key d = k.data;
			k = k.next;
			return d;
		}	
	}	
}
