package model;

import java.awt.Canvas;
import java.awt.Color;
import java.awt.Graphics;

public class Boton extends Canvas{
    int ancho;
    int alto;

    public Boton(int ancho, int alto) {
        this.ancho = ancho;
        this.alto = alto;
        setBounds(0, 0, ancho, alto);
    }

    public void paint(Graphics g) {
        g.setColor(Color.green);
        g.fillOval(0, 0, ancho, alto);
        g.setColor(Color.black);
        g.drawString("Restaurar", 20, 50);
    }
}
