package edu.fiuba.algo3.modelo;

public class InvertirComportamiento implements EstadoDeBloque {
    private RecorridoNormal bloques;
    boolean fueInvertido = false;

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        this.bloques.ejecutar(personaje, dibujo);
    }

    @Override
    public EstadoDeBloque invertir() {
        this.bloques.invertir();
        fueInvertido = true;
        return this;
    }

    @Override
    public void setBloques(RecorridoNormal bloques) {
        if(!fueInvertido) {
            this.bloques = bloques.clonar().invertir();
        } else {
            this.bloques = bloques.clonar();
        }
    }

    @Override
    public String toString() {
        return "InvertirComportamiento{}";
    }
}
