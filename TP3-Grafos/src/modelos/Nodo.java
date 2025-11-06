package modelos;

// ▶ Importaciones ─────────────────────────────────────────────────────────────────────────────────────────────────────
import interfaces.INodo     ;
import java.util.ArrayList  ;
import java.util.HashMap    ;
import java.util.List       ;
import java.util.Map        ;

// ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

public class Nodo<T> implements INodo<T> {

    // ▶ Atributos ─────────────────────────────────────────────────────────────────────────────────────────────────────
    private boolean visitado                ;
    private Map<INodo<T>, Integer> pesos    ;
    private List<INodo<T>> vecinos          ;
    private T dato                          ;

    // ▶ Constructor ───────────────────────────────────────────────────────────────────────────────────────────────────
    public Nodo(T dato){
        this.visitado = false                   ;
        this.pesos = new HashMap<>()            ;
        this.vecinos = new ArrayList<>()        ;
        this.dato = dato                        ;
    }

    // ▶ Getters ───────────────────────────────────────────────────────────────────────────────────────────────────────
    @Override
    public boolean isVisitado() { return visitado; }

    @Override
    public Map<INodo<T>, Integer> getPesos() { return pesos; }

    @Override
    public List<INodo<T>> getVecinos() { return new ArrayList<>(vecinos); }

    @Override
    public T getDato() { return dato; }

    // ▶ Setters ───────────────────────────────────────────────────────────────────────────────────────────────────────
    @Override
    public void setVisitado(boolean visitado) { this.visitado = visitado; }

    @Override
    public void setPesos(Map<INodo<T>, Integer> pesos) { this.pesos = pesos; }

    @Override
    public void setVecinos(List<INodo<T>> vecinos) { this.vecinos = vecinos; }

    @Override
    public void setDato(T data) { this.dato = data; }

    // ▶ Métodos ───────────────────────────────────────────────────────────────────────────────────────────────────────
    @Override
    public void agregarVecino(INodo<T> nodo, int peso){
        vecinos.add(nodo);
        pesos.put(nodo, peso);
    }

// ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
}