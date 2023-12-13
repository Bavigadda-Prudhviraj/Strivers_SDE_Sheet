package com.prudhvi.linked_list_Part_II;

import com.prudhvi.linked_list_1.ListNode;

public class Intersection_Of_Two_Linked_Lists {

	public static void main(String[] args) {
		int[] arr= {1,2,3,4,5,6};
		ListNode headA=ListNode.convertArrtoLinkedList(arr);
		//second Node
		ListNode headB=createIntersetionPoint(headA);
		ListNode intersectionNode=getIntersectionNode(headA, headB);
		System.out.println(intersectionNode.val);

	}
	
	/*
	This method finds the intersection node of two linked lists, headA and headB. 
	It uses two pointers, pointerA and pointerB, which traverse the linked lists. 
	The pointers move to the next node or switch to the other list if they reach the end of the current list. 
	The loop continues until the intersection point is found or both pointers reach the end (null) if there is no intersection.
	 
	Time Complexity:
		The algorithm has a time complexity of O(N + M), where N and M are the lengths of the input linked lists headA and headB, respectively.
		The code traverses both linked lists once.
	Space Complexity:
		The space complexity is O(1), as the algorithm uses only a constant amount of extra space for the two pointers, regardless of the input size.
	 */
    public static ListNode getIntersectionNode(ListNode headA, ListNode headB) {
    	//Check if either of the linked lists is null. If so, there can be no intersection, and null is returned.
        if (headA == null || headB == null) {
            return null;
        }
        //Initialize two pointers, pointerA and pointerB, both pointing to the heads of their respective linked lists.
        ListNode pointerA = headA;
        ListNode pointerB = headB;
        //In each iteration, check if the current nodes pointed to by pointerA and pointerB are the same. 
        //If they are, an intersection is found, and the loop exits.
        while (pointerA != pointerB) {
        	//Move pointerA to the next node in its list or switch to the other list if it reaches the end (pointerA = (pointerA == null) ? headB : pointerA.next).
            pointerA = (pointerA == null) ? headB : pointerA.next;
            //Move pointerB similarly.
            pointerB = (pointerB == null) ? headA : pointerB.next;
        }
        //If the loop exits because an intersection is found, pointerA now points to the intersection node.
        //If the loop exits because both pointers reach the end (null), there is no intersection, and null is returned.
        return pointerA;
    }
    
    private static ListNode createIntersetionPoint(ListNode headA) {
    	ListNode headB=new ListNode(7);
    	ListNode temp=headB;
    	for(int i=0;i<3;i++) {
    		ListNode newNode=new ListNode(i+8);
    		temp.next=newNode;
    		temp=temp.next;
    	}
    	for(int i=0;i<3;i++) {
    		headA=headA.next;
    	}
    	temp.next=headA;
    	temp=temp.next;
    	for(int i=0;i<3;i++) {
    		ListNode newNode=new ListNode(i+10);
    		temp.next=newNode;
    		temp=temp.next;
    	}
		return headB;
	}
}
