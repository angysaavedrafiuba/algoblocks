package edu.fiuba.algo3;

public class InvertirComportamiento extends Bloque {
    private final ColaDeInstrucciones secuencia = new RecorridoNormal();

    InvertirComportamiento() {
        siguiente = new BloqueNulo();
    }

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        secuencia.ejecutar(personaje, dibujo);
        this.siguiente.ejecutar(personaje, dibujo);
    }

    @Override
    public InvertirComportamiento invertir() {
        secuencia.invertir();
        return this;
    }

    public void agregarBloque(Bloque bloque) {
        secuencia.agregarBloque(bloque.invertir());
    }
}
