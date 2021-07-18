class Solution {
     public ListNode reverseKGroup(ListNode head, int k) {
		
        if (k == 1) return head;
		
        ListNode root = new ListNode(-1);
        root.next = head;
