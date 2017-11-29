import unit4.utilsLib.Date;
import DS.Queue;
import DS.Stack;
public class Practice
{
	public static void main(String[] args){
		
		
	}
	
	public static void moveQ(Queue<Integer> q1, Queue<Integer> q2)
	{
		while (!q1.isEmpty())
			q2.insert(q1.remove());
	}

	public static int sizeQ(Queue<Integer> q1)
	{
		int len = 0;
		Queue<Integer> q2 = new Queue<Integer>();
		Queue<Integer> temp = new Queue<Integer>();
		moveQ(q1, q2);

		while (!q2.isEmpty())
		{
			len++;
			temp.insert(q2.remove());
		}
		moveQ(temp, q1);

		return len;
	}

	public static int occInQueue(Queue<Integer> q1, int n)
	{
		int count = 0;
		Queue<Integer> q2 = new Queue<Integer>();
		Queue<Integer> temp = new Queue<Integer>();
		moveQ(q1, q2);

		while (!q2.isEmpty())
		{
			if (n == q2.head())
				count++;
			temp.insert(q2.remove());
		}
		moveQ(temp, q1);

		return count;

	}

	public static boolean inQueue(Queue<Integer> q1, int n)
	{
		boolean inOrNot = false;
		Queue<Integer> q2 = new Queue<Integer>();
		Queue<Integer> temp = new Queue<Integer>();
		moveQ(q1, q2);

		while (!q2.isEmpty())
		{
			if (n == q2.head())
				inOrNot = true;
			temp.insert(q2.remove());
		}
		moveQ(temp, q1);

		return inOrNot;
	}

	public static Queue<Integer> remVal(Queue<Integer> q1, int val)
	{
		Queue<Integer> q2 = new Queue<Integer>();

		while (!q1.isEmpty())
		{
			int x = q1.remove();
			if (x != val)
				q2.insert(x);
		}
		moveQ(q2, q1);
		return q1;
	}
	static int occInQ(Queue<Integer> Q, int n) // returns the number of times n
	// appears in Q
	{
		int N = 0;
		Queue<Integer> temp = new Queue<Integer>();
		while (!Q.isEmpty())
		{
			if (Q.head() == n)
				N++;
			temp.insert(Q.remove());
		}
		moveQ(temp, Q);
		return N;
	}
	static void remQueDup2(Queue<Integer> Q) // removes all the duplicate
	// values from the queue
	{
		Queue<Integer> temp = new Queue<Integer>();
		while (!Q.isEmpty())
		{
			for (int i = occInQ(Q, Q.head() - 1); i > 0; i--)
				remVal(Q, Q.head());
			temp.insert(Q.remove());
		}
		moveQ(temp, Q);
	}
	public static Queue<Integer> remQueueDup(Queue<Integer> q1)
	{
		int temp;
		Queue<Integer> q2 = new Queue<Integer>();
		Queue<Integer> q3 = new Queue<Integer>();

		while (!q1.isEmpty())
		{
			temp = q1.remove();
			moveQ(q1, q2);

			while (!q2.isEmpty())
			{
				if (temp != q2.head())
					q3.insert(q2.remove());
				else
					q2.remove();
			}
		}
		// moveQ(q2, q1);

		return q3;
	}

	public static int findSmallest(Queue<Integer> q1)
	{
		int temp, min = q1.head();
		Queue<Integer> q2 = new Queue<Integer>();

		while (!q1.isEmpty())
		{
			temp = q1.remove();
			if (temp < min)
				min = temp;
			q2.insert(temp);
		}

		moveQ(q2, q1);

		return min;
	}

