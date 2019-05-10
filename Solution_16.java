//反转链表并输出反转后链表的头节点
//思路1：遍历链表获取长度n；新建数组长度为n;新建链表将数组中的值一一赋值；输出头节点并返回新链表；
//思路2：三指针方案，定义三个指针，一个指向当前遍历到的节点，一个指向一个指向该节点的前一个节点，另一个指向当前节点的后一个节点；
//思路3：极致的递归
public class Solution_16 {
    public static void main(String[] lwj){
        ListNode tail=new ListNode(0,null);
        ListNode n1=new ListNode(1,tail);
        ListNode n2=new ListNode(2,n1);
        ListNode n3=new ListNode(3,n2);
        ListNode n4=new ListNode(4,n3);
        ListNode n5=new ListNode(5,n4);
        ListNode head=new ListNode(6,n5);
        ListNode res=ReversList3(head);
        while (res!=null){
            System.out.println(res.val);
            res=res.next;
        }
    }
    //链表定义
    public static class ListNode{
        int val;
        ListNode next;
        ListNode(int val){
            this.val=val;
        }
        ListNode(int val,ListNode node){
            this.val=val;
            this.next=node;
        }
    }
    //思路1：

    public static ListNode ReversList1(ListNode head){
        //边缘判断
        if (head==null) return null;
        //获取链表长度
        int len=0;
        ListNode tmp=head;
        while (tmp!=null){
            len++;
            tmp=tmp.next;
        }
        ListNode tmp2=head;
        int [] list=new int[len];
        for (int i = 0; i <len ; i++) {
            list[i]=tmp2.val;
            tmp2=tmp2.next;
        }
        ListNode res=new ListNode(list[len-1]);
        ListNode other=res;
        for (int i = len-2; i >=0 ; i--) {
            //每次循环生成一个新的节点
            ListNode tmpt=new ListNode(list[i]);
            //将新建的节点指向other的下一个节点；
            other.next=tmpt;
            //更新other
            other=tmpt;
        }
        return res;
    }


    //思路2：三指针方案
    public static ListNode ReversList2(ListNode head){
        //边界判断
        //链表为空，返回空
        if (head==null) return null;
        //链表只有一个节点，返回该节点
        if (head.next==null) return head;
        //链表含有多个节点
        ListNode left=null;
        ListNode right=null;

        while (head!=null){
            //先保存head的原本next的节点；
            right=head.next;
            //反转left->head为left<-head;
            head.next=left;
            //将right节点向右移动一位
            left=head;
            //更新head节点为原来保存的节点，循环
            head=right;
        }
        //循环完之后的left即为新链表的头节点；
        return left;
    }
    //思路3：极致递归
    public static ListNode ReversList3(ListNode head){
            if(head == null || head.next == null) return head;
            ListNode preverse=ReversList3(head.next);
            head.next.next=head;
            head.next=null;
            return preverse;
    }
}
