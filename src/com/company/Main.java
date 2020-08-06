package com.company;

public class Main {

    public static void main(String[] args) {

        ListaDoblementeEnlazadaCircular l1 = new ListaDoblementeEnlazadaCircular();

        l1.addPrimero("Juan");
        l1.addPrimero(22);
        l1.addPrimero("Hola");
        l1.addPrimero(44);
        l1.addPrimero(55);
        l1.addPrimero("Pepe");
        l1.addFinal("Jorge");
        l1.addFinal(50);
        l1.addPorPosicion(21, 5);
        System.out.println("Esta vacía: " + l1.estaVacio());
        System.out.println("Tamaño: " + l1.getTamano());
        System.out.println(l1.obtenerSiguiente(8));
        System.out.println(l1.obtenerAnterior(0));
        l1.mostrar();
    }
}
