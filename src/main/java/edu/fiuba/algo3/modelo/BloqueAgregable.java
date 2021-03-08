package edu.fiuba.algo3.modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class BloqueAgregable extends Bloque{
    private RecorridoNormal bloques = new RecorridoNormal();
    EstadoDeBloqueCompuesto estado;

    public BloqueAgregable(EstadoDeBloqueCompuesto estado){
        super();
        super.estado = estado;
        this.estado = estado;
    }

    public BloqueAgregable(EstadoDeBloqueCompuesto estado, RecorridoNormal bloques){
        this.estado = estado;
        this.bloques = bloques;
    }

    public void invertir(){
        this.bloques.invertir();
        this.estado.setBloques(this.bloques);
    }

    public void ejecutar(Personaje personaje, Dibujo dibujo){
        this.estado.setBloques(bloques);
        this.estado.ejecutar(personaje, dibujo);
    }

    @Override
    public Bloque clonar() {
        return new BloqueAgregable(this.estado.clonar(), this.bloques.clonar());
    }

    public void agregarBloque(Bloque bloque){
        bloques.agregarBloque(bloque);
    }

    public void removerUltimo(){
        bloques.removerUltimo();
    }

    public RecorridoNormal getRecorrido() {
        return this.bloques;
    }

    public void addPropertyChangeListener(PropertyChangeListener controladorBloque) {
        this.bloques.addPropertyChangeListener(controladorBloque);
    }

    @Override
    public String toString() {
        return this.estado.toString();
    }

    @Override
    public Estado getEstado() {
        return this.estado;
    }
}
