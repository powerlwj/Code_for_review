public class Solution_9 {
    public static void main(String[] lwj){
        System.out.println(Fibonacci(6));
    }
    //递归法：
    public static int Fibonacci(int n){
        if (n<=0) return 0;
        if(n<=2) return 1;
        if (n>2) return Fibonacci(n-1)+Fibonacci(n-2);
        return -1;
    }
    //迭代法（推荐）：
    public static int Fibonacci(int n){
        if (n<=0) return 0;
        if (n<=2) return 1;
        int fir=1;
        int sec=1;
        int res=0;
        for (int i = 3; i <=n; i++) {
            res=fir+sec;
            fir=sec;
            sec=res;
        }
        return res;
    }
}
