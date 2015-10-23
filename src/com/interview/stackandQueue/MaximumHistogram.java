package com.interview.stackandQueue;

import java.util.ArrayDeque;
import java.util.Deque;

public class MaximumHistogram {

	/*
	 * http://www.geeksforgeeks.org/largest-rectangle-under-histogram/
	 * Largest Rectangular Area in a Histogram
	 */
	
	 public static void main(String args[]){
	        MaximumHistogram mh = new MaximumHistogram();
	        int input[] = {6, 2, 5, 4, 5, 1, 6};
	        int maxArea = mh.maxHistogram(input);
	        System.out.println(maxArea);
	        assert maxArea == 12;
	    }

	private int maxHistogram(int[] input) {
		// TODO Auto-generated method stub
		Deque<Integer> stack = new ArrayDeque<Integer>();
		
		int maxarea=0;
		int area=0;
		int i=0;
		for (; i< input.length-1; ++i){
			
			if (stack.isEmpty() || input[i] >= input[stack.peek()]){
				stack.push(i);
			}else {
			    while (!stack.isEmpty() && input[stack.peek()] >= input[i]){
			    	int top=stack.pop();
			    	if (stack.isEmpty()){
			    		 area = i * input[top];
			    		
			    	}else {
			    		 area = (i-stack.peek()-1) * input[top];
			    	}
			    	maxarea=Math.max(maxarea,area);
			    }
			    stack.push(i);
			}
		}
		while (!stack.isEmpty()){
			int top=stack.pop();
	    	if (stack.isEmpty()){
	    		 area = i * input[top];
	    		
	    	}else {
	    		 area = (i-stack.peek()-1) * input[top];
	    	}
	    	maxarea=Math.max(maxarea,area);
		}
		return maxarea;
	}
}
