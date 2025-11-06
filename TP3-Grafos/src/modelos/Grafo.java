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
    public void eliminarNodo(T dato) {
        /* Si el elemento no está detiene el procedimiento. */
        if (!nodos.containsKey(dato)) { return; }

        /* Recorre todos los nodos dentro del grafo. */
        for (INodo<T> nodo : nodos.values()) {
            /* Accedemos a la lista de sus vecinos. */
            List<INodo<T>> vecinos = nodo.getVecinos();

            INodo<T> nodoAEliminar = nodos.get(dato);

            /* Creamos la lista nueva. */
            List<INodo<T>> vecinosTemporal = new ArrayList<>();

            for (INodo<T> vecino : vecinos) {
                if (!vecino.equals(nodoAEliminar)) {
                    vecinosTemporal.add(vecino);
                }
            }

            /* Reemplazamos la original. */
            nodo.setVecinos(vecinosTemporal);
        }

        /* Eliminamos del mapa, luego de haber eliminado sus referencias. */
        nodos.remove(dato);
    }

    @Override
    public void borrarGrafo() {
        /* Primero eliminamos las listas de vecinos de cada nodo. */
        for (INodo<T> nodo : nodos.values()) {
            nodo.getVecinos().clear();
        }

        /* Finalmente, eliminamos de forma segura */
        nodos.clear();
    }

    @Override
    public void conectarNodos(INodo<T> nodo1, INodo<T> nodo2) {
        if (nodo1 == null || nodo2 == null) return;

        nodo1.agregarVecino(nodo2,1);

        if (!isDirigido) {
            nodo2.agregarVecino(nodo1,1);
        }
    }

    @Override
    public int[][] crearMatrizAdyacencia() {
        if(nodos.isEmpty()) { return null; }

        /* Determinamos el tamaño de la matriz, de acuerdo
        *  con la cantidad de nodos en el grafo. */
        int tam = nodos.size();
        int[][] matriz = new int[tam][tam];

        List<INodo<T>> listaNodos = new ArrayList<>(nodos.values());

        /* Creamos el mapa */
        Map<INodo<T>, Integer> indice = new HashMap<>();

        for (int i = 0 ; i < listaNodos.size() ; i++) {
            indice.put(listaNodos.get(i),i);
        }

        /* Llenamos la matriz */
        for (INodo<T> nodo : listaNodos) {
            int i = indice.get(nodo);

            for (INodo<T> vecino : nodo.getVecinos()) {
                int j = indice.get(vecino);
                matriz[i][j] = 1;
            }
        }

        return matriz;
    }

    @Override
    public void imprimirMatriz() {
        List<INodo<T>> listaNodos = new ArrayList<>(nodos.values());
        int n = listaNodos.size();

        if (n == 0) {
            System.out.println("El grafo está vacío...");
            return;
        }

        int[][] matriz = crearMatrizAdyacencia();

        System.out.println("\n⌞ Matriz de Adyacencia ⌝\n");

        // Calcula el largo del texto más largo
        int largoMax = 0;
        for (INodo<T> nodo : listaNodos) {
            int largo = nodo.getDato().toString().replace("|", "").trim().length();
            if (largo > largoMax) largoMax = largo;
        }

        // Encabezado de columnas
        System.out.print(" ".repeat(largoMax + 5));
        for (INodo<T> nodo : listaNodos) {
            String nombre = nodo.getDato().toString().replace("|", "").trim();
            System.out.printf("[%-" + largoMax + "s] ", nombre);
        }

        System.out.println();

        // Filas
        for (int i = 0; i < n; i++) {
            String nombre = listaNodos.get(i).getDato().toString().replace("|", "").trim();
            System.out.printf("| %-" + largoMax + "s | ", nombre);

            for (int j = 0; j < n; j++) {
                System.out.printf("[ %d ] ", matriz[i][j]);
            }

            System.out.println();
        }

        System.out.println();
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
                List<INodo<T>> vecinos = actual.getVecinos();

                for (int i = vecinos.size() - 1; i >= 0; i--) {
                    INodo<T> vecino = vecinos.get(i);

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