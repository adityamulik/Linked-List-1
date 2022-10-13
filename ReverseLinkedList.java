// Stack Implementation 

/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    /*
     * Time Complexity: O(n) to loop over the list
     * Space Complexity: O(n) to add elements to stack
     *
     *
     */
    public ListNode reverseListStack(ListNode head) {
        
        if (head == null) return null;        
        
        Stack<ListNode> stack = new Stack<>();        
        
        while (head != null) {
            stack.add(head);
            head = head.next;
        }
        
        ListNode dummy = new ListNode(-1);
        head = dummy;
        
        while (!stack.isEmpty()) {
            ListNode current = stack.pop();
            head.next = new ListNode(current.val);
            head = head.next;
        }
        
        return dummy.next;
    }
}

// Two Pointers (100% fast)
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseList(ListNode head) {
        if (head == null) return null;
        
        // logic - using pointers
        
        ListNode prev = null;
        ListNode curr = head;
        ListNode fast = head.next;
        
        while (fast != null) {
            curr.next = prev;
            prev = curr;
            curr = fast;
            fast = fast.next;
        }
        
        curr.next = prev;
                
        return curr;
    }
}

// Recursive
/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode reverseListRecursive(ListNode head) {
        
        if (head == null || head.next == null) return head;

        ListNode newNode = reverseListRecursive(head.next);

        System.out.println(newNode.val + " " + head.val + " " + head.next.val);

        head.next.next = head;
        head.next = null;

        return newNode;
    }
}
