package com.wyw.leetCode021_030;

import java.util.ArrayList;
import java.util.List;

public class LeetCode_23_MergeKSortedLists {
	public static void main(String[] args){

		int[] num1 = {-9,3};
		int[] num2 = {5,7};
		ListNode l1 = parseArrayToLinkList(num1);
		ListNode l2 = parseArrayToLinkList(num2);
		List<ListNode> list = new ArrayList<ListNode>();
//		list.add(l1);
//		list.add(l2);
		ListNode result = mergeKLists(list);
		System.out.println(result.val);
		
	}
	public static ListNode mergeKLists(List<ListNode> lists) {
		if(lists == null || lists.size() == 0){
			return null;
		}
		ListNode head = mergeLists(lists, 0 , lists.size() - 1);
		return head;
	}
	public static ListNode mergeLists(List<ListNode> lists, int low, int high){
		
		if(low < high){
			int mid = (low + high) / 2;
			ListNode left = mergeLists(lists, low , mid);
			ListNode right = mergeLists(lists, mid + 1, high);
			return mergeTwoLists(left, right);
		}
		return lists.get(low);
	}
	 public static ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		 
		 ListNode head = null;
		 ListNode tmp = null;
		 if(l1 == null){
			 return l2;
		 }
		 if(l2 == null){
			 return l1;
		 }
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
		 while(l1 != null && l2 != null){
			if(l1 != null && l2 != null){
				if(l1.val <= l2.val){
					tmp.next = l1;
					l1 = l1.next;
					tmp = tmp.next;
				}
				else{
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
