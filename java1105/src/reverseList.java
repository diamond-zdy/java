class ListNode{
    public int data;
    public ListNode next;
    public ListNode(int data){
        this.data = data;
        this.next = null;
    }
}
//头插法也能翻转 下去自己写

class myRever{
    public ListNode head;
    public myRever(){
        this.head = null;
    }
    public ListNode reverse(){
        ListNode prev = null;
        ListNode cur = this.head;
        ListNode newHead = null;
        while (cur != null){
            ListNode curNext = cur.next;
            if (curNext == null){
                newHead = cur;
            }
            cur.next = prev;
            prev = cur;
            cur = curNext;

        }
        return newHead;
    }

    //找出中间节点
    public int getLength(){
        int count = 0;
        ListNode cur = this.head;
        while (cur != null){
            count++;
            cur = cur.next;
        }
        return count;
    }
    public ListNode middleList(){
        ListNode cur = this.head;
        for(int i = 0;i < getLength()/2;i++){
            cur = cur.next;
        }
        return cur;
    }
    public ListNode middleList2(){
        ListNode slow = this.head;
        ListNode fast = this.head;
        while (fast != null && fast.next != null){
            fast = fast.next.next;
            slow = slow.next;

        }
        return slow;
    }
    //找倒数第k个节点
    public ListNode findKToTail(int k) {
        if (k <= 0 || head == null) {
            return null;
        }
        ListNode slow = this.head;
        ListNode fast = this.head;
        while (k - 1 > 0) {
            if (fast.next != null){
                fast = fast.next;
                k--;
            }
        }
        while (fast != null) {
            fast = fast.next;
            slow = slow.next;
        }
        return slow;
    }
}
public class reverseList {

}
