///Jeremy Cabrera (jcabrera111@toromail.csudh.edu)
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class NumberFileWriter {
	File file;
	String filepath;
	
	public NumberFileWriter(String filePath){
		file = new File(filePath);
		this.filepath=filePath;
	}
	
	public void write(int[] numArray) throws IOException {
		FileWriter write = new FileWriter(file);
		for(int i = 0; i<numArray.length;i++) {
	        write.write(String.valueOf(numArray[i]));
	        write.write(System.lineSeparator());
		}
		write.close();

	}
}
