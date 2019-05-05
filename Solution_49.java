//把字符串转换为整数
//思路：从头开始遍历，以“345”为例，遍历到“3"，得到数字3,遍历到“4”,返回3*10+4=34,遍历到“5”,返回34*10+5=345,,遍历完成，返回结果345。
//即：每遍历到一个数，就将前面遍历到的数乘以10，然后加上当前的数并返回，即为所求整数；
//但是本题的难度在于：边界条件的判断，非法字符的判断和正负符号以及空字符的判断；
public class Solution_49 {
    public static void main(String[] lwj){
        System.out.println(StrtoInt("-456"));
    }
    public static int StrtoInt(String str){
        char[] chars=str.toCharArray();
        int res=0;
        //空字符串的判断：
        if (str.length()==0||str.isEmpty()) return 0;
        //正负符号的判定：
        int symbol=1;//首位：正负标志位
        //如果首位是
        if (chars[0]=='-'){
            symbol=-1;
            chars[0]='0';
        }else if (chars[0]=='+'){
            symbol=1;
            chars[0]='0';
        }
        for (int i = 0; i <str.length(); i++) {
            //判断是否是非法字符，如果是非法字符,跳出判断
            if (chars[i]<'0'||chars[i]>'9'){
                res=0;
                break;
            }
            //当前字符为0-9时，按照思路进行计算，减去48的原因是，在字符串加减时，操作的其实是ASCII码，要减去‘0’对应的ASCII码即48,为啥呢？因为：  '1'-'0'=1 ;
            //char+char，char+int结果的类型均会被提升为int
            res=res*10+chars[i]-'0';
        }
        //乘以前面的正负标志位
        return res*symbol;
    }
}
