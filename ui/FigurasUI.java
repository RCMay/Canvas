package ui;
import java.awt.*;
import java.awt.FlowLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseMotionListener;
import javax.swing.*;
import model.*;

public class FigurasUI extends JFrame implements KeyListener, MouseListener{
    JPanel panel1, panel2, panel3, panel4;
    Boolean dentro;

    private volatile int screenX = 0;
    private volatile int screenY = 0;
    private volatile int myX = 0;
    private volatile int myY = 0;

    Contenedor contenedor;
    Boton boton;
    ContenedorTemporal temporal;
    Circulo circulo;

    public FigurasUI() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setSize(1000, 700);
        panel1 = new JPanel();
        panel1.setLayout(new FlowLayout());
        panel2 = new JPanel();
        panel2.setLayout(new BorderLayout());
        panel3 = new JPanel();
        panel3.setLayout(new FlowLayout());
        panel4 = new JPanel();
        panel4.setLayout(new FlowLayout());

        dentro = false;

        boton = new Boton(100, 100);
        panel1.add(boton);
        add(panel1, BorderLayout.NORTH);
        boton.addMouseListener(this);

        contenedor = new Contenedor(400, 200);
        circulo = new Circulo(40, 40);

        circulo.addMouseListener(new MouseListener() {

            @Override
            public void mouseClicked(MouseEvent e) {
            }

            @Override
            public void mousePressed(MouseEvent e) {
                screenX = e.getXOnScreen();
                screenY = e.getYOnScreen();

                myX = circulo.getX();
                myY = circulo.getY();

            }

            @Override
            public void mouseReleased(MouseEvent e) {
            }

            @Override
            public void mouseEntered(MouseEvent e) {
            }

            @Override
            public void mouseExited(MouseEvent e) {
            }

        });
        circulo.addMouseMotionListener(new MouseMotionListener() {

            @Override
            public void mouseDragged(MouseEvent e) {
                int deltaX = e.getXOnScreen() - myX;
                int deltaY = e.getYOnScreen() - myY;
                int contenedorx1 = contenedor.getX();
                int contenedorx2 = contenedorx1 + contenedor.getWidth();
                int contenedory1 = contenedor.getY();
                int contenedory2 = contenedory1 + contenedor.getHeight();
                int x = myX + deltaX - 20;
                int y = myY + deltaY - 150;
                if (dentro == false) {
                    circulo.setLocation(x, y);
                }
                if ((y >= (contenedory1) && y <= (contenedory2 - circulo.getHeight()))
                        && x >= contenedorx1 + 575
                        && x <= contenedorx2 - circulo.getWidth() + 575) {
                    dentro = true;
                }
                invalidate();
                if (dentro == true && y >= contenedory1 && y <= contenedory2 - circulo.getHeight()
                        && x >= contenedorx1 + 575
                        && x <= contenedorx2 - circulo.getWidth() + 575) {
                    circulo.setLocation(x, y);
                }
                invalidate();
            }

            @Override
            public void mouseMoved(MouseEvent e) {
            }

        });

        circulo.setLocation(contenedor.getX(), contenedor.getY());

        add(panel3, BorderLayout.EAST);
        add(panel2, BorderLayout.CENTER);
        contenedor.addMouseListener(this);

        temporal = new ContenedorTemporal(200, 100);
        temporal.addMouseListener(this);

        panel2.add(circulo);
        panel2.add(temporal);

        panel3.add(contenedor);
        setVisible(true);
        addKeyListener(this);

        this.setFocusable(true);
    }


    @Override
    public void mouseClicked(MouseEvent e) {
        if (e.getSource().equals(boton)) {
            circulo.setBounds(0, 0, circulo.getAncho(), circulo.getAlto());
            dentro = false;
        }
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
    }

    @Override
    public void mouseExited(MouseEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyTyped'");
    }

    @Override
    public void keyPressed(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyPressed'");
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub
        throw new UnsupportedOperationException("Unimplemented method 'keyReleased'");
    }
}
