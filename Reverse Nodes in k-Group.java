class Solution {
     public ListNode reverseKGroup(ListNode head, int k) {
		
        if (k == 1) return head;
		
        ListNode root = new ListNode(-1);
        root.next = head;
	
	int count = countNodes(head);
        int reverseCount = count / k;
        ListNode node = root;
        while (reverseCount > 0) {
            node = reverse(node, k);
            reverseCount--;
        }

        return root.next;
    }
