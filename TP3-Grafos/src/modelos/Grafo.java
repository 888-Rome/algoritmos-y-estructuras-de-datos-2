package modelos;

// ▶ Importaciones ─────────────────────────────────────────────────────────────────────────────────────────────────────
import interfaces.IGrafo;
import interfaces.INodo;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class Grafo<T extends Comparable<T>> implements IGrafo<T> {

    // ▶ Atributos ─────────────────────────────────────────────────────────────────────────────────────────────────────
    private List<Nodo<T>> nodos;

    // ▶ Constructor ───────────────────────────────────────────────────────────────────────────────────────────────────
    public Grafo(List<Nodo<T>> nodos) {
        this.nodos = new ArrayList<>();
    }

    // ▶ Métodos ───────────────────────────────────────────────────────────────────────────────────────────────────────

    // ▶ Recorridos
    /** Método para recorrer por profundidad. Llama a dfsRecursivo. */
    @Override
    public void recorrerDFS(INodo inicio) {
        /** Condición para detener el recorrido; Se encuentra vacío. */
        if (inicio == null) return;

        /**  */
        Set<INodo<T>> visitados = new HashSet<>();

        System.out.println("Recorrido DFS: ");

        dfsRecursivo(inicio, visitados);

        System.out.println();
    }

    @Override
    public void recorrerBFS(INodo inicio) {

    }

    // ▶ Recursivos
    /** Método recursivo para el recorrido por profundidad. */
    private void dfsRecursivo(INodo<T> nodo, Set<INodo<T>> visitados) {
        if (nodo == null || visitados.contains(nodo)) return;

        visitados.add(nodo);
        System.out.print(nodo.getDato() + " ");

        for (INodo<T> vecino : nodo.getVecinos()) {
            if (!visitados.contains(vecino)) {
                dfsRecursivo(vecino, visitados);
            }
        }
    }

    // ▶ Otros
    /** Método para agregar un nodo genérico al grafo. */
    @Override
    public void agregarNodo(INodo nodo) {
        nodos.add((Nodo<T>) nodo);
    }

    @Override
    public void conectarNodos(INodo nodo1, INodo nodo2) {

    }

// ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
}