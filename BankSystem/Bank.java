import java.util.Scanner;
import java.io.IOException;
import java.util.HashMap;
public class Bank {
	Scanner sc = new Scanner(System.in);
	User user;
	
	public void register() {//用户注册
		User us = new User();
		System.out.println("请输入银行卡号");
		String cardId=sc.nextLine();
		us.setCardId(cardId);
		while(true) {
		System.out.println("请设置银行卡密码");
		String cardPwd1=sc.nextLine();
		System.out.println("请再次确认输入的密码");
		String cardPwd2=sc.nextLine();
		if(cardPwd1.equals(cardPwd2)) {
			us.setCardPwd(cardPwd1);
			break;
		}else {
			System.out.println("你的两次密码输入不一致，请从新设置密码");
		   }
		}
		System.out.println("请输入用户名");
		String userName=sc.nextLine();
		us.setUserName(userName);
		System.out.println("请输入性别");
		String sex=sc.nextLine();
		us.setSex(sex);
		System.out.println("请输入账户余额");
		double account=sc.nextDouble();
		us.setAccount(account);
	
	  HashMap<String,User> u = Test.users;//获取所有用户存储集合
	  u.put(cardId, us);//向集合中添加该用户
	  System.out.println("恭喜你注册成功"+us.getUserName()+" 账户余额为"+us.getAccount()+"元,请谨记密码");
	  return ;
	 // login(); //调用登陆
		
	}
	public void login() {   //用户登陆
		System.out.println("欢迎进入网上银行服务系统");
	//	User user;
		while(true) {
			System.out.print("请输入银行账户");
			sc.nextLine();
			String ID = sc.nextLine();
			System.out.print("请输入账户密码");
			sc.nextLine();
			String Pwd = sc.nextLine();
			HashMap<String,User> u = Test.users;//获取所有用户存储集合
		    user = u.get(ID);                   //获取单个账户信息
			//String sex=null;
			if(u.containsKey(ID)&&Pwd.equals(user.getCardPwd())) {
				String sex;
				if("男".equals(user.getSex())) {
					     sex="先生";
					}
					else {
						 sex="女士";
					}
				System.out.println("登陆成功，欢迎"+user.getUserName()+sex);
				break;
			}else {
				if(!u.containsKey(ID)) {
					System.out.println("账号输入错误，请重新输入");
				}else {
				System.out.println("密码输入错误，请从新输入");
				}
			}
			
		}
	}
	
	public void operate()  {
		
		while(true) {
			show1();
			System.out.print("请输入操作的选项");
			int x = sc.nextInt();
			switch(x){
			case 1://存款操作
				deposit();
				break;
			case 2:
				//Runtime.getRuntime().exec("cls");
				withDraw();
				break;
			case 3:
				show();
				break;
			case 0:
				break;
			default:
				break;
			}
			System.out.print("1:继续操作 0:退出");
			int y=sc.nextInt();
			if(y==0) {
				System.out.print("感谢你的使用,欢迎下次光临");
				break;
			}
		}
	}
	 public void deposit(){
      //   String d;
         double c;
		 while(true){
			   System.out.println("请输入存款金额");
			   c = sc.nextDouble();
			   double account=user.getAccount()+c;
			   user.setAccount(account);
			   System.out.println(user.getUserName()+"你好,你的账户已存入"+c+"元,");
			   System.out.println("按1继续存钱,按0返回");
			   int x=sc.nextInt();
			   if(x==0) break;
			}
	    }
	 
	 public void withDraw(){
		// String d;
         double c;
		  while(true){
			System.out.println("请输入取款金额");
			c = sc.nextDouble();
		   if(c<=user.getAccount()){
			  double account=user.getAccount()-c;
			  user.setAccount(account);
			  System.out.println(user.getUserName()+"你好,你的账户已取出"+c+"元,");
			  System.out.println("按1继续取钱,按0返回");
			  int x=sc.nextInt();
			  if(x==0) break;
		   }
		   else{
			 System.out.println("对不起,账户余额不足");
			  }
		   }
	   }
	 public void show() {
		 System.out.println(user.getUserName()+"目前你的账户余额为"+user.getAccount()+"元");
	 }
	 public void show1() {
			System.out.println("------欢迎来到中国银行，银行工作人员将竭诚为你服务------");
			System.out.println("------------------1:存款------------------");
			System.out.println("------------------2:取款------------------");
			System.out.println("------------------3:显示余额--------------");
			System.out.println("------------------0:退出------------------");
		}
   
}
