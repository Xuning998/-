class DeadLockThread implements Runnable
{
	static Object chopsticks=new Object();
	static Object knifandforks=new Object();
	private boolean flag;
	DeadLockThread(boolean flag){
	this.flag=flag;}
	public void run(){
	if(flag){
	while(true){
	synchronized(chopsticks){
	System.out.println(Thread.currentThread().getName()+"--if--chopsticks");
	
	synchronized(knifandforks){
	System.out.println(Thread.currentThread().getName()+"--if--knifandforks");
	}
	}
	}
	
	}
	else{
	while(true){
	synchronized(knifandforks){
	System.out.println(Thread.currentThread().getName()+"--if--chopsticks");
	
	synchronized(chopsticks){
	System.out.println(Thread.currentThread().getName()+"--if--knifandforks");
	}
	}
	}
	}
	}
}
public class Example01
{
	public static void main(String[] args){
	DeadLockThread d1=new DeadLockThread(true);
	DeadLockThread d2=new DeadLockThread(false);
	new Thread(d1,"chinese").start();
	new Thread(d2,"American").start();
	}
}