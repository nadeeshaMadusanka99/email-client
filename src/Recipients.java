import java.util.ArrayList;

public abstract class Recipients {
	//super class of the Official,OfficeFriend,Personal,Friend classes
	static ArrayList<Recipients> recipientsList = new ArrayList<Recipients>();
	static int noOfRecipients;
	private String personName;
	private String personMail;
	
	public Recipients(String personName, String personMail) {
		this.personName = personName;
		this.personMail = personMail;
		noOfRecipients+=1;
	}
	public static int getNoOfRecipients() {
		return noOfRecipients;
	}

	public String getPersonName() {
		return personName;
	}
	public String getPersonMail() {
		return personMail;
	}
	//check if a person has the birthday on the asked day.
	public static void currentDayBirthdays(String day) {
		for(Recipients x: recipientsList) {
			if((x instanceof Friend) && day.equals(((Friend)x).getStrBirthDate())) {
				System.out.println(x.getPersonName());
			}
		}
		
	}
	
}
