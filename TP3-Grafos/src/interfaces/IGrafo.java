package interfaces;

// ▶ Importaciones ─────────────────────────────────────────────────────────────────────────────────────────────────────
import java.util.List   ;
import java.util.Map    ;

// ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

public interface IGrafo<T> {

    // ▶ Getters ───────────────────────────────────────────────────────────────────────────────────────────────────────
    Map<T, INodo<T>> getNodos()                         ;
    INodo<T> getDato(T dato)                            ;


    // ▶ Otros Métodos ─────────────────────────────────────────────────────────────────────────────────────────────────

    // ▶ Funcionamiento Básico
    void agregarNodo(T dato)                            ;
    void eliminarNodo(T dato)                           ;
    void conectarNodos(INodo<T> nodo1, INodo<T> nodo2)  ;
    void borrarGrafo()                                  ;

    // ▶ Representación
    int[][] crearMatrizAdyacencia()                     ;
    void imprimirMatriz()                               ;

    // ▶ Recorridos
    List<T> recorrerDFS(INodo<T> inicio)                ;
    void recorrerBFS(INodo<T> inicio)                   ;

// ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
}