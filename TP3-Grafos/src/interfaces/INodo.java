package interfaces;

// ▶ Importaciones ─────────────────────────────────────────────────────────────────────────────────────────────────────
import java.util.List   ;
import java.util.Map    ;

// ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

public interface INodo<T> {

    // ▶ Getters ───────────────────────────────────────────────────────────────────────────────────────────────────────
    boolean isVisitado()                        ;
    Map<INodo<T>, Integer> getPesos()           ;
    List<INodo<T>> getVecinos()                 ;
    T getDato()                                 ;

    // ▶ Setters ───────────────────────────────────────────────────────────────────────────────────────────────────────
    void setVisitado(boolean visitado)          ;
    void setPesos(Map<INodo<T>, Integer> pesos) ;
    void setVecinos(List<INodo<T>> vecinos)     ;
    void setDato(T dato)                        ;

    // ▶ Otros Métodos ─────────────────────────────────────────────────────────────────────────────────────────────────
    void agregarVecino(INodo<T> nodo, int peso) ;

// ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
}