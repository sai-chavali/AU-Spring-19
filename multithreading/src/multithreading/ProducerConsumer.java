package multithreading;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class ProducerConsumer {

	public static void main(String[] args) {
		BlockingQueue<Item> blockingqueue = new ArrayBlockingQueue<Item>(10);
		new Producer(blockingqueue).start();
		new Consumer(blockingqueue).start();
	}

}

class Producer extends Thread {
	BlockingQueue<Item> blockingqueue;

	public Producer(BlockingQueue<Item> blockingqueue) {
		this.blockingqueue = blockingqueue;
	}

	public void run() {
		try {
			for (int i = 0; i < 10; i++)
			{
				Thread.sleep(100);
				blockingqueue.put(new Item(String.valueOf(i)));
				System.out.println("Produced: "+i);
			}
		} catch (Exception e) {
		}
	}
}

class Consumer extends Thread {
	BlockingQueue<Item> blockingqueue;

	public Consumer(BlockingQueue<Item> blockingqueue) {
		this.blockingqueue = blockingqueue;
	}

	public void run() {
		try {
			for (int i = 0; i < 10; i++)
			{	Thread.sleep(500);
				System.out.println("Consumed: "+blockingqueue.take().getName());
			}
		} catch (Exception e) {
		}
	}
}

class Item{
	private String name;
	
	public Item(String name){
	    this.name=name;
	}

	public String getName() {
	    return name;
	}
}