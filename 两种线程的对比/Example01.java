public class Example01
{
	public static void main(String[] args){
	TicketWindow tw=new TicketWindow();
	
     new Thread(tw,"����һ").start();
	 new Thread(tw,"���ڶ�").start();
	 new Thread(tw,"������").start();
	 new Thread(tw,"������").start();
	}
}
class TicketWindow implements Runnable
{
	private int ticket=100;
	public void run(){
	while(true){
	if(ticket>0){
	System.out.println(Thread.currentThread().getName()+"���ڳ��۵�"+ticket--+"��Ʊ");
     }
	}
	}
}