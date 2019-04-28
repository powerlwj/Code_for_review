import static java.util.Arrays.copyOfRange;

public class Solution_6 {
    private class TreeNode {
          int val;
          TreeNode left;
          TreeNode right;
          TreeNode(int x) { val = x; }
     }

     public static void main(String [] args){
        Solution_6 s6=new Solution_6();
        int[] pre={1,2,3,4,5,6};
        int[] in={1,2,3,4,5,6};
        s6.reConstructBinaryTree(pre,in);
     }

     public TreeNode reConstructBinaryTree(int[] pre,int[] in){
        if (pre==null || in==null) return null;
        if (pre.length==in.length && pre.length==0) return null;
        TreeNode treeNode=new TreeNode(pre[0]);
        //下面这个循环是为了递归分开左子树和右子树
         for (int i = 0; i <pre.length&&in[i]!=pre[0] ; i++) {
            if (i>=1){
                treeNode.left=reConstructBinaryTree(copyOfRange(pre,1,i+1),copyOfRange(in,0,i));
            }else {
                treeNode.left=null;
            }
            if (i+1<pre.length){
                treeNode.right=reConstructBinaryTree(copyOfRange(pre,i+1,pre.length),copyOfRange(in,i+1,in.length));
            }else {
                treeNode.right=null;
            }
         }
         return treeNode;
     }

}
