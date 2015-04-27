package com.wyw.leetCode021_030;

public class LeetCode_21_MergeTwoSortedLists {
	public static void main(String[] args){

		int[] num1 = {-9,3};
		int[] num2 = {5,7};
		ListNode l1 = parseArrayToLinkList(num1);
		ListNode l2 = parseArrayToLinkList(num2);
		ListNode result = mergeTwoLists(l1, l2);
		System.out.println();
		
	}
	 public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 
		 ListNode head = null;
		 ListNode tmp = null;
		 if(l1 == null){
			 head = l2;
			 return head;
		 }
		 if(l2 == null){
			 head = l1;
			 return head;
		 }
		 while(l1 != null && l2 != null){
			 if(head  == null){
				 if(l1.val < l2.val){
					 head = l1;
					 l1 =l1.next;
				 }
				 else{
					 head = l2;
					 l2 = l2.next;
				 }
				 tmp = head;
			 }
			 else{
				if(l1 != null && l2 != null && l1.val <= l2.val){
					tmp.next = l1;
					l1 = l1.next;
					tmp = tmp.next;
				}
				if(l1 != null && l2 != null && l2.val <= l1.val){
					tmp.next = l2;
					l2 = l2.next;
					tmp = tmp.next;
				}
			 }
		 }
		 if(l1 != null){
			 tmp.next = l1;
		 }
		 if(l2 != null){
			 tmp.next = l2;
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
}
