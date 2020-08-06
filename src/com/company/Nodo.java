package com.company;

public class Nodo {
    private Object valor;
    private Nodo anterior;
    private Nodo siguiente;

    public Nodo(Object valor) {
        this.valor = valor;
    }

    public Object obtenerValor() {
        return valor;
    }

    public Nodo obtenerAnterior() {
        return anterior;
    }

    public Nodo obtenerSiguiente() {
        return siguiente;
    }

    public void enlazarAnterior(Nodo nodo) {
        anterior = nodo;
    }

    public void enlazarSiguiente(Nodo nodo) {
        siguiente = nodo;
    }
}
