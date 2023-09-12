import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class Serialize {
	//class do serialization and deserialization.
	
	static void serialization(){
		try {
			FileOutputStream fos = new FileOutputStream("serializedDate.ser");
			ObjectOutputStream oos = new ObjectOutputStream(fos);
			
			oos.writeObject(SendMail.toSendMails);
			oos.close();
			fos.close();
		}
		catch(IOException e) {
			e.printStackTrace();
		}
	}
	static void deserialization() throws Exception{
		try {
			FileInputStream fis = new FileInputStream("serializedDate.ser");
            ObjectInputStream ois = new ObjectInputStream(fis);
            
            SendMail.toSendMails = (ArrayList<SendMail>) ois.readObject();
            ois.close();
            fis.close();
		}
		catch (Exception e) {
			throw e;
		}
	}
}	
	
