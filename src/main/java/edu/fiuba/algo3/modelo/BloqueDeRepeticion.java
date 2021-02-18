package edu.fiuba.algo3.modelo;

public class BloqueDeRepeticion extends Bloque {
    private final RecorridoNormal secuencia = new RecorridoNormal();
    private final int repeticiones;

    BloqueDeRepeticion(int repeticiones){
        siguiente = new BloqueNulo();
        this.repeticiones = repeticiones;
    }

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        for(int i=0; i<repeticiones; i++) {
            secuencia.ejecutar(personaje, dibujo);
        }
        this.siguiente.ejecutar(personaje, dibujo);
    }

    @Override
    public Bloque invertir() {
        secuencia.invertir();
        return this;
    }

    public void removerUltimo() {
        secuencia.removerUltimo();
    }

    public void agregarBloque(Bloque bloque) {
        secuencia.agregarBloque(bloque);
    }
}
