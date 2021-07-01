package june2021.week5;

public class LowestCommonAncestor {

    public class TreeNode{
        int val;
        TreeNode left;
        TreeNode right;

        TreeNode(int x){ this.val = x;}

    }

    public TreeNode lowestCommonAncestor(TreeNode root, TreeNode p, TreeNode q){


        // 4 cases:

        if(root == null)
            return null;
        // found p
        // needs to be under left and right are null first, since a node can be a descendant to itself
        if(root == p)
            return p;
        if(root == q)
            return q;


        TreeNode left = lowestCommonAncestor(root.left, p, q);
        TreeNode right = lowestCommonAncestor(root.right, p, q);

        // LCA found
        if((left == p && right == q) || (right == p && left == q)){
            return root;
        }

        if(left == null && right == null)
            return null;

        if(left != null)
            return left;
        if(right != null)
            return right;

        return null;
    }



}

