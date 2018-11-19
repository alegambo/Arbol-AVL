/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoavl.model;

/**
 *
 * @author cristian
 */
public class Model {

    private AVLTree<Node<Book>> tree;

    public Model() {
        tree = new AVLTree<>();
    }

    /**
     * Agregar Libro al Arbol (Sin Repetir Codigo)
     *
     * @param book
     */
    public void addAVL(Book book) {
        tree.insert(new Node<>(book));
    }
    public void deleteByCode(String Code) {
        if (tree.deletebyCode(Code)) {
            System.out.print(tree.deletebyCode(Code));
        } else {
            System.out.print("El codigo no se pudo eliminar");
        }
    }
    
    public boolean search(Book book){
        return tree.search(new Node(book));
    }

    public void searchByType(int type) {
        if (tree.searchByType(type) != null) {
            System.out.print(tree.searchByType(type));
        } else {
            System.out.print("El xxx no existe\n");
        }
    }

    /**
     * 4) Busqueda Por Código
     *
     */
    public void searchByCode(String Code) {
        if (tree.searchByCode(Code) != null) {
            System.out.print(tree.searchByCode(Code));
        } else {
            System.out.print("El codigo no existe\n");
        }
    }

    /*
     * 5) Si es completo. (Árbol en el que todas las hojas están a profundidad n o n-1)
     */
    public void complete() {
        if (tree.complete()) {
            System.out.println("El Arbol si es Completo");
        } else {
            System.out.println("El Arbol no es Completo");
        }
    }

    /*
     * 6) Si es Perfecto. (Árbol lleno en el que todas las hojas están a la misma profundidad)
     */
    public void perfect() {
        if (tree.perfect()) {
            System.out.println("El Arbol si es Perfecto");
        } else {
            System.out.println("El Arbol no es Perfecto");
        }
    }

    /*
     * 7) Si es lleno.(Es un árbol en el que cada nodo tiene cero o dos hijos).
     */
    public void emptyTree() {
        if (tree.emptyTree()) {
            System.out.println("El Arbol esta lleno, Cada nodo posee Cero o 2 Hijos");
        } else {
            System.out.println("El Arbol no esta lleno, Cada nodo no posee Cero o 2 Hijos");
        }
    }

    /*
     * 8) La altura.(Camino más largo desde la raíz hasta la hoja en el árbol)
     */
    public void height() {
        tree.height();
    }

    /**
     * 9) El nivel.(La raíz de un árbol se considera en el nivel 1 y así
     * sucesivamente.)
     *
     */
    public void printNivels() {
        tree.printNivels();
    }

    /**
     * 10) El peso.(Es el número de nodos del árbol sin contar la raíz.)
     *
     */
    public int treeWeight() {
        return tree.treeWeight();
    }

}
