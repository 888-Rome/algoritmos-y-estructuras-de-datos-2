package modelos;

// ▶ Importaciones ─────────────────────────────────────────────────────────────────────────────────────────────────────
import interfaces.IPersona  ;

public class Persona implements IPersona {

    // ▶ Atributos ─────────────────────────────────────────────────────────────────────────────────────────────────────
    private String nombre   ;
    private String DNI      ;

    // ▶ Constructores ─────────────────────────────────────────────────────────────────────────────────────────────────
    public Persona() {}

    public Persona(String nombre, String DNI) {
        this.nombre = nombre    ;
        this.DNI = DNI          ;
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

    // ToString ────────────────────────────────────────────────────────────────────────────────────────────────────────
    @Override
    public String toString() {
        return nombre + ", (" + DNI + ")" + " | ";
    }

// ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
}
