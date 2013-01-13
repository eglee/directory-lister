public class LinkedList
{
		/*
			Edward Lee
			CISC231
			11/09/11
			Linked List
		*/

	Node currentNode; //points to current node
	Node firstNode; //points to first node
	int size; //points to number of nodes in list

	public LinkedList()
	{
		this.firstNode = null;
		this.currentNode = null;
		this.size = 0;
	}

	public boolean atEnd()
	{
		checkCurrent();
		return getCurrent().getNext() == null;
	}//Returns true if the current position in the list is null

	public boolean isEmpty()
	{
		return getListPtr() == null;
	}//Returns true if list pointer to the list is null

	public void first()
	{
		setCurrent(getListPtr());
	}//Makes the first node in the list the current position

	public void next()
	{
		checkCurrent();
		if (this.isEmpty()) {throw new ListEmptyException("list empty");}
		setCurrent(getCurrent().getNext());
	}//Makes the next node in the list the current position

	public void last()
	{
		first();
		while (!atEnd()){ next(); }
	}//Makes the last node in the list the current position

	public Object getData()
	{
		checkCurrent();
		return getCurrent().getData();
	}//Returns data part of the current Node

	public void insertBeforeCurrentNode(Object obj)
	{
		boolean foundCurrent; //returns true once current node is found
		Node newNode; //new node to be allocated
		Node traverse; //holds postion in list while traversing towards current node
		
		checkCurrent();
		foundCurrent = false;
		traverse = getListPtr();
		newNode = allocateNode();
		newNode.setData(obj);

		if(isEmpty())
		{
			setCurrent(newNode);
			setListPtr(getCurrent());
		}
			else if (size() == 1 || getListPtr() == getCurrent())
			{
				newNode.setNext(getCurrent());
				setListPtr(newNode);
			}
				else
				{
					 while(traverse.getNext() != null && !foundCurrent)
					{
						if(traverse.getNext() == getCurrent())
						{
							newNode.setNext(traverse.getNext());
							traverse.setNext(newNode);
							foundCurrent = true;
						}
						traverse = traverse.getNext();
					}
				}

	}//Inserts a new node before the current node

	public void insertAfterCurrentNode(Object obj)
	{
		Node temp; //will hold the next node following the current node
		Node newNode; //new node to be allocated

		newNode = allocateNode();
		newNode.setData(obj);

		temp = null;
		
		if(isEmpty())
		{
			setCurrent(newNode);
			setListPtr(getCurrent());
		}
			else
			{
				checkCurrent();
				temp = getCurrent().getNext();
				getCurrent().setNext(newNode);
				newNode.setNext(temp);
			}
	}//Inserts a node after the current node

	public void insert(Object obj)
	{
		insertAfterCurrentNode(obj);
	}//Convenience method that calls insertAfterCurrentNode

	public Object deleteCurrentNode()
	{
		Node current; //points to current node
		Object data; //holds data of current node
		Node previousToCurrent; //holds the position of the node before current node during list traversal
		
		if(isEmpty()){ throw new ListEmptyException("Can't delete, list is empty"); }
		
		checkCurrent();
		data = getCurrent().getData();
		current = getCurrent();
	
		if (size() == 1 || getCurrent() == getListPtr()) //one node on list
		{
			setListPtr(getCurrent().getNext());
		}
			else
			{
				previousToCurrent = getListPtr();

				while(previousToCurrent.getNext() != getCurrent())
				{
					previousToCurrent = previousToCurrent.getNext();
				}
				previousToCurrent.setNext(getCurrent().getNext());//skip over current node
			}
		if(!isEmpty())
		{ 
			setCurrent(getCurrent().getNext());
		}
			
		deAllocateNode(current);
		
		return data;
	}//Deletes the node pointed to by current

	public Object deleteFirstNode(boolean delete)
	{
		Object data; //holds data of current node
		Node firstNode; //holds pointer to the first node

		if(isEmpty()) { throw new ListEmptyException ("Can't delete, list is empty"); }
		
		data = getListPtr().getData();
		firstNode = getListPtr();
		
		setListPtr(getListPtr().getNext());
		deAllocateNode(firstNode);
		
		if(delete) { setCurrent(getListPtr()); }
		
		return data;
	}//Deltes the first node on the list

	public Object deleteFirstNode()
	{
		return deleteFirstNode(true);
	}//Passes true to deleteFirstNode method

	public int size()
	{
		return this.size;
	}//Returns intsance variable size

	public String toString()
	{
		boolean done; //false until end of list
		Node traverse; //holds a node during list traveral
		String string; //string to be printed of data part of nodes on list
		
		traverse = getListPtr();
		string = "List contains " + this.size() + " nodes:";

		done = false;

		if (!isEmpty())
		{
			while(traverse != null && !done)
			{
				if (traverse == null) {done=true;}
				string = string + " " + traverse.getData();
				traverse = traverse.getNext();

			}
		}
			else {string = "List contains " + size + " nodes:";}
			
		return string;
	}//Outputs data nodes on the list


	////Private Methods////

	private Node allocateNode()
	{
		this.size = this.size + 1;
		return new Node();
	}// Returns new Node reference and increments the size instance variable

	private void deAllocateNode(Node node)
	{
		this.size = this.size - 1;
		node.setData(null);
		node.setNext(null);
	}//Sets data and link part of passed Node to null

	private Node getListPtr()
	{
		return this.firstNode;
	}//Acecessor for list pointer instance variable

	private void setListPtr(Node node)
	{
		this.firstNode = node;
	}//Mutator for list pointer instance variable

	private Node getCurrent()//change
	{
		return this.currentNode;
	}//Accessor for the curren node pointer instance variable

	private void setCurrent(Node node)
	{
		this.currentNode = node;
	}//Mutator for the current node pointer instance variable

	private void checkCurrent()
	{
		if (getCurrent() == null) { throw new InvalidPositionInListException ("current node is null"); }
	}//Checks current node reference for null

	////Node Class////

	private class Node
	{
		Object data; //holds data part of node
		Node next; //holds reference to next node

		public Node()
		{
			this.next = null;
			this.data = null;
		}

		public Object getData()
		{
			return this.data;
		}

		public void setData(Object set)
		{
			this.data = set;
		}

		public Node getNext()
		{
			return this.next;
		}

		public void setNext(Node newNext)
		{
			this.next = newNext;
		}

		public String toString()
		{
			return this.data.toString();
		}
	}



}