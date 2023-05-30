class EvenNumberPrinter implements Runnable 
{
    @Override
    public void run() 
    {
        for(int i=2;i<=10;i=i+2) 
        {
        	System.out.println("Even Number:" + i);
        	try
        	{
        		Thread.sleep(100);
        	}
        	catch(InterruptedException e)
        	{
        		System.out.print(e);
        	}
        }
    }
}
class OddNumberPrinter implements Runnable 
{
    @Override
    public void run() 
    {
        for(int i=1;i<=10;i=i+2) 
        {
            System.out.println("Odd Number:" + i);
            try
            {
            	Thread.sleep(1000);
            }
            catch(InterruptedException e)
            {
            	System.out.print(e);
            }
        }
    }
}
public class JavaQue8 {

	public static void main(String[] args) {
		Thread evenThread = new Thread(new EvenNumberPrinter());
        Thread oddThread = new Thread(new OddNumberPrinter());
        evenThread.start();
        oddThread.start();
	}
}
