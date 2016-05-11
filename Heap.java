package com.rgv.algorithms;

/**
 * @author rajaganeshv
 * This class uses Heap Sort algorithm to sort a given Array of Comparable elements. ex: String, Integer etc.,
 *
 */
public class Heap {
	
	private static int parent(int index){
		if(index==0) return 0;
		int c=(int)Math.ceil(((double)index)/2);
		return c-1;
	}
	
	private  static  int left(int index){
		if(index==0) return 1;
		return (2*index)+1;
	}
	
	private static  int right(int index){
		if(index==0) return 2;
		return (2*index)+2;
	}

	private static <T extends Comparable<T>> void heapify(T[] a,int index,int arrmax){		
		
		int left=left(index);
		int right=right(index);
		
		T l=left>arrmax?null:a[left];
		T r=right>arrmax?null:a[right];	
		
		T c=a[index];
		
		if(l!=null && r!=null && l.compareTo(r)<0 && c.compareTo(r)<=0)
		{	
			if(right!=arrmax){
				swap(a,right,index);
				heapify(a,right,arrmax);	
			}
			else{
				swap(a,right,index);
				return;
			}
		}
		else if(l!=null && r!=null && l.compareTo(r)>=0 && c.compareTo(l)<=0){	
			
			if(left!=arrmax){
				swap(a,left,index);
				heapify(a,left,arrmax);
			}
			else{
				swap(a,left,index);
				return;
			}
			
		}
		else{		
			
			if(l==null && r!=null && c.compareTo(r)<=0){
				swap(a,right,index);
				return;
			}
			else if(l!=null && r==null && c.compareTo(l)<=0){
				swap(a,left,index);
				return;
			}
			else{		
				//System.out.println(Arrays.toString(a));
				return;
			}
			
			
		}
	}
	
	
	private static  <T extends Comparable<T>> void swap(T[] a,int i,int j){
		T temp=a[i];
		a[i]=a[j];
		a[j]=temp;
	}
	
	
	private static <T extends Comparable<T>> void buildHeap(T[] a){
		for(int i=0;i<a.length;i++){
			add(a,i);			
		}
	}
	
	
	private static <T extends Comparable<T>> int add(T[] a,int index){		
		if(index==0){			
			return index; //root element			
		}
		else{
			int parent=parent(index);			
			while(parent>-1){			
				if(a[parent].compareTo(a[index])<0)
				{			
					swap(a,index,parent);
					index=parent;
					parent=parent(parent);				
				}
				else{
					break;
				}				
			}		
			
		}
		return index;		
	}
	
	/*
	 * The array passed to this method is sorted (in place.) using Heap Sort. 
	 * 
	 * @param a can be any Array that has objects of class implements Comparable interface.
	 * 
	 * 
	 */
	public static <T extends Comparable<T>> void sort(T[] a){
		
		buildHeap(a); //Build a Heap in Place using the Array
		
		int arrmax=a.length-1; //Arraymax
		
		while(arrmax>=1){	
			swap(a,0,arrmax);	//Element at 0 is max. so Swap to last. 
			arrmax=arrmax-1;
			heapify(a,0,arrmax);
		}
	}	
	

}
