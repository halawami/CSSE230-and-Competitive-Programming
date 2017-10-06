import java.util.Stack;

/**
 * 
 * A chain implemented using a Stack (LIFO fashion)
 *
 * @author xiek and Alawamhm.
 *         Created Sep 21, 2017.
 */

public class StackChainManager extends ChainManager {
	Stack<Chain> stk;
	
	public StackChainManager() {
		this.stk = new Stack<>();
	}
	
	@Override
	public void add(Chain chain) {
		this.stk.push(chain);
		this.updateMax(stk.size());
	}

	@Override
	public Chain next() {
		this.incrementNumNexts();
		return this.stk.pop();
	}

	@Override
	public boolean isEmpty() {
		return this.stk.isEmpty();
	}

}
