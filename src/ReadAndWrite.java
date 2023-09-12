import java.io.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public abstract class ReadAndWrite {
	//Read the data from the clientList.txt and put to createObj method to create hashmap.
	 public static void readAText() throws Exception{
		 try {
			BufferedReader reader = new BufferedReader(new FileReader("D:\\Mora\\Projects So Far\\Email Client (1)\\My\\EmailClient\\clientList.txt"));
			String line = null;
			while((line = reader.readLine()) != null) {
				createObj(line); 
			}
			reader.close();
			}
		catch (IOException e) {
			throw e;
		}	
	}
	 
	 //create the hashmap from the read data.
	 static private void createObj(String line){
		 String[] type = line.split(":");
		 String[] personData = type[1].split(",");
		 Date dateObj;
		 String currDate;
		 SimpleDateFormat formatDate = new  SimpleDateFormat("yyyy/MM/dd");
		 //create the hashmap according to the type of the person
		 switch(type[0]){
			 case "Official":
				 Recipients.recipientsList.add(new Official(personData[0],personData[1],personData[2]));
				 break;
				 
			 case "Office_friend" :
					 currDate = personData[3];
				 try {
					 dateObj = formatDate.parse(currDate);
					 Recipients.recipientsList.add(new OfficeFriend(personData[0],personData[1],personData[2],dateObj,currDate));
				 }
				 catch(ParseException e) {
					 e.printStackTrace();
				 }
				 break;
				 
			 case "Personal":
				 currDate = personData[3];
				 try {
					 dateObj = formatDate.parse(currDate);
					 Recipients.recipientsList.add(new Personal(personData[0],personData[1],personData[2],dateObj,currDate));
					 
				 }
				 catch(ParseException e) {
					 e.printStackTrace();
				 }
				 break;
		 }
	 }
	 //write the use input clientList and do hashmaping.
	 public static void writeAText(String data) {
		try {
			File check = new File("D:\\Email Client\\Recipients\\clientList.txt");
			if(!check.exists()) {
				FileWriter writer = new FileWriter(check,true);
				writer.write(data);
				createObj(data);
				writer.close();
			}
			else {
				FileWriter writer = new FileWriter(check,true);
				writer.write("\n"+data);
				createObj(data);
				writer.close();
			}
			System.out.println("Successfully added to the file");
		}
		catch(IOException e){
			e.printStackTrace();
		}
	}
}
