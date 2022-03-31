package CtCILibrary;

/**
 * The TreeNode program implemented in Java for learning purposes.
 *
 * While it's perfectly fine - even good - to use the built-in binary tree class when possible, it's not always
 * possible. In many questions, we needed access to the internals of the node or tree class (or needed to tweak these)
 * and thus couldn't use the built-in libraries.
 *
 * The TreeNode class supports a variety of functionality, much of which we wouldn't necessarily want for every
 * question/solution. For example, the TreeNode class tracks the parent of the node, even though we often don't use it
 * (or specifically ban using it).
 *
 * The tree is implemented to be a binary search tree. However, you can use it for other purposes. You would just need
 * to use the setLeftChild/setRightChild methods, or the left and right child variables. For this reason, we have kept
 * these methods and variable public. We need this sort of access for many problems.
 *
 * @author Evanthios Papadopoulos
 * @since 31-Mar-22
 **/

public class TreeNode {

    public int data;
    public TreeNode left, right, parent;
    private int size = 0;

    /**
     * Constructor TreeNode to take given value as data, and size as 1.
     * @param d the integer value.
     */
    public TreeNode(int d) {
        data = d;
        size = 1;
    }

    /**
     * InsertInOrder() method, will add the integer to the tree based on its value. First we check the current treeNode
     * value, depends on the outcome, we will insert the given integer left or right. If the given integer is to be
     * inserted to the left (left subTree) then we check if the leftChild is null in order to add it at that position or
     * else we go a level down (for our example, we go left) and we call the InsertInOrder() method again and start
     * making the same check until we insert the given integer to the correct position. The same checks happen if the
     * given integer goes right.
     *
     * @param d integer to add to the tree
     */
    public void insertInOrder(int d) {
        if (d <= data) {
            if (left == null) {
                setLeftChild(new TreeNode(d));
            } else {
                left.insertInOrder(d);
            }
        } else {
            if (right == null) {
                setRightChild(new TreeNode(d));
            } else {
                right.insertInOrder(d);
            }
        }
        size++;
    }

    /**
     * Size() method returns the size of the tree.
     *
     * @return an integer of the size.
     */
    public int size() {
        return size;
    }

    /**
     * Find() method returns a treeNode that is has been asked. First we check the head of the tree and if the head has
     * the integer we are looking for then we return this.TreeNode. If the integer we asked if smaller than the head
     * treeNode value then we go a level down if there is a left subTree, and we call the find() method again to with
     * given integer, or we return null. If the integer we asked is bigger that the head treeNode then we make the same
     * checks with the right subTree. Last if there is nowhere to be found we return null.
     *
     * @param d integer to be found.
     * @return an integer or null.
     */
    public TreeNode find(int d) {
        if (d == data) {
            return this;
        } else if (d <= data) {
            return left != null ? left.find(d) : null;
        } else if (d > data) {
            return right != null ? right.find(d) : null;
        }
        return null;
    }

    /**
     * SetLeftChild() method takes a treeNode and insert it to the left of the tree and set current treeNode as parent.
     * @param left a TreeNode to be added.
     */
    public void setLeftChild(TreeNode left) {
        this.left = left;
        if (left != null) {
            left.parent = this;
        }
    }

    /**
     * SetRightChild() method takes a treeNode and insert it to the right of the tree and set current treeNode as parent.
     * @param right a TreeNode to be added.
     */
    public void setRightChild(TreeNode right) {
        this.right = right;
        if (right != null) {
            right.parent = this;
        }
    }
}
