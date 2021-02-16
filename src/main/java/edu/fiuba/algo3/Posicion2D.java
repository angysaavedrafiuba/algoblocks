package edu.fiuba.algo3;

public class Posicion2D{
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

    public boolean esLaMismaQue(Posicion2D posicion){
        return(posicion.getX() == x && posicion.getY() == y);
    }

    public Posicion2D calcularNuevaPosicion(Posicion2D posicion) {
        return posicion.calcularNuevaPosicion(this.x, this.y);
    }

    private Posicion2D calcularNuevaPosicion(int xActual, int yActual) {
        return new Posicion2D(this.x + xActual, this.y + yActual);
    }

    public Posicion2D clonarPosicion(){
        return (new Posicion2D(this.x, this.y));
    }

    @Override
    public boolean equals(Object object) {
        Posicion2D posicionAComparar = (Posicion2D) object;

        return (esLaMismaQue(posicionAComparar));
    }

    /* Test only */
    @Override
    public java.lang.String toString() {
        return "Posicion2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}
