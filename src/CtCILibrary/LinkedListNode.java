package CtCILibrary;

/**
 * The LinkedListNode program implemented in Java for learning purposes.
 *
 * Like the TreeNode class, we often needed access to the internals of a linked list in a way that the built-in linked
 * list class wouldn't support. For this reason, we implemented our own class and used it for many problems.
 *
 * Again, we've kept the methods and variables public because we often needed this access. This would allow the user to
 * "destroy" the linked list, but we actually needed this sort of functionality for our purposes.
 *
 * @author Evanthios Papadopoulos
 * @since 31-Mar-22
 **/
public class LinkedListNode {

    public LinkedListNode next, prev, last;
    public int data;

    /**
     * @param d the integer value.
     * @param n the LinkedListNode next value.
     * @param p the LinkedListNode previous value.
     */
    public LinkedListNode(int d, LinkedListNode n, LinkedListNode p) {
        data = d;
        setNext(n);
        setPrevious(p);
    }

    /**
     * Some args constructor.
     * @param d the integer's value to be added.
     */
    public LinkedListNode(int d) {
        data = d;
    }

    /**
     * No args constructor.
     */
    public LinkedListNode() {}

    /**
     * SetNext() method, sets next treeNode if we are at the last Node then we add the given treeNode to the end and
     * then we set the current node to previousNode.
     *
     * @param n the LinkedListNode next value.
     */
    public void setNext(LinkedListNode n) {
        next = n;
        if (this == last) {
            last = n;
        }
        if (n != null && n.prev != this) {
            n.setPrevious(this);
        }
    }

    /**
     * SetPrevious() method, sets previous node and then we call the setNext to the current node that took this one's
     * place.
     *
     * @param p the LinkedListNode previous value.
     */
    public void setPrevious(LinkedListNode p) {
        prev = p;
        if (p != null && p.next != this) {
            p.setNext(this);
        }
    }

    /**
     * Clone() method, creates a null LinkedListNode, if not next node found then we return a new LinkedListNode with
     * current data, the new LinkedListNode that we created, and a null (as previous node). If the next node exists, we
     * then assert the new LinkedListNode while calling the next's clone() method.
     *
     * @return a LinkedListNode.
     */
    public LinkedListNode clone() {
        LinkedListNode next2 = null;
        if (next != null) {
            next2 = next.clone();
        }
        return new LinkedListNode(data, next2, null);
    }
}
