import java.util.HashSet;

//链表中环的入口节点
//思路：使用两个指针p1,p2,假设环中共有n个节点，则p1先在链表上移动n位，然后p1和p2再同时移动，当p2移动n位，p1恰好完成一个环回到和p2指向同一个节点，此时返回该节点的值就是环的入口；
//思路2：使用HashSet
public class Solution_56 {
    public static void main(String[] lwj){

        //System.out.println(GetNofListNode(head));
    }
    //先定义一个链表
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val,ListNode node){
            this.val=val;
            this.next=node;
        }
    }
    //使用HashSet,弊端在于：如果链表中存在相同的元素，那就会翻车
    public static ListNode GetNofListNode2(ListNode listNode){
        if (listNode==null) return null;
        //还要判断链表中是否只有两个节点而且成环，因为这时的HashSet是判断不出来的
        if (listNode==listNode.next) return listNode;
        HashSet set=new HashSet();
        while (listNode!=null&&!set.contains(listNode.val)){
            set.add(listNode.val);
            listNode=listNode.next;
        }
        return listNode;
    }

    //先判断链表中是否有环并获取环中节点的个数n
    //判断链表中是否有环的思路：设置两个快慢指针，快指针每次走两步，慢指针每次走一步，这样如果链表中存在环，快指针肯定能追上慢指针
    public static ListNode GetNofListNode(ListNode listNode){
        if (listNode==null||listNode.next==null) return null;
        ListNode fast=listNode;
        ListNode slow=listNode;
        int len=0;
        //循环结束，len的长度即为环中的节点数
        while (fast!=null&&fast.next!=null){
            fast=fast.next.next;
            slow=slow.next;
            len++;
            if (fast==slow){
                break;
            }
        }
        //再次设置两个指针，一个先走len步，另一个再走，然后两者相遇的地方，就是环儿最初的起点
        ListNode p1=listNode;
        ListNode p2=listNode;
        for (int i = 0; i <len ; i++) {
            p1=p1.next;
        }
        while (p1!=p2){
            p1=p1.next;
            p2=p2.next;
        }
        return p1;

    }

}
