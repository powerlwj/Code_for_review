public class Solution_4 {
    public static void main(String[] args){
		
        String res="We are happy.";
		//���µ��ַ����ϸ��ģ���Ҫ������ڴ�ռ䣩
        StringBuilder str=new StringBuilder();
        for (int i = 0; i <res.length(); i++) {
            if (res.charAt(i)!=' '){
                str.append(res.charAt(i));
            }else {
                str.append('%');
                str.append('2');
                str.append('0');
            }
        }
        System.out.println(str.toString());

    }


	//���úķ�����̫���ڴ棬��ԭʼ�ַ�����ֱ���޸ģ�
	StringBuilder str = new StringBuilder("We are happy.");
        int space = 0;
        int len = str.length();
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') space++;
        }
        int fir = len - 1;
        int sec = len + space * 2 - 1;
        for (int i = 0; i < space; i++) {
            str = str.append("  ");
        }
        //���ϴ����Ŀ�ľ��ǽ�ԭʼ�ַ������ݣ�����������к����ƶ���
        for (; fir >= 0 && sec >=0; fir--) {
            if (str.charAt(fir) == ' ') {
                str.setCharAt(sec--, '0');
                str.setCharAt(sec--, '2');
                str.setCharAt(sec--, '%');
            } else if (str.charAt(fir) != ' ') {
                str.setCharAt(sec--, str.charAt(fir));
            }
        }

        System.out.println(str.toString());