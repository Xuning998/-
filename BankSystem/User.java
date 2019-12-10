package package1;

public class User {
	
	private String cardId;   //银行卡号
	private String cardPwd;  //银行卡密码
	private String userName; //账户名
	private String sex;     //性别
	private double account;  //余额
	
	public User() {
		super();
		// TODO Auto-generated constructor stub
	}

	public User(String cardId, String cardPwd, String userName, String sex, double account) {
		super();
		this.cardId = cardId;
		this.cardPwd = cardPwd;
		this.userName = userName;
		this.sex = sex;
		this.account = account;
	}

	public String getCardId() {
		return cardId;
	}

	public void setCardId(String cardId) {
		this.cardId = cardId;
	}

	public String getCardPwd() {
		return cardPwd;
	}

	public void setCardPwd(String cardPwd) {
		this.cardPwd = cardPwd;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getSex() {
		return sex;
	}
	public void setSex(String sex) {
		this.sex = sex;
	}

	public double getAccount() {
		return account;
	}

	public void setAccount(double account) {
		this.account = account;
	}
    

	
}
