package edu.fiuba.algo3.modelo;

public class BloqueDeRepeticion implements EstadoDeBloque{
    private Recorrido bloques = new RecorridoNormal();
    private final int repeticiones;

    BloqueDeRepeticion(int repeticiones){
        this.repeticiones = repeticiones;
    }

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        for(int i=0; i<repeticiones; i++) {
            bloques.ejecutar(personaje, dibujo);
        }
    }

    @Override
    public EstadoDeBloque invertir() {
        this.bloques = bloques.invertir();
        return this;
    }

    @Override
    public void agregarBloque(Bloque bloque) {
        bloques.agregarBloque(bloque);
    }

    public void removerUltimo(){
        bloques.removerUltimo();
    }

}
