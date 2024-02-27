///Jeremy Cabrera (jcabrera111@toromail.csudh.edu)
public class BubbleSort {

	public int[] array;
	int loops;
	
	BubbleSort(int[] array){
		this.array = array;
	}
	
	public int[] sortAsc () {
		loops = 0;
		boolean swap = true;
		while(swap) {
			swap=false;
			for(int i = 0;i<array.length-1;i++) {
				if(array[i]>array[i+1]) {
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					swap=true;
				}
			}
			loops++;
		}
		return array;
	}
	
	public int[]  sortDesc() {
		loops = 0;
		boolean swap = true;
		while(swap) {
			swap=false;
			for(int i = 0;i<array.length-1;i++) {
				if(array[i]<array[i+1]) {
					int temp = array[i];
					array[i] = array[i+1];
					array[i+1] = temp;
					swap=true;
				}
			}
			loops++;
		}
		return array;
	}
	
	public  int loopCycles() {
		return loops;
	}
}
