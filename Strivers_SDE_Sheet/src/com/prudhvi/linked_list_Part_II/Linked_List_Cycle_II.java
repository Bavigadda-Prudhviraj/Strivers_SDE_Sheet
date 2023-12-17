package com.prudhvi.linked_list_Part_II;

import com.prudhvi.linked_list_1.ListNode;

public class Linked_List_Cycle_II {

	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9};
		ListNode head = Linked_List_Cycle_II.createLoopLinkedList(arr);
		ListNode loopNode = detectCycle(head);
		System.out.println(loopNode.val);

	}
	/*
	This method detects the starting node of a cycle in a linked list using Floyd's Tortoise and Hare algorithm.
	
	Time Complexity:
		The time complexity is O(N), where N is the number of nodes in the linked list.
		The code traverses the linked list once with the two pointers.
	Space Complexity:
		The space complexity is O(1), as the algorithm uses only a constant amount of extra space regardless of the input size.
	 */
    public static ListNode detectCycle(ListNode head) {
    	//Check if the linked list is empty. If it is, there can be no cycle, and null is returned.
        if (head == null){
            return null;
        }
        //Initialize two pointers, slowPointer and fastPointer, both pointing to the head of the linked list.
        ListNode slowPointer = head;
        ListNode fastPointer = head;
        //Use two pointers to traverse the linked list. 
        while( fastPointer != null && fastPointer.next != null){
        	//The slowPointer moves one step at a time, and the fastPointer moves two steps at a time.
            slowPointer = slowPointer.next;
            fastPointer = fastPointer.next.next;
            //If there is a cycle, the two pointers will eventually meet (Floyd's cycle-finding step).
            if( slowPointer == fastPointer){
            	//If a cycle is detected, reset the slowPointer to the head of the linked list.
                slowPointer = head;
                //Move both pointers one step at a time until they meet. The meeting point is the starting node of the cycle.
                while(slowPointer != fastPointer){
                    slowPointer = slowPointer.next;
                    fastPointer = fastPointer.next;
                }
                //return the loop starting index
                return slowPointer;
            }
        }
        //If no cycle is detected, return null.
        return  null;   
    }
    
	public static ListNode createLoopLinkedList(int[] arr){
		//Create a new ListNode headNode and initialize it with the first element of the given array.
		ListNode headNode=new ListNode(arr[0]);
		//Create a temporary ListNode tempNode and set it equal to headNode.
		ListNode tempNode=headNode;
		//Create a ListNode linkListNode and initialize it as null. This variable will store the node that will create the loop in the linked list.
		ListNode linkListNode=null;
		//Use a for loop to iterate over the remaining elements of the array starting from index 1.
		for(int i=1;i<arr.length;i++) {
			//Inside the loop, create a new ListNode with the current element of the array and assign it to tempNode.next. Move tempNode to the newly created node.
			tempNode.next=new ListNode(arr[i]);
			tempNode=tempNode.next;
			//Check if the current index is 5. If it is, set linkListNode equal to tempNode. 
			//This marks the node at index 5 as the node where the loop will start.
			if(i==5) {
				linkListNode=tempNode;
			}
			
		}
		//After the loop, set the next pointer of tempNode (which currently points to the last node) to linkListNode, 
		//creating a loop in the linked list.
		tempNode.next=linkListNode;
		//ListNode.printLinkedList(headNode);
		return headNode;//Return the headNode of the linked list.
	}

}
