package model;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Contenedor extends Canvas{
    int ancho;
    int alto;

    public Contenedor(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;

        setBounds(0, 0, ancho, alto);
    }

    public void paint(Graphics g) {
        g.setColor(Color.red);
        g.fillRect(0, 0, ancho, alto);
    }
}
