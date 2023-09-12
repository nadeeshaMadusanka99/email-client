//200614N
import java.util.Scanner;

public class Email_Client {

	public static void main(String[] args) {
		//Traverse through the Recipients list and see if there is anyone has a birthday today.
		try {
			ReadAndWrite.readAText();
		}
		catch(Exception e) {
			System.out.println("No recipients available. Add recipients.");
		}
		//Send birthday wishes to those who has birthday in the current day.
		SendWish.sendWishes();
	
		//Deserialize the sent mails arrays.
		try {
	          Serialize.deserialization();
	    } 
		catch (Exception e) {
	           System.out.println(" ");;
	    }
		
		//run the program until the use enter exit command.
		boolean isRun = true;
		while(isRun) {
			Scanner scanner = new Scanner(System.in);
				
		    System.out.println("Enter option type: \n"
		          + "1 - Adding a new recipient\n"
		          + "2 - Sending an email\n"
		          + "3 - Printing out all the names of recipients who have their birthday in the current date\n"
		          + "4 - Printing out details of all the emails sent on the day\n"
		          + "5 - Printing out the number of recipient objects in the application\n"
		          + "6 - Exit the program" );
		
		    int num = scanner.nextInt();
		    
		    switch(num){
		          case 1:
		        	  //adding a new recipient to the recipients list
		        	  scanner.nextLine();
		        	  System.out.println("Enter the details in the following format:\n	\t-Official:  <name>,<email>,<designation> \n \t\t-Office_friend:  <name>,<email>,<designation>,<date of birth> \n \t\t-Personal:  <name>,<nick name>,<emial>,<date of birth>");
		        	  String data = scanner.nextLine();
		        	  ReadAndWrite.writeAText(data);
		        	  break;
		        	  
		          case 2:
		        	  //sending a email as use input details.
		        	  System.out.println("Enter detail in the following format:\n  email, subject, content :");
		        	  scanner.nextLine();
	                  String toSendMail = scanner.nextLine();
	                  String[] toSendMailData = toSendMail.split(",");
	                  SendMail.sendEmail(toSendMailData[0],toSendMailData[1],toSendMailData[2]);
		              break;
		              
		          case 3:
		        	  //printing the names of recipients who has their birthdays on the user input date.
		        	  System.out.println("Enter date in the format: yyyy/MM/dd");
		        	  scanner.nextLine();
		        	  String dateNeeded = scanner.nextLine();
		        
		        	  Recipients.currentDayBirthdays(dateNeeded);
		              break;
		              
		          case 4:
		        	  //printing all the details of the mails sent on the user input date.
		        	  System.out.println("Enter date in the format: yyyy/MM/dd");
		        	  scanner.nextLine();
		        	  String givenDate = scanner.nextLine();
		        	  SendMail.getGivenDateDetails(givenDate);
		        	  break;
		              
		          case 5:
		        	  //print the number of recipients.
		        	  System.out.println(Recipients.getNoOfRecipients());
		              break;
		              
		          case 6:
		        	  //Serialize the send mails array and exit the program.
		        	  Serialize.serialization();
		        	  isRun = false;
		    
			   }
		} 
	}
}
