//不使用pow()函数实现数值的整数次方的功能
public class Solution_11 {
    public static void main(String[] lwj){
        System.out.println(SelfPow(99999999,-2000000000));
    }
    public static double SelfPow(double base,int exponent){
        double res=1;
        //关于数值运算，首先判断输入的数值的边界，base作为幂运算的基本单位，取值范围是所有有理数，exponent作为幂次，只有为正整数时才能正常运算；当exponent为负数时：结果为exponent为
        //正数运算结果的倒数，如2的-2次方为1/4；
        if (base==0) return 1;
        for (int i = 0; i <Math.abs(exponent) ; i++) {
            res*=base;
        }
        //超出了double的范围
        if (res>1.7976931348623157E308) return -1;
        //exponent为正数
        if (exponent>=0){
            return res;
        }
        //exponent为负数
        else {
            return 1/res;
        }
    }
}
