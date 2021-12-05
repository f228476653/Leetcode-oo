import java.util.ArrayList;
import java.util.List;
// TODO:look up linkedlist pointer
public class SwapNodesInPairs_24 {
    public static ListNode swapPairs(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }
        ListNode newHead = head.next;
        ListNode cur = head; //1
        while (cur != null && cur.next != null) {
            ListNode temp = cur;
            cur = cur.next;//2
            temp.next = cur.next; //134
            cur.next = temp; //2134
            cur = temp.next;
            if (cur != null && cur.next != null) temp.next = cur.next;
        }
        return newHead;


}
    public static class ListNode {
     int val;
     ListNode next;
      ListNode() {}
      ListNode(int val) { this.val = val; }
      ListNode(int val, ListNode next) { this.val = val; this.next = next; }
  }
    public static void main(String[] args){
        ListNode one =new ListNode(1);
        ListNode two =new ListNode(2);
        ListNode three =new ListNode(3);
        one.next=two;
        two.next=three;
        SwapNodesInPairs_24.swapPairs(one);
        //SwapNodesInPairs_24.removeNthFromEnd(one,3);
    }
}
