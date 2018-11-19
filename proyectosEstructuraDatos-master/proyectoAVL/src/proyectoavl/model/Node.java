/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoavl.model;

/**
 *
 * @author cristian
 * @param <T>
 */
public class Node<T extends Comparable<T>> implements Comparable<Node<T>> {

    private T data;
    public Node<T> left;
    public Node<T> right;
    public int level;
    private int depth;

    public Node(T data) {
        this(data, null, null);
    }

    public Node(T data, Node<T> left, Node<T> right) {
        super();
        this.data = data;
        this.left = left;
        this.right = right;
        if (left == null && right == null) {
            setDepth(1);
        } else if (left == null) {
            setDepth(right.getDepth() + 1);
        } else if (right == null) {
            setDepth(left.getDepth() + 1);
        } else {
            setDepth(Math.max(left.getDepth(), right.getDepth()) + 1);
        }
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public Node<T> getLeft() {
        return left;
    }

    public void setLeft(Node<T> left) {
        this.left = left;
    }

    public Node<T> getRight() {
        return right;
    }

    public void setRight(Node<T> right) {
        this.right = right;
    }

    /**
     * @return the depth
     */
    public int getDepth() {
        return depth;
    }

    /**
     * @param depth the depth to set
     */
    public void setDepth(int depth) {
        this.depth = depth;
    }

    @Override
    public String toString() {
        if (this.getLeft() != null && this.getRight() != null) {
            return data + "\n || left " + this.getLeft().data + "\n | right " + this.getRight().data;
        } else if (this.getLeft() != null && this.getRight() == null) {
            return data + "\n || left " + this.getLeft().data;
        } else if (this.getLeft() == null && this.getRight() != null) {
            return data + "\n || right " + this.getRight().data;
        }

        return data + "";
    }

    public String toStringNivels() {
        if (this.getLeft() != null && this.getRight() != null) {
            return "Level " + level + ": " + data + " || left " + this.getLeft().data + " | right " + this.getRight().data;
        } else if (this.getLeft() != null && this.getRight() == null) {
            return "Level " + level + ": " + data + " || left " + this.getLeft().data;
        } else if (this.getLeft() == null && this.getRight() != null) {
            return "Level " + level + ": " + data + " || right " + this.getRight().data;
        }

        return "Level " + level + ": " + data;
    }

    /**
     *
     * @param o
     * @return Node<T> Object
     */
    @Override
    public int compareTo(Node<T> o) {
        return this.data.compareTo(o.data);
    }
}
