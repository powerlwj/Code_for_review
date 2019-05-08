//在O(1)时间段删除单链表中的节点（给定头结点和要删除的节点）
//思路：一般链表节点的删除是要定位删除节点的前一个节点，然后将前一个节点的指针指向删除节点的下一个节点；
//单链表的节点删除，要删除指定节点，就必须从头结点开始遍历，然后才能找到要删除的节点的前一节点，但是单链表的遍历时间复杂度为O（n），不能满足所需条件
//新的解决方案是：给我要删除节点，那么就可以知道下一节点，所以我将下一节点的值复制到要删除的节点上，然后将要删除节点的指针指向下一节点的下一节点，再删除下一节点，时间复杂度O(1)
public class Solution_13 {
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val,ListNode node){
            this.val=val;
            this.next=node;
        }
    }
    public static void main(String[] lwj){
        ListNode tail=new ListNode(1,null);
        ListNode n2=new ListNode(2,tail);
        ListNode n3=new ListNode(3,n2);
        ListNode n4=new ListNode(4,n3);
        ListNode head=new ListNode(5,n4);
        deleteNode(head,n3);
        while (head!=null){
            System.out.println(head.val);
            head=head.next;
        }
    }
    public static void deleteNode(ListNode head,ListNode deleteNode){
        if (head==null||deleteNode==null) return;
        //如果被删除节点不是尾节点,即正常情况下：
        if (deleteNode.next!=null){
            ListNode tmp=deleteNode.next;
            deleteNode.val=tmp.val;
            deleteNode.next=tmp.next;
            tmp=null;
        }
        //要删除的节点只有一个
        else if (head==deleteNode){
            head=null;
        }
        //如果要删除的节点是尾节点,则需要从头遍历，寻找尾节点的前一个节点
        else {
            while (head.next!=deleteNode){
                head=head.next;
            }
            head.next=null;
        }

    }
}
