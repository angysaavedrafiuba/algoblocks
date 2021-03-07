package edu.fiuba.algo3.modelo;

public class BloqueDeRepeticion implements EstadoDeBloque, EstadoDeBloqueCompuesto {
    private final int repeticiones;
    private RecorridoNormal bloques = new RecorridoNormal();

    public BloqueDeRepeticion(int repeticiones){
        this.repeticiones = repeticiones;
    }

    @Override
    public void setBloques(RecorridoNormal bloques) {
        this.bloques = bloques.clonar();
    }

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        for(int i=0; i<repeticiones; i++) {
            bloques.ejecutar(personaje, dibujo);
        }
    }

    @Override
    public EstadoDeBloqueCompuesto clonar() {
        EstadoDeBloqueCompuesto estadoClonado = new BloqueDeRepeticion(repeticiones);
        estadoClonado.setBloques(this.bloques);
        return estadoClonado;
    }

    @Override
    public EstadoDeBloque invertir() {
        this.bloques = this.bloques.invertir();
        return this;
    }

    @Override
    public String toString() {
        return "BloqueDeRepeticion{" + repeticiones + "}";
    }

    @Override
    public Bloque agregarBloque(Bloque bloque) {
        return bloque;
    }
}
