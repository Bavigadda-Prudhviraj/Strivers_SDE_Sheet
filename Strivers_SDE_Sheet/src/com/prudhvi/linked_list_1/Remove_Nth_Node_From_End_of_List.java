package com.prudhvi.linked_list_1;

public class Remove_Nth_Node_From_End_of_List {

	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5};
		ListNode head=ListNode.convertArrtoLinkedList(arr);
		ListNode afterNthNodeRemoved=removeNthFromEnd(head, 2);
		ListNode.printLinkedList(afterNthNodeRemoved);

	}
	/*
	This method remove the nth node from the end of a linked list. 
	It uses two pointers, a fast pointer (fast) and a slow pointer (slow), to traverse the list. 
	The start node is introduced to handle the case where the head of the linked list needs to be removed
	
	Time Complexity:
		The algorithm has a time complexity of O(N), where N is the number of nodes in the linked list.
		The code traverses the linked list twice: once to move the fast pointer n nodes ahead and once to find the nth node from the end.
	Space Complexity:
		The space complexity is O(1), as the algorithm uses a constant amount of extra space for the three pointers, regardless of the input size.
	 */
    public static ListNode removeNthFromEnd(ListNode head, int n) {
    	//Create a new node start and set its next pointer to the head of the linked list.
        ListNode start = new ListNode();
        start.next = head;
        //Initialize both fast and slow pointers to the start node.
        ListNode fast = start;
        ListNode slow = start;     
        //Move the fast pointer n nodes ahead in the linked list.
        for(int i = 1; i <= n; ++i)
            fast = fast.next;
        //Move both fast and slow pointers until the fast pointer reaches the end of the list.
        while(fast.next != null)
        {
            fast = fast.next;
            slow = slow.next;
        }
        //At this point, the slow pointer will be at the node preceding the one to be removed.
        //Update the next pointer of the node preceding the target node, effectively skipping the target node.
        slow.next = slow.next.next;
        //Return the next pointer of the start node, which is the head of the modified linked list.
        return start.next; 
    }

}
