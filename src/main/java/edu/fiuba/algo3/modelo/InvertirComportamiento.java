package edu.fiuba.algo3.modelo;

public class InvertirComportamiento implements EstadoDeBloque {

    private Recorrido bloques;


    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        this.bloques.clonar().ejecutar(personaje, dibujo);
    }

    @Override
    public EstadoDeBloque invertir() {
        return this;
    }

    @Override
    public void setBloques(Recorrido bloques) {
        this.bloques = bloques.invertir();
    }

}
