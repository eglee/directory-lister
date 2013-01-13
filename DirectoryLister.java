import java.io.File;

public class DirectoryLister
{
	/*
		Edward Lee
		CISC231
		11/10/11
		Traverses a directory hierarchy depth first, and outputs a preorder traversal
	*/

	private int maxDepthAllowed;
	private File startingDirectory;
	private int fileQueueSize;
	
	public DirectoryLister(File startingDirectory, int maxDepthAllowed)
		{
			this.startingDirectory = startingDirectory;
			this.maxDepthAllowed = maxDepthAllowed;
			this.fileQueueSize = 0;
		}
		
	private Queue populateQueue(File directory)
	{
		int length;
		String[] list;
		File[] listFiles;
		Queue queue;
		
		listFiles = directory.listFiles();
		list =  directory.list();
		length = list.length;
		queue = new Queue();
		
		
		for (int i = 0; i < length; i++)
		{
			if (listFiles[i].isDirectory() == true)
			{
				queue.enqueue(listFiles[i]);
			}
		}
		
		for (int i = 0; i < length; i++)
		{
			if (listFiles[i].isFile() == true)
			{
				queue.enqueue(listFiles[i]);
				fileQueueSize = fileQueueSize + 1;
			}
		}
		return queue;
	}//populate queue with files and directories
	
	public void run()
	{
		File dequeuedFile;
		Stack dirStack;
		Queue fileQueue;
		
		dirStack = new Stack();
		fileQueue = populateQueue(startingDirectory);
		
		dirStack.push(fileQueue);//push first queue onto stack
		
		while(!dirStack.isEmpty())
		{
			fileQueue = (Queue) dirStack.pop();//pop queue off stack
			
			while(!fileQueue.isEmpty())
			{
				dequeuedFile = (File) fileQueue.dequeue();//dequeue to check if file or directory
				
				if(dequeuedFile.isFile())
				{
					System.out.println(dequeuedFile.getName() + "\n");//print name if file
				}
				if(dequeuedFile.isDirectory())
				{
					dirStack.push(fileQueue);//push back on queue
					fileQueue = populateQueue(dequeuedFile);//populate new queue to be examined
				} 
			} 
		}
	}//run() method
}