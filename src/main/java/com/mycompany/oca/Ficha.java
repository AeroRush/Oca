/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.oca;

import java.awt.Color;
import java.awt.Graphics;
import javax.swing.BorderFactory;
import javax.swing.JLabel;

/**
 *
 * @author Ezequiel
 */
public class Ficha extends JLabel {

    private int casillaActual;
    private int jugador;
    private int turnosEspera = 0;

    public Ficha(int Jugador, int casillaActual) {
        this.casillaActual = casillaActual;
        this.jugador = Jugador;
    }

    public int getCasillaActual() {
        return casillaActual;
    }

    public void setCasillaActual(int casillaActual) {
        this.casillaActual = casillaActual;
    }

    public int getJugador() {
        return jugador;
    }

    public int getTurnosEspera() {
        return turnosEspera;
    }

    public void setTurnosEspera(int turnosEspera) {
        this.turnosEspera = turnosEspera;
    }

    @Override
    protected void paintComponent(Graphics g) {
        int w = this.getWidth(), h = this.getHeight();
        Color green = new Color(124, 252, 0);
        Color orange = new Color(255, 140, 0);

        switch (jugador) {
            case 1 -> {
                g.setColor(Color.red);
                g.fillOval(0, 0, w / 2, h / 2);

            }
            case 2 -> {
                g.setColor(orange);
                g.fillOval(0, h / 2, w / 2, h / 2);

            }
            case 3 -> {
                g.setColor(Color.blue);
                g.fillOval(w / 2, 0, w / 2, h / 2);
            }
            case 4 -> {
                g.setColor(green);
                g.fillOval(w / 2, h / 2, w / 2, h / 2);
            }
        }
        g.setColor(Color.black);
        super.paintComponent(g);
    }

}
