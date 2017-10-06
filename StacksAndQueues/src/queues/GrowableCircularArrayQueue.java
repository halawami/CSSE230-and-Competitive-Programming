package queues;

import java.lang.reflect.Array;
import java.util.Arrays;
import java.util.NoSuchElementException;

/**
 * A circular queue that grows as needed.
 * 
 * @author Matt Boutell and <<<David Mason and Hussein Alawami>>>
 * @param <T>
 */
public class GrowableCircularArrayQueue<T> implements SimpleQueue<T> {
	// DONE: Declare this class to implement SimpleQueue<T>, then add the
	// missing methods (Eclipse will help).

	// DONE: The javadoc for overridden methods is in the SimpleQueue interface.
	// Read it!

	private static final int INITIAL_CAPACITY = 5;

	private T[] array;
	private Class<T> type;
	private boolean isArrayFull = false;
	private int count = 0;
	private int countDeq = 0;
	private boolean isOrdered = false;

	/**
	 * Creates an empty queue with an initial capacity of 5
	 * 
	 * @param type
	 *            So that an array of this type can be constructed.
	 */
	@SuppressWarnings("unchecked")
	public GrowableCircularArrayQueue(Class<T> type) {
		this.type = type;
		// This is a workaround due to a limitation Java has with
		// constructing generic arrays.
		this.array = (T[]) Array.newInstance(this.type, INITIAL_CAPACITY);
	}

	/**
	 * Displays the contents of the queue in insertion order, with the
	 * most-recently inserted one last, in other words, not wrapped around. Each
	 * adjacent pair will be separated by a comma and a space, and the whole
	 * contents will be bounded by square brackets. See the unit tests for
	 * examples.
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append("[");
		if (this.isOrdered && this.array[0] != null) {
			for (int i = 0; i < this.array.length; i++) {
				if (this.array[i] != null) {
					sb.append(this.array[i]);
					if (i < this.size() - 1) {
						sb.append(", ");
					}
				}
			}
		} else {
			for (int i = 0; i < this.array.length; i++) {
				if (this.array[(this.array.length + this.countDeq + i) % this.array.length] != null) {
					if ((this.array.length + this.countDeq + i) % this.array.length == this.countDeq) {
						sb.append(this.array[(this.array.length + this.countDeq + i) % this.array.length]);
					} else if ((this.array.length + this.countDeq + i) % this.array.length != this.countDeq) {
						sb.append(", " + this.array[(this.array.length + this.countDeq + i) % this.array.length]);
					}
				} else if (this.isOrdered && this.array[i] != null) {
					sb.append(this.array[i]);
					if (i < this.size() - 1) {
						sb.append(", ");
					}
				}
			}
		}
		sb.append("]");
		return sb.toString();
	}

	@Override
	public void clear() {

		this.array = (T[]) Array.newInstance(this.type, INITIAL_CAPACITY);
		this.count = 0;
		this.countDeq = 0;
	}

	@Override
	public void enqueue(T item) {
		for (int i = 0; i < this.array.length; i++) {
			if (this.array[i] == null) {
				this.array[i] = item;
				this.count++;
				return;
			}
			if (i == this.array.length - 1) {
				this.isArrayFull = true;
			}
		}

		if (this.countDeq > 0 && this.isArrayFull == false) {
			for (int i = 0; i <= this.countDeq; i++) {
				this.array[i] = item;
				this.count++;
				return;
			}
		}
		if (this.isArrayFull = true || this.array.length == (this.count - this.countDeq)) {
			T[] copyArray = this.array;
			this.array = (T[]) Array.newInstance(this.type, this.array.length * 2);
			for (int i = 0; i < copyArray.length; i++) {
				this.array[i] = copyArray[(copyArray.length + i + this.countDeq) % copyArray.length];
				isOrdered = true;
			}
			this.isArrayFull = false;
		}
		enqueue(item);
	}

	@Override
	public T dequeue() throws NoSuchElementException {
		// Done Auto-generated method stub
		this.isOrdered = false;
		if (this.count - this.countDeq == 0) {
			throw new NoSuchElementException();
		}
		T item = null;
		for (int i = 0; i < this.array.length; i++) {
			if (this.array[i] != null) {
				item = this.array[i];
				this.array[i] = null;
				this.countDeq++;
				return item;
			}
		}
		return item;
	}

	@Override
	public T peek() throws NoSuchElementException {
		if (this.count - this.countDeq == 0) {
			throw new NoSuchElementException();
		}
		return this.array[this.countDeq];
	}

	@Override
	public boolean isEmpty() {
		return this.count == 0;
	}

	@Override
	public int size() {
		return this.count - this.countDeq;
	}

	@Override
	public boolean contains(T item) {
		// Done Auto-generated method stub
		for (int i = 0; i < this.array.length; i++) {
			if (this.array[i] == item) {
				return true;
			}
		}
		return false;
	}

	@Override
	public String debugString() {
		// Done Auto-generated method stub
		return Arrays.toString(this.array);
	}

}
