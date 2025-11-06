package test;

// ▶ Importaciones ─────────────────────────────────────────────────────────────────────────────────────────────────────
import interfaces.INodo;
import modelos.Nodo;

public class TestNodo {

    public static void main(String[] args) {
        System.out.println("=== PRUEBA DE NODO ===");

        // Crear nodo con dato inicial
        INodo<Integer> nodo1 = new Nodo<>(10);
        System.out.println("Dato inicial: " + nodo1.getDato());

        // Cambiar el dato
        nodo1.setDato(20);
        System.out.println("Dato después de setDato: " + nodo1.getDato());

        // Crear un segundo nodo y agregarlo como vecino
        INodo<Integer> nodo2 = new Nodo<>(30);
        nodo1.agregarVecino(nodo2,1);

        // Mostrar los vecinos
        System.out.println("Vecinos de nodo1:");
        for (INodo<Integer> v : nodo1.getVecinos()) {
            System.out.println(" - " + v.getDato());
        }
    }

// ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
}
