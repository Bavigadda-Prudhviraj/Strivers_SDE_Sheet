package com.prudhvi.linked_list_Part_II;

import com.prudhvi.linked_list_1.ListNode;

public class Palindrome_Linked_List {

	public static void main(String[] args) {
		int[] arr = {1,2,3,3,2,1};
		ListNode head = ListNode.convertArrtoLinkedList(arr);
		boolean isPalindrome = isPalindrome(head);
		System.out.println( isPalindrome );
	}
	/*
	This code checks whether a linked list is a palindrome or not. 
	A palindrome is a sequence that reads the same backward as forward.
	
	Time Complexity:
		The time complexity is O(N), where N is the number of nodes in the linked list.
		The code iterates through the entire linked list twice: once to find the middle and once to compare the reversed second half with the first half.
	Space Complexity:
		The space complexity is O(1), as the reversal is done in-place without using additional space proportional to the size of the input. The recursion stack does not contribute significantly to the space complexity.
    
    */
    public static boolean isPalindrome(ListNode head) {
    	//Check if the linked list is empty or has only one node. In such cases, it's considered a palindrome, and true is returned.
        if (head == null || head.next == null) 
            return true; 
        //Use two pointers (slowPointer and fastPointer) to find the middle of the linked list. 
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        //The slow pointer moves one step at a time, while the fast pointer moves two steps at a time.
        while( fastPointer.next != null && fastPointer.next.next != null){
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
        }
        //Reverse the second half of the linked list starting from the node after the middle.
        slowPointer.next = reverseList(slowPointer.next);
        fastPointer = slowPointer.next;
        slowPointer = head;
        //Compare the first half of the original linked list (slowPointer) with the reversed second half (fastPointer).
        while(fastPointer != null ){
        	//If any nodes are different, return false.
            if(slowPointer.val != fastPointer.val)
                return false;
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next;
        }
        // Otherwise, return true.
        return true;
    }
    public static ListNode reverseList(ListNode head){
         if(head == null || head.next == null)
            return head;
            
        ListNode currentHead = head;
        ListNode reversedHead =  null;

        while(currentHead != null){
            ListNode nextNode = currentHead.next;
            currentHead.next = reversedHead;
            reversedHead = currentHead;
            currentHead =  nextNode;
        }
        return reversedHead;
    }

}
