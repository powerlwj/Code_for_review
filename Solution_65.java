import java.util.*;

//滑动窗口的最大值：给定数组和滑动窗口的大小，输出所有滑动窗里最大的数
//思路1：暴力法：两层循环，外层循环控制滑动窗在数组的移动，内存循环遍历滑动窗内的小数组，找出最大值
public class Solution_65 {
    public static void main(String[] lwj) {
        int arr[] = {4, 3, 5, 4, 3, 3, 6, 7};
        ArrayList list = MaxValue2(arr, 3);
        System.out.println(list);

    }

    //思路1：暴力法
    public static int[] MaxValue(int[] array, int len) {
        int[] res = new int[array.length];
        //边界判断
        if (array.length == 0) return null;
        if (len == 0 || len>array.length) return array;
        //第一层循环控制滑动窗的移动
        for (int i = 0; i < array.length; i++) {
            //内层小循环
            int[] tmp=Arrays.copyOfRange(array,i,i+len);
            res[i]=maxTmp(tmp);
        }
        return res;
    }
    //寻找数组中的最大值
    public static int maxTmp(int[] tmp) {
        int max = tmp[0];
        for (int i = 0; i < tmp.length; i++) {
            if (tmp[i] > max) {
                max = tmp[i];
            }
        }
        return max;
    }

    //思路2：
    public static ArrayList<Integer> MaxValue2(int[] array, int len){
        ArrayList<Integer> res=new ArrayList<>();
        //边界判断
        if (array.length == 0) return null;
        if (len == 0 || len>array.length) return res;
        Deque deque=new LinkedList();
        for (int i = 0; i <array.length; i++) {
            if (!deque.isEmpty()){
                if (i>=(int)deque.peek()+len){
                    deque.pop();
                }
                while (!deque.isEmpty()&&array[i]>=array[(int)deque.getLast()]){
                    deque.removeLast();
                }
            }
            deque.offer(i);
            if (i+1>len){
                res.add(array[(int)deque.peek()]);
            }
        }
        return res;
    }
}
