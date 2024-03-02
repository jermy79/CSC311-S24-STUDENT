package com.usman.csc311.lists;

public class Stack {
	
	static final int DEFAULT_CAPACITY = 50;
	private int[] data= new int[DEFAULT_CAPACITY];
	int stackPointer=0;
	
	public Stack() {

	}
	
	public void push(int value) {
		if (stackPointer == data.length) {
			resizeArray();
		}
		data[stackPointer++] = value;

	}
	
	public int pop() {
		if (stackPointer == 0) {
			throw new IllegalStateException("No more items on the stack");
		}
		return data[--stackPointer];
	}
	
	public int peek() {
		return data[stackPointer-1];
	}
	
	public int size() {
		return stackPointer;
	}

	public boolean isEmpty() {
		return stackPointer == 0;
	}
	
	private void resizeArray() {
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
