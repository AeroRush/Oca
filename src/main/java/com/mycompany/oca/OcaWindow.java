/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.oca;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.GridLayout;
import java.awt.HeadlessException;
import java.awt.Image;
import java.awt.Point;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.*;
import javax.swing.border.Border;

public class OcaWindow extends JFrame implements ActionListener {

    Tablero panelTablero;
    boolean partidaTerminada = false;

    Ficha ficha1 = new Ficha(1, 1);
    JButton tirar;
    Image icon;
    

    public OcaWindow(String title) {
        super(title);
        icon = new ImageIcon(OcaWindow.class.getResource("/Imagenes/icon.png")).getImage();
        setIconImage(icon);
        panelTablero = new Tablero();
        tirar = new JButton("Tirar");
        tirar.addActionListener(this);
        add(tirar, BorderLayout.SOUTH);
        add(panelTablero, BorderLayout.CENTER);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(new Dimension(1000, 1000));
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);

    }

    @Override
    public void actionPerformed(ActionEvent e) {

        Object objeto = e.getSource();

        if (objeto == tirar) {
            panelTablero.nuevoTurno();
            tirar.setEnabled(false);
            panelTablero.nuevoTurno();
            panelTablero.nuevoTurno();
            panelTablero.nuevoTurno();
            tirar.setEnabled(true);
            if (panelTablero.getJugadorActual() == 0) {
                panelTablero.setJugadorActual(1);
            }

        }
    }

}