	public static Queue<Integer> mergeNotSortedQ(Queue<Integer> q1,
			Queue<Integer> q2)
	{
		Queue<Integer> q3 = new Queue<Integer>();
		int min1 = 0, min2 = 0;

		while (!q1.isEmpty() && !q2.isEmpty())
		{
			min1 = findSmallest(q1);
			min2 = findSmallest(q2);
			if (min1 <= min2)
			{
				for (int i = 0; i < occInQueue(q1, min1); i++)
					q3.insert(min1);
				remVal(q1, min1);
			}
			else
			// (findSmallest(q1) > findSmallest(q2))
			{
				for (int i = 0; i < occInQueue(q2, min2); i++)
					q3.insert(min2);
				remVal(q2, min2);
			}

		}
		if (!q1.isEmpty())
		{
			while (!q1.isEmpty())
			{
				min1 = findSmallest(q1);
				for (int i = 0; i < occInQueue(q1, min1); i++)
					q3.insert(min1);
				remVal(q1, min1);
			}
		}
		else
		{
			while (!q2.isEmpty())
			{
				min2 = findSmallest(q2);
				for (int i = 0; i < occInQueue(q2, min2); i++)
					q3.insert(min2);
				remVal(q2, min2);

			}
		}

		return q3;
	}

	public static Queue<Integer> mergeSortedQ(Queue<Integer> q1,
			Queue<Integer> q2)
	{
		Queue<Integer> q3 = new Queue<Integer>();
		int min1 = 0, min2 = 0, bigLen = Math.max(sizeQ(q1), sizeQ(q2));

		while (bigLen > 0)
		{
			min1 = q1.remove();
			min2 = q2.remove();
			if (min1 <= min2)
			{
				q3.insert(min1);
				q3.insert(min2);
			}
			else
			{
				q3.insert(min2);
				q3.insert(min1);
			}
			bigLen--;
		}

		return q3;
	}

	public static Queue<Integer> sortQ(Queue<Integer> q1)
	{
		Queue<Integer> q2 = new Queue<Integer>();
		int temp;

		while (!q1.isEmpty())
		{
			temp = findSmallest(q1);
			remVal(q1, temp);
			q2.insert(temp);

		}
		moveQ(q2, q1);

		return q1;
	}

	public static Queue<Integer> insQue(Queue<Integer> q1, int num)
	{
		Queue<Integer> q2 = new Queue<Integer>();

		if (q1.head() > num)
		{
			q2.insert(num);
			moveQ(q1, q2);

		}
		else
		{
			q1.insert(num);
			sortQ(q1);
		}

		moveQ(q2, q1);
		return q1;
	}
	
	public static void genDate(Queue<Date> q1){
		
		for(int i = 0; i < 100; i++){
			q1.insert(new Date((int)Math.random()*30 + 1,(int) Math.random()*12 + 1,(int) Math.random()*2017 + 1));
		}
		
	}
	
	public static void sortQDate(Queue<Date> q1){
		Queue<Date> q2 = new Queue<Date>();
		while(!q1.isEmpty()){
		int min = q1.head().getYear();
		while(!q1.isEmpty()){
			if(q1.head().getYear() < min)
			min = q1.head().getYear();
		}
		q2.insert(remValDate(q1, min));
		}
		moveQDate(q2,q1);
	}
	
	public static Date remValDate(Queue<Date> q1, int val)
	{
		Queue<Date> q2 = new Queue<Date>();
		Date x = q1.head();
		while (!q1.isEmpty())
		{
			 x = q1.remove();
			if (x.getYear() != val)
				q2.insert(x);
		}
		moveQDate(q2, q1);
		return x;
	}
	public static void moveQDate(Queue<Date> q1, Queue<Date> q2)
	{
		while (!q1.isEmpty())
			q2.insert(q1.remove());
	}
	public static Queue<Date> insQueDate(Queue<Date> q1, Date d)
	{
		Queue<Date> q2 = new Queue<Date>();

		if (q1.head().getYear() > d.getYear()){
			q2.insert(d);
			moveQDate(q1, q2);

		}
		else
		{
			q1.insert(d);
			sortQDate(q1);
		}

		moveQDate(q2, q1);
		return q1;
	}
}
