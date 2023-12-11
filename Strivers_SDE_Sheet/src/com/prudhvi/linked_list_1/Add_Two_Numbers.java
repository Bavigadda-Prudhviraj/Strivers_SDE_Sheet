package com.prudhvi.linked_list_1;

public class Add_Two_Numbers {

	public static void main(String[] args) {
		int[] num1= {9,9,9,9,9,9,9};
		int[] num2= {9,9,9,9};
		ListNode l1=ListNode.convertArrtoLinkedList(num1);
		ListNode l2=ListNode.convertArrtoLinkedList(num2);
		ListNode sumOfl1Andl2=addTwoNumbers(l1, l2);
		ListNode.printLinkedList(sumOfl1Andl2);

	}
	/*
	This method adds two numbers represented by linked lists. 
	It traverses both linked lists, adds corresponding digits along with the carry, and creates a new linked list to represent the sum
	
	Time Complexity:
		The algorithm has a time complexity of O(max(N, M)), where N and M are the lengths of the input linked lists l1 and l2, respectively.
		The code traverses both linked lists once.
	Space Complexity:
		The space complexity is O(max(N, M)), where N and M are the lengths of the input linked lists l1 and l2, respectively.
		The result linked list can have a length at most max(N, M) + 1.
	 */
    public static ListNode addTwoNumbers(ListNode l1, ListNode l2) {
    	//A dummy node is created to simplify the code and avoid special cases when dealing with the head of the result linked list.
        ListNode dummy = new ListNode(); 
        ListNode temp = dummy; //A temporary pointer is used to traverse the result linked list.
        int carry = 0; //Variable to store the carry from adding digits.
        while( l1 != null || l2 != null || carry == 1) {
        	//Add the values of the current nodes of l1 and l2.
        	//Move l1 and l2 pointers to their next nodes if they are not null.
            int sum = 0; 
            if(l1 != null) {
                sum += l1.val; 
                l1 = l1.next; 
            }
            
            if(l2 != null) {
                sum += l2.val; 
                l2 = l2.next; 
            }
            //Add the carry from the previous step.
            
            sum += carry; 
            //Update the carry for the next iteration.
            carry = sum / 10; 
            //Create a new node with the digit at the units place of the sum.
            ListNode node = new ListNode(sum % 10); 
            //Connect the new node to the result linked list through temp.next.
            temp.next = node; 
            //Move the temp pointer to the last node added to the result linked list.
            temp = temp.next; 
        }
        //Return the next node after the dummy node, which is the head of the result linked list.
        return dummy.next;
    }

}
