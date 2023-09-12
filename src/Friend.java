import java.util.Date;

public abstract class Friend extends Recipients {
	//superclass of OfficeFriend and Personal classes. 
	//attributes: personName, personMail, birthDate,strBirthDate
	private Date birthDate;
	private String strBirthDate;
	
	public Friend(String personName, String personMail, Date birthDate, String strBirthDate) {
		super(personName, personMail);
		this.birthDate = birthDate; 
		this.strBirthDate = strBirthDate;
	}

	public String getStrBirthDate() {
		return strBirthDate;
	}

	public Date getBirthDate() {
		return birthDate;
	}

}
