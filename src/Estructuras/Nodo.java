/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author apnil
 */
public class Nodo <T> {
    private T dato;
    private Nodo<T> next;
    private Nodo<T> prev;

    public Nodo(T dato) {
        this.dato = dato;
        this.next = null;
        this.prev = null;
    }

    public T getDato() {
        return dato;
    }

    public void setDato(T dato) {
        this.dato = dato;
    }

    public Nodo<T> getNext() {
        return next;
    }

    public void setNext(Nodo<T> next) {
        this.next = next;
    }

    public Nodo<T> getPrev() {
        return prev;
    }

    public void setPrev(Nodo<T> prev) {
        this.prev = prev;
    }
    
}
