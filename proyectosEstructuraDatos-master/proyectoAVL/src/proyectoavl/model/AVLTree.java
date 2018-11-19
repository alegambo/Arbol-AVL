/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoavl.model;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Stack;

/**
 *
 * @author cristian
 * @param <T>
 *
 */
public class AVLTree<T extends Comparable<T>> {

    Node<T> root;

    /**
     *
     */
    public AVLTree() {
        root = null;
    }

    /**
     *
     * @return
     */
    public T Maximum() {
        Node<T> local = root;
        if (local == null) {
            return null;
        }
        while (local.getRight() != null) {
            local = local.getRight();
        }
        return local.getData();
    }

    /**
     *
     * @return
     */
    public T Minimum() {
        Node<T> local = root;
        if (local == null) {
            return null;
        }
        while (local.getLeft() != null) {
            local = local.getLeft();
        }
        return local.getData();
    }

    /**
     *
     * @param node
     * @return
     */
    private int depth(Node<T> node) {
        if (node == null) {
            return 0;
        }
        return node.getDepth();
    }

    /**
     *
     * @param data
     * @return
     */
    public Node<T> insert(T data) {
        root = insert(root, data);
        switch (balanceNumber(root)) {
            case 1:
                root = rotateLeft(root);
                break;
            case -1:
                root = rotateRight(root);
                break;
            default:
                break;
        }
        return root;
    }

    /**
     *
     * @param node
     * @param data
     * @return
     */
    public Node<T> insert(Node<T> node, T data) {
        if (node == null) {
            return new Node<>(data);
        }

        if (node.getData().compareTo(data) > 0) {
            node = new Node<>(node.getData(), insert(node.getLeft(), data),
                    node.getRight());
        } else if (node.getData().compareTo(data) < 0) {
            node = new Node<>(node.getData(), node.getLeft(), insert(
                    node.getRight(), data));
        }

        switch (balanceNumber(node)) {
            case 1:
                node = rotateLeft(node);
                break;
            case -1:
                node = rotateRight(node);
                break;
            default:
                return node;
        }
        return node;
    }

    /**
     *
     * @param node
     * @return
     */
    private int balanceNumber(Node<T> node) {
        int L = depth(node.getLeft());
        int R = depth(node.getRight());
        if (L - R >= 2) {
            return -1;
        } else if (L - R <= -2) {
            return 1;
        }
        return 0;
    }

    /**
     *
     * @param node
     * @return
     */
    private Node<T> rotateLeft(Node<T> node) {
        Node<T> q = node;
        Node<T> p = q.getRight();
        Node<T> c = q.getLeft();
        Node<T> a = p.getLeft();
        Node<T> b = p.getRight();
        q = new Node<>(q.getData(), c, a);
        p = new Node<>(p.getData(), q, b);
        return p;
    }

    /**
     *
     * @param node
     * @return
     */
    private Node<T> rotateRight(Node<T> node) {
        Node<T> q = node;
        Node<T> p = q.getLeft();
        Node<T> c = q.getRight();
        Node<T> a = p.getLeft();
        Node<T> b = p.getRight();
        q = new Node<>(q.getData(), b, c);
        p = new Node<>(p.getData(), a, q);
        return p;
    }

    /**
     *
     * @param data
     * @return
     */
    public boolean search(T data) {
        Node<T> local = root;
        while (local != null) {
            if (local.getData().compareTo(data) == 0) {
                return true;
            } else if (local.getData().compareTo(data) > 0) {
                local = local.getLeft();
            } else {
                local = local.getRight();
            }
        }

        return false;
    }

    /**
     *
     * @return root data
     */
    @Override
    public String toString() {
        return root.toString();
    }

    /* Metodos Busqueda */
 /* 1) Todos los libros de un mismo tipo. (Ordenados lexicográficamente utilizando el algoritmo de Radix) */
    public Node<T> searchByType(int type) {
        Node<T> local = root;
        Node<T> cod = new Node<>((T) new Book("", "", "", "", type));
        boolean flat = false;
        while (local != null) {
            if (local.getData().compareTo((T) cod) == 0) {
                flat = true;
                break;
            } else if (local.getData().compareTo((T) cod) > 0) {
                local = local.getLeft();
            } else {
                local = local.getRight();
            }
        }

        return (flat == true) ? local : null;
    }

    /* 2) Todos los libros de un autor. (Ordenados lexicográficamente utilizando el algoritmo de Radix) */
 /* 3) Por nombre. (Ordenados lexicográficamente utilizando el algoritmo de Radix) */
    /**
     * 4) Busqueda Por Código
     *
     * @param code
     * @return Node<T>
     */
    public Node<T> searchByCode(String code) {
        Node<T> local = root;
        Node<T> cod = new Node<>((T) new Book("", code, "", "", 0));
        boolean flat = false;
        while (local != null) {
            if (local.getData().compareTo((T) cod) == 0) {
                flat = true;
                break;
            } else if (local.getData().compareTo((T) cod) > 0) {
                local = local.getLeft();
            } else {
                local = local.getRight();
            }
        }

        return (flat == true) ? local : null;
    }

    /**
     * 5) Si es completo. (Árbol en el que todas las hojas están a profundidad n
     * o n-1)
     *
     * @return True if Tree it complete
     */
    public boolean complete() {
        return complete(root);
    }

    private boolean complete(Node<T> n) {
        return (n == null) ? true : Math.abs(Math.subtractExact(depth(n.getLeft()),
                depth(n.getRight()))) <= 1;
    }

