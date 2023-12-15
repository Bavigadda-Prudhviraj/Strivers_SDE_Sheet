package com.prudhvi.linked_list_Part_II;

import com.prudhvi.linked_list_1.ListNode;

public class Reverse_Nodes_In_k_Group {

	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5};
		ListNode head=ListNode.convertArrtoLinkedList(arr);
		int k=2;
		ListNode reversedListNode=reverseKGroup(head, k);
		ListNode.printLinkedList(reversedListNode);

	}
	/*
	This method is for reversing nodes in k-group in a linked list. 
	It takes the head of a linked list and an integer k as input and reverses every k nodes in the list. 
	If the number of nodes in the last group is less than k, they remain unchanged.
	
	 */
    public static ListNode reverseKGroup(ListNode head, int k) {
    	//Check if the input linked list is null or if k is less than or equal to 1. If true, return the input list as no reversal is needed.
        if(head == null || k <= 1){
            return head;
        }
        int index = k;//Initialize a counter index to k.
        ListNode currentHead = head;//is a pointer to the current head of the group being processed.
        ListNode reversedHead = null;//is a pointer to the head of the reversed group.
        //Reverse the first k nodes:
        while(currentHead != null && index > 0){
        	//Save the next node (temp) of the current head.
            ListNode temp = currentHead.next;
            //Update the next pointer of the current head to point to the reversed part.
            currentHead.next = reversedHead;
            //Move the reversedHead pointer to the current head.
            reversedHead = currentHead;
            //Move the currentHead pointer to the saved next node.
            currentHead = temp;
            index--;//Decrease the counter index.
        }
        //If there are fewer than k nodes left, recursively reverse the remaining nodes.
        if(index > 0){
           return  reverseKGroup(reversedHead,k - index);
        }
        //Connect the reversed group to the next reversed group.
        head.next = reverseKGroup(currentHead,k);
       //Return the head of the final reversed list.
        return reversedHead;
     }
}
