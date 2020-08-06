package com.company;

public class ListaDoblementeEnlazadaCircular {
    private Nodo cabeza;
    private Nodo cola;
    private int tamano;


    public ListaDoblementeEnlazadaCircular() {
        this.cabeza = null;
        this.cola = null;
        this.tamano = 0;
    }

    //Metodos obtener
    public Object obtenerCabeza() {
        return cabeza.obtenerValor();
    }

    public Object obtener(int posicion) {
        Nodo temp = cabeza;
        for (int i = 0; i < posicion; i++) {
            temp = temp.obtenerSiguiente();
        }
        return temp.obtenerValor();
    }

    public Object obtenerSiguiente(int posicion) {
        Nodo temp = cabeza;

        for (int i = 0; i < posicion; i++) {
            temp = temp.obtenerSiguiente();
        }
        return temp.obtenerSiguiente().obtenerValor();
    }

    public Object obtenerAnterior(int posicion) {
        Nodo temp = cabeza;
        for (int i = 0; i < posicion; i++) {
            temp = temp.obtenerSiguiente();
        }
        return temp.obtenerAnterior().obtenerValor();
    }

    //Metodos agregar
    public void addPrimero(Object obj) {
        Nodo nodo = new Nodo(obj);
        if (cabeza == null && cola == null) {
            cabeza = nodo;
            cola = nodo;
        } else {
            nodo.enlazarSiguiente(cabeza);
            cabeza.enlazarAnterior(nodo);
            nodo.enlazarAnterior(cola);
            cola.enlazarSiguiente(nodo);
            cabeza = nodo;
        }
        tamano++;
    }

    public void addFinal(Object obj) {
        Nodo nodo = new Nodo(obj);
        if (cola == null && cabeza == null) {
            cola = nodo;
            cabeza = nodo;
        } else {
            cola.enlazarSiguiente(nodo);
            nodo.enlazarAnterior(cola);
            nodo.enlazarSiguiente(cabeza);
            cabeza.enlazarAnterior(nodo);
            cola = nodo;

        }
        tamano++;
    }

    public void addPorPosicion(Object obj, int posicion) {
        if (posicion == 0 || cabeza == null && cola == null) {
            addPrimero(obj);
        } else {
            Nodo nuevo = new Nodo(obj);
            Nodo temp = cabeza;
            for (int i = 0; i < posicion; i++) {
                temp = temp.obtenerSiguiente();
            }
             temp.obtenerAnterior().enlazarSiguiente(nuevo);
            nuevo.enlazarAnterior(temp.obtenerAnterior());
            nuevo.enlazarSiguiente(temp);
            temp.enlazarAnterior(nuevo);
            tamano++;
        }
    }

    //Metodos eliminar
    public void eliminarPorPosicion(int posicion) {

        Nodo temp = cabeza;

        if (posicion == 0) {
            cabeza = cabeza.obtenerSiguiente();
            cabeza.enlazarAnterior(cola);
        } else {
            //2 -> 3 -> 4  -> 5 -> 6
            //2 -> 3 -> 4 -> 6
            for (int i = 0; i < posicion - 1; i++) {
                temp = temp.obtenerSiguiente();
            }
            temp.enlazarSiguiente(temp.obtenerSiguiente().obtenerSiguiente());
            temp.obtenerSiguiente().obtenerSiguiente().enlazarAnterior(temp);
        }
        tamano--;
    }

    public void eliminarPrimero() {
        cabeza = cabeza.obtenerSiguiente();
        cabeza.enlazarAnterior(cola);
        tamano--;
    }

    public void eliminarTodo() {
        cabeza = null;
        cola = null;
        tamano = 0;
    }

    //Metodo esta vacio
    public boolean estaVacio() {
        if (cabeza == null) {
            return true;
        } else {
            return false;
        }
    }

    //Metodo getTamaño
    public int getTamano() {
        return tamano;
    }

    //Metodo mostrar
    public void mostrar() {
        for (Nodo i = cabeza; i != cabeza.obtenerAnterior(); i = i.obtenerSiguiente()) {
            System.out.print(i.obtenerValor().toString() +" ");
        }
        System.out.println(cola.obtenerValor().toString());
    }

}

