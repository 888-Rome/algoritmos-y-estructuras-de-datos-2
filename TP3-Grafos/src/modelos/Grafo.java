package modelos;

// ▶ Importaciones ─────────────────────────────────────────────────────────────────────────────────────────────────────
import interfaces.IGrafo    ;
import interfaces.INodo     ;
import java.util.*          ;

// ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────

public class Grafo<T> implements IGrafo<T> {

    // ▶ Atributos ─────────────────────────────────────────────────────────────────────────────────────────────────────
    private final boolean isDirigido        ;
    private final Map<T, INodo<T>> nodos    ;

    // ▶ Constructor ───────────────────────────────────────────────────────────────────────────────────────────────────
    public Grafo(boolean isDirigido) {
        this.isDirigido = isDirigido    ;
        this.nodos = new HashMap<>()    ;
    }

    // ▶ Getters ───────────────────────────────────────────────────────────────────────────────────────────────────────
    @Override
    public Map<T, INodo<T>> getNodos() { return nodos; }
    public INodo<T> getDato(T dato) { return nodos.get(dato); }

    // ▶ Métodos ───────────────────────────────────────────────────────────────────────────────────────────────────────

    // ▶ Funcionamiento Básico
    @Override
    public void agregarNodo(T dato) {
        if (!nodos.containsKey(dato)) {
            nodos.put(dato, new Nodo<>(dato));
        }
    }

    @Override
    public void conectarNodos(INodo<T> nodo1, INodo<T> nodo2) {
        if (nodo1 == null || nodo2 == null) return;

        nodo1.agregarVecino(nodo2);

        if (!isDirigido) {
            nodo2.agregarVecino(nodo1);
        }
    }

    // TODO: Delegada a los miembros restantes del grupo:
    // Facundo Ojeda - Juan García - Camila Portillo
    @Override
    public int[][] matrizAdyacencia() {
        return null;
    }

    // TODO: Delegada a los miembros restantes del grupo:
    // Facundo Ojeda - Juan García - Camila Portillo
    @Override
    public Map<T, List<T>> listaAdyacencia() {
       return null;
    }

    // ▶ Recorridos
    /* Método para recorrer por profundidad.
    *  Elegimos usar la versión iterativa, en lugar de su variante recursiva
    *  para evitar Stack Overflows en grafos extensos. */
    @Override
    public List<T> recorrerDFS(INodo<T> nodoInicio) {
        List<T> resultado = new ArrayList<>();

        if (nodoInicio == null) return resultado;

        /* Usamos un set, porque no permite duplicados. */
        Set<INodo<T>> visitados = new HashSet<>();

        /* Usamos una pila porque DFS recorre por profundidad, yendo hasta el fondo antes de volver. */
        Stack<INodo<T>> pila = new Stack<>();

        pila.push(nodoInicio);

        while (!pila.isEmpty()) {
            INodo<T> actual = pila.pop();

            /* Si el nodo no está aún, lo agrega a visitados y a resultado. */
            if (!visitados.contains(actual)) {
                visitados.add(actual);
                resultado.add(actual.getDato());

                /* Verifica si el nodo se encuentra en los visitados, de no ser así,
                * lo agrega. */
                for (INodo<T> vecino : actual.getVecinos()) {
                    if (!visitados.contains(vecino)) { pila.push(vecino); }
                }
            }
        }
        return resultado;
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

// ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
}