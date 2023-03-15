package helper;

import java.util.regex.Pattern;

import bao.EmployeeBao;
import bao.RelativesBao;

public class Validation {

	public static String MessErrorInputFullName(String fullname) {
		var mess = "";
		var matcher = Pattern.compile(helper.Regex.NAME).matcher(fullname);
		if (fullname.trim().isEmpty()) {
			mess = "Please, fill fullname!";
		} else if (!matcher.matches()) {
			mess = "Fullname must be at least 5 to 50 characters, not include: Special characters, numbers, Unicode letters";
		}
		return mess;
	}
	

	public static String MessErrorInputAddress(String address) {
		var mess = "";
		var matcher = Pattern.compile(helper.Regex.ADDRESS).matcher(address);
		if (address.trim().isEmpty()) {
			mess = "Please, fill address!";
		} else if (!matcher.matches()) {
			mess = "Address must be at least 5 to 50 characters, not include: Special characters, Unicode letters";
		}
		return mess;
	}

	public static String MessErrorInputMail(String mail, EmployeeBao empb) {
		var mess = "";
		var matcher = Pattern.compile(helper.Regex.EMAIL).matcher(mail);
		if (mail.trim().isEmpty()) {
			mess = "Please, fill E-mail!";
		} else if (empb.checkEmail(mail) == true) {
			mess = "E-mail already exists, please fill another e-mail";
		} else if (!matcher.matches()) {
			mess = "Must be valid e-mail!";
		}
		return mess;
	}

	public static String MessErrorInputPhone(String phone, EmployeeBao empb, RelativesBao relb) {
		var mess = "";
		var matcher = Pattern.compile(helper.Regex.PHONE).matcher(phone);
		if (phone.trim().isEmpty()) {
			mess = "Please, fill Phone number!";
		} else if (empb.checkPhone(phone) == true || relb.checkPhoneRelative(phone) == true) {
			mess = "Phone-number already exists!";
		} else if (!matcher.matches()) {
			mess = "Must be valid phone number (10 numbers)";
		}
		return mess;
	}
	
	public static String MessErrorInputRelationship(String relation) {
		var mess = "";
		var matcher = Pattern.compile(helper.Regex.RELATIONSHIP).matcher(relation);
		if (relation.trim().isEmpty()) {
			mess = "Please, fill relationship!";
		} else if (!matcher.matches()) {
			mess = "Relationship must be at least 3 to 20 characters, not include: Special characters, numbers, Unicode letters";
		}
		return mess;
	}


	public static String MessErrorInputUsername(String username, EmployeeBao empb) {
		var mess = "";
		var matcher = Pattern.compile(helper.Regex.USERNAME).matcher(username);
		if (username.trim().isEmpty()) {
			mess = "Please, fill username!";
		} else if (empb.checkUsername(username) == true) {
			mess = "Username already exists, please fill another username";
		} else if (!matcher.matches()) {
			mess = "Username must be at least 5 to 30 characters, "
					+ "\nnot include: Special characters, space, Unicode letters";
		}
		return mess;
	}

	public static String MessErrorInputPass(String password) {
		var mess = "";
		var matcher = Pattern.compile(helper.Regex.PASS).matcher(password);
		if (password.trim().isEmpty()) {
			mess = "Please, fill password!";
		} else if (!matcher.matches()) {
			mess = "Password must at least 6 chars and 1 digit-1 lower-1 upper alpha, 1 special char and not contain space";
		}
		return mess;
	}
	
	public static String MessErrosInputSalary(String salary) {
		var mess="";
		var matcher=Pattern.compile(helper.Regex.NUM).matcher(salary);
		if(salary.trim().isEmpty()) {
			mess="Please, fill salary!";
		}		
		else if(!matcher.matches()) {
			mess="Salary must contain only numbers!";
		}
		else if(Long.parseLong(salary) % 100000!=0){
			mess="Salary not valid!";
		}	
		return mess;
	}
	
	public static String MessErrorInputPassScript(String password) {
		var mess = "";
		var matcher = Pattern.compile(helper.Regex.PASS).matcher(password);
		if (password.trim().isEmpty()) {
			mess = "Please, fill password!";
		} else if (!matcher.matches()) {
			mess = "Password not valid!";
		}
		return mess;
	}
	
	public static String MessErrorInputFullNameScript(String fullname) {
		var mess = "";
		var matcher = Pattern.compile(helper.Regex.NAME).matcher(fullname);
		if (fullname.trim().isEmpty()) {
			mess = "Please, fill fullname!";
		} else if (!matcher.matches()) {
			mess = "Fullname not valid!";
		}
		return mess;
	}
	
	public static String MessErrorInputRelationshipScript(String relation) {
		var mess = "";
		var matcher = Pattern.compile(helper.Regex.RELATIONSHIP).matcher(relation);
		if (relation.trim().isEmpty()) {
			mess = "Please, fill relationship!";
		} else if (!matcher.matches()) {
			mess = "Relationship not valid!";
		}return mess;
	}

	public static String MessErrorInputPhoneScript(String phone, EmployeeBao empb, RelativesBao relb) {
		var mess = "";
		var matcher = Pattern.compile(helper.Regex.PHONE).matcher(phone);
		if (phone.trim().isEmpty()) {
			mess = "Please, fill Phone number!";
		} else if (empb.checkPhone(phone) == true || relb.checkPhoneRelative(phone) == true) {
			mess = "Phone-number already exists";
		} else if (!matcher.matches()) {
			mess = "Must be valid phone number";
		}
		return mess;
	}
	//=====Code nay c xuan dung====/
		
		
		public static String MessErrorInputtime(String time) {
			var mess = "";
			var matcher = Pattern.compile(helper.Regex.time).matcher(time);
			if(time.trim().isEmpty()) {
				mess="Please, fill time!";
			}
			if  (!matcher.matches()) {
				mess = "Must have a valid time format HH:mm";
			}
			return mess;
		}
		
		
		public static String MessErrorInputOT(String OT) {
			var mess = "";
			var matcher = Pattern.compile(helper.Regex.OT).matcher(OT);
			if(OT.trim().isEmpty()) {
				mess="Please, fill OT!";
			}
			if  (!matcher.matches()) {
				mess = "Over Time need input with format exampe 09.5,9.0 and maximum 12.00";
			}
			return mess;
		}
		public static String MessErrorInputNumber(String number) {
			var mess = "";
			var matcher = Pattern.compile(helper.Regex.NUM).matcher(number);
			if(number.trim().isEmpty()) {
				mess="Please, fill number!";
			}
			if  (!matcher.matches()) {
				mess = "Input only number";
			}
			return mess;
		}
		
		
		public static String MessErrorSearchNameXuan(String name) {
			var mess = "";
			var matcher = Pattern.compile(helper.Regex.Xuanname).matcher(name);
			if  (!matcher.matches()) {
				mess = "Input only alphabet";
			}
			return mess;
		}
}
