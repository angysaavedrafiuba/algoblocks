package edu.fiuba.algo3;

public class Posicion2D implements Posicion{
    private int x, y;

    public static final int X_DERECHA   =   1;
    public static final int Y_DERECHA   =   0;

    public static final int X_IZQUIERDA =  -1;
    public static final int Y_IZQUIERDA   =   0;
    public static final int X_ABAJO     =   0;
    public static final int Y_ABAJO     =  -1;

    public static final int X_ARRIBA    =   0;
    public static final int Y_ARRIBA    =   1;

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
        return(posicion.getX() == this.x && posicion.getY() == this.y);
    }

    public boolean esLaMismaQue(Posicion2D posicion){
        return(posicion.getX() == x && posicion.getY() == y);
    }

    public void mover(Posicion2D posicion) {
        this.x += posicion.getX();
        this.y += posicion.getY();
    }

    public Posicion2D clonarPosicion(){
        return (new Posicion2D(this.x, this.y));
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
