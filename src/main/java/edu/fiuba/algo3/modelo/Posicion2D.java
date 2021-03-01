package edu.fiuba.algo3.modelo;

public class Posicion2D {
    public static int xLimite = 21;
    public static int yLimite = 21;

    private static final int X_DERECHA   =   1;
    private static final int Y_DERECHA   =   0;

    private static final int X_IZQUIERDA =  -1;
    private static final int Y_IZQUIERDA =   0;

    private static final int X_ABAJO     =   0;
    private static final int Y_ABAJO     =  -1;

    private static final int X_ARRIBA    =   0;
    private static final int Y_ARRIBA    =   1;

    private final int x, y;

    public static Posicion2D posicionInicial() {
        return new Posicion2D((xLimite/2), (yLimite/2));
    }

    public static Posicion2D derecha    ()  { return new Posicion2D(X_DERECHA, Y_DERECHA);      }
    public static Posicion2D izquierda  ()  { return new Posicion2D(X_IZQUIERDA, Y_IZQUIERDA);  }
    public static Posicion2D abajo      ()  { return new Posicion2D(X_ABAJO, Y_ABAJO);          }
    public static Posicion2D arriba     ()  { return new Posicion2D(X_ARRIBA, Y_ARRIBA);        }

    public Posicion2D(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public Posicion2D calcularNuevaPosicion(Posicion2D posicion) {
        return posicion.calcularNuevaPosicion(this.x, this.y);
    }

    private Posicion2D calcularNuevaPosicion(int xActual, int yActual) {
        int nuevaX = (this.x + xActual + xLimite) % (xLimite);
        int nuevaY = (this.y + yActual + yLimite) % (yLimite);
        return new Posicion2D(nuevaX, nuevaY);
    }

    public Posicion2D clonarPosicion(){
        return (new Posicion2D(this.x, this.y));
    }

    /* Test only */
    @Override
    public boolean equals(Object object) {
        if (!(object instanceof Posicion2D)) {
            return false;
        }

        Posicion2D posicionAComparar = (Posicion2D) object;

        return (esLaMismaQue(posicionAComparar));
    }

    @Override
    public java.lang.String toString() {
        return "Posicion2D{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }

    public boolean esLaMismaQue(Posicion2D posicion){
        return(posicion.getX() == x && posicion.getY() == y);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
}
