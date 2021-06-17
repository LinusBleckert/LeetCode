package week5;

public class TreeNode {

    int val;
    TreeNode left;
    TreeNode right;

    TreeNode() {
    }

    TreeNode(int val) {
        this.val = val;
    }

    TreeNode(int val, TreeNode left, TreeNode right) {
        this.val = val;
        this.left = left;
        this.right = right;
    }


    public void createExample1(){

        this.val = 3;
        this.left = new TreeNode(9);
        this.right = new TreeNode(20);
        this.right.left = new TreeNode(15);
        this.right.right = new TreeNode(7);

    }

}