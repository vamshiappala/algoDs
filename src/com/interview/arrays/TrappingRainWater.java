package com.interview.arrays;


/**
 * We have an array where each element represents height of a tower. 
 * If it starts raining, what is the amount of water that can be collected between the towers? 
 * Assumption is that the width of every tower is 1. Example:Input - {1,5,2,3,1,7,2} Output - 9
 * See explanation here
 * http://www.ideserve.co.in/learn/trapping-rain-water-between-towers
 * 
 */
public class TrappingRainWater {

	public static int getMaxRainWaterBetweenTowers(int [] arr){
		
		int maxRHeightSoFar=0;
		int maxLHeightSoFar=0;
		int rainwater =0;
		int [] maxRHeights = new int[arr.length] ;
		for (int i= arr.length-1; i>=0; --i){
			if ( arr[i] > maxRHeightSoFar){
				maxRHeights[i]=maxRHeightSoFar=arr[i];
				
			}else {
				maxRHeights[i] =maxRHeightSoFar;
			}
		}
		
		for(int i=0; i < arr.length-1; ++i){
			
			int maxheight=  Math.max( Math.min(maxLHeightSoFar, maxRHeights[i]), 0);
			if (maxheight > arr[i]){
				rainwater += maxheight -arr[i];
			}
			maxLHeightSoFar = Math.max(maxLHeightSoFar,arr[i]);
		}
		return  rainwater;
	}
	
	

    public static void main(String[] args) {
        int[] towerHeight = { 1, 5, 2, 3, 1, 7, 2, 4 };
        System.out.println(TrappingRainWater.getMaxRainWaterBetweenTowers(towerHeight));
    }
}
