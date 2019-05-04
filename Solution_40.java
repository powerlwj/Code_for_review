//位运算中异或的性质：两个相同的数字异或为0，一个数与0异或还是它本身；
//思路：本体的思路来源于，如果一个数组中只有一个数不是成对出现的，我们将该数组异或之后剩下的那个数便是唯一落单的数；
//但是本题中给了两个落单的数，那么我们在对所有数进行异或操作之后，得到的数肯定是两个落单的数（假设A和B）的异或；
//将最终异或剩余后的数划为二进制，从右往左数，如果第n位为1，则根据第n位是否为1，将原始数组分为两类，A和B肯定分别在两个类别当中；
//原因：相同的数的位数肯定相同，1的位置就是A和B不同的位置，也是分成两部分的关键
public class Solution_40 {
    public static void main(String[] lwj){
        int[] arr={2,4,3,6,3,2,5,5,6,9};
        System.out.println(FindNumsAppearOnce(arr)[0]+" "+FindNumsAppearOnce(arr)[1]);
    }
    public static int[] FindNumsAppearOnce(int[] array){
        int[] res=new int[2];
        if (array.length<2) return res;
        int xor=0;
        //对所给数组的所有数字进行异或运算
        for (int i = 0; i <array.length ; i++) {
            xor^=array[i];
        }
        //找到异或之后的数字中，哪一位是1
        int Num1Bit=Find1Bit(xor);
        //找到是1的这个位之后，需要将原始的数组分为两类，然后将两类数组各自分别组内异或，得到的那个数就是落单的数；
        for (int i = 0; i <array.length ; i++) {
            if (isBit1(array[i],Num1Bit)){
                res[0]^=array[i];
            }else {
                res[1]^=array[i];
            }
        }
        return res;

    }
    //寻找传入参数n的哪一位是1
    public static int Find1Bit(int n){
        int index=0;
        while ((n&1)==0 && index<32){
            n>>=1;
            index++;
        }
        return index;
    }
    //判断传入参数target的第index位是否为1
    public static boolean isBit1(int target,int n){
        return ((target>>n)&1)==1;
    }
}
