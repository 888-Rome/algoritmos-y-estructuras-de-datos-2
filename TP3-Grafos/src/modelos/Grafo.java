package modelos;

// ▶ Importaciones ─────────────────────────────────────────────────────────────────────────────────────────────────────
import interfaces.IGrafo    ;
import interfaces.INodo     ;
import java.util.*          ;

public class Grafo<T extends Comparable<T>> implements IGrafo<T> {

    // ▶ Atributos ─────────────────────────────────────────────────────────────────────────────────────────────────────
    private List<Nodo<T>> nodos ;

    // ▶ Constructor ───────────────────────────────────────────────────────────────────────────────────────────────────
    public Grafo() {
        this.nodos = new ArrayList<>()  ;
    }

    // ▶ Getters ───────────────────────────────────────────────────────────────────────────────────────────────────────
    public List<Nodo<T>> getNodos() { return nodos; }

    // ▶ Métodos ───────────────────────────────────────────────────────────────────────────────────────────────────────

    // ▶ Recorridos
    /* Método para recorrer por profundidad. Llama a dfsRecursivo. */
    @Override
    public void recorrerDFS(INodo<T> inicio) {
        /* Condición para detener el recorrido; Se encuentra vacío. */
        if (inicio == null) return;

        /*  */
        Set<INodo<T>> visitados = new HashSet<>();

        System.out.println("Recorrido DFS: ");

        dfsRecursivo(inicio, visitados);

        System.out.println();
    }

    /* Método  para el recorrido por anchura. */
    @Override
    public void recorrerBFS(INodo<T> inicio) {
        Set<T> visitados = new HashSet<>();
        Queue<INodo<T>> cola = new LinkedList<>();

        cola.add(inicio);
        visitados.add((T) inicio.getDato());

        System.out.println("Recorrido BFS: ");
        while (!cola.isEmpty()) {
            INodo<T> actual = cola.poll();
            System.out.print(actual.getDato() + " ");

            for (INodo<T> vecino : actual.getVecinos()) {
                T val = vecino.getDato();
                if (!visitados.contains(val)) {
                    visitados.add(val);
                    cola.add(vecino);
                }
            }
        }
        System.out.println();
    }

    // ▶ Recursivos
    /* Método recursivo para el recorrido por profundidad. */
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
    @Override
    public void conectarNodos(INodo<T> nodo1, INodo<T> nodo2) {
        if (nodo1 == null || nodo2 == null) return;

        if (!nodos.contains(nodo1) || !nodos.contains(nodo2)) return;

        nodo1.agregarVecino(nodo2);
        nodo2.agregarVecino(nodo1);
    }

    /* Método para agregar un nodo genérico al grafo. */
    public void agregarNodo(INodo<T> nodo) {
        nodos.add((Nodo<T>) nodo);
    }

// ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
}