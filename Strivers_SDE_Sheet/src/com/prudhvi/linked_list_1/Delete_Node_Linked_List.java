package com.prudhvi.linked_list_1;



public class Delete_Node_Linked_List {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5};
		ListNode  head = ListNode.convertArrtoLinkedList(arr);
		ListNode temp  = head;
		for(int i=1; i<3; i++) 
			temp=temp.next;
		deleteNode(temp);
		ListNode.printLinkedList(head);
		

	}
	/*
	This method deletes a node from a singly linked list given access only to that node (not the head of the list). 
	Instead of traditional deletion where you have to update the previous node's next pointer, this approach copies the value of the next node into the current node and then skips the next node, effectively removing the current node.
	 
	Time Complexity:
		The algorithm has a time complexity of O(1), as it involves a constant number of operations regardless of the size of the linked list.
		The deletion is performed in a single pass.
	Space Complexity:
		The space complexity is O(1), as the algorithm uses only a constant amount of extra space regardless of the input size.
	 */
    public static void deleteNode(ListNode node) {
    	//Copy the value of the next node (node.next.val) into the current node (node.val).
        node.val  = node.next.val;
        //Update the next pointer of the current node (node.next) to point to the node after the next node (node.next.next).
        node.next = node.next.next;
    }
}
