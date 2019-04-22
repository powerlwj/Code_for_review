//思路1：暴力法全遍历
//思路2：暴力法半遍历:寻找对角线最中间的元素进行比较，然后就可以去掉一般的元素，然后再遍历
//思路3：对角线法遍历：以副对角线的第一个元素为基准与目标数值比较，目标>基准，行数加1，目标<基准，列数减一，遍历即可
public class Solution_3 {
    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        String res = Two_dim_array_search(matrix, 0) ? "找到了" : "没找到";
        System.out.println("查找结果：" + res);
    }
//思路1：暴力法全遍历
    public static boolean Two_dim_array_search(int[][] mat,int target) {
        boolean res=false;
        for (int i = 0; i <mat.length ; i++) {
            for (int j = 0; j <mat[0].length ; j++) {
                if (target==mat[i][j]) res=true;
            }
        }

        return res;

    }
//思路2：暴力法半遍历:寻找对角线最中间的元素进行比较，然后就可以去掉一般的元素，然后再遍历
    public static boolean Two_dim_array_search(int[][] mat, int target) {
        boolean res = false;
        int row = mat.length/2+1;
        int line = mat[0].length/2+1;
        if (target>=mat[row][line]){
            for (int i = 0; i <mat.length ; i++) {
                for (int j = line; j <mat[0].length ; j++) {
                    if (target==mat[i][j]) res=true;
                }
            }
        }else {
            for (int i = 0; i <mat.length ; i++) {
                for (int j = 0; j <line ; j++) {
                    if (target==mat[i][j]) res=true;
                }
            }
        }

        return res;
    }
//思路3：对角线法遍历：以副对角线的第一个元素为基准与目标数值比较，目标>基准，行数加1，目标<基准，列数减一，遍历即可
    public static boolean Two_dim_array_search(int[][] mat, int target) {
        int row = 0;
        int line = mat[0].length;
        int start = 0;
        while (row < mat.length && line > 0) {
            start = mat[row][line - 1];
            System.out.println(start);
            if (target > start) {
                row++;
            } else if (target < start) {
                line--;
            } else {
                return true;
            }
        }

        return false;

    }

}
