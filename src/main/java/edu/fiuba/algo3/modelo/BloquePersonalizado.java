package edu.fiuba.algo3.modelo;

public class BloquePersonalizado implements EstadoDeBloque, EstadoDeBloqueCompuesto {
    private final String nombre;
    private RecorridoNormal bloques;

   public BloquePersonalizado(String nombre, RecorridoNormal secuenciaDeBloques){
       this.bloques = secuenciaDeBloques;
       this.nombre = nombre;
   }

    @Override
    public Bloque agregarBloque(Bloque bloque) {
       return bloque;
    }

    @Override
    public void ejecutar(Personaje personaje, Dibujo dibujo) {
        this.bloques.ejecutar(personaje, dibujo);
    }

    @Override
    public EstadoDeBloqueCompuesto clonar() {
        RecorridoNormal nuevosBloques = this.bloques.clonar();
        return new BloquePersonalizado(nombre, nuevosBloques);
    }

    @Override
    public void setBloques(RecorridoNormal bloques) {
        this.bloques = bloques;
    }

    @Override
    public EstadoDeBloque invertir() {
        this.bloques = this.bloques.clonar().invertir();
        return this;
    }

    @Override
    public String toString() {
        return nombre;
    }

    public String getNombre() {
       return this.nombre;
    }
}
