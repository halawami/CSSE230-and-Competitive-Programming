package queues;

import java.util.NoSuchElementException;
import java.util.Stack;

public class QueueFromStacks<T> implements SimpleQueue<T> {

	private Stack<T> stackTemp =new Stack();
	private Stack<T> stackOrig = new Stack();
	private int countDeq = 0;
	
	
	@Override
	public String toString(){
		if(this.countDeq == 0){
			return this.stackTemp.toString();
		}
			StringBuilder sb = new StringBuilder();
			sb.append("[");
			for(int i = this.countDeq;i<this.stackTemp.size();i++){
				if(this.stackTemp.get(i)!=null){
					sb.append(this.stackTemp.get(i));
					if (i < this.stackTemp.size() - 1) {
						sb.append(", ");
					}
				}
			}
			sb.append("]");
			return sb.toString();		
	}
	
	@Override
	public void clear() {
		// TODO Auto-generated method stub.
		this.stackOrig = new Stack();
		this.stackTemp = new Stack();
	}

	@Override
	public void enqueue(T item) {
		// TODO Auto-generated method stub.
		this.stackTemp.push(item);
	}
	
	public void moveData(){
		for(int i =this.stackTemp.size()-1;i>=0;i--){
				this.stackOrig.push(this.stackTemp.get(i));
		}
		
	}

	@Override
	public T dequeue() throws NoSuchElementException {
		// TODO Auto-generated method stub.
		this.countDeq++;
		if(this.stackOrig.size()==0){
			moveData();
		}
		if(this.stackOrig.size()!=0){
			T item = this.stackOrig.peek();
			this.stackOrig.pop();
			return item;
		}
		throw new NoSuchElementException();
	}

	@Override
	public T peek() throws NoSuchElementException {
		// TODO Auto-generated method stub.
		if(this.stackOrig.size()==0){
			moveData();
		}
		if(this.stackOrig.size()>0){
			return this.stackOrig.get(0);
		}
		throw new NoSuchElementException();
	}

	@Override
	public boolean isEmpty() {
		// TODO Auto-generated method stub.
		if(this.stackTemp.isEmpty()&&this.stackOrig.isEmpty()){
			return true;
		}
		return false;
	}

	@Override
	public int size() {
		// TODO Auto-generated method stub.
		return this.stackOrig.size() + this.stackTemp.size();
	}

	@Override
	public boolean contains(T item) {
		// TODO Auto-generated method stub.
		if(this.stackOrig.size()==0){
			moveData();
		}
		for(int i =0;i<this.stackOrig.size();i++){
			if(this.stackOrig.get(i).equals(item)){
				return true;
			}
		}
		return false;
	}

	@Override
	public String debugString() {
		// TODO Auto-generated method stub.
		return null;
	}

}
