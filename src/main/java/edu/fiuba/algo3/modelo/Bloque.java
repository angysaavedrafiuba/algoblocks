package edu.fiuba.algo3.modelo;

public abstract class Bloque {
    protected EstadoDeBloque estado;

    public void invertir(){
        this.estado = this.estado.invertir();
    }

    public void ejecutar(Personaje personaje, Dibujo dibujo){
        this.estado.ejecutar(personaje, dibujo);
    }

    public abstract Bloque clonar();

    @Override
    public String toString() {
        return "Bloque{estado=" + estado.toString() + "}";
    }

}
