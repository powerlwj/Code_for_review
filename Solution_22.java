import java.util.Stack;

//判断栈的压入和弹出顺序
//思路：使用辅助栈，先将入栈数组进行入栈，在入栈的过程中进行判断，每次入栈一个，就去判断入栈元素是不是当前出栈元素的栈顶，如果是，直接出栈，如果不是，接着对入栈元素进行入栈操作；
public class Solution_22 {

        public static void main(String[] lwj){
            int[] pushA={1,2,3,4,5};
            int[] popB={4,5,3,2,1};
            System.out.println("判定结果是："+IsPopOrder(pushA,popB));
        }
        public static boolean IsPopOrder(int [] pushA,int [] popB) {
            //pushA是入栈数组，popB是给定的出栈数组；
            //思路：利用辅助栈
            Stack<Integer> stack=new Stack<Integer>();
            //边界判断
            if(pushA.length==0||popB.length==0) return true;
            //先把入栈数组入栈
            int j = 0;
            for(int i=0;i<pushA.length;i++){
                stack.push(pushA[i]);
                //每次入栈就开始判断：
                while(j<pushA.length && stack.peek()==popB[j]){
                    stack.pop();
                    j++;
                }

            }

            return stack.empty()? true:false;

        }

}
