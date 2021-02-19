package edu.fiuba.algo3.modelo;

public class InvertirComportamiento implements EstadoDeBloque {

    private final RecorridoInverso bloques = new RecorridoInverso();

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        bloques.ejecutar(personaje, dibujo);
    }

    @Override
    public EstadoDeBloque invertir() {
        return this;
    }

    public void agregarBloque(Bloque bloque) {
        bloques.agregarBloque(bloque);
    }

    public void removerUltimo() {
        bloques.removerUltimo();
    }
}
