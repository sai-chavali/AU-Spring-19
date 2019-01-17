package multithreading;

public class Threadtest{
	public static int number = 1;
	
    public static void main(String[] args){
    	Threadtest evenodd = new Threadtest();
        Thread t1 = new Thread(() ->{
            evenodd.printeven();
        });
        Thread t2 =  new Thread(()->{
            evenodd.printodd();
         
        });
        t1.start();
        t2.start();
    }
    
    public synchronized void printeven() {
    	for(int i=1;i<=10;i++){
            while(number%2 == 1) {
            	try{
            		wait();
            	}catch(Exception e){
            		e.printStackTrace();
            	
            	}
            }
            System.out.println(number);
            number++;
            notify();
    	}
    }
    
    public synchronized void printodd() {
    	for(int i=1;i<=10;i++){
            while(number%2 == 0) {
            	try{
            		wait();
            	}catch(Exception e){
            	e.printStackTrace();
            	}
            }
            System.out.println(number);
            number++;
            notify();
    	}
    }
}