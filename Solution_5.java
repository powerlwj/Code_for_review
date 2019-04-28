import java.util.ArrayList;
import java.util.Stack;

//从尾到头将链表输出
//思路：将链表中的节点顺序遍历存入栈中，然后将栈中数据输出打印
public class Solution_5 {
    private class ListNode {
        int val;
        ListNode next = null;
        ListNode(int val) {
            this.val = val;
        }
    }

    public static void main(String[] args){
        printLinkedlist(ListNode listNode);
    }

    public static ArrayList printLinkedlist(ListNode listNode){
        Stack<Integer> stack=new Stack<>();
        while (listNode!=null){
            stack.push(listNode.val);
            listNode=listNode.next;
        }
        ArrayList<Integer> list = new ArrayList<>();
        while (!stack.empty()){
            list.add(stack.pop());
        }
        return list;

    }


}


//思路2：利用Collections的排序性质，但是时间复杂度较高；
import java.util.ArrayList;
import java.util.Collections;
public class Solution {
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        ArrayList<Integer> res=new ArrayList<Integer>();
        while(listNode!=null)
        {
            res.add(listNode.val);
            listNode=listNode.next;
        }
        Collections.reverse(res);
        return res;
    }
}


//思路3：递归简洁版
public class Solution {
    ArrayList<Integer> arrayList=new ArrayList<Integer>();
    public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
        if(listNode!=null){
            this.printListFromTailToHead(listNode.next);
            arrayList.add(listNode.val);
        }
        return arrayList;
    }
}  