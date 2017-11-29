import DS.Stack;

public class QueueStk
{

	private Stack<Integer> stR; // comes remove -> pop

	private Stack<Integer> stI; // comes insert -> push

	public QueueStk()
	{
		this.stI = new Stack<Integer>();
		this.stR = new Stack<Integer>();
	}

	public boolean isEmpty()
	{
		return this.stI.isEmpty() && this.stR.isEmpty();
	}

	public int head()
	{
		while (!this.stI.isEmpty())
			this.stR.push(this.stI.pop());
		return this.stR.top();
	}

	public void insert(int x)
	{
		if (this.stI.isEmpty() && this.stR.isEmpty())
			this.stI.push(x);
		else
		{
			if (this.stI.isEmpty())
			{
				while (!this.stR.isEmpty())
					this.stI.push(this.stR.pop());
				this.stI.push(x);
			}
			else
				this.stI.push(x);
		}
		
		/*while (!this.stI.isEmpty())
		 * this.stR.push(this.stI.pop());
		 * this.stI.puch(x);
		 * */
	}

	public int remove()
	{
		while (!this.stI.isEmpty())
			this.stR.push(this.stI.pop());

		int x = this.stR.pop();

		return x;

	}

	public String toString()
	{
		return ("stR:" + this.stR + "  stI:" + this.stI);
	}
	// 4 5 6 -> 6 5 4
	// 4 5 6 (copy) -> 6 5 4 -> (pop)

}
