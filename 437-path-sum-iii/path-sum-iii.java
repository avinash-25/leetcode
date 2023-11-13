class Solution {
    int ctr =0;
    public int pathSum(TreeNode root, int sum) {
        if(root == null)
            return 0;
        PSH(root,sum,0);
        pathSum(root.left,sum);
        pathSum(root.right,sum);

        return ctr;
    }

    void PSH(TreeNode rt , int s , long currS)
    {
        if(rt==null)
            return;
        currS += rt.val;
        if(currS == s)
            ctr++;
        PSH(rt.left,s,currS);
        PSH(rt.right,s,currS); 
    }
}