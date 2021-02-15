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

    public boolean estaEn(Posicion2D posicion) {
        return(posicion.getX() == this.x && posicion.getY() == this.y);
    }

    public boolean igualA(Posicion2D posicion){
        return(posicion.getX() == x && posicion.getY() == y);
    }

    /* Revisar */
    public void mover(Posicion2D posicion) {
        this.x += posicion.getX();
        this.y += posicion.getY();
    }

    public Posicion2D clonarPosicion(){
        return (new Posicion2D(this.x, this.y));
    }

    @Override
    public boolean equals(Object object) {
        Posicion2D posicionAComparar = (Posicion2D) object;

        return (igualA(posicionAComparar));
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
