import java.util.Date;

public class Personal extends Friend{
	//Personal person class
	//attributes: personName, personNickName, personMail, birthDate,strBirthDate
	private String personNickName;

	public Personal(String personName,String personNickName, String personMail, Date birthDate, String strBirthDate) {
		super(personName, personMail, birthDate, strBirthDate);
		// TODO Auto-generated constructor stub
		this.personNickName = personNickName;
	}

}
