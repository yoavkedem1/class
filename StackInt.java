import DS.Node;
public class StackInt{
	
	private Node<Integer> first;
	
	public StackInt(){
		this.first = null;
	}
	
	public boolean isEmpty(){
		return(this.first == null);
	}
	
	public int top(){
		return (this.first.getValue());
	}
	
	public void push(int val){
	Node<Integer> newVal = new Node<Integer>(val);
	newVal.setNext(this.first);
	this.first = newVal;
	}
	
	public void pop(){
	Node<Integer> newVal = this.first.getNext();
	this.first = newVal;
	}
	
	public String toString1(){
		
		Node<Integer> curr = this.first;
		String st = "";
		if(curr.hasNext()){
		curr = curr.getNext();
		st = toString1() + " --> " + curr.toString();
		}
		st = st + this.first.getValue();
		curr = null;
		return st;
	}
}