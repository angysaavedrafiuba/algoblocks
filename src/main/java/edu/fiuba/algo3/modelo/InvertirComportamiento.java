package edu.fiuba.algo3.modelo;

public class InvertirComportamiento extends Bloque {
    private final RecorridoNormal secuencia = new RecorridoNormal();

    InvertirComportamiento() {
        this.siguiente = new BloqueNulo();
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

    public void removerUltimo() {
        secuencia.removerUltimo();
    }
}
