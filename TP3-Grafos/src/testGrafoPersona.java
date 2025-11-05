
// ▶ Importaciones ─────────────────────────────────────────────────────────────────────────────────────────────────────
import interfaces.IGrafo    ;
import java.util.List       ;
import java.util.ArrayList  ;
import java.util.Arrays     ;
import modelos.Grafo        ;
import modelos.Nodo         ;
import modelos.Persona      ;


public class testGrafoPersona {

    public static void main(String[] args) {

        // ▶ 🌐 Crea el grafo.
        IGrafo<Persona> grafo = new Grafo<>();

        // ▶ 👥 Crea las personas.
        List<Persona> personas = new ArrayList<>(Arrays.asList(
            new Persona("28374915", "Bautista Ibarra")  ,
            new Persona("34562718", "María González")   ,
            new Persona("39487230", "Emilia Soler")     ,
            new Persona("31290456", "Abril Roldán")     ,
            new Persona("43175642", "Thiago Bianchi")   ,
            new Persona("40591274", "Zoe Mancini")      ,
            new Persona("31285749", "Gael Montenegro")  ,
            new Persona("29837461", "Aylén Varela")     ,
            new Persona("27659384", "Fiorella Paredes") ,
            new Persona("42194876", "Mateo Olmos")
            ));

        // ▶ 🧩 Las usa para insertarlas en el grafo como un nodo.
        for (Persona p : personas) {
            grafo.agregarNodo(new Nodo<>(false, null, p));
        }

        // 🔗 Crea conexiones
        grafo.conectarNodos(grafo.getNodos().get(0), grafo.getNodos().get(1));
        grafo.conectarNodos(grafo.getNodos().get(0), grafo.getNodos().get(2));
        grafo.conectarNodos(grafo.getNodos().get(1), grafo.getNodos().get(3));
        grafo.conectarNodos(grafo.getNodos().get(1), grafo.getNodos().get(4));
        grafo.conectarNodos(grafo.getNodos().get(2), grafo.getNodos().get(0));
        grafo.conectarNodos(grafo.getNodos().get(3), grafo.getNodos().get(5));
        grafo.conectarNodos(grafo.getNodos().get(4), grafo.getNodos().get(4));
        grafo.conectarNodos(grafo.getNodos().get(5), grafo.getNodos().get(4));
        grafo.conectarNodos(grafo.getNodos().get(0), grafo.getNodos().get(1));
        grafo.conectarNodos(grafo.getNodos().get(1), grafo.getNodos().get(0));

        // 📍 Accede al nodo del inicio
        Nodo<Persona> inicio = grafo.getNodos().get(0);

        // 📈 Visualización y recorrido

        // TODO: Agregar mostrarMatrizAdyacencia()
        // TODO: Agregar mostrarListaAdyacencia()

        // Método por anchura
        grafo.recorrerBFS(inicio);

        System.out.println();

        // Método por profundidad
        grafo.recorrerDFS(inicio);

    }
}
