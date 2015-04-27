package com.wyw.leetCode021_030;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_22_GenerateParentheses {
	public static void main(String[] args){

		int n = 2;
		List<String> result = generateParenthesis(n);
		for(String s: result){
			System.out.println(s);
		}
	}
	
    public static List<String> generateParenthesis(int n) {
        
    	List<String> result = new ArrayList<String>();
    	String s = "";
    	int rightTimes = 0;
    	int leftTimes = 0;
//    	generateParenthesis( leftTimes,  rightTimes,  s,  result);
    	generateParenthesis(leftTimes, rightTimes, s, result, n );
    	return result;
    }
   /* public static void generateParenthesis( int leftTimes, int rightTimes, String s, List<String> result){
    	
    	 if(leftTimes==0&&rightTimes==0)  
         {  
             result.add(s);  
         }  
         if(leftTimes>0)  
         {  
        	 generateParenthesis(leftTimes-1,rightTimes,s+'(',result);  
         }  
         if(rightTimes>0&&leftTimes<rightTimes)  
         {  
        	 generateParenthesis(leftTimes,rightTimes-1,s+')',result);  
         } 
        
    }*/
    public static void generateParenthesis( int leftTimes, int rightTimes, String tmp, List<String> result, int n ){
	    if(leftTimes == n && rightTimes == n){
    		result.add(tmp);
	    }
		if(leftTimes < n){
//			tmp += '(';
			generateParenthesis(leftTimes + 1, rightTimes, tmp + "(", result, n);
		}
		if(rightTimes < n && leftTimes > rightTimes){
//			tmp += ')';
			generateParenthesis(leftTimes, rightTimes + 1, tmp + ")", result, n);
				/**
				 * 
				 * 为什么不一致！
				 * 
				 * 
				 */
	    }
    }

}
