package package1;
import java.io.*;
import java.util.*;
public class Test {
    public static HashMap<String,User> users = new HashMap<String,User>();
	public static void main(String[] args) throws Exception {
		// TODO Auto-generated method stub
	   Scanner sc = new Scanner(System.in);
       User us1 = new User("184804344","123456","����","��",666);
       users.put(us1.getCardId(), us1);
      
       
       FileReader reader=new FileReader("read.txt");//����FileReader����������ȡ�ļ��е��ַ�
       BufferedReader br = new BufferedReader(reader);//����һ��BufferedReader�������
       String str;
       String[] s;
       String cardId;   //���п���
   	   String cardPwd;  //���п�����
       String userName; //�˻���
       String sex;      //�Ա�
       double account;  //���
       while((str=br.readLine())!=null) {//���ļ����ζ���ÿ���û���Ϣ�����뼯��
     	  s = str.split(" ");
     	  cardId=s[0];
     	  cardPwd=s[1];
     	  userName=s[2];
     	  sex=s[3];
     	  account=Integer.parseInt(s[4]);
     	  users.put(cardId, new User(cardId,cardPwd,userName,sex,account));
     	  //System.out.println(s[0]+" "+s[1]+" "+s[2]+" "+s[3]+" "+s[4]);
       }
       Bank bank = new Bank();//�������ж���
       System.out.println("��ѡ���½��ע��");
       System.out.println("1:ע��   2:��½");
       int x = sc.nextInt();
       if(x==1) {
    	   bank.register();//ע��
       }
       bank.login();//��½
       bank.operate();//����
	}
}
