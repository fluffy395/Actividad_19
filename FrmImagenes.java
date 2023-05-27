package Hilos.Imagenes;

import javax.swing.*;
import java.awt.*;
public class FrmImagenes extends JFrame implements Runnable {
    Thread hilo1;

    public FrmImagenes() {
        initComponents();
        hilo1 = new Thread(this);
        hilo1.start();
    }

    public void run() {
        int contadorAdelante = 1;
        int contadorAtras = 6;
        ImageIcon picture1, picture2, picture3;
        while(true) {
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            //Hacer cambio de imagen
            try {
                String nombreImagen1 = "p" + contadorAdelante + ".jpg";
                String nombreImagen2 = "p" + contadorAtras + ".jpg";
                String nombreImagen3 = "p" + (contadorAtras - 2) + ".jpg";
                picture1 = new ImageIcon(getClass().getResource(nombreImagen1));
                picture2 = new ImageIcon(getClass().getResource(nombreImagen2));
                picture3 = new ImageIcon(getClass().getResource(nombreImagen3));
                imagen1.setIcon(picture1);
                imagen2.setIcon(picture2);
                imagen3.setIcon(picture3);
            } catch (Exception e) {
                e.printStackTrace();
            }
            contadorAdelante++;
            if (contadorAdelante > 6) {
                contadorAdelante = 1;
            }
            contadorAtras--;
            if (contadorAtras < 1 ) {
                contadorAtras = 6;
            }
        }
    }
    public void initComponents() {
        imagen1 = new JLabel();
        imagen2 = new JLabel();
        imagen3 = new JLabel();
        lblTitulo = new JLabel();

        getContentPane().setBackground(Color.black);
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setSize(1200, 800);
        setLocationRelativeTo(null);
        setLayout(new GridLayout(2, 1, 10, 10));

        lblTitulo.setFont(new Font("Dialog", 0, 48));
        lblTitulo.setText("PELICULA");
        lblTitulo.setForeground(Color.WHITE);
        lblTitulo.setPreferredSize(new Dimension(500, 500));
        lblTitulo.setHorizontalAlignment(SwingConstants.CENTER);
        add(lblTitulo);

        panelImagenes = new JPanel();
        panelImagenes.setBackground(Color.black);
        panelImagenes.setLayout(new GridLayout(1,3,10,10));
        add(panelImagenes);

        imagen1.setSize(500,500);
        imagen2.setSize(500,500);
        imagen3.setSize(500, 500);
        panelImagenes.add(imagen1);
        panelImagenes.add(imagen2);
        panelImagenes.add(imagen3);
    }

    public static void main(String[] args) {
        new FrmImagenes().setVisible(true);
    }
    private JLabel lblTitulo;
    private  JLabel imagen1;
    private  JLabel imagen2;
    private JLabel imagen3;
    JPanel panelImagenes;
}