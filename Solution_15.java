//获取单链表中倒数第k个节点
//思路1：将链表依次拿出存入数组，然后倒序第K个输出
//思路2：倒数第K个节点即顺数第n-k+1个节点，其中n为单链表的长度，所以需对链表遍历两次，第一次完全遍历获取链表的长度n，第二次从头节点开始遍历n-k+1，然后返回节点即可；
//思路3：再头节点设置两个指针，第一个指针先走k-1步，然后从第K步起，第二个节点也开始遍历，当第一个指针到达链表尾部的时候，第二个指针恰好指在倒数第k个节点上；‍
public class Solution_15 {
    public static void main(String[] lwj){
        ListNode tail=new ListNode(0,null);
        ListNode n1=new ListNode(1,tail);
        ListNode n2=new ListNode(2,n1);
        ListNode n3=new ListNode(3,n2);
        ListNode n4=new ListNode(4,n3);
        ListNode n5=new ListNode(5,n4);
        ListNode head=new ListNode(6,n5);

        System.out.println("思路1测试"+RKnode(head,3));
        System.out.println("思路2测试"+RKnode2(head,3));

    }
    //单链表的定义
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val,ListNode node){
            this.val=val;
            this.next=node;
        }
    }
    //思路2：两次遍历
    public static int RKnode(ListNode node,int k){
        int len=0;
        ListNode  tmp=node;
        //获取单链表的长度
        while (node!=null){
            len++;
            node=node.next;
        }
        //System.out.println("链表长度："+len);
        //获取第n-k+1个节点
        for (int i = 0; i <len-k ; i++) {
            System.out.print(tmp.val);
            tmp=tmp.next;
        }
        return tmp.val;
    }
    //思路3：双指针遍历
    public static int RKnode2(ListNode node,int k){
        ListNode  tmp=node;
        int fir=0;
        int sec=0;
        for (int i = 0; i <k ; i++) {
            node=node.next;
            fir++;
        }
        while (node!=null){
            node=node.next;
            sec++;
            fir++;
        }
        for (int i = 0; i <sec ; i++) {
            tmp=tmp.next;
        }
        return tmp.val;

    }
}
