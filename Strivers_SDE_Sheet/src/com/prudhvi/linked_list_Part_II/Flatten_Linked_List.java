package com.prudhvi.linked_list_Part_II;
class Node
{
	int data;
	Node next;
	Node bottom;
	
	Node(int d)
	{
		data = d;
		next = null;
		bottom = null;
	}
}
public class Flatten_Linked_List {
	/*
	The method is to flatten a linked list with a structure that includes both horizontal and vertical pointers. 
	The flatten function recursively flattens the linked list, and the mergeTwoLists function is used to merge two linked lists in a sorted manner.
	Time Complexity:

		1. The `flatten` function involves recursion and calls the `mergeTwoLists` function, which iterates through the nodes of the linked lists once. The recursion in `flatten` will visit all nodes in the linked list.
		2. The `mergeTwoLists` function, in the worst case, iterates through all the nodes once.
		Therefore, the overall time complexity is indeed O(N), where N is the total number of nodes in the linked list.
		
	Space Complexity:
		
		1. The space complexity is determined by the recursion stack in the `flatten` function. In the worst case, the maximum depth of the recursion stack is O(log n) (if the linked list is perfectly balanced).
		2. The `mergeTwoLists` function uses a constant amount of extra space, mainly for the `dummy` and `resultNode` variables.
		Therefore, the overall space complexity of the given code is O(log n) due to the recursion stack.

	 */
    public static Node flatten(Node root){
    	//The base case checks if the current node or the next node is null. If either is null, it returns the current node.
	    if(root == null || root.next == null)
	        return root;
	    //It then recursively flattens the next node (root.next).
	    root.next = flatten(root.next);
	    //After flattening, it merges the current node and the flattened next node using the mergeTwoLists function.
	    root = mergeTwoLists(root, root.next);
	    //The merged result is returned.
	    return root;
    }
    public static Node mergeTwoLists(Node head1, Node head2){
    	//It uses a dummy node (dummy) to build the merged list.
        Node dummy = new Node(0);
       
        Node resultNode = dummy;
        // //The node with smaller data is added to the merged list (resultNode), and the respective pointers are moved forward.
        while(head1 != null && head2 != null){
            if(head1.data < head2.data){
                resultNode.bottom = head1;
                head1 = head1.bottom;
                resultNode = resultNode.bottom;
            }else{
                resultNode.bottom = head2;
                head2 = head2.bottom;
                resultNode = resultNode.bottom;
            }
        }
        //The remaining nodes from the non-null list are attached to the merged list.
        resultNode.bottom = (head1 == null) ? head2 : head1;
        //The merged list is returned.
        return dummy.bottom;
    }

}
