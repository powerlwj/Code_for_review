import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

//合并两个有序链表
//思路1：将两个链表分别遍历获取各自的元素,遍历的同时将元素放到list中，将list排序，然后新建链表，一一赋值；
public class Solution_17 {
    public static void main(String[] lwj){
        ListNode tail=new ListNode(0,null);
        ListNode n1=new ListNode(1,tail);
        ListNode n3=new ListNode(3,n1);
        ListNode head1=new ListNode(5,n3);


        ListNode tail2=new ListNode(0,null);
        ListNode n2=new ListNode(2,tail2);
        ListNode n4=new ListNode(4,n2);
        ListNode head2=new ListNode(6,n4);

        ListNode res=CombineListnode2(head1,head2);
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

    //思路1：利用list保存数据排序并转为链表
    public static ListNode CombineListnode1(ListNode l1,ListNode l2){
        //先进性边缘判断
        if (l1==null) return l2;
        if (l2==null) return l1;
        ArrayList<Integer> list=new ArrayList<>();
        while (l1!=null){
            list.add(l1.val);
            l1=l1.next;
        }
        while (l2!=null){
            list.add(l2.val);
            l2=l2.next;
        }
        Collections.sort(list);
        int len=list.size();
        int[] arr = list.stream().mapToInt(Integer::valueOf).toArray();
        ListNode res=new ListNode(arr[0]);
        ListNode tmp=res;
        for (int i = 1; i <len ; i++) {
          ListNode tmp2=new ListNode(arr[i]);
          tmp.next=tmp2;
          tmp=tmp2;
        }
        return res;
    }

    //思路2：正常合并
    public static ListNode CombineListnode2(ListNode l1,ListNode l2){
        //边界判断
        if (l1==null) return l2;
        if (l2==null) return l1;
        ListNode res=null;
        if (l1.val<l2.val){
            res=l1;
            res.next=CombineListnode2(l1.next,l2);
        }else {
            res=l2;
            res.next=CombineListnode2(l1,l2.next);
        }
        return res;
    }

}
