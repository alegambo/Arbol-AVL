/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package proyectoavl.model;

import java.io.Serializable;

/**
 *
 * @author cristian
 */
public class Book implements Comparable<Book>, Serializable {

    private String name;
    private String code;
    private String author;
    private String description;
    private int type;

    /**
     * Constructor
     */
    public Book() {
    }

    /**
     *
     * Constructor
     *
     * @param name
     * @param code
     * @param author
     * @param description
     * @param type
     */
    public Book(String name, String code, String author, String description, int type) {
        this.name = name;
        this.code = code;
        this.author = author;
        this.description = description;
        this.type = type;
    }

    /**
     * @return the name
     */
    public String getName() {
        return name;
    }

    /**
     * @param name the name to set
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * @return the code
     */
    public String getCode() {
        return code;
    }

    /**
     * @param code the code to set
     */
    public void setCode(String code) {
        this.code = code;
    }

    /**
     * @return the author
     */
    public String getAuthor() {
        return author;
    }

    /**
     * @param author the author to set
     */
    public void setAuthor(String author) {
        this.author = author;
    }

    /**
     * @return the description
     */
    public String getDescription() {
        return description;
    }

    /**
     * @param description the description to set
     */
    public void setDescription(String description) {
        this.description = description;
    }

    /**
     * @return the type
     */
    public int getType() {
        return type;
    }

    /**
     * @param type the type to set
     */
    public void setType(int type) {
        this.type = type;
    }

    /**
     *
     * @return Code Data
     */
    @Override
    public String toString() {
        return "Nombre: " + name + "\n"
                + "Author: " + author + "\n"
                + "Descripcion: " + description + "\n"
                + "Codigo: " + code + "\n"
                + "Tipo: " + type + "\n";
    }

    /**
     * a) Inclusión de nuevos libros dentro del árbol.(sin repetir código)
     *
     * @param o
     * @return Book Object
     */
    @Override
    public int compareTo(Book o) {
        return this.code.compareTo(o.code);
    }
}
