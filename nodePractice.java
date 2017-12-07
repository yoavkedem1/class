import DS.*;
public class nodePractice
{
	public static void main(String[] args)
	{
		Node<Integer> node = listGen(10,5,1);
		System.out.println(listSize(node));
		System.out.println(strList(node));

	}
	
	public static Node<Integer> listGen(int size, int max, int low){
		int range = (max-low)+1;
		Node<Integer> fst = new Node<Integer>((int)(Math.random()*range +1));
		Node<Integer> curr = fst;
		Node<Integer> tmp = new Node<Integer>((int)(Math.random()*(range)));
		
		for(int i = 0; i < size; i++){
		tmp = new Node<Integer>((int)(Math.random()*range)+1);
		curr.setNext(tmp);
		curr = curr.getNext();
		}
		curr = null;
		return fst;
	}
	
	public static int listSize(Node<Integer> fst){
		int size = 0;
		Node<Integer> curr = fst;
		while(curr.hasNext()){
			size++;
			curr = curr.getNext();
		}
		curr = null;
		return size;
	}
	public static String strList(Node<Integer> fst){
		Node<Integer> curr = fst;
		String st = "";
		if(curr.hasNext()){
		curr = curr.getNext();
		st = strList(curr) + " --> " + curr.toString();
		}
		st = st + fst.getValue();
		curr = null;
		return st;
	}
	public static Node<Integer> getIt(Node<Integer> fst, int val){
		Node<Integer> curr = fst;
		Node<Integer> tar = new Node<Integer>(0);
		
		while(curr.hasNext()){
			
			if(curr.getValue() == val){
				tar = curr;
			}else{
				curr = curr.getNext();
			}
		}
		return tar;
	}
	public static boolean findIt(Node<Integer> fst, int val){
		boolean tof = false;
		Node<Integer> curr = fst;
		
		while(curr.hasNext()){
			
			if(curr.getValue() == val){
				tof = true;
			}else{
				curr = curr.getNext();
			}
		}
		return tof;
	}
	public static void insertAfter(Node<Integer> aft, Node<Integer> pt){
		
		pt.setNext(aft);
		pt = pt.getNext();
		aft = aft.getNext();
		
	}
}
