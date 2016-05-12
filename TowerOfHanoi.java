package com.rgv.algorithms;

public class TowerOfHanoi {
	
	public Stack tower1=null;	
	public Stack tower2=null;
	public Stack tower3=null;
	
	public int discs=0;
	
	/*
	 * Initializes the problem, creating three towers.
	 */
	TowerOfHanoi(int discs){
		this.discs=discs;
		this.tower1=new Stack(discs);
		this.tower2=new Stack(discs);
		this.tower3=new Stack(discs);
		populateTower();
	}
	
	/*
	 * Initializes First Tower with the disc values.
	 * 
	 */
	private void populateTower(){
		int x=this.discs;
		for(int i=0;i<this.discs;i++){
			tower1.push(new String(x+""));
			x=x-1;
		}
	}
	
	/*
	 * @see java.lang.Object#toString()
	 */
	public String toString(){		
		StringBuilder t1= new StringBuilder("TOWER 1: "+this.tower1+" \n");
		t1.append("TOWER 2: "+this.tower2+" \n");
		t1.append("TOWER 3: "+this.tower3+" \n");
		return t1.toString();
	}
	
	/*
	 * Returns the sequence of discs to move at each step.
	 * @param number of discs.
	 * 
	 * CREDIT/REFERENCE - http://mathworld.wolfram.com/TowerofHanoi.html
	 * 
	 */
	private int[] sequence(int discs){
		int[] steps=null;
		if(discs==1)
		{
			steps=new int[]{1};
		}
		else{
			int[] prevSteps=sequence(discs-1);
			int size=(prevSteps.length*2)+1;
			steps=new int[size];
			int f=0;
			int s=0;
			for(int j=0;j<size;j++){				
				if(j<prevSteps.length){
					steps[j]=prevSteps[f];
					f=f+1;
				}
				if(j==prevSteps.length){
					steps[j]=discs;
				}	
				if(j>prevSteps.length){				
					steps[j]=prevSteps[s];
					s=s+1;
				}					
			}			
			
			
		}
		return steps;		
	}
	
	
	
	public int solveTower(){
		
		int[] steps=sequence(this.discs);		
			
		for(int i=0;i<steps.length;i++){	// cycle thru steps.	
			
			if(tower1.size()!=0 && tower1.top().equals(steps[i]+"")){ // Find the tower in which the disc is present.
				String x=tower1.pop().toString();
				if(this.discs%2!=0){			// Sequence of events if the Discs are odd.
					if(steps[i]%2==0){			// If the tower is even
						tower2.push(x);
					}
					else{						//	If the tower is odd.
						tower3.push(x);
					}
				}else{							// Sequence of events if the Discs are even.
					if(steps[i]%2==0){
						tower3.push(x);
					}
					else{
						tower2.push(x);
					}
				}
			}
			else if(tower2.size()!=0 &&  tower2.top().equals(steps[i]+"")){
				String x=tower2.pop().toString();
				if(this.discs%2!=0){
					if(steps[i]%2==0){
						tower3.push(x);
					}
					else{
						tower1.push(x);
					}
				}
				else{
					if(steps[i]%2==0){
						tower1.push(x);
					}
					else{
						tower3.push(x);
					}
				}
			}
			else if(tower3.size()!=0 &&  tower3.top().equals(steps[i]+"")){
				String x= tower3.pop().toString();
				if(this.discs%2!=0){
					if(steps[i]%2==0){
						tower1.push(x);
					}
					else{
						tower2.push(x);
					}
				}
				else{
					if(steps[i]%2==0){
						tower2.push(x);
					}
					else{
						tower1.push(x);
					}
				}
			}
		
			System.out.println(this.toString());
		}
			
		return steps.length;
	}
	
	public static void main(String[] a){
		
		int discs=4;		//Initialize with Number of Discs.
		
		TowerOfHanoi t=new TowerOfHanoi(discs);		
		System.out.println("Solving Tower ");
		System.out.println(t);
		
		int i=t.solveTower();
		
		System.out.println("It took "+i+" steps to solve Three towers with "+discs+" discs");
		
	}
}
