package edu.fiuba.algo3.modelo;

import java.util.ArrayList;

public class Algoblocks {
    private final Personaje personaje = new Personaje(Posicion2D.posicionInicial());
    private final Dibujo dibujo = new Dibujo();
    private final RecorridoNormal bloques = new RecorridoNormal();

    private static Algoblocks instance;

    public static Algoblocks getInstance() {
        return instance;
    }

    public static void Create() {
        instance = new Algoblocks();
    }

    public void agregarBloqueDeAccion(BloqueDeAccion bloque){
        bloques.agregarBloque(bloque);
    }

    public void agregarBloqueAgregable(BloqueAgregable bloque){
        bloques.agregarBloque(bloque);
    }

    public EstadoDeBloque guardarAlgoritmo(String nombreAlgoritmo){
        return bloques.guardarSecuenciaConNombre(nombreAlgoritmo);
    }

    public void ejecutar() {
        bloques.ejecutar(this.personaje, this.dibujo);
    }

    public void reiniciarAlgoritmo() {
        bloques.reiniciar();
    }

    public void removerUltimo() {
        bloques.removerUltimo();
    }

    public void reiniciarDibujo() {
        dibujo.reiniciar();
    }

    public Dibujo getDibujo(){
        return dibujo;
    }

    public Personaje getPersonaje(){
        return personaje;
    }

    public RecorridoNormal getRecorridoNormal(){
        return bloques;
    }

    public void reset() {
        dibujo.reset();
        bloques.reiniciar();
        personaje.volverAPosicionInicial();
    }

    /* Test only */
    public ArrayList<Posicion2D> obtenerDibujo() {
        return this.dibujo.posicionesDibujadas();
    }
}
