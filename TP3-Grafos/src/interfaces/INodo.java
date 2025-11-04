package interfaces;

public interface INodo<T extends Comparable<T>> {

    //Getters y setters
    public T getDato();
    public void setDato(T dato);


    public void agregarVecino(INodo<T> nodo);


    public boolean fueVisitado();
    public void marcarVisitado(boolean b);

    INodo<T>[] getVecinos();
}