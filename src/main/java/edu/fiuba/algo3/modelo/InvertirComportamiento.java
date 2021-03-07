package edu.fiuba.algo3.modelo;

public class InvertirComportamiento implements EstadoDeBloque, EstadoDeBloqueCompuesto {
    private RecorridoNormal bloques = new RecorridoNormal();

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        this.bloques.ejecutar(personaje, dibujo);
    }

    @Override
    public EstadoDeBloqueCompuesto clonar() {
        EstadoDeBloqueCompuesto estadoClonado = new InvertirComportamiento();
        estadoClonado.setBloques(this.bloques);
        return estadoClonado;
    }

    @Override
    public EstadoDeBloque invertir() {
        this.bloques.invertir();
        return this;
    }

    @Override
    public void setBloques(RecorridoNormal bloques) {
        this.bloques = bloques.clonar();
        this.bloques.invertir();
    }

    @Override
    public String toString() {
        return "InvertirComportamiento{}";
    }

    @Override
    public Bloque agregarBloque(Bloque bloque) {
        Bloque bloqueInvertido = bloque.clonar();
        bloqueInvertido.invertir();
        return bloqueInvertido;
    }
}