    /* 6) Si es Perfecto. (Árbol lleno en el que todas las hojas están a la misma profundidad) */
    public boolean perfect() {
        return perfect(root);
    }

    private boolean perfect(Node<T> n) {
        return (n == null) ? true : (depth(n.getLeft()) == depth(n.getRight()));
    }

    /**
     * 7) Si es lleno.(Es un árbol en el que cada nodo tiene cero o dos hijos).
     *
     * @return
     */
    public boolean emptyTree() {
        return perfect();
    }

    /**
     * 8) La altura.(Camino más largo desde la raíz hasta la hoja en el árbol)
     *
     * @return height
     */
    public void height() {
        preorden(root);
    }

    private void preorden(Node<T> n) {
        if (n != null) {
            System.err.println(n.getData());
            preorden(n.getLeft());
            preorden(n.getRight());
        }
    }

    /**
     * 9) El nivel.(La raíz de un árbol se considera en el nivel 1 y así
     * sucesivamente.)
     *
     */
    public void printNivels() {
        root.level = 1;
        Queue<Node<T>> queue = new LinkedList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            System.out.println(node.toStringNivels());
            int level = node.level;
            Node<T> left = node.getLeft();
            Node<T> right = node.getRight();
            if (left != null) {
                left.level = level + 1;
                queue.add(left);
            }
            if (right != null) {
                right.level = level + 1;
                queue.add(right);
            }
        }
    }

    /**
     * 10) El peso.(Es el número de nodos del árbol sin contar la raíz.)
     *
     * @return treeWeight
     */
    public int treeWeight() {
        Queue<Node<T>> queue = new LinkedList<Node<T>>();
        queue.add(root);
        int nodeLeft = 0;
        int nodeRight = 0;
        while (!queue.isEmpty()) {
            Node<T> node = queue.poll();
            Node<T> left = node.getLeft();
            Node<T> right = node.getRight();
            if (left != null) {
                nodeLeft++;
                queue.add(left);
            }
            if (right != null) {
                nodeRight++;
                queue.add(right);
            }
        }
        return (nodeLeft + nodeRight) - 1;
    }

    /* 11) Ruta: Se solicita dos nodos, el sistema debe indicar si hay camino. Si el camino existe entre ellos mostrar la longitud. */

 /*Las eliminaciones a realizar sobre el árbol serán: 
   12) Borrar un libro por Código. (Se pideCódigo).*/
 /*13) Borrar todos los libros de un Tipo determinado. (Se pide Tipo).*/
    public boolean deletebyCode(String code) {
        Node<T> local = root;
        Node<T> father = root;
        Node<T> cod = new Node<>((T) new Book("", code, "", "", 0));
        boolean isLeft = true;
        while (local.getData() != cod) {
            father = local;
            if (local.getData().compareTo((T) cod) > 0) {
                isLeft = true;
                local = local.getLeft();
            } else {
                isLeft = false;
                local = local.getRight();
            }
            if (local == null) {
                return false;
            }
        }
        if (local.getLeft() == null && local.getRight() == null) {
            if (local == root) {
                root = null;
            } else if (isLeft) {
                father.left = null;
            } else {
                father.right = null;
            }
        } else if (local.getRight() == null) {
            if (local == root) {
                root = local.getLeft();
            } else if (isLeft) {
                father.left = local.getLeft();
            } else {
                father.right = local.getLeft();
            }
        } else if (local.getLeft() == null) {
            if (local == root) {
                root = local.getRight();
            } else if (isLeft) {
                father.left = local.getRight();
            } else {
                father.right = local.getLeft();
            }
        } else {
            Node<T> replace = getNodeReplace(local);
            if (local == root) {
                root = replace;
            } else if (isLeft) {
                father.left = replace;
            } else {
                father.right = replace;
            }
            replace.left = local.getLeft();
        }
        return true;
    }
    public boolean deletebyType(int type) {
        Node<T> local = root;
        Node<T> father = root;
        Node<T> cod = new Node<>((T) new Book("", "", "", "", type));
        boolean isLeft = true;
        while (local.getData() != cod) {
            father = local;
            if (local.getData().compareTo((T) cod) > 0) {
                isLeft = true;
                local = local.getLeft();
            } else {
                isLeft = false;
                local = local.getRight();
            }
            if (local == null) {
                return false;
            }
        }
        if (local.getLeft() == null && local.getRight() == null) {
            if (local == root) {
                root = null;
            } else if (isLeft) {
                father.left = null;
            } else {
                father.right = null;
            }
        } else if (local.getRight() == null) {
            if (local == root) {
                root = local.getLeft();
            } else if (isLeft) {
                father.left = local.getLeft();
            } else {
                father.right = local.getLeft();
            }
        } else if (local.getLeft() == null) {
            if (local == root) {
                root = local.getRight();
            } else if (isLeft) {
                father.left = local.getRight();
            } else {
                father.right = local.getLeft();
            }
        } else {
            Node<T> replace = getNodeReplace(local);
            if (local == root) {
                root = replace;
            } else if (isLeft) {
                father.left = replace;
            } else {
                father.right = replace;
            }
            replace.left = local.getLeft();
        }
        return true;
    }

    public Node<T> getNodeReplace(Node<T> nodeRep) {
        Node<T> replaceFather = nodeRep;
        Node<T> replace = nodeRep;
        Node<T> local = nodeRep.getRight();
        while (local != null) {
            replaceFather = replace;
            replace = local;
            local = local.getLeft();
        }
        if (replace != nodeRep.getRight()) {
            replaceFather.left = replace.getLeft();
            replace.right = nodeRep.right;
        }
        return replace;
    }

}
