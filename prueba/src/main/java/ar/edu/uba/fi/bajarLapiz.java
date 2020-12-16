package ar.edu.uba.fi;

public class bajarLapiz implements Bloque {
    @Override
    public void ejecutar(Tablero tablero){
        Personaje personaje = tablero.obtenerPersonaje();
        personaje.setLapiz(new lapizConPuntaHaciaAbajo());

    }
}
