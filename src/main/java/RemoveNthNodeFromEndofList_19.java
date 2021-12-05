import java.util.ArrayList;
import java.util.List;

public class RemoveNthNodeFromEndofList_19 {
//    public static ListNode removeNthFromEnd(ListNode head, int n) {
//        List<Integer> tempList = new ArrayList<>();
//        ListNode cur = head;
//        while (cur != null) {
//            tempList.add(cur.val);
//            cur = cur.next;
//        }
//        if (tempList.size() == 2) { //[1,2]
//            if(n==2){
//                head =head.next;
//                return head;
//            }
//            if(n==1){
//                head.next =null;
//                return head;
//            }
//        }
//        if (tempList.size() == n) { //4-3=1
//            head= head.next;
//            return head;
//        }
//        cur = head;
//        for (int i = 0; i < tempList.size(); i++) {
//
//            if (i == tempList.size() - n -1) { //4-3=1
//                cur.next = cur.next.next;
//                break;
//            }
//            cur = cur.next;
//        }
//        return head;
//    }
public static ListNode removeNthFromEnd(ListNode head, int n) {

    ListNode start = new ListNode(0);
    ListNode slow = start, fast = start;
    slow.next = head; //head 前面補０

    //Move fast in front so that the gap between slow and fast becomes n
    for (int i = 1; i <= n + 1; i++) {
        fast = fast.next;
    }
    //Move fast to the end, maintaining the gap
    while (fast != null) {
        slow = slow.next;
        fast = fast.next;
    }
    //Skip the desired node
    slow.next = slow.next.next;
    return start.next;
}
    public static void main(String[] args){
        ListNode one =new ListNode(1);
        ListNode two =new ListNode(2);
        ListNode three =new ListNode(3);
        ListNode four =new ListNode(4);
        ListNode five =new ListNode(5);
        one.next=two;
        two.next=three;
        three.next=four;
        four.next=five;
        //SwapNodesInPairs_24.swapPairs(one);
        RemoveNthNodeFromEndofList_19.removeNthFromEnd(one,3);
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
