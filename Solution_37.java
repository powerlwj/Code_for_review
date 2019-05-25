import java.util.Stack;

//两个链表的第一个公共节点；
//思路1：以第一个链表为基准，对第二个链表进行遍历；
//思路2：利用单链表的特性：1→3→5→7→9和2→4→6→7→9两个链表在内存中的位置，节点4是相同的，即两个链表公用一个节点，有因为是单链表的缘故，后面只能有一个next数组，所以两个链表后面的元素都是相同的
//这有点像一个字母Y，而非字母X；但是要利用辅助栈，即用空间换取时间；
//思路3：根据单链表的特性，只要从第一个公共节点开始，两个链表就合二为一，所以只要遍历到第一个公共节点就行；但是链表长度不同，简单的方法是，先让长链表走完多余的节点，然后同时遍历；
// 先遍历获取各个链表的长度，然后长链表先遍历，再同时开始遍历，相同的元素即所求；
public class Solution_37 {
    public static void main(String[] lwj){

        ListNode tail=new ListNode(0,null);
        ListNode n1=new ListNode(1,tail);
        ListNode n3_2=new ListNode(32,n1);
        ListNode n3_1=new ListNode(31,n3_2);
        ListNode n3=new ListNode(3,n3_1);
        ListNode n5=new ListNode(5,n3);
        ListNode head1=new ListNode(6,n5);



        ListNode tail2=new ListNode(2,null);
        ListNode n2=new ListNode(4,tail2);
        ListNode n4=new ListNode(5,n2);
        ListNode head2=new ListNode(6,n4);

        ListNode res=FirstSameNode3(head1,head2);
        System.out.println(res.val);

    }
    //链表的定义
    public static class ListNode{
        int val;
        ListNode next;
        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

    }
    //思路1：一个链表为基准，遍历另一个,缺点在于时间复杂度太高；
    public static ListNode FirstSameNode(ListNode node1,ListNode node2){
        //边界判断
        if (node1==null || node2==null) return null;
        ListNode res=null;
        while (node1!=null){
            int ele1=node1.val;
            while (node2!=null){
                int ele2=node2.val;
                if (ele1==ele2) {
                    return node1;
                }
                node2=node2.next;
            }

            node1=node1.next;
        }
        return res;
    }
    //有共同节点的两个单项链表最终的归宿肯定是相同的，，所以我们倒着比较，最后一个相同元素就是他们的第一个公共节点；
    //因为单链表无法倒序比较，因此我们利用栈作为辅助空间，将两根链表分别压栈，然后比较栈顶元素，相同则出栈，最后一个出栈的元素即第一个公共节点；
    public static ListNode FirstSameNode2(ListNode node1,ListNode node2){
        Stack<ListNode> stack1=new Stack<>();
        Stack<ListNode> stack2=new Stack<>();
        //边界判断
        if (node1==null || node2==null) return null;
        ListNode res=null;
        //链表入栈
        while (node1!=null){
            stack1.push(node1);
            node1=node1.next;
        }
        System.out.println(stack1.peek().val);
        while (node2!=null){
            stack2.push(node2);
            node2=node2.next;
        }
        System.out.println(stack2.peek().val);
        //压栈完成之后，开始比较
        while (!stack1.isEmpty()&&!stack2.isEmpty()){
            ListNode l1=stack1.pop();
            ListNode l2=stack2.pop();
            if (l1.val==l2.val){
                res=l1;
                System.out.println("-------");
                System.out.println(res.val);
            }else {
                break;
            }
        }
        return res;
    }
    //思路3：先获得两个链表的长度，然后在较长的链表上先走若干步(两链表长度之差)，接着同时在两个链表上遍历，
    // 找到的第一个相同的节点就是他们的第一个公共节点。时间复杂度O(m + n)。
    public static ListNode FirstSameNode3(ListNode node1,ListNode node2){
        //在做链表的重复操作时，一定要记得复制新的链表进行操作，不要破坏原始链表的结构
            ListNode head1=node1;
            ListNode head2=node2;
            int l1=Getlen(head1);
            int l2=Getlen(head2);
            int gap=l1-l2;
            //谁长了就先走
            if (gap>0){
                for (int i = 0; i <gap; i++) {
                    node1=node1.next;
                }
            }else {
                for (int i = 0; i <Math.abs(gap); i++) {
                    node2=node2.next;
                }
            }
            //此时两个链表等长，一起登场，遍历判断
            while (node1!=null && node2!=null && node1.val!=node2.val){
                node1=node1.next;
                node2=node2.next;
            }
            ListNode res=node1;
            return res;
    }
    public static int Getlen(ListNode node){
        int len=0;
        if (node==null) len=0;
        while (node!=null){
            ++len;
            node=node.next;
        }
        return len;
    }


}
