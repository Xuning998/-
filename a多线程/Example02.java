public class Example02{
public static void main (String[] args){
  MyThread myThread=new MyThread();
  myThread.start();
  while(true) {
  System.out.println("mainisrunning");
   }
 }
}
class MyThread extends Thread{
  public void run(){
  while(true){
 System.out.println("MyThreadisrunnig");
     }
  }
}
