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
	public static Node<Integer> insertBefore(Node<Integer> fst,Node<Integer> be, Node<Integer> pt ){
		Node<Integer> tmp = fst;
		if(be == fst){
			pt.setNext(fst);
			fst = pt;
		}
		while(!(tmp.getNext() ==  be && tmp.hasNext())){
			
			tmp = tmp.getNext();
		}
		if(tmp.getNext() == be)
		tmp.setNext(pt);
		
		tmp = null;
		return fst;
		
	}
	
	public static Node<Integer> remove(Node<Integer> fst, Node<Integer> pt){
		if(fst == pt){
			pt = fst.getNext();
			fst = pt;
			return fst;
		}
		Node<Integer> tmp = fst;
		while(!(tmp.getNext() ==  pt && tmp.hasNext())){
			tmp = tmp.getNext();
		}
		tmp.setNext(pt.getNext());
		tmp = null;
		
		return fst;
		
	}
	
	public static Node<Integer> findMin(Node<Integer> fst){
		Node<Integer> tmp = fst;
		Node<Integer> val = new Node<Integer>(null);
		
		while(tmp.hasNext()){
			if(val.getValue() > tmp.getValue())
			val.setValue(tmp.getValue());
			
			tmp = tmp.getNext();
		}
		return val;
	}
	
	public static Node<Integer> sort(Node<Integer> fst){
		Node<Integer> curr;
		Node<Integer> tmp;
		tmp = new Node<Integer>(findMin(fst).getValue());
		curr = tmp;
		while(fst.hasNext()){
			curr.setNext(findMin(fst));
			remove(fst,findMin(fst));
			curr = curr.getNext();
		}
		fst = tmp;
		return fst;
	}
	
	public static Node<Integer> merge(Node<Integer> fst,Node<Integer> fst1){
		Node<Integer> fst2 = new Node<Integer>(null);
		Node<Integer> curr = fst;
		
		if(fst.getValue() <= fst1.getValue()){
			fst2.setValue(fst.getValue());
			fst = fst.getNext();
			fst1 = fst1.getNext();
		}else{
			fst2.setValue(fst1.getValue());
			fst = fst.getNext();
			fst1 = fst1.getNext();
		}
		while(fst.hasNext() && fst1.hasNext()){
			if(fst.getValue() <= fst1.getValue()){
				curr.setNext(fst);
				fst = fst.getNext();
				fst1 = fst1.getNext();
			}else{
				curr.setNext(fst1);
				fst = fst.getNext();
				fst1 = fst1.getNext();
			}
		}
		return fst2;
		
	}
	
}
