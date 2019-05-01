public class Solution_10 {
    public static void main(String[] lwj){
        System.out.println(NumberOf1(9));
    }

    //方法1：可能陷入死循环的解
     public static int NumberOf1(int n){
        int count=0;
        while (n!=0){
            if ((n&1)==1){
                count++;
            }
            n=n>>1;
        }
        return count;
    }
	//方法2：通过不断左移1实现对n的二进制数字中1的判断
    public static int NumberOf1(int n){
        int count=0;
        int ind=1;
        while (ind!=0){
            if ((ind&n)!=0){
                count++;
            }
            ind=ind<<1;
        }
        return count;
    }
    //方法3：最优解
    public static int NumberOf1(int n){
        int count=0;
        while (n!=0){
                count++;
                n=n&(n-1);
        }
        return count;
    }

}
