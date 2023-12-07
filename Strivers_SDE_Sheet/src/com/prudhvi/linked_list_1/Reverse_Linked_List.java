package com.prudhvi.linked_list_1;

public class Reverse_Linked_List {

	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5};
		ListNode head=ListNode.convertArrtoLinkedList(arr);
		ListNode reversedList=reverseList(head);
		ListNode.printLinkedList(reversedList);

	}
	/*
	This method reverse a linked list in-place. 
	It iterates through the linked list, changing the direction of the pointers to reverse the order of the nodes
	
	Time Complexity:
		The algorithm has a time complexity of O(n), where n is the number of nodes in the linked list.
		The code iterates through each node once.
	Space Complexity:
		The space complexity is O(1), as the reversal is done in-place without using additional data structures.
	 */
    public static ListNode reverseList(ListNode head) {
    	//Check if the linked list is empty or has only one node. If so, it is already reversed, and the original head is returned.
        if(head == null || head.next == null){
            return head;
        }
        ListNode currentHead  = head; //Pointer to traverse the original linked list.
        ListNode reversedHead = null; // Pointer to build the reversed linked list.
        while(currentHead != null){
        	//Store the reference to the next node in the original linked list (nextNode).
            ListNode nextNode = currentHead.next;
            //Change the direction of the pointer for the current node (currentHead.next) to point to the previously reversed part of the linked list (reversedHead).
            currentHead.next = reversedHead;
            //Update the reversedHead to be the current node.
            reversedHead = currentHead;
            //Move the currentHead pointer to the next node in the original linked list (nextNode).
            currentHead = nextNode;
        }
        return reversedHead;   
    }
}
