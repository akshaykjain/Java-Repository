import java.util.ArrayList;

/*--------------------------------------------------------------------------------------------------------------
You are given two non-empty linked lists representing two non-negative integers. The digits are stored in 
reverse order and each of their nodes contain a single digit. Add the two numbers and return it as a linked 
list. You may assume the two numbers do not contain any leading zero, except the number 0 itself.
Example:
Input: (2 -> 4 -> 3) + (5 -> 6 -> 4)
Output: 7 -> 0 -> 8
--------------------------------------------------------------------------------------------------------------*/


/*
Definition for singly-linked list.
public class ListNode 
{
	int val;
	ListNode next;
	
	ListNode(int x) 
	{ 
		val = x; 
	}
}
*/

public class LinkedListAddition 
{
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) 
    {
        ListNode head = null;
        ListNode temp = null;
        ListNode previous = null;
        int carry = 0;
        int sum;
        while(l1 != null || l2 != null)
        {
            sum = carry + (l1 != null ? l1.val : 0) + (l2 != null ? l2.val : 0);
            carry = (sum >= 10) ? 1 : 0;
            sum = sum % 10;
            temp = new ListNode(sum);
            
            if(head == null)
            {
                head = temp;
            }
            else
            {
                previous.next = temp;
            }
            previous = temp;
            if (l1 != null)
            {
                l1 = l1.next;
            }
            if (l2 != null)
            {
                l2 = l2.next;
            }
        }
        if(carry == 1)
        {
            temp.next = new ListNode(carry);
        }
        return head;
    }
}