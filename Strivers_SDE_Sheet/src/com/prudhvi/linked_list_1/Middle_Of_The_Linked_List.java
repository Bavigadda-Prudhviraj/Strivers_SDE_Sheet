package com.prudhvi.linked_list_1;

public class Middle_Of_The_Linked_List {

	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5};
		ListNode head=ListNode.convertArrtoLinkedList(arr);
		ListNode middleNode=middleNode(head);
		ListNode.printLinkedList(middleNode);

	}
	/*
	This method finds the middle node of a linked list. 
	It uses the slow and fast pointer approach, where the slow pointer moves one step at a time, and the fast pointer moves two steps at a time. 
	This ensures that when the fast pointer reaches the end of the list, the slow pointer will be at the middle node
	
	Time Complexity:
		The algorithm has a time complexity of O(n), where n is the number of nodes in the linked list.
		The slow pointer makes one pass through the list, and the fast pointer makes two passes.
	Space Complexity:
		The space complexity is O(1), as the algorithm uses a constant amount of extra space for the two pointers, regardless of the input size.
	 */
    public static ListNode middleNode(ListNode head) {
    	//Initialize two pointers, slowPointer and fastPointer, both pointing to the head of the linked list.
        ListNode slowPointer = head;
        ListNode fastPointer = head;
       
        //The loop continues as long as the fastPointer and its next node are not null (to handle both even and odd-sized lists).
        while(fastPointer.next != null  &&  fastPointer.next.next != null){
        	//In each iteration,
        	//move the slowPointer one step (slowPointer = slowPointer.next).
            slowPointer = slowPointer.next;
            //Move the fastPointer two steps (fastPointer = fastPointer.next.next).
            fastPointer = fastPointer.next.next;
        }
        //If the fastPointer reached the end of the list (indicating an odd-sized list), return the current slowPointer.
        if(fastPointer.next == null)
            return slowPointer;
        //If the fastPointer is not at the end of the list (indicating an even-sized list), return the next node after the slowPointer.
        return slowPointer.next;
    }

}
