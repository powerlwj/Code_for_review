public class Solution_8 {
    public static void main(String[] lwj){
        int[] nums={4,5,6,7,8,1,2,0};
        System.out.println(minNum(nums));
    }
//方法1：暴力搜索
public class Solution {
    public int minNumberInRotateArray(int [] array) {
       int res=array[0];
       if(array.length<0) return 0;
       for (int i = 0; i <array.length ; i++) {
           if (res>array[i]){
                res=array[i];
            }
        }
        return res;
    }

}

//方法2：二分查找
public class Solution_8 {
    public static void main(String[] lwj){
        int[] nums={4,5,6,7,8,9,1,2,0};
        System.out.println(minNum(nums));
    }
    public static int minNum(int[] nums){
        int start=0;
        int end=nums.length-1;
        while (start<end){
            int mid=start+(end-start)/2;
            if (nums[mid]>nums[end]){
                start=mid+1;
            }else if (nums[mid]==nums[end]){
                end=end-1;
            }else {
                end=mid;
            }
        }
        return nums[start];
    }
}
