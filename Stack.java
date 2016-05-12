package com.rgv.algorithms;

public class Stack {
	
	private Object[] values=null;	
	private int size=0;	
	private int top=0;
	
	public Object pop(){		
		if(top<=0)
		{	
			throw new IllegalAccessError("Stack is Empty "+top);
		}
		Object val=this.values[this.top-1];
		top=top-1;
		return val;
	}
	
	public Object top(){		
		if(top<=0)
		{	
			throw new IllegalAccessError("Stack is Empty "+top);
		}
		return this.values[this.top-1];
				
	}
	
	public void push(Object val){
		if(top>=size){
			throw new IllegalAccessError("Stack is full "+size);
		}		
		values[top]=val;
		top=top+1;
	}
	
	Stack(int size){
		this.size=size;
		values=new Object[this.size];
	}
	
	public String toString(){
		StringBuilder stack=new StringBuilder("");
		for (int i=0;i<top;i++)
			stack=stack.append("  "+values[i]);		
		return stack.toString();
			
	}
	
	public int size(){
		return this.top;
	}
	
	
	
	public static void main(String[] a){
		Stack x=new Stack(10);
		
		for(int i=1;i<=10;i++){
			x.push("RECORD "+i);
		}
	
		System.out.println(x);
		
	}
}
