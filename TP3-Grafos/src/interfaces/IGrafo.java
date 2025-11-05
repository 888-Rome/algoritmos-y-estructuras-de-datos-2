package interfaces;

// ▶ Importaciones ─────────────────────────────────────────────────────────────────────────────────────────────────────
import modelos.Nodo     ;
import java.util.List   ;

public interface IGrafo<T extends Comparable<T>> {

    // ▶ Getters ───────────────────────────────────────────────────────────────────────────────────────────────────────
    public List<Nodo<T>> getNodos() ;

    // ▶ Recorridos ────────────────────────────────────────────────────────────────────────────────────────────────────
    public void recorrerDFS(INodo<T> inicio)    ;
    public void recorrerBFS(INodo<T> inicio)    ;

    // ▶ Otros ─────────────────────────────────────────────────────────────────────────────────────────────────────────
    public void agregarNodo(INodo<T> nodo)                      ;
    public void conectarNodos(INodo<T> nodo1, INodo<T> nodo2)   ;

// ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
}