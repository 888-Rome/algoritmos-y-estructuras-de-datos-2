package modelos;

// ▶ Importaciones ─────────────────────────────────────────────────────────────────────────────────────────────────────
import interfaces.INodo     ;
import java.awt.*           ;
import java.util.ArrayList  ;
import java.util.List       ;

public class Nodo<T extends Comparable<T>> implements INodo<T> {

    // ▶ Atributos ─────────────────────────────────────────────────────────────────────────────────────────────────────
    private boolean visitado        ;
    private List<Nodo<T>> vecinos   ;
    private T dato                  ;

    // ▶ Constructor ───────────────────────────────────────────────────────────────────────────────────────────────────
    public Nodo(boolean visitado, List<Nodo<T>> vecinos, T dato){
        this.visitado = false               ;
        this.vecinos = new ArrayList<>()    ;
        this.dato = dato                    ;
    }

    // ▶ Getters ───────────────────────────────────────────────────────────────────────────────────────────────────────
    public boolean getVisitado(){ return visitado; }

    public T getDato() { return dato; }

    public List<INodo<T>> getVecinos() { return new ArrayList<>(vecinos); }

    // ▶ Setters ───────────────────────────────────────────────────────────────────────────────────────────────────────
    public void setDato(T data) { this.dato = data; }

    // ▶ Métodos ───────────────────────────────────────────────────────────────────────────────────────────────────────
    public void marcarVisitado(boolean b){
        this.visitado=b;
    }

    public void agregarVecino(INodo<T> nodo){
        vecinos.add((Nodo<T>) nodo);
    }

// ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
}