class DamonThread implements Runnable {
   public void run () {
   while (true) {
   System.out.println(Thread.currentThread().getName()+"--is running.");
     }
 }
}

 public class Example06 {
 public static void main (String[] args ) {
  System.out.println("mian线程是后台线程吗？"+Thread.currentThread().isDaemon());
  DamonThread dt = new DamonThread();
  Thread t = new Thread(dt,"后台线程");
 System.out.println("t线程默认是后台线程吗？"+t.isDaemon());
 t.setDaemon(true);
 t.start();
 for(int i = 0; i<10;i++) {
  System.out.println(i);
    }
  } 
}