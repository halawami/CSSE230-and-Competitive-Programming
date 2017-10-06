import java.util.PriorityQueue;
import java.util.Queue;

public class PriorityQueueChainManager extends ChainManager {
	private Queue<Entry> que;
	private String target;

	public PriorityQueueChainManager(String end) {
		this.que = new PriorityQueue<>();
		this.target = end;
		
	}
	
	@Override
	public void add(Chain chain) {
		Entry entry = new Entry(chain);
		this.updateMax(this.que.size());
		this.que.add(entry);
	}

	@Override
	public Chain next() {
		this.incrementNumNexts();
		return this.que.poll().getChain();
	}

	@Override
	public boolean isEmpty() {
		return this.que.isEmpty();
	}
	
	private int distance(String s){
		if(s.equals(this.target))
			return 0;
		if(s.length()!=this.target.length())
			return -1;
		int cnt = 0;
		for(int i = 0; i<s.length();i++){
			if(s.charAt(i)!=target.charAt(i))
				cnt++;
		}
		return cnt;
	}
	
	private class Entry implements Comparable<Entry>{
		private Chain chain;
		private int value;
		
		public Entry(Chain chain){
			this.chain=chain;
			this.value = chain.length()+distance(chain.getLast());
		}
		
		public Chain getChain(){
			return this.chain;
		}

		@Override
		public int compareTo(Entry o) {
			return this.value-o.value;
		}
		
	}

}
