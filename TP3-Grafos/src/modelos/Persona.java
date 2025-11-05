package modelos;

// ▶ Importaciones ─────────────────────────────────────────────────────────────────────────────────────────────────────
import interfaces.IPersona  ;

public class Persona implements IPersona, Comparable<Persona> {

    // ▶ Atributos ─────────────────────────────────────────────────────────────────────────────────────────────────────
    private String DNI      ;
    private String nombre   ;

    // ▶ Constructores ─────────────────────────────────────────────────────────────────────────────────────────────────
    public Persona() {}

    public Persona(String DNI, String nombre) {
        this.DNI = DNI          ;
        this.nombre = nombre    ;
    }

    // ▶ Getters ───────────────────────────────────────────────────────────────────────────────────────────────────────
    public String getNombre() { return nombre; }
    public String getDNI() { return DNI; }

    // ▶ Setters ───────────────────────────────────────────────────────────────────────────────────────────────────────
    public void setNombre(String nombre) { this.nombre = nombre; }
    public void setDNI(String DNI) { this.DNI = DNI; }

    // ▶ Métodos ───────────────────────────────────────────────────────────────────────────────────────────────────────
    /* Compara a las personas por su DNI. */
    public int compararPorDNI(IPersona persona) {
        return this.DNI.compareTo(persona.getDNI());
    }

    /* Compara a las personas por nombre. */
    public int compararPorNombre(IPersona persona) {
        return this.nombre.compareTo(persona.getNombre());
    }

    @Override
    public int compareTo(Persona persona) {
        return this.DNI.compareTo(persona.getDNI());
    }

    // ToString ────────────────────────────────────────────────────────────────────────────────────────────────────────
    @Override
    public String toString() {
        return nombre + " (" + DNI + ")" + " | ";
    }

// ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
}
