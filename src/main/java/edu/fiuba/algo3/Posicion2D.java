package edu.fiuba.algo3;

public class Posicion2D {
    private int x, y;

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Posicion2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public boolean estaEn(Posicion2D posicion) {
        return(posicion.getX() == x && posicion.getY() == y);
    }

    public void mover(Posicion2D posicion) {
        this.x += posicion.getX();
        this.y += posicion.getY();
    }
}
