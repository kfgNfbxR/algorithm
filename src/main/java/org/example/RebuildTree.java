package org.example;

import org.example.model.TreeNode;

/**
 * 根据前序和中序序列重建二叉树
 *
 * @author mouxh 2021/3/8 17:09
 */
public class RebuildTree {

    public static void main(String[] args) {

        int[] preArr = new int[]{2, 4, 7};
        int[] midArr = new int[]{4, 7, 2};

        TreeNode<Integer> treeNode = rebuild(preArr, midArr);

        TreeUtils.breadthPrint(treeNode);
    }


    private static TreeNode<Integer> rebuild(int[] preArr, int[] midArr) {

        if (preArr == null || midArr == null) {
            return null;
        }

        if (preArr.length != midArr.length) {
            return null;
        }

        return rebuild0(preArr, 0, midArr, 0, midArr.length - 1);
    }

    private static TreeNode<Integer> rebuild0(int[] preArr, int preStart, int[] midArr, int midStart, int midEnd) {

        int rootVal = preArr[preStart];
        TreeNode<Integer> treeNode = TreeNode.newNode(rootVal);

        int rootIdx = 0;

        for (int i = midStart; i < midArr.length; i++) {
            if (midArr[i] == rootVal) {
                rootIdx = i;
                break;
            }
        }

        //左孩子的长度
        int leftChildSize = rootIdx - midStart;
        //右孩子的长度
        int rightChildSize = midEnd - rootIdx;
        //前序遍历左孩子的序列结束位置
        int leftPreOrderEnd = preStart + leftChildSize;


        if (leftChildSize > 0) {
            treeNode.setLeftChild(rebuild0(preArr, preStart + 1, midArr, midStart, rootIdx - 1));
        }
        if (rightChildSize > 0) {
            treeNode.setRightChild(rebuild0(preArr, leftPreOrderEnd + 1, midArr, rootIdx + 1, midEnd));
        }

        return treeNode;

    }

}
