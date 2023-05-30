import java.util.LinkedList;
import java.util.Queue;
import java.util.Random;
class Producer implements Runnable 
{
    private Queue<Integer> queue;
    private int capacity;
    public Producer(Queue<Integer> queue, int capacity) 
    {
        this.queue = queue;
        this.capacity = capacity;
    }
    @Override
    public void run() 
    {
        Random random = new Random();
        while(true) 
        {
            synchronized(queue) 
            {
                while(queue.size() == capacity) 
                {
                    try 
                    {
                        queue.wait();
                    } 
                    catch(InterruptedException e) 
                    {
                        e.printStackTrace();
                    }
                }
                int number = random.nextInt(100);
                queue.add(number);
                System.out.println("Produced: " + number);
                queue.notifyAll();
            }
        }
    }
}
class Consumer implements Runnable 
{
    private Queue<Integer> queue;

    public Consumer(Queue<Integer> queue) 
    {
        this.queue = queue;
    }
    @Override
    public void run() 
    {
        while(true) 
        {
            synchronized(queue) 
            {
                while(queue.isEmpty()) 
                {
                    try 
                    {
                        queue.wait();
                    } 
                    catch(InterruptedException e) 
                    {
                        e.printStackTrace();
                    }
                }
                int sum = 0;
                while(!queue.isEmpty()) 
                {
                    int number = queue.poll();
                    sum=sum+number;
                }
                System.out.println("Consumed. Sum: " + sum);
                queue.notifyAll();
            }
        }
    }
}
public class JavaQue9 {

	public static void main(String[] args) {
        Queue<Integer> queue = new LinkedList<>();
        int capacity=10;

        Producer producer = new Producer(queue, capacity);
        Consumer consumer = new Consumer(queue);

        Thread producerThread = new Thread(producer);
        Thread consumerThread = new Thread(consumer);

        producerThread.start();
        consumerThread.start();
    }
}


