package list;

/**
 * 
 * @author anderson
 * 
 * @param <T>
 *            Any Comparable type
 * 
 *            A linked list whose elements are kept in sorted order.
 */
public class SortedLinkedList<T extends Comparable<T>> extends
		DoublyLinkedList<T> {

	/**
	 * Create an empty list
	 * 
	 */
	public SortedLinkedList() {
		super();
	}

	/**
	 * Creates a sorted list containing the same elements as the parameter
	 * 
	 * @param list
	 *            the input list
	 */
	public SortedLinkedList(DoublyLinkedList<T> list) {
		super();
//		SortedLinkedList<T> newList = new SortedLinkedList<T>(); //Instead of doing all this, I can just use this
		Node current = list.head.next;
		while(current.data != null){
			this.add(current.data);
			current = current.next;
		}
	}

	/**
	 * Adds the given element to the list, keeping it sorted.
	 */
	@Override
	public void add(T element) {
		// TODO: implement this method
		Node current = this.head;
			while(current.next.data != null && element.compareTo(current.next.data)>=0){
				current=current.next;
				}
			current.addAfter(element);
	}

	@Override
	public void addFirst(T element){
		// TODO: throw UnsupportedOperationException exception
		throw new UnsupportedOperationException();
	}

	@Override
	public void addLast(T element){
		// TODO: throw UnsupportedOperationException exception
		throw new UnsupportedOperationException();
	}
}
