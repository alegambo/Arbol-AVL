/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoavl.view;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectoavl.controller.Controller;
import proyectoavl.model.Book;

/**
 *
 * @author cristian
 */
public class View {

    Controller controller = new Controller();

    public View() {
        this.controller = controller;

        menuPrincipal();

    }

    public void menuPrincipal() {
        Scanner sn = new Scanner(System.in);
        boolean salir = false;
        int opcion; //Guardaremos la opcion del usuario

        while (!salir) {

            System.out.println("1.  Agregar Libro");
            System.out.println("2.  Busqueda por Tipo");
            System.out.println("3.  Busqueda por Autor");
            System.out.println("4.  Busqueda por Nombre");
            System.out.println("5.  Busqueda por Codigo");
            System.out.println("6.  Revisar si es Completo");
            System.out.println("7.  Revisar si es Perfecto");
            System.out.println("8.  Revisar si es Lleno");
            System.out.println("9.  Saber la Altura");
            System.out.println("10. Niveles del Arbol");
            System.out.println("11. El peso del Arbol");
            System.out.println("12. Ruta de 2 Nodos");
            System.out.println("13. Eliminar por Codigo");
            System.out.println("14. Eliminar por Tipo");
            System.out.println("15. Salir");

            try {

                System.out.println("Escribe una de las opciones");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("1.Agregar Libro");
                        agregarLibro();
                        break;
                    case 2:
                        System.out.println("\n 2. Busqueda por Tipo \n");
                        break;
                    case 3:
                        System.out.println("\n 3. Busqueda por Autor \n");
                        break;
                    case 4:
                        System.out.println("\n 4.  Busqueda por Nombre \n");
                        break;
                    case 5:
                        System.out.println("\n 5. Busqueda por Codigo \n");
                        break;
                    case 6:
                        System.out.println("\n 6.Revisar si es Completo \n");
                        completeTree();
                        break;
                    case 7:
                        System.out.println("\n 7.Revisar si es Perfecto \n");
                        perfectTree();
                        break;
                    case 8:
                        System.out.println("\n 8.Revisar si esta Lleno \n");
                        emptyTree();
                        break;
                    case 9:
                        System.out.println("\n 9.Saber la Altura \n");
                        heightTree();
                        break;
                    case 10:
                        System.out.println("\n 10. Niveles del Arbol \n");
                        printNivels();
                        break;
                    case 11:
                        System.out.println("\n 11. El peso del Arbol \n");
                        treeWeight();
                        break;
                    case 12:
                        System.out.println("\n 12. Ruta de 2 Nodos \n FALTA");
                        break;
                    case 13:
                        System.out.println("\n 13. Eliminar por Codigo");
                        
                        break;
                    case 14:
                        System.out.println("\n 14. Eliminar por Tipo");
                        break;
                    case 15:
                        salir = true;
                        break;
                    default:
                        System.out.println("Solo números entre 1 y 15");
                }
            } catch (InputMismatchException e) {
                System.out.println("Debes insertar un número");
                sn.next();
            }
        }
    }

    public void agregarLibro() {
        Scanner sn = new Scanner(System.in);
        int tipo;
        String nombre, codigo, autor, descripcion;

        System.out.println("-- Datos del Libro --\n");
        System.out.println("Escribe el Nombre");
        nombre = sn.next();
        System.out.println("Escribe el Codigo");
        codigo = sn.next();
        System.out.println("Escribe el Autor");
        autor = sn.next();
        System.out.println("Escribe el Descripcion");
        descripcion = sn.next();
        System.out.println("Escribe el Tipo (1-2-3)");
        tipo = sn.nextInt();

        Book book = new Book(nombre, codigo, autor, descripcion, tipo);

        if (!(controller.search(book))) {
            {
                try {
                    controller.add(book);
                } catch (ClassNotFoundException | IOException ex) {
                    Logger.getLogger(View.class.getName()).log(Level.SEVERE, null, ex);
                }
            }
            System.err.println("--- Acaba de Ingresar un Libro ---\n");
        } else {
            System.err.println("--- El Codigo ya existe ---\n");
        }
    }

    public void completeTree() {
        controller.completeTree();
        System.err.println("\n");
    }

    public void perfectTree() {
        controller.perfectTree();
        System.err.println("\n");
    }

    public void emptyTree() {
        controller.emptyTree();
        System.err.println("\n");
    }

    public void printNivels() {
        controller.printNivels();
        System.err.println("\n");
    }

    public void heightTree() {
        controller.heightTree();
        System.err.println("\n");
    }

    public void treeWeight() {
        System.out.println(controller.treeWeight());
        System.err.println("\n");
    }
    
}
