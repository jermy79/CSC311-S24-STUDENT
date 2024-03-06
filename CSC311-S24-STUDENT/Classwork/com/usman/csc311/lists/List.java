package com.usman.csc311.lists;
public class List {
	static final int DEFAULT_CAPACITY = 50;
	private int[] data= new int[DEFAULT_CAPACITY];
	int arrayPointer=0;
	
	public List() {
		
	}
	public void add(int value) {
		if (arrayPointer == data.length) {
			resizeArray();
		}
		data[arrayPointer++] = value;
		
	}
	
	public void put(int value, int index) {
		data[index] = value;
	}
	
	public void insert(int value, int index) {
		
		int loopCount = 0;
		
        if (arrayPointer == data.length) {
            resizeArray();
        }
        for (int i = arrayPointer; i > index; i--) {
            data[i] = data[i-1];
            loopCount++;
        }
        data[index] = value;
        arrayPointer++;
        System.out.println("Insert: "+loopCount);
    }
	
	public void delete(int index) {
		int loopCount = 0;
		for (int i = index; i < arrayPointer; i++) {
			data[i] = data[i + 1];
			loopCount++;
		}
		arrayPointer--;
		System.out.println("Delete: " + loopCount);
	}
	
	public String toString() {
		String result = "";
		for (int i = 0; i < arrayPointer; i++) {
			result += data[i] + " ";
		}
		return result;
	}
	
	private void resizeArray() {
		System.out.println("Resizing array");
		int loopCount = 0;
		int[] newData = new int[data.length +DEFAULT_CAPACITY];
		for (int i = 0; i < data.length; i++) {
			newData[i] = data[i];
			loopCount++;
		}
		data = newData;
		System.out.println("Resize: "+loopCount);
	}
}
