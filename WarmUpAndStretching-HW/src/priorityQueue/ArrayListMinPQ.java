package priorityQueue;
import java.util.ArrayList;
import java.util.Collections;

/**
 * An implementation of the Priority Queue interface using an array list.
 * 
 * @author Matt Boutell and Hussein Alawami. Created Mar 29, 2014.
 * 
 * @param <T>
 *            Generic type of PQ elements
 */
public class ArrayListMinPQ<T extends Comparable<T>> {
	// Requirement: You must use this instance variable without changes.
	private ArrayList<T> items;

	public ArrayListMinPQ() {
		// Done: implement
		
		items = new ArrayList<T>();
		Collections.sort(items);
	}

	public T findMin() {
		// This is also known as peekMin
		// done: implement
		if(items.isEmpty()){
			return null;
		}return items.get(0);
	}

	public T deleteMin() {
		// done: implement
		if(items.isEmpty()){
			return null;
		}
		T min = items.get(0);
		items.remove(0);
		return min;
	}

	public void insert(T item) {
		// done: implement
		items.add(item);
		Collections.sort(items);
	}

	public int size() {
		// done: implement
		return items.size();
	}

	public boolean isEmpty() {
		// done: implement
		return items.isEmpty();
	}

	public void clear() {
		// done: implement
		items.clear();
	}
}
