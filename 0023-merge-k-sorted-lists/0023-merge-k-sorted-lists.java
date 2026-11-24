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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> pq = new PriorityQueue<>((a, b) -> 
        Integer.compare(a.val, b.val));

        if(lists.length==0)
            return null;

        ListNode ans = new ListNode(-1);
        ListNode temp = ans;

        for(int i = 0;i<lists.length;i++){
            if(lists[i]!=null)
                pq.add(lists[i]);
        }
        while(!pq.isEmpty()){
            ListNode curr = pq.poll();
            temp.next = curr;

            if(curr.next!=null)
                pq.add(curr.next);
            
            temp = temp.next;
        }
        return ans.next;
        
    }
}