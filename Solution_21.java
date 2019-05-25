//包含min函数的栈:实现O(1)的pop,push和寻找当前栈中的最小值，前两个操作的时间复杂度都是满足O(1)的，但是寻找最小值就意味着要对栈排序，由于原始栈不可能在压栈的时候排序，所以
//就需要额外的空间对栈中的元素进行排序，也就是数据栈用来进行pop和push，辅助栈用来排序，即以空间复杂度换区时间复杂度；


import java.util.Stack;

//思路：采用辅助栈，辅助栈在数据栈每次压入元素后与压入的元素进行比较：
// 入栈有两种情况：1. 当前元素>压入元素：数据栈存入压入元素，辅助栈存入压入元素；2. 当前元素<压入元素：数据栈依旧存入压入元素，辅助栈再次存入当前元素；
//出栈的情况：1. 数据栈弹出栈顶元素是辅助栈的栈顶元素（即最小元素），辅助栈弹出栈顶元素，保证数据栈没了最小元素之后辅助栈同步更新，此时辅助栈的栈顶元素为次小元素；
//2. 数据栈顶元素不是辅助栈顶元素
public class Solution_21 {
    public static Stack<Integer> dataStack = new Stack<>();
    public static Stack<Integer> helpStack = new Stack<>();

    public static void main(String[] lwj) {
        Solution_21 s=new Solution_21();
        s.push(3);
        s.push(4);
        s.push(5);
        s.push(1);
        s.push(2);
        s.push(6);

        s.printStack(dataStack);
        System.out.println("------------------");
        s.printStack(helpStack);
        System.out.println("------------------");
        System.out.println(s.Min());

    }
    //压入元素
    public void push(int n) {
        if (dataStack.isEmpty()|| helpStack.isEmpty()){
            dataStack.push(n);
            helpStack.push(n);
        }
        else if (dataStack.peek() > n) {
            dataStack.push(n);
            helpStack.push(n);
        } else {
            helpStack.push(helpStack.peek());
            dataStack.push(n);
        }
    }
    //弹出元素
    public void pop() {
        if (!dataStack.isEmpty() && !helpStack.isEmpty()) {
            dataStack.pop();
            helpStack.pop();
        }
    }
    //获取最小元素
    public int Min() {
        int res=0;
        if (!helpStack.isEmpty()){
            System.out.println(helpStack.pop());
            return helpStack.pop();
        }
        return res;
    }

    //打印栈内所有元素
    public void printStack(Stack<Integer> stack){
        if (stack.isEmpty()) System.out.println("空栈");
        while (!stack.isEmpty()){
            System.out.println(stack.pop());
        }
    }

}
