import java.util.HashMap;

//复杂链表的复制
//思路1：借助辅助空间，利用HashMap存储对应的关系
//思路2：不使用辅助空间的三步走法；
public class Solution_26 {
    public static void main(String[] lwj) {

    }

    //复杂链表的定义
    public static class ListNode {
        int val;
        ListNode next;
        ListNode random;

        public ListNode(int val) {
            this.val = val;
        }

        public ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }

        public ListNode(int val, ListNode next, ListNode random) {
            this.val = val;
            this.next = next;
            this.random = random;
        }
    }

    //思路1：
    public static ListNode ListCopy1(ListNode head){
        //边缘判断
        if (head==null) return null;
        HashMap<ListNode,ListNode> map=new HashMap<>();
        //新建两个链表，用HashMap存储两个相同的链表
        ListNode pre=head;
        ListNode newpre=new ListNode(head.val);
        //先放头节点
        map.put(pre,newpre);
        while (pre.next!=null){
            //每次进来都是新建一个节点
            newpre.next=new ListNode(pre.next.val);
            pre=pre.next;
            newpre=newpre.next;
            map.put(pre,newpre);
        }
        pre=head;
        newpre=new ListNode(head.val);
        while (newpre!=null){
            newpre.random=map.get(pre.random);
            pre=pre.next;
            newpre=newpre.next;
        }
        return head;
    }
    //思路2：
    public static ListNode ListCopy2(ListNode head){
        //边界判断
        if (head==null) return null;
        //第一步：不考虑兄弟节点，只复制当前节点并连接到其后面；
        ListNode h=head;
        clone(h);
        //第二步：考虑兄弟节点，如果原始的N指向了S，那么新的链表应有N'指向S'
        ListNode s=h;
        cloneRandom(s);
        //第三部：待补充
        return s;
    }

    public static void clone(ListNode head){
        //举例：A → B → C  变为：  A → A'→ B→ B' → C→ C'
        while (head!=null){

            ListNode tmp=new ListNode(head.val);
            tmp.next=head.next;
            head.next=tmp;
            head=tmp.next;//将A转为B，重复上述操作
        }

    }
    public static void cloneRandom(ListNode head){
        while (head!=null){
            if (head.random!=null){
                ListNode rdm=new ListNode(head.val);
                rdm.next=head.next;
                head.next=rdm;
                head=rdm.next;

            }
        }
    }

}
