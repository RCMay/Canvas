package model;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Circulo extends Canvas{
    int ancho;
    int alto;

    public void setAlto(int alto) {
        this.alto = alto;
    }

    public int getAlto() {
        return alto;
    }

    public void setAncho(int ancho) {
        this.ancho = ancho;
    }

    public int getAncho() {
        return ancho;
    }

    public Circulo(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        setBounds(0, 0, ancho, alto);
    }

    public void paint(Graphics g) {
        g.setColor(Color.black);
        g.fillOval(0, 0, ancho, alto);

    }
}
