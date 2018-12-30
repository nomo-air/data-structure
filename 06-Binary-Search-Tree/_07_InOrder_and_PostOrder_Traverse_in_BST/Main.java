package _07_InOrder_and_PostOrder_Traverse_in_BST;

public class Main {

    public static void main(String[] args) {

        BST<Integer> bst = new BST<>();
        int[] nums = {5, 3, 6, 8, 4, 2};
        for (int num : nums)
            bst.add(num);

        /////////////////
        //      5      //
        //    /   \    //
        //   3    6    //
        //  / \    \   //
        // 2  4     8  //
        /////////////////
        bst.preOrder(); // 先序
        System.out.println();

        bst.inOrder(); // 中序，顺序的的结果，从小到大排序
        System.out.println();

        bst.postOrder(); // 后序，应用场景：为二分搜索树释放内存
        System.out.println();
    }
}
