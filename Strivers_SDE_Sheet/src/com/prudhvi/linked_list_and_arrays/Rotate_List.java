package com.prudhvi.linked_list_and_arrays;

import com.prudhvi.linked_list_1.ListNode;

public class Rotate_List {

	public static void main(String[] args) {
		int[] arr = { 1,2,3,4,5 };
		ListNode head = ListNode.convertArrtoLinkedList(arr); 
		int k = 2;
		ListNode rotatedHeadListNode = rotateRight(head, k);
		ListNode.printLinkedList(rotatedHeadListNode);

	}
	/*
	The method implements the rotation of a linked list to the right by k places. 
	The rotateRight function takes the head of the linked list and an integer k as input and returns the head of the rotated linked list.
	
	Time Complexity:
		The time complexity is O(N), where N is the number of nodes in the linked list.
		The code iterates through the linked list twice: once to calculate the length and once to find the new head.
	Space Complexity:
		The space complexity is O(1), as the operations are performed in-place without using additional space proportional to the input size.
	 */
    public static ListNode rotateRight(ListNode head, int k) {
    	//Check for base cases. If the linked list is empty, has only one node, or k is 0, no rotation is needed, and the original list is returned.
        if (head == null || head.next == null || k == 0 ) 
            return head;
        //Calculate the length of the linked list and check if k is a multiple of the length. If so, no rotation is needed, and the original list is returned.
        int length = 1;
        ListNode endNode = head;

        while( endNode.next != null ){
            length++;
            endNode = endNode.next;
        }

        if( (k % length) == 0 )
            return head;
        //Connect the end of the linked list to the head to create a circular linked list.
        endNode.next = head;
        //Update k to the remainder when divided by the length.
        k = k % length;
        //Iterate to find the new tail, which is the (length - k - 1)-th node.
        ListNode newTail = head;
        for (int i = 0; i < length - k - 1; i++) 
            newTail = newTail.next;
        //Set the new head and break the circular structure.
        ListNode newHead = newTail.next;
        newTail.next = null;
        //return newHead
        return newHead;
    }

}
