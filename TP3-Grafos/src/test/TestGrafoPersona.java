package test;

// ▶ Importaciones ─────────────────────────────────────────────────────────────────────────────────────────────────────
import interfaces.INodo;
import modelos.Grafo    ;
import modelos.Persona  ;

public class TestGrafoPersona {
    public static void main(String[] args) {

        // ▶ Crea el grafo
        Grafo<Persona> grafo = new Grafo<>(false);

        // ▶ Crea las personas los nodos
        Persona p1 = new Persona("001","Eleanor");
        Persona p2 = new Persona("002","Theodora");
        Persona p3 = new Persona("003","Olivia");
        Persona p4 = new Persona("004","Luke");
        Persona p5 = new Persona("005","Hugh");

        // ▶ Agrega los nodos, usando las personas creadas previamente.
        grafo.agregarNodo(p1);
        grafo.agregarNodo(p2);
        grafo.agregarNodo(p3);
        grafo.agregarNodo(p4);
        grafo.agregarNodo(p5);

        // ▶ Crea los nodos
        INodo<Persona> nodo1 = grafo.getDato(p1);
        INodo<Persona> nodo2 = grafo.getDato(p2);
        INodo<Persona> nodo3 = grafo.getDato(p3);
        INodo<Persona> nodo4 = grafo.getDato(p4);
        INodo<Persona> nodo5 = grafo.getDato(p5);

        // ▶ Conecta los nodos
        grafo.conectarNodos(nodo1,nodo2);
        grafo.conectarNodos(nodo2,nodo3);
        grafo.conectarNodos(nodo3,nodo4);
        grafo.conectarNodos(nodo5,nodo1);
        grafo.conectarNodos(nodo4,nodo1);

        // ▶ Imprime la matriz de adyacencia
        grafo.imprimirMatriz();

        // ▶ Prueba DFS
        System.out.println("\n" + "[ Recorrido DFS ]");
        System.out.println(grafo.recorrerDFS(nodo1));

        // ▶ Prueba BFS
        System.out.println("\n" + "[ Recorrido BFS ]");
        grafo.recorrerBFS(nodo1);

        // ▶ Elimina un nodo y vuelve a imprimir:
        System.out.println("| Eliminando el nodo 3: " + "\n");
        grafo.eliminarNodo(p3);
        grafo.imprimirMatriz();
    }
}
