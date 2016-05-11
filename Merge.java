package com.rgv.algorithms;

/**
 * @author rajaganeshv
 * This class uses Merge Sort algorithm to sort a given Array of Comparable elements. ex: String, Integer etc.,
 *
 */
public class Merge {
	
	
	/*
	 * 
	 * @param input is an Array of Objects that implement Comparable 
	 * 
	 */
	@SuppressWarnings({ "rawtypes", "unchecked" })
	public static <T extends Comparable<T>> void mergeSort(T[] a){
		Comparable[] temp=new Comparable[a.length];
		mergeSort(a,temp,0,a.length-1);
	}
	
	
	private static <T extends Comparable<T>> void mergeSort(T[] a,T[] temp,int low,int high){			
		if(low<high){					
				int mid=(low+high)/2;		
				mergeSort(a,temp,low,mid);
				mergeSort(a,temp,mid+1,high);
				merge(a,temp,low,mid+1,high);
			}			
	}
	
	
	private static <T extends Comparable<T>> void merge(T[] a,T[] temp,int low,int mid,int high){		
		
		int first=low;
		int first_end=mid-1;
		int second=mid;
		int second_end=high;
		
		int k=low;
		int num=high-low+1;
		
		
		while(first<=first_end && second<=second_end){
			if(a[first].compareTo(a[second])<=0){
				temp[k++]=a[first++];				
			}
			else{
				temp[k++]=a[second++];				
			}
		}	
		
		while(first<=first_end){
			temp[k++]=a[first++];
		}
		while(second<=second_end){
			temp[k++]=a[second++];
		}
		
		for(int i=0;i<num;i++,second_end--){
			a[second_end]=temp[second_end];
		}
	}
	
	public static <T extends Comparable<T>> void show(T a[]){
		System.out.println("\n");
		for(int i=0;i<a.length;i++){
			System.out.print(" "+a[i].toString());
		}
		System.out.println("\n");
	}
	
	
	public static void main(String[] a){
		//Integer[] x={24,12,53,90,100,1,6,20};		
		String[] x={"One","World","This","IS"};
		long start_time=System.nanoTime();
		Merge.mergeSort(x);
		long  end_time=System.nanoTime();
		Merge.show(x);       
		System.out.println(" \n"+(end_time-start_time)/100);
	}
}
