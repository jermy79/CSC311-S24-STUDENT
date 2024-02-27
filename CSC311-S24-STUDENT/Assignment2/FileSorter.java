///Jeremy Cabrera (jcabrera111@toromail.csudh.edu)
import java.io.IOException;
import java.util.Scanner;

public class FileSorter {

	public static void main(String[] args) throws IOException {
		String filePath = null;
		Scanner input = new Scanner(System.in);
		System.out.print("Please provide name of a File: ");
		filePath = input.nextLine();
		
		NumberFileReader readFile = new NumberFileReader(filePath);
		NumberFileWriter writeFile = new NumberFileWriter(filePath);
		int [] numArray = readFile.read();
		BubbleSort sorter = new BubbleSort(numArray);
		int [] sortedNumArray = sorter.sortAsc();
		writeFile.write(sortedNumArray);
		System.out.println("Done!");
	}

}
