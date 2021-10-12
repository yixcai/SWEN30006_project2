package scoring;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

	public Logger() {}
	
	public static void init() {
		// Create the pasur.log file
    	try {
	      File fileObject = new File("pasur.log");
	      fileObject.createNewFile();
	    } catch (IOException e) {
	      e.printStackTrace();
	    }
	}
	
	// Write to pasur.log
    public static void writeToLog(String s)
    {
    	try {
        	FileWriter myWriter = new FileWriter("pasur.log", true);
	        myWriter.write(s+"\n");
	        myWriter.close();
	        System.out.println(s);
        } catch (IOException e) {
        	e.printStackTrace();
    	}
    }
}
