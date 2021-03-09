package edu.fiuba.algo3.modelo;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.ArrayList;
import java.util.List;

public class RecorridoNormal {
    ArrayList<Bloque> bloques = new ArrayList<>();
    private final PropertyChangeSupport support = new PropertyChangeSupport(this);

    public void agregarBloque(Bloque bloque){
        Bloque bloqueAntiguo = bloques.isEmpty() ? null : bloques.get(bloques.size() - 1);
        this.bloques.add(bloque);
        support.firePropertyChange("bloque", bloqueAntiguo, bloque);
    }

    public RecorridoNormal invertir() {
        bloques.forEach(Bloque::invertir);
        return this;
    }

    public RecorridoNormal clonar() {
        RecorridoNormal recorridoClonado = new RecorridoNormal();
        recorridoClonado.clonar(bloques);
        return recorridoClonado;
    }

    private void clonar(List<Bloque> bloques){
        this.bloques = new ArrayList<>();
        bloques.forEach(bloque -> this.bloques.add(bloque.clonar()));
    }

    public void ejecutar(Personaje personaje, Dibujo dibujo){
        this.bloques.forEach(bloque -> bloque.ejecutar(personaje, dibujo));
    }

    public void reiniciar(){
        this.bloques = new ArrayList<>();
        support.firePropertyChange("bloques", bloques, null);
    }

    public BloqueAgregable guardarSecuenciaConNombre(String nombre) {
        return new BloqueAgregable(new BloquePersonalizado(nombre, this.clonar()), this.clonar());
    }

    void removerUltimo(){
        if(!bloques.isEmpty()) {
            bloques.remove(bloques.size() - 1);
        }
    }

    public void addPropertyChangeListener(PropertyChangeListener pcl) {
        support.addPropertyChangeListener(pcl);
    }

}
