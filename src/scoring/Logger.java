package scoring;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class Logger {

	public Logger() {}
	
	// Write to pasur.log
    public static void writeToLog(String s)
    {
    	// Create the pasur.log file if it doesn't exist yet
    	File logFile = new File("pasur.log");
    	if (!logFile.exists() || logFile.isDirectory()) { 
        	try {
    	      File fileObject = new File("pasur.log");
    	      fileObject.createNewFile();
    	    } catch (IOException e) {
    	      e.printStackTrace();
    	    }
    		
    	}
    	
    	// Now that it exists, write to it
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
