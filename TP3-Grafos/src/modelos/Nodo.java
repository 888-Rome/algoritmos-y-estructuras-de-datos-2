package modelos;

// Importaciones ───────────────────────────────────────────────────────────────────────────────────────────────────────
import interfaces.INodo;
import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Nodo<T extends Comparable<T>> implements INodo<T> {

    // Atributos ───────────────────────────────────────────────────────────────────────────────────────────────────────
    private T dato;
    private List<Nodo<T>> vecinos;
    private boolean visitado;

    // Constructor
    public Nodo(T dato,List<Nodo<T>> vecinos,boolean visitado){
        this.dato = dato;
        this.vecinos = new ArrayList<>();
        this.visitado = false;

    }

    // Getters
    public T getDato() {
        return dato;
    }

    @Override
    public INodo<T>[] getVecinos() {
        return new INodo[0];
    }

    // Setters
    public void setDato(T data) {
        this.dato = data;
    }

    // Métodos
    public boolean fueVisitado(){
        return visitado;
    }

    public void marcarVisitado(boolean b){
        this.visitado=b;
    }

    public void agregarVecino(INodo<T> nodo){
        vecinos.add((Nodo<T>) nodo);
    }

}