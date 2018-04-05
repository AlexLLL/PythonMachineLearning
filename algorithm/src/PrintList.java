import java.util.ArrayList;

public class PrintList {
    public class ListNode {
        int val;
        ListNode next=null;
        ListNode(int data) {
            this.val=data;
        }

    }
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        res=help(res,listNode);
        return res;
    }
    private ArrayList<Integer> help(ArrayList<Integer> p,ListNode head) {
        if (head!=null) {
            if (head.next!=null) {
                help(p,head.next);
            }
            p.add(head.val);
        }
        return p;
    }
}
