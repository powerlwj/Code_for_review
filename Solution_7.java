import java.util.Stack;

public class Solution_7 {

    Stack<Integer> stack1=new Stack<Integer>();
    Stack<Integer> stack2=new Stack<Integer>();

    public static void main(String [] args){


    }
    public int deleteHead(){
        if (!stack2.isEmpty()){
            return stack2.pop();
        }
        while (!stack1.isEmpty()){
            stack2.push(stack1.pop());
        }
        return stack2.pop();
    }
    public void appendTail(int node){
        stack1.push(node);
    }
}
