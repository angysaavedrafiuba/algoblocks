package edu.fiuba.algo3.modelo;

public abstract class Bloque {
    protected Estado estado;

    public void invertir(){
        this.estado = this.estado.invertir();
    }

    public void ejecutar(Personaje personaje, Dibujo dibujo){
        this.estado.ejecutar(personaje, dibujo);
    }

    public abstract Bloque clonar();

    // TODO Verificar si se puede generalizar el metodo toString y tener uno específico para BloquesPersonalizados
    @Override
    public String toString() {
        return estado.toString();
    }

    public Estado getEstado() {
        return this.estado;
    }
}
