package interfaces;

public interface IGrafo<T extends Comparable<T>> {

    // ▶ Recorridos
    public void recorrerDFS(INodo<T> inicio);
    public void recorrerBFS(INodo<T> inicio);

    // ▶ Otros
    public void agregarNodo(INodo<T> nodo);
    public void conectarNodos(INodo<T> nodo1, INodo<T> nodo2);

// ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
}