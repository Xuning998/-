public class Example01
{
	public static void main(String[] args){
	TicketWindow tw=new TicketWindow();
	
     new Thread(tw,"窗口一").start();
	 new Thread(tw,"窗口二").start();
	 new Thread(tw,"窗口三").start();
	 new Thread(tw,"窗口四").start();
	}
}
class TicketWindow implements Runnable
{
	private int ticket=100;
	public void run(){
	while(true){
	if(ticket>0){
	System.out.println(Thread.currentThread().getName()+"正在出售第"+ticket--+"张票");
     }
	}
	}
}