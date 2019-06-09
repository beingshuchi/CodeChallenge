package demo.demo;

import com.paypay.exercise.immutablequeue.ImmutableQueue;
import com.paypay.exercise.immutablequeue.Queue;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args )
    {
    	long startTime = System.currentTimeMillis();
       @SuppressWarnings("unchecked")
	Queue<Integer> q=ImmutableQueue.getInstance();
       try {
    	   long startTime1 = System.currentTimeMillis();
           q = q.enQueue(1);
           long endTime = System.currentTimeMillis();
		   long duration = (endTime - startTime1);  //Total execution time in milli seconds
		   System.out.println("enq : "+duration);
           q = q.enQueue(2);
          
           q = q.enQueue(3);
           System.out.println("------");
           startTime1 = System.currentTimeMillis();
           q = q.deQueue();
           endTime = System.currentTimeMillis();
		   duration = (endTime - startTime1);  //Total execution time in milli seconds
		   System.out.println("Deq : "+duration);
		   startTime1 = System.currentTimeMillis();
           int head =q.head();
           System.out.println(head);
           endTime = System.currentTimeMillis();
		   duration = (endTime - startTime1);  //Total execution time in milli seconds
		   System.out.println("head : "+duration);
           System.out.println("------");
           endTime = System.currentTimeMillis();
		   duration = (endTime - startTime);  //Total execution time in milli seconds
		   System.out.println("total : "+duration);
           
       } catch (Exception e) {
           System.out.println("Exception: " + e.getStackTrace());
       }
    }
}
