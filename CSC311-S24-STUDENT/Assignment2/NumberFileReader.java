///Jeremy Cabrera (jcabrera111@toromail.csudh.edu)
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class NumberFileReader {
	
	File file;
	
	public NumberFileReader(String filePath){
		file = new File(filePath);
	}
	
	public int[] read() throws FileNotFoundException{
		int length = 0;
		Scanner fileLength = new Scanner(file);
		while(fileLength.hasNext()) {
			fileLength.nextInt();
			length=length+1;
		}
		fileLength.close();
		int[] fileArray= new int[length];
		
		int counter = 0;
		Scanner fileContent = new Scanner(file);
		while(fileContent.hasNext()) {
			fileArray[counter] = fileContent.nextInt();
			counter++;
		}
		fileContent.close();
		return fileArray;
	}
}
