package edu.fiuba.algo3.modelo;

public class Bloque{

    private EstadoDeBloque estado;

    Bloque(EstadoDeBloque estadoDeBloque){
        this.estado = estadoDeBloque;
    }

    public void invertir(){
        this.estado = this.estado.invertir();
    }

    public void ejecutar(Personaje personaje, Dibujo dibujo){
        this.estado.ejecutar(personaje, dibujo);
    }

    public void agregarBloque(Bloque bloque){
        estado.agregarBloque(bloque);
    }

}
