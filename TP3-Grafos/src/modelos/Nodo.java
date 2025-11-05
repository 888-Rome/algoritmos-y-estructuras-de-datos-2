package modelos;

// ▶ Importaciones ─────────────────────────────────────────────────────────────────────────────────────────────────────
import interfaces.INodo     ;
import java.util.ArrayList  ;
import java.util.List       ;

// ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

public class Nodo<T> implements INodo<T> {

    // ▶ Atributos ─────────────────────────────────────────────────────────────────────────────────────────────────────
    private boolean visitado        ;
    private List<INodo<T>> vecinos  ;
    private T dato                  ;

    // ▶ Constructor ───────────────────────────────────────────────────────────────────────────────────────────────────
    public Nodo(T dato){
        this.visitado = false               ;
        this.vecinos = new ArrayList<>()    ;
        this.dato = dato                    ;
    }

    // ▶ Getters ───────────────────────────────────────────────────────────────────────────────────────────────────────
    @Override
    public boolean isVisitado() { return visitado; }
    @Override
    public T getDato() { return dato; }
    @Override
    public List<INodo<T>> getVecinos() { return new ArrayList<>(vecinos); }

    // ▶ Setters ───────────────────────────────────────────────────────────────────────────────────────────────────────
    @Override
    public void setDato(T data) { this.dato = data; }
    @Override
    public void setVisitado(boolean visitado) { this.visitado = visitado; }
    @Override
    public void setVecinos(List<INodo<T>> vecinos) { this.vecinos = vecinos; }

    // ▶ Métodos ───────────────────────────────────────────────────────────────────────────────────────────────────────
    @Override
    public void agregarVecino(INodo<T> nodo){
        vecinos.add((Nodo<T>) nodo);
    }

// ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
}