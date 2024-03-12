package Week7;
import com.usman.csudh.csc311.datastructures.Queue;
import com.usman.csudh.csc311.datastructures.QueueEmptyException;



public class LinkedQueue implements Queue{
	Node head;
	
	public LinkedQueue() {
		head = null;
	}
	@Override
	public void add(int data) {
		Node current = head;
		// Create a new node, which should be added to the end of the list
		Node newNode = new Node(data);

		// Find the tail of the list
		Node tail = findTail();

		/*If the list is empty, then this node will become the first item (HEAD)
		 else this node will be added to the end of the current TAIL, effectively
		 becoming the new TAIL 
		 */
		if (tail == null) {
			head = newNode;
		} else {
			newNode.next = head;
			head = newNode;
		}
	}

	@Override
	public int remove() throws QueueEmptyException {
		Node current = head;
		while (current.next.next != null) {
			current = current.next;
		}
		int deleted = current.next.data;
		current.next = null;
		return deleted;
	}

	@Override
	public int peek() throws QueueEmptyException {
		return findTail().data;
	}

	@Override
	public int size() {
		Node current = head;
		int size = 0;
		while (current != null) {
			size++;
			current = current.next;
		}
		return size;
	}

	@Override
	public boolean isEmpty() {
		Node tail = findTail();
		boolean empty = (tail == null) ? true : false;
		return empty;
	}

	@Override
	public void clear() {
		head = null;		
	}
	
	@Override
	public String toString() {
		Node current = head;
		String result = "";
		while (current != null) {
			result += current.data + " ";
			current = current.next;
		}
		return result;
	}
	
	private Node findTail() {
		if (head == null) {
			return null;
		}

		Node current = head;
		while (current.next != null) {
			current = current.next;
		}
		return current;
	}
	
	private class Node {

		int data;
		Node next;

		public Node(int data) {
			this.data = data;
			next = null;
		}

	}

}
