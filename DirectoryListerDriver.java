import java.io.File;

public class DirectoryListerDriver
{
	/*
		Edward Lee
		CISC231
		11/10/11
		Drives the DirectoryLister class and its methods
	*/
	public static void main(String args[])
	{

		DirectoryLister dirLister = new DirectoryLister(new File("C:\\L0"), 5);
		dirLister.run();
	}
}