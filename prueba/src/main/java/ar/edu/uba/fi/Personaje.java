package ar.edu.uba.fi;

public class Personaje {
    private Lapiz lapiz;

    /* constructor */
    public Personaje() {
        this.lapiz = new lapizConPuntaHaciaArriba();
    }

    public boolean lapizEstaArriba() {
        return lapiz.LapizArriba();
    }

    public void setLapiz(Lapiz lapiz) {
        this.lapiz = lapiz;
    }

    /*public void aplicar(Bloque bloque) {
        bloque.ejecutar(this);
    }

    public Coordenada obtenerCoordenada() {

    }*/
}


