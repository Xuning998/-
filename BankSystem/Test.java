package package1;
import java.io.*;
import java.util.*;
public class Test {
    public static HashMap<String,User> users = new HashMap<String,User>();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	   Scanner sc = new Scanner(System.in);
       User us1 = new User("184804344","123456","徐宁","男",666);
       users.put(us1.getCardId(), us1);
      
       
       FileReader reader=new FileReader("read.txt");//创建FileReader对象用来读取文件中的字符
       BufferedReader br = new BufferedReader(reader);//创建一个BufferedReader缓冲对象
       String str;
       String[] s;
       String cardId;   //银行卡号
   	   String cardPwd;  //银行卡密码
       String userName; //账户名
       String sex;      //性别
       double account;  //余额
       while((str=br.readLine())!=null) {//用文件依次读入每个用户信息并存入集合
     	  s = str.split(" ");
     	  cardId=s[0];
     	  cardPwd=s[1];
     	  userName=s[2];
     	  sex=s[3];
     	  account=Integer.parseInt(s[4]);
     	  users.put(cardId, new User(cardId,cardPwd,userName,sex,account));
     	  //System.out.println(s[0]+" "+s[1]+" "+s[2]+" "+s[3]+" "+s[4]);
       }
       Bank bank = new Bank();//创建银行对象
       System.out.println("请选择登陆或注册");
       System.out.println("1:注册   2:登陆");
       int x = sc.nextInt();
       if(x==1) {
    	   bank.register();//注册
       }
       bank.login();//登陆
       bank.operate();//操作
	}
}
