package Activities;

import java.util.Arrays;

public class Activity4 {	
	
	public static void main(String[] args) {
		int[] data= {4,3,2,10,12,1,5,6};
		System.out.println("Array before sorting: "+Arrays.toString(data));
		ascendingSort(data);
		System.out.println("Sorted array in ascending order: "+Arrays.toString(data));		
	}
		
	static void ascendingSort(int array[]) {
		int size=array.length,i,j;
		for(i=1;i<size;i++){
			int key=array[i];
			j=i-1;
			while(j>=0 && key<array[j]) {
				array[j+1]=array[j];
				j--;
			}
			array[j+1]=key;				
		}			
	}
		
	

}
