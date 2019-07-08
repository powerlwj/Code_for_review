import java.util.HashMap;

//数组类：数组中重复的数字
//思路1：双循环暴力OB法：
//思路2：利用HashMap，将数字从头到尾依次放入Map，放入之前先利用containsKey()函数进行判断，如果存在，直接返回
//思路3：在数组重排列的过程中查找重复的数:具体操作：
//遍历，如果位置i上的数值（m）并不是i,则交换该值和数组中第i个值,交换之后接着判断，如果不等接着交换，如果相等，进入下一个（n），此时要先判断m和n是否相等，如果想等，找到重复值
//如果不等，重复进入上一行中的操作；
public class Solution_51 {
    public static void main(String[] lwj) {
        int[] arr = {2, 3, 1, 0, 2, 5, 3};
        System.out.println("重复的数字为：" + duplicate3(arr, 7));

    }

    //思路1：双循环暴力法
    public static int duplicate(int[] array, int len) {
        //边界判断
        if (array.length == 0) return -1;
        if (array.length != len) return -1;
        int res = 0;
        for (int i = 0; i < len; i++) {
            for (int j = i + 1; j < len; j++) {
                if (array[i] == array[j]) {
                    res = array[i];
                    return res;
                }
            }
        }
        return res;
    }

    //思路2：HashMap
    public static int duplicate2(int[] array, int len) {
        //边界判断
        if (array.length == 0) return -1;
        if (array.length != len) return -1;
        int res = 0;
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < len; i++) {
            if (map.containsKey(array[i])) {
                res = array[i];
                return res;
            } else {
                map.put(array[i], array[i]);
            }
        }
        return res;
    }

    //思路3：数组重排列，数组交换
    public static int duplicate3(int[] array, int len) {
        //边界判断
        if (array.length == 0) return -1;
        if (array.length != len) return -1;
        int res = 0;
        for (int i = 0; i < len; i++) {
            while (array[i] != i) {
                int tmp = array[i];
                array[i] = array[array[i]];
                array[array[i]] = tmp;
                if (array[i] == array[array[i]]) {
                    res = array[i];
                    System.out.println(res);
                    return res;
                }
            }
        }
        return res;
    }
}
