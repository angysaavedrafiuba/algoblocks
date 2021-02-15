package edu.fiuba.algo3;

public class RecorridoNormal implements Recorrido{
    private Bloque primerBloque = new BloqueNulo();
    private Bloque ultimoBloque = new BloqueNulo();

    @Override
    public void agregar(Bloque bloque){
        try {
            ultimoBloque.siguiente(bloque);
            ultimoBloque = bloque;
        }
        catch (RuntimeException e){
            primerBloque=bloque;
            ultimoBloque=bloque;
        }
    }

    @Override
    public Bloque primerBloque(){
        return primerBloque;
    }
}
