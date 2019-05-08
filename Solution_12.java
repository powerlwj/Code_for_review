//打印1到最大的n位数
public class Solution_12 {
    public static void main(String[] lwj){
        PrintToN(2);
    }
    //思路1：普通实现，但是当输入很大时，会超出范围从而报错
    public static void PrintToN(long n){
        //先判断输入的n
        for (long i = 1; i <Math.pow(10,n) ; i++) {
            System.out.println(i);
        }
    }
    //思路2：通过字符串的形式存储大数
	 public static void Print1ToMaxOfNDigits_2(int n){

        if(n <= 0){
            return;
        }
        StringBuffer number = new StringBuffer();

        for(int i = 0; i < n; i++){
            number.append('0');

        }

        while(!Increment(number)){
            PrintNumber(number);
        }
    }
    public static boolean Increment(StringBuffer s){
        boolean isOverflow = false;
        int nTakeOver = 0;
        int nLength = s.length();
        for(int i = nLength - 1; i >= 0; i--){
            int nSum = s.charAt(i) - '0' + nTakeOver;
            if( i == nLength - 1){
                nSum++;
            }
            if(nSum >= 10){
                if(i == 0){
                    isOverflow = true;

                }else{
                    nSum -= 10;
                    nTakeOver = 1;
                    s.setCharAt(i, (char) ('0' + nSum));
                }

            }else{
                s.setCharAt(i, (char) ('0' + nSum));
                break;
            }
        }
        return isOverflow;
    }

    public static void PrintNumber(StringBuffer s){
        boolean isBeginning0 = true;
        for(int i = 0; i < s.length(); i++){
            if(isBeginning0 && s.charAt(i) != '0'){
                isBeginning0 = false;
            }
            if(!isBeginning0){
                System.out.print(s.charAt(i));
            }
        }

        System.out.println();
    }


}
