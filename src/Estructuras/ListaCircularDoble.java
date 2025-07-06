/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Estructuras;

/**
 *
 * @author apnil
 */
public class ListaCircularDoble <T> {
    private Nodo<T> head;
    private Nodo<T> tail;
    
    public boolean estaVacia() {
        return head == null;
    }
    
    public void agregarFinal(T dato) {
        Nodo<T> nuevoNodo = new Nodo<>(dato);
        if (estaVacia()) {
            head = nuevoNodo;
            tail = nuevoNodo;
            head.setNext(head);
            head.setPrev(head);
        } else {
            nuevoNodo.setPrev(tail);
            nuevoNodo.setNext(head);
            tail.setNext(nuevoNodo);
            head.setPrev(nuevoNodo);
            tail = nuevoNodo;
        }
}

    public Nodo<T> getHead() {
        return head;
    }

    public Nodo<T> getTail() {
        return tail;
    }
    
    
    
}
