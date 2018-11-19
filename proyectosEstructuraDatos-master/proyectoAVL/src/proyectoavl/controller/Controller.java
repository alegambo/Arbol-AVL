/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoavl.controller;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;
import proyectoavl.model.Book;
import proyectoavl.model.Model;

/**
 *
 * @author cristian
 */
public class Controller {

    Model model = new Model();
    private final String ruta = "archivo.txt";
    private File archivo = new File(ruta);

    public Controller() {
        this.model = model;

        // Creo - Cargo el Archivo y Agrego esos Valores al Arbol
        try {
            file();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(Controller.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public void add(Book book) throws ClassNotFoundException, IOException {
        FileOutputStream bw = new FileOutputStream(archivo, true);

        try (ObjectOutputStream oss = new ObjectOutputStream(bw)) {
            oss.writeObject(book);
            model.addAVL(book);
        }
    }

    public void searchByType(int type) {
        model.searchByType(type);
    }

    public void searchByCode(String Code) {
        model.searchByCode(Code);
    }

    public void completeTree() {
        model.complete();
    }

    public void perfectTree() {
        model.perfect();
    }

    public void emptyTree() {
        model.emptyTree();
    }
    public void deleteByCode(String Code){
    model.deleteByCode(Code);
    }
    public void printNivels() {
        model.printNivels();
    }

    public int treeWeight() {
        return model.treeWeight();
    }

    public void heightTree() {
        model.height();
    }
    
    public boolean search(Book book){
        return model.search(book);
    }

    public void file() throws IOException, ClassNotFoundException {
        //Crea el Archivo.

        if (archivo.exists()) {
            System.err.println("Ya el Archivo Existe");
        } else {
            System.err.println("Archivo Nuevo");
            FileOutputStream bw = new FileOutputStream(archivo, true);

            try (ObjectOutputStream oss = new ObjectOutputStream(bw)) {
                oss.writeObject(new Book("La Ilíada", "3010", "Homero", "Bachillerato", 3));
                oss.writeObject(new Book("Don Quijote", "3011", "Cervantes", "Novela", 2));
                oss.writeObject(new Book("Cien Años de Soledad", "3012", "García Marquez", "Bachillerato", 3));
            }
        }

        // Lee el archivo y agrega esos valores al AVL
        ObjectInputStream ois = null;
        try {
            FileInputStream fis = new FileInputStream(ruta);
            ois = new ObjectInputStream(fis);

            while (true) {
                Book book = (Book) ois.readObject();
                model.addAVL(book);
            }
        } catch (IOException io) {
        } finally {
            ois.close();
        }
    }
}
