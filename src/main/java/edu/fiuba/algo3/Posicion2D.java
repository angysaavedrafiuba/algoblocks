package edu.fiuba.algo3;

public class Posicion2D implements Posicion{
    private int x, y;

    public static final Posicion2D DERECHA   =  new Posicion2D(1, 0);
    public static final Posicion2D IZQUIERDA =  new Posicion2D(-1, 0);
    public static final Posicion2D ARRIBA    =  new Posicion2D(0, 1);
    public static final Posicion2D ABAJO     =  new Posicion2D(0, -1);

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

    public boolean esLaMismaQue(Posicion2D posicion){
        return(posicion.getX() == x && posicion.getY() == y);
    }

    public void mover(Posicion2D posicion) {
        this.x += posicion.getX();
        this.y += posicion.getY();
    }

    public boolean equals(Object object) {
        if (this == object) return true;
        if (object == null || getClass() != object.getClass()) return false;
        if (!super.equals(object)) return false;
        Posicion2D that = (Posicion2D) object;
        return x == that.x && y == that.y;
    }

    public int hashCode() {
        return java.util.Objects.hash(super.hashCode(), x, y);
    }

    @java.lang.Override
    public java.lang.String toString() {
        return "Posicion2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }


}
