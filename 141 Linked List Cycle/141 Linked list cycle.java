public class Solution {
    public boolean hasCycle(ListNode head) {
        
        if(head == null ){
            return false;
        }
        
        ListNode slow = head;
        ListNode fast = head.next;
        
        while(slow != null || fast != null){
            if(fast == null || fast.next == null){
                return false;
            }
            
            if(fast == slow){
                return true;
            }
            
            slow = slow.next;
            fast = fast.next.next;
        }
        
        return false;
        
    }
}
