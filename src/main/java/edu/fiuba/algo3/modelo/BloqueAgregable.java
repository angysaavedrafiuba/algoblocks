package edu.fiuba.algo3.modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

//TODO Implementar AlgoritmoPersonalizado que implementa BloqueAgregable
public class BloqueAgregable extends Bloque{
    private RecorridoNormal bloques = new RecorridoNormal();
    EstadoDeBloqueCompuesto estadoCompuesto;

    public BloqueAgregable(EstadoDeBloqueCompuesto estado){
        super();
        this.estado = (EstadoDeBloque) estado;
        this.estadoCompuesto = estado;
    }

    public BloqueAgregable(EstadoDeBloqueCompuesto estado, RecorridoNormal bloques){
        this.estadoCompuesto = estado;
        this.bloques = bloques;
    }

    public void invertir(){
        this.bloques.invertir();
        this.estadoCompuesto.setBloques(this.bloques);
    }

    public void ejecutar(Personaje personaje, Dibujo dibujo){
        this.estadoCompuesto.setBloques(bloques);
        this.estadoCompuesto.ejecutar(personaje, dibujo);
    }

    @Override
    public Bloque clonar() {
        return new BloqueAgregable(this.estadoCompuesto.clonar(), this.bloques.clonar());
    }

    public void agregarBloque(Bloque bloque){
        bloques.agregarBloque(this.estadoCompuesto.agregarBloque(bloque));
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
}
