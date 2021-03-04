package edu.fiuba.algo3.modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;

public class BloqueAgregable extends Bloque{
    private RecorridoNormal bloques = new RecorridoNormal();
    private PropertyChangeSupport support = new PropertyChangeSupport(this);

    public BloqueAgregable(EstadoDeBloque estado){
        super();
        idParticular = super.getId();
        this.estado = estado;
    }

    private BloqueAgregable(EstadoDeBloque estado, RecorridoNormal bloques){
        this.estado = estado;
        this.bloques = bloques;
    }

    public void invertir(){
        estado.setBloques(bloques);
        this.estado.invertir();
    }

    public void ejecutar(Personaje personaje, Dibujo dibujo){
        this.estado.setBloques(bloques);
        this.estado.ejecutar(personaje, dibujo);
    }

    @Override
    public Bloque clonar() {
        return new BloqueAgregable(this.estado, this.bloques);
    }

    public void agregarBloque(Bloque bloque){
        bloques.agregarBloque(bloque);
    }

    public void removerUltimo(){
        bloques.removerUltimo();
    }

    @Override
    public int getId() {
        return idParticular;
    }

    public RecorridoNormal getRecorrido() {
        return this.bloques;
    }

    public void addPropertyChangeListener(PropertyChangeListener controladorBloque) {
        this.bloques.addPropertyChangeListener(controladorBloque);
    }
}
