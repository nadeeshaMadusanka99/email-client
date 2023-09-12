import java.time.LocalDate;
import java.util.Date;

public class SendWish {
	//sending wishes to the persons who has the birthdays today.
	@SuppressWarnings("deprecation")
	public static void sendWishes() {
		 LocalDate dt = LocalDate.now();
	     int currDay = dt.getDayOfMonth();
	     int currMonth = dt.getMonthValue();
	     //check the type of person(Personal or OfficeFriend) and send wishes as given.
	     for(Recipients x: Recipients.recipientsList) {
	    	 int day;
	    	 int month;
	    	 if(x instanceof Personal) {
	    		 Date birthDay = ((Personal) x).getBirthDate();
	             day = birthDay.getDate();
	             month = (birthDay.getMonth())+1;
	             
	             if(isBirthday(day,month,currDay,currMonth)) {
	            	 SendMail.sendEmail(x.getPersonMail(), "Happy Birthday", "Hugs and love on your birthday, Nadeesha");
	             }
	    	 }
	    	 else if(x instanceof OfficeFriend) {
	    		 Date birthDay = ((OfficeFriend) x).getBirthDate();
	    		 day = birthDay.getDate();
	    		 month = birthDay.getMonth()+1;
	    		 
	    		 if(isBirthday(day,month,currDay,currMonth)) {
	            	 SendMail.sendEmail(x.getPersonMail(), "Birthday", "Wish you a happy birthday, Nadeesha");
	             }
	    	 }
	 
	     }
	 }

	private static boolean isBirthday(int day,int month, int currDay,int currMonth) {
			return (day == currDay) && (month == currMonth);
	}
}
