
public class Official extends Recipients {
	//Official person class
	//attributes : persoName,personMail,personDesignation,birthDate,strBirthdate
	private String personDesignation;
	
	public Official(String personName, String personMail, String personDesignation) {
		super(personName, personMail);
		this.personDesignation = personDesignation;
	}

	
}
