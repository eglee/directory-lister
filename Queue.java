public class Queue
{
	/*
		Edward Lee
		CISC231
		11/10/11
		Creates a queue that allows Objects to be enqueued or dequeued in a first in first out algorithm
	*/
	
	private LinkedList newList;
	
	public Queue()
	{
		this.newList = new LinkedList();
	}//Create a new linked list to represent the queue

	public boolean isEmpty()
	{
		return newList.isEmpty() == true;
	}
	
	public boolean isFull()
	{
		return true;
	}

	public Object dequeue()
	{
		Object temp;
	
		if (isEmpty()) {throw new QueueUnderflowException("Queue is empty, can't dequeue()");}
		
		temp = newList.deleteFirstNode();
		
		return temp;
	} //Removes front element of queue (first in, first out)
	
	
	public void enqueue(Object obj)
	{
		newList.insert(obj);
		newList.last();
	}//Enqueues new element onto queue

	public int size()
	{
		return newList.size();
	} //returns size of queue;
}