package edu.fiuba.algo3.modelo;

public class InvertirComportamiento implements EstadoDeBloque {
    private RecorridoNormal bloques;

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        this.bloques.ejecutar(personaje, dibujo);
    }

    @Override
    public EstadoDeBloque invertir() {
        return this;
    }

    @Override
    public void setBloques(RecorridoNormal bloques) {
        this.bloques = bloques.clonar().invertir();
    }

    @Override
    public String toString() {
        return "InvertirComportamiento{}";
    }
}
