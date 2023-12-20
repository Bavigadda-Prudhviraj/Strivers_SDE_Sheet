package com.prudhvi.linked_list_and_arrays;

import java.util.HashMap;



public class Copy_List_with_Random_Pointer {
	/*
	The method is used to create a deep copy of a linked list with random pointers. 
    This code optimizes the space complexity by using a two-pass approach
    
	Time Complexity:
    		The time complexity of the code is O(n), where n is the number of nodes in the original linked list. 
    		This is because we iterate through the linked list three times: once for the first pass, once for the second pass, and once for resetting pointers in the original and copied linked lists.

	Space Complexity:
			The space complexity of the code is O(1) because we do not use any additional space that grows with the input size.
	 */
    public Node copyRandomList(Node head) {
    	// Check if the input list is empty
        if(head == null)
        	// If it is, return null since there's nothing to copy
            return head;
        
        Node temp = head;
        // First pass: Create a copy of each node and insert it after the original node
        while(temp != null){
        	// Create a new node with the same value
            Node newNode = new Node(temp.val);
            //Set the new node's next to the original node's next
            newNode.next = temp.next;
            // Insert the new node immediately after the original node
            temp.next = newNode;
            // Move to the next original node (skip the copied node)
            temp = temp.next.next;
        }

        temp = head;
        // Second pass: Set the random pointers of the copied nodes
        while(temp != null){
        	//If the original node's random pointer is not null, set copied node's random to the next node of the original node's random
            temp.next.random = (temp.random == null) ? null : temp.random.next;
            // Move to the next original node (skip the copied node)
            temp = temp.next.next;
        }

        temp = head;
        Node newHead = temp.next;
        Node newTemp = newHead;
        
        // Third pass: Separate the original list and the copied list
        while(temp != null){
        	// Restore the original list's next pointers
            temp.next = temp.next.next;
            // Set the copied list's next pointers
            newTemp.next = (newTemp.next != null) ? newTemp.next.next : null;
            // Move to the next original node
            temp=temp.next;
            // Move to the next copied node
            newTemp = newTemp.next;
        }
        // Return the head of the copied list
        return newHead;
    }
    
    
    
    /*
    note: Brute Force Space Complexity: O(N)
    The given code is used to create a deep copy of a linked list with random pointers
    
    Time Complexity:
    		The time complexity of the code is O(n), where n is the number of nodes in the original linked list. 
    		This is because we iterate over the list twice: once to create the copied nodes and once to assign the random pointers.
	
	Space Complexity:
			The space complexity of the code is O(n), as we use extra space to store the mapping between the original nodes and the copied nodes in the addresses HashMap.
     */
    public Node copyRandomList1(Node head) {
    	//Check if the input head is null. If it is, return null to indicate an empty list.
        if(head==null){
            return null;
        }
        //Create a HashMap addresses to keep track of the mapping between original nodes and copied nodes.
        HashMap<Node,Node> addresses=new HashMap<>();
        //Create two pointers h1 and h2 and initialize h1 with the head of the original list and h2 with a new RandomListNode with the same label as the head node.
        Node h1=head;
        Node deepCopyListNode=new Node(head.val);
        //Create a temporary pointer temp and set it equal to h2.
        Node temp=deepCopyListNode;
        //Add the mapping between h1 (original node) and temp (copied node) to the addresses HashMap.
        addresses.put(h1,temp);
        h1=h1.next;//Move h1 to the next node and iterate over the rest of the original list.
        while(h1!=null){
        	//create a new RandomListNode with the label of the current h1 node 
        	Node node=new Node(h1.val);
            //and assign it to temp.next. 
            temp.next=node;
            //Move temp to the newly created node.
            temp=temp.next;
            //Add the mapping between h1 and temp to the addresses HashMap.
            addresses.put(h1,temp); 
            h1=h1.next;
        }
        //Reset temp to h2 and h1 to head.
        temp=deepCopyListNode;
        h1=head;
        //Iterate over the original list again.
        while(h1!=null){
        	//Inside the loop, set the random pointer of temp to the corresponding copied node stored in the addresses HashMap using the h1.random node as the key.
            temp.random=addresses.get(h1.random);
            //Move both h1 and temp to their next nodes.
            h1=h1.next;
            temp=temp.next;
        }
        //Return the copied linked list h2.
        return deepCopyListNode;
    }

}
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
