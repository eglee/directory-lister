public class Stack 
{
	/*
		Edward Lee
		CISC231
		11/10/11
		Stack implelmented with a linked list, can push or pop elements on or off stack
	*/

	private LinkedList newList;

	public Stack()
	{
		this.newList = new LinkedList();
	}//Create a new linked list to represent the stack
	
	public boolean isEmpty()
	{
		return newList.isEmpty() == true;
	}
	
	public boolean isFull()
	{
		return true;
	}
	
	public Object pop()
	{
		Object temp;
		
		if (isEmpty()) {throw new StackUnderflowException("Stack is empty, can't pop()");}

		newList.last();
		temp = newList.deleteCurrentNode();
		if(!newList.isEmpty()) { newList.last(); }
		
		return temp;
	}//Pops last element to go onto stack

	
	public void push(Object obj)
	{
		newList.insert(obj);
		newList.last();
	}//Pushes new element onto top of stack
	
	public int size()
	{
		return newList.size();
	}
}