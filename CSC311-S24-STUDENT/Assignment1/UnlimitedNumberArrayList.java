
public class UnlimitedNumberArrayList {
//Jeremy Cabrera (jcabrera111@toromail.csudh.edu)
	private int total = 0;
	private int[] mainArray;
	
	public int add (int number) {
		total+=1;

		if(total==1) {
			int[] tempArray = new int[1];
			tempArray[0] = number;
			mainArray = tempArray;
			return 0;
		}
		else {
			int[] tempArray = new int[total];
			for(int i=0;i<total-1;i++){
				tempArray[i] = mainArray[i];
			}
			tempArray[total-1] = number;
			mainArray = tempArray;
			return total-1;
		}
	}
	
	public int  get(int index) {
		if(index > total-1 || index<0) {
			System.out.println("Error Out of Bounds");
			return -1;
		}
		else {
			return mainArray[index];
		}

	}
	
	public int size(){
		return total;
	}
	
	public int getLargest() {
		if(total==0) {
			return -1;
		}
		else {
			int biggestNum = -1;
			for(int i = 0;i<total;i++) {
				if (mainArray[i] > biggestNum) {
					biggestNum = mainArray[i];
				}
			}
			return biggestNum;
		}
	}
	public int getSmallest() {
		if(total==0) {
			return -1;
		}
		else {
			int biggestNum = mainArray[0];
			for(int i = 0;i<total;i++) {
				if (mainArray[i] < biggestNum) {
					biggestNum = mainArray[i];
				}
			}
			return biggestNum;
		}
	}
	public int getAverage() {
		if(total==0) {
			return -1;
		}
		else {
			int sum = 0;
			int average = 0;
			for(int i = 0;i<total;i++) {
				sum+=mainArray[i];
			}
			average = sum/total;
			return average;
		}
	}
	
	public int[] find(int number) {
		int[] location = new int[] {};
		int[] tempArray1 = new int[total];
		int index=0;
		for(int i = 0;i<total;i++) {
			if(mainArray[i] == number) {
				tempArray1[index]=i;
				index +=1;
			}
		}
		int[] tempArray2 = new int[index];
		for(int i = 0;i<index;i++) {
			tempArray2[i] = tempArray1[i];
		}
		location = tempArray2;
		return location;
	}
	
    @Override
    public String toString() {
    	String data= "[";
		for(int i = 0;i<total;i++) {
			data += mainArray[i];
			if(i!=total-1) {
				data+=", ";
			}
		}
    	data+="]";
        return data;
    }
}
