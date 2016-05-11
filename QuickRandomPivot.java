package com.rgv.algorithms;

import java.util.Random;

/**
 * @author rajaganeshv
 * This class uses Quick Sort algorithm to sort a given Array of Comparable elements. ex: String, Integer etc.,
 *
 */
public class QuickRandomPivot {

	private static Random rand = new Random();
	
	/**
	 * @param a Comparable array, can be any array of elements of Classes that implement Comparable Interface. 
	 */
	public static <T extends Comparable<T>> void sort(T[] a){
		quickSort(a,0,a.length-1);		
	}

	/**
	 * @param a Comparable array, can be any array of elements of Classes that implement Comparable Interface. 
	 * @param start - is the starting position within the Array that needed to be sorted.
	 * @param end - is the ending position of the array that needed to be sorted. (usually this is array.length - 1).
	 * 
	 */
	private static <T extends Comparable<T>> void quickSort(T[] a,int start,int end){				
		if((end-start)<=0){
			return;  
		}
		int p=partition(a,start,end);				
		quickSort(a,start,p-1);
		quickSort(a,p+1,end);
	}

	
	/**
	 * @param a Comparable array, can be any array of elements of Classes that implement Comparable Interface. 
	 * @param start - is the starting position within the Array that needed to be sorted.
	 * @param end - is the ending position of the array that needed to be sorted. (usually this is array.length - 1).
	 * 
	 */
	private  static <T extends Comparable<T>> int partition(T[] a,int start,int end){	
		int p=randInt(start, end);	// Use (start+end)/2 if you want to use the mid number as the Pivot. 
		
		swap(a,p,end); //Swap the Pivot to the Last element in the Array (Specified by the End - index).
		
		T pivot=a[end]; //The last element in the Array becomes the Pivot. 
		
		int j=end-1;
		int i=start;

		while(i<=j){			// loop through i and j and keep swapping if there are large numbers. 
			if(a[i].compareTo(pivot)>0){
				swap(a,i,j);
				j--;
			}
			else{
				i++;
			}

		}			
		swap(a,i,end);
		
		return i;
	}


	/**
	 * @param a - comparable array
	 * @param i - Index of the first element to be swapped. 
	 * @param j - Index of the second element to be swapped.
	 */
	private static <T extends Comparable<T>> void swap(T[] a,int i,int j){			
		T t=a[i];
		a[i]=a[j];
		a[j]=t;
	}

	/**
	 * show - Method prints the array to System.out.
	 *  
	 * @param a
	 */
	public static <T extends Comparable<T>> void show(T a[]){
		System.out.println("\n");
		for(int i=0;i<a.length;i++){
			System.out.print(" "+a[i].toString());
		}
		System.out.println("\n");
	}

	private static int randInt(int min, int max) {

		// nextInt is normally exclusive of the top value,
		// so add 1 to make it inclusive
		int randomNum = rand.nextInt((max - min) + 1) + min;
		
		return randomNum;
	}

	public static void main(String[] args) {
		
		Integer[] x={90,23,56,45,89,34,100,110};

		long start_time=System.nanoTime();
		QuickRandomPivot.sort(x);
		long  end_time=System.nanoTime();
		QuickRandomPivot.show(x);       
		System.out.println("  \n Quick Sort Timing: "+(end_time-start_time)/100);

	}


}
