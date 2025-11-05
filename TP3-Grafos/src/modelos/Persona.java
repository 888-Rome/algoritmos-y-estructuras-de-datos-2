package modelos;

// ▶ Importaciones ─────────────────────────────────────────────────────────────────────────────────────────────────────
import interfaces.IPersona  ;

// ▶ ───────────────────────────────────────────────────────────────────────────────────────────────────────────────────

public class Persona implements IPersona {

    // ▶ Atributos ─────────────────────────────────────────────────────────────────────────────────────────────────────
    private String DNI      ;
    private String nombre   ;

    // ▶ Constructores ─────────────────────────────────────────────────────────────────────────────────────────────────
    public Persona(String DNI, String nombre) {
        this.DNI = DNI          ;
        this.nombre = nombre    ;
    }

    // ▶ Getters ───────────────────────────────────────────────────────────────────────────────────────────────────────
    @Override
    public String getNombre() { return nombre; }
    @Override
    public String getDNI() { return DNI; }

    // ▶ Setters ───────────────────────────────────────────────────────────────────────────────────────────────────────
    @Override
    public void setDNI(String DNI) { this.DNI = DNI; }
    @Override
    public void setNombre(String nombre) { this.nombre = nombre; }

    // ▶ Métodos ───────────────────────────────────────────────────────────────────────────────────────────────────────
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;

        if (!(obj instanceof Persona)) return false;

        Persona persona = (Persona) obj;

        return this.DNI.equals(persona.DNI);
    }

    @Override
    public int hashCode() { return DNI.hashCode(); }

    // ToString ────────────────────────────────────────────────────────────────────────────────────────────────────────
    @Override
    public String toString() {
        return nombre + " (" + DNI + ")" + " | ";
    }

// ─────────────────────────────────────────────────────────────────────────────────────────────────────────────────────
}
