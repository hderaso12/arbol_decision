/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.mycompany.arbolbinariobusqueda;

/**
 *
 * @author thder
 */
class Producto {
    String marca;
    double precio;

    public Producto(String marca, double precio) {
        this.marca = marca;
        this.precio = precio;
    }

    @Override
    public String toString() {
        return "Marca: " + marca + ", Precio: " + precio;
    }
}

class NodoArbol {
    Producto producto;
    NodoArbol izquierda, derecha;

    public NodoArbol(Producto producto) {
        this.producto = producto;
        this.izquierda = null;
        this.derecha = null;
    }
}

public class ArbolBinarioBusqueda {
    private NodoArbol raiz;

    public ArbolBinarioBusqueda() {
        raiz = null;
    }

    public void insertar(Producto producto) {
        raiz = insertarRec(raiz, producto);
    }

    private NodoArbol insertarRec(NodoArbol raiz, Producto producto) {
        if (raiz == null) {
            raiz = new NodoArbol(producto);
            return raiz;
        }

        if (producto.precio < raiz.producto.precio)
            raiz.izquierda = insertarRec(raiz.izquierda, producto);
        else if (producto.precio > raiz.producto.precio)
            raiz.derecha = insertarRec(raiz.derecha, producto);

        return raiz;
    }

    public void imprimirInOrden() {
        imprimirInOrdenRec(raiz);
    }

    private void imprimirInOrdenRec(NodoArbol raiz) {
        if (raiz != null) {
            imprimirInOrdenRec(raiz.izquierda);
            System.out.println(raiz.producto);
            imprimirInOrdenRec(raiz.derecha);
        }
    }

    public static void main(String[] args) {
        ArbolBinarioBusqueda arbol = new ArbolBinarioBusqueda();

        arbol.insertar(new Producto("Marca1", 50.0));
        arbol.insertar(new Producto("Marca2", 30.0));
        arbol.insertar(new Producto("Marca3", 70.0));
        arbol.insertar(new Producto("Marca4", 20.0));
        arbol.insertar(new Producto("Marca5", 60.0));

        System.out.println("Productos ordenados por precio:");
        arbol.imprimirInOrden();
    }
}
