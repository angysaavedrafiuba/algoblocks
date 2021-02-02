package edu.fiuba.algo3;

public class RecorridoInverso implements Recorrido {

    private Bloque ultimoBloque = new BloqueNulo();
    private Bloque primerBloque = new BloqueNulo();

    @Override
    public void ultimoBloque(Bloque bloque) {
        this.ultimoBloque = ultimoBloque;
    }

    @Override
    public void agregar(Bloque bloque) {
        try {
            bloque.siguiente(primerBloque);
            primerBloque = bloque;
        }
        catch (RuntimeException e){
            primerBloque=bloque;
            ultimoBloque=bloque;
        }
    }

    public Bloque primerBloque(){
        return primerBloque;
    }
}
