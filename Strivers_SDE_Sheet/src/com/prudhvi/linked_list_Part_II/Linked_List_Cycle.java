package com.prudhvi.linked_list_Part_II;

import com.prudhvi.linked_list_1.ListNode;

public class Linked_List_Cycle {

	public static void main(String[] args) {
		int[] arr= {3,2,0,-4};
		ListNode head=ListNode.convertArrtoLinkedList(arr);
		createCycle(head);
		boolean hasCycle=hasCycle(head);
		System.out.println(hasCycle);
		
	}
	/*
	This method checks if a linked list contains a cycle (i.e., if it has a loop) using the Floyd's Tortoise and Hare algorithm
	
	Time Complexity:
		The algorithm has a time complexity of O(N), where N is the number of nodes in the linked list.
		The code traverses the linked list once.
	Space Complexity:
		The space complexity is O(1), as the algorithm uses only a constant amount of extra space for the two pointers, regardless of the input size.
	 */
	public static boolean hasCycle(ListNode head) {
	    // Check for empty list or a list with only one node
	    if (head == null || head.next == null) {
	        return false;
	    }
	    // Initialize slow and fast pointers to the head of the list
	    ListNode slowPointer = head;
	    ListNode fastPointer = head;
	    // Move pointers until the end of the list or a cycle is detected
	    while (fastPointer.next != null && fastPointer.next.next != null) {
	        // Move slow pointer one step
	        slowPointer = slowPointer.next;
	        // Move fast pointer two steps
	        fastPointer = fastPointer.next.next;

	        // If slow and fast pointers meet, there is a cycle
	        if (slowPointer == fastPointer) {
	            return true;
	        }
	    }
	    // If the loop completes without meeting, there is no cycle
	    return false;
	}
	public static void createCycle(ListNode head){
		ListNode tempListNode=head;
		int i=0;
		while(i<3) {
			tempListNode=tempListNode.next;
			i++;
		}
		tempListNode.next=head.next;
	}


}
