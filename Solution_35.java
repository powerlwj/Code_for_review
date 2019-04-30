import java.util.LinkedHashMap;
//����1�����ù�ϣ����
public class Solution_35 {
    public static void main(String[] lwj){
        String str="abcdacdef";
        System.out.println(FirstNotRepeatingChar(str));
    }

    public static int FirstNotRepeatingChar(String str){
        int res=0;
        LinkedHashMap<Character,Integer> hashMap=new LinkedHashMap<>();
        for (int i = 0; i <str.length() ; i++) {
            if (hashMap.containsKey(str.charAt(i))){
                int count=hashMap.get(str.charAt(i));
                hashMap.put(str.charAt(i),++count);
            }else {
                hashMap.put(str.charAt(i),1);
            }
        }

        for (int i = 0; i <str.length() ; i++) {
            if (hashMap.get(str.charAt(i))==1){
                return i;
            }
        }
        return res;
    }
}
