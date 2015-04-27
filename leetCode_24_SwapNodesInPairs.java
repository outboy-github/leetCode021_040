package com.wyw.leetCode021_030;

public class LeetCode_24_SwapNodesInPairs {
	public static void main(String[] args){

		int[] num1 = {1,2,3};
		ListNode l1 = parseArrayToLinkList(num1);

		System.out.println(l1.val);
		ListNode head = swapPairs(l1);
		System.out.println(head.val);
		
	}
	
    public static ListNode swapPairs(ListNode head) {
    	
    	if(head == null || head.next == null){
    		return head;
    	}
    	
    	ListNode prevprev = null;
    	ListNode prev = head;
    	ListNode p = head;
    	
    	while(p != null && p.next != null){
    		prev = p;
    		p = p.next;
    		
    		ListNode pNext = p.next;
    		
    		if(prev == head){
    			head = p;
    		}
    		p.next = prev;
    		prev.next = pNext;
    		if(prevprev != null){
    			prevprev.next = p;
    		}
   			prevprev = prev;
   			p = pNext;
    	}
    	return head;
   	}
    /* public static ListNode swapPairs(ListNode head) {
	    
    	if(head == null || head.next == null){
    		return head;
    	}
    	
    	int headVal = head.val; 
    	head.val = head.next.val;
    	head.next.val = headVal;

    	ListNode tmp = head.next.next;
    	while(tmp != null && tmp.next != null){
    		int val = tmp.val; 
        	tmp.val = tmp.next.val;
        	tmp.next.val = val;
        	tmp = tmp.next.next;
    	}
    	return head;
   	}*/
	public static ListNode parseArrayToLinkList(int[] num){
		 ListNode head = null;
		 ListNode tmp = null;
		 if(num.length == 0){
			 return head;
		 }
		 for( int i : num){
			 ListNode node = new ListNode(i);
			 if(head == null){
				 head = node;
			 }
			 else{
				 tmp.next = node;
			 }
			 tmp = node;
		 }
		 return head;
	 }
	public static class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
			next = null;
		}
	}
	 
}
