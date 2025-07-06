/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Util;

/**
 *
 * @author apnil
 */
public class ContenedorGenerico<T, U, V, W>  {
    public T valor1;
    public U valor2;
    public V valor3;
    public W valor4;

    public ContenedorGenerico(T valor1, U valor2) {
        this.valor1 = valor1;
        this.valor2 = valor2;
    }

    public ContenedorGenerico(T valor1, U valor2, V valor3) {
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.valor3 = valor3;
    }

    public ContenedorGenerico(T valor1, U valor2, V valor3, W valor4) {
        this.valor1 = valor1;
        this.valor2 = valor2;
        this.valor3 = valor3;
        this.valor4 = valor4;
    }
}
