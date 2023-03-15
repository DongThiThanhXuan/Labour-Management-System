package helper;

public class Regex {
	

	//at least 5 chars - maximum 50 chars (only alphabet)
	public final static String NAME = "^([a-zA-Z]\\s*){5,50}$";
	
	//at least 5 chars - maximum 50 chars (not include special characters)
	public final static String ADDRESS = "^([a-zA-z0-9-\\''(),.\\s]{5,50})$";
	
	//must be valid e-mail: example123@abc.com
	public final static String EMAIL =  "^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$";
	
	//phone number (10 number)
	public final static String PHONE = "(84|0[3|5|7|8|9])+([0-9]{8})\\b";
	
	//at least 3 chars - maximum 20 chars (only alphabet)
	public final static String RELATIONSHIP = "^([a-zA-Z]\\s*){3,20}$";
	
	//at least 3 chars - maximum 30 chars (not include special characters and space)
	public final static String USERNAME = "^(\\d|\\w){3,30}$";
	
	// must at least 6 char, at least: one digit, one lower, one upper alpha char, one special char and does not contain space, tab
	public final static String PASS ="^(?=.*[0-9])(?=.*[a-z])(?=.*[A-Z])(?=.*[!@#$%^&+=.])(?=\\S+$).{6,}$";

	//only number
	public final static String NUM = "^[0-9]*$";
	
	//only alphabet
	public final static String ALPHABET = "^[A-Za-z]+$";
	
	//month 1->12
	public final static String MONTH = "^(1[0-2]|[1-9])$";
	

	//===============Xuan=============
	
	public final static String time="^(([0-1][0-9])||(2[0-3])):[0-5][0-9]$";
	public final static String OT="^((0?[0-9])|(1[0-2]))(.[0|5])?$";
	public final static String Xuanname="^(?![\\s.]+$)[a-zA-Z\\s.]*$";
}
