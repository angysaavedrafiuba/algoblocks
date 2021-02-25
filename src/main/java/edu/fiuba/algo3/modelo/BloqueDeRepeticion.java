package edu.fiuba.algo3.modelo;

public class BloqueDeRepeticion implements EstadoDeBloque{
    private final int repeticiones;
    private Recorrido bloques;

    BloqueDeRepeticion(int repeticiones){
        this.repeticiones = repeticiones;
    }

    @Override
    public void setBloques(Recorrido bloques){
        this.bloques = bloques;
    }

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        for(int i=0; i<repeticiones; i++) {
            bloques.clonar().ejecutar(personaje, dibujo);
        }
    }

    @Override
    public EstadoDeBloque invertir() {
        this.bloques = this.bloques.invertir();
        return this;
    }

}
