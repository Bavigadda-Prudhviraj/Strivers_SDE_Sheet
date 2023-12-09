package com.prudhvi.linked_list_1;

public class Merge_Two_Sorted_Lists {

	public static void main(String[] args) {
		int[] arr1= {1,3,5,7,9};
		int[] arr2= {2,4,6,8};
		ListNode list1=ListNode.createLinkedListFromArray(arr1);
		ListNode list2=ListNode.createLinkedListFromArray(arr2);
		ListNode mergedList=mergeTwoLists(list1, list2);
		ListNode.printLinkedList(mergedList);

	}
	/*
	This method merge two sorted linked lists into a single sorted linked list. 
	It uses a dummy node and three pointers (p1, p2, and p3) to traverse and merge the two lists.
	
	Time Complexity:
		The algorithm has a time complexity of O(n + m), where n and m are the lengths of the input lists list1 and list2, respectively.
		The code iterates through both lists once.
	Space Complexity:
		The space complexity is O(1), as the algorithm uses a constant amount of extra space for the three pointers, regardless of the input size.
	 */
    public static ListNode mergeTwoLists(ListNode list1, ListNode list2) {
    	//A dummy node is created to simplify the code and avoid special cases when dealing with the head of the merged list.
        ListNode dummy = new ListNode(-1);
        //p1: Pointer for traversing list1.
        //p2: Pointer for traversing list2.
        //p3: Pointer for building the merged list.
        ListNode p1 = list1, p2 = list2, p3 = dummy;

        while (p1 != null && p2 != null) {
        	//Compare the values of the current nodes pointed to by p1 and p2.
            if (p1.val <= p2.val) {
            	//Connect the smaller node to the merged list through p3.next.
                p3.next = p1;
                p1 = p1.next;
            } else {
            	//Connect the smaller node to the merged list through p3.next.
                p3.next = p2;
                p2 = p2.next;
            }
            //Move the pointer p3 to the last node added to the merged list.
            p3 = p3.next;
        }
        //Connect the remaining nodes of the non-empty list to the merged list.
        p3.next = (p1 != null) ? p1 : p2;
        //Return the next node after the dummy node, which is the head of the merged list.
        return dummy.next;
    }

}
