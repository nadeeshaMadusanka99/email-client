import java.util.Date;

public class OfficeFriend extends Friend {
	//OfficeFriend person class
	//attributes : persoName,personMail,personDesignation, personBirthdate, strBirthDate
	private String personDesignation;
	
	public OfficeFriend(String personName, String personMail, String personDesignation, Date birthDate, String strBirthDate) {
		super(personName, personMail, birthDate, strBirthDate);
		// TODO Auto-generated constructor stub
		this.personDesignation = personDesignation;
	}

}
