import java.util.Scanner;
import java.io.IOException;
import java.util.HashMap;
public class Bank {
	Scanner sc = new Scanner(System.in);
	User user;
	
	public void register() {//�û�ע��
		User us = new User();
		System.out.println("���������п���");
		String cardId=sc.nextLine();
		us.setCardId(cardId);
		while(true) {
		System.out.println("���������п�����");
		String cardPwd1=sc.nextLine();
		System.out.println("���ٴ�ȷ�����������");
		String cardPwd2=sc.nextLine();
		if(cardPwd1.equals(cardPwd2)) {
			us.setCardPwd(cardPwd1);
			break;
		}else {
			System.out.println("��������������벻һ�£��������������");
		   }
		}
		System.out.println("�������û���");
		String userName=sc.nextLine();
		us.setUserName(userName);
		System.out.println("�������Ա�");
		String sex=sc.nextLine();
		us.setSex(sex);
		System.out.println("�������˻����");
		double account=sc.nextDouble();
		us.setAccount(account);
	
	  HashMap<String,User> u = Test.users;//��ȡ�����û��洢����
	  u.put(cardId, us);//�򼯺�����Ӹ��û�
	  System.out.println("��ϲ��ע��ɹ�"+us.getUserName()+" �˻����Ϊ"+us.getAccount()+"Ԫ,���������");
	  return ;
	 // login(); //���õ�½
		
	}
	public void login() {   //�û���½
		System.out.println("��ӭ�����������з���ϵͳ");
	//	User user;
		while(true) {
			System.out.print("�����������˻�");
			sc.nextLine();
			String ID = sc.nextLine();
			System.out.print("�������˻�����");
			sc.nextLine();
			String Pwd = sc.nextLine();
			HashMap<String,User> u = Test.users;//��ȡ�����û��洢����
		    user = u.get(ID);                   //��ȡ�����˻���Ϣ
			//String sex=null;
			if(u.containsKey(ID)&&Pwd.equals(user.getCardPwd())) {
				String sex;
				if("��".equals(user.getSex())) {
					     sex="����";
					}
					else {
						 sex="Ůʿ";
					}
				System.out.println("��½�ɹ�����ӭ"+user.getUserName()+sex);
				break;
			}else {
				if(!u.containsKey(ID)) {
					System.out.println("�˺������������������");
				}else {
				System.out.println("��������������������");
				}
			}
			
		}
	}
	
	public void operate()  {
		
		while(true) {
			show1();
			System.out.print("�����������ѡ��");
			int x = sc.nextInt();
			switch(x){
			case 1://������
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
			System.out.print("1:�������� 0:�˳�");
			int y=sc.nextInt();
			if(y==0) {
				System.out.print("��л���ʹ��,��ӭ�´ι���");
				break;
			}
		}
	}
	 public void deposit(){
      //   String d;
         double c;
		 while(true){
			   System.out.println("����������");
			   c = sc.nextDouble();
			   double account=user.getAccount()+c;
			   user.setAccount(account);
			   System.out.println(user.getUserName()+"���,����˻��Ѵ���"+c+"Ԫ,");
			   System.out.println("��1������Ǯ,��0����");
			   int x=sc.nextInt();
			   if(x==0) break;
			}
	    }
	 
	 public void withDraw(){
		// String d;
         double c;
		  while(true){
			System.out.println("������ȡ����");
			c = sc.nextDouble();
		   if(c<=user.getAccount()){
			  double account=user.getAccount()-c;
			  user.setAccount(account);
			  System.out.println(user.getUserName()+"���,����˻���ȡ��"+c+"Ԫ,");
			  System.out.println("��1����ȡǮ,��0����");
			  int x=sc.nextInt();
			  if(x==0) break;
		   }
		   else{
			 System.out.println("�Բ���,�˻�����");
			  }
		   }
	   }
	 public void show() {
		 System.out.println(user.getUserName()+"Ŀǰ����˻����Ϊ"+user.getAccount()+"Ԫ");
	 }
	 public void show1() {
			System.out.println("------��ӭ�����й����У����й�����Ա���߳�Ϊ�����------");
			System.out.println("------------------1:���------------------");
			System.out.println("------------------2:ȡ��------------------");
			System.out.println("------------------3:��ʾ���--------------");
			System.out.println("------------------0:�˳�------------------");
		}
   
}
