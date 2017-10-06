import java.util.LinkedList;
import java.util.Queue;

/**
 * 
 * A chain implemented using a Queue (FIFO fashion)
 *
 * @author xiek and Hussein Alawami.
 *         Created Sep 21, 2017.
 */

public class QueueChainManager extends ChainManager {
	Queue<Chain> que;
	
	public QueueChainManager() {
		this.que = new LinkedList<>();
	}

	@Override
	public void add(Chain chain) {
		this.que.add(chain);
		this.updateMax(que.size());
	}

	@Override
	public Chain next() {
		this.incrementNumNexts();
		return this.que.poll();
	}

	@Override
	public boolean isEmpty() {
		return this.que.isEmpty();
	}

}
