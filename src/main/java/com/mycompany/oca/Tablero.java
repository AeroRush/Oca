/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.oca;

import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.font.TextAttribute;
import static java.lang.Thread.sleep;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.BorderFactory;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;

public class Tablero extends JPanel {

    private Casilla[][] tablero = new Casilla[10][10];
    private int[][] numerosCasilla =    {{27, 26, 25, 24, 23, 22, 21, 20, 19, 18},
                                        {28, 57, 56, 55, 54, 53, 52, 51, 50, 17},
                                        {29, 58, 63, 63, 63, 63, 63, 63, 49, 16},
                                        {30, 59, 63, 63, 63, 63, 63, 63, 48, 15},
                                        {31, 60, 63, 63, 63, 63, 63, 63, 47, 14},
                                        {32, 61, 63, 63, 63, 63, 63, 63, 46, 13},
                                        {33, 62, 63, 63, 63, 63, 63, 63, 45, 12},
                                        {34, 63, 63, 63, 63, 63, 63, 63, 44, 11},
                                        {35, 36, 37, 38, 39, 40, 41, 42, 43, 10},
                                        {0, 1, 2, 3, 4, 5, 6, 7, 8, 9}};

    Ficha fichaActual = new Ficha(0, 1);
    Ficha ficha1 = new Ficha(1, 1);
    Ficha ficha2 = new Ficha(2, 1);
    Ficha ficha3 = new Ficha(3, 1);
    Ficha ficha4 = new Ficha(4, 1);
    Ficha[] fichas = new Ficha[4];
    Border borde = BorderFactory.createLineBorder(Color.black);
    private int jugadorActual = 1;
    private int casillaActual = 1;
    private int nuevaCasilla;
    private int n;
    private int ocaNumCasillasActual;
    private boolean partidaTerminada;
    Color waterblue = new Color(0, 117, 119);
    Color brown = new Color(128, 64, 0);
    Color purple = new Color(48, 25, 52);
    Color darkgreen = new Color(45, 87, 44);
    Color darkorange = new Color(255, 189, 12);
    Color oca = new Color(255, 237, 81);

    public Tablero() {
        fichas[0] = ficha1;
        fichas[1] = ficha2;
        fichas[2] = ficha3;
        fichas[3] = ficha4;

        setLayout(new GridLayout(10, 10));
        for (int k = 0; k < numerosCasilla.length; k++) {
            for (int l = 0; l < numerosCasilla[0].length; l++) {
                tablero[k][l] = new Casilla(numerosCasilla[k][l], numerosCasilla[k][l] + "");
                tablero[k][l].setBorder(borde);
                tablero[k][l].setFont(new Font("Alef", Font.BOLD, 15));
                add(tablero[k][l]);

                switch (tablero[k][l].getNumeroCasilla()) {
                    case 0 -> {
                        tablero[k][l].setBackground(darkorange);
                        tablero[k][l].setBorder(BorderFactory.createMatteBorder(1, 1, 1, 0, Color.black));

                        tablero[k][l].setOpaque(true);
                        tablero[k][l].setText("");
                    }

                    case 1 -> {
                        tablero[k][l].setBackground(darkorange);
                        tablero[k][l].setBorder(BorderFactory.createMatteBorder(1, 0, 1, 1, Color.black));
                        tablero[k][l].setOpaque(true);
                    }
                    case 9,18,27,36,45,54 -> {
                        tablero[k][l].setText(tablero[k][l].getText() + " Oca");
                        tablero[k][l].setBackground(Color.yellow);
                        tablero[k][l].setEsCasillaOca(true);
                        tablero[k][l].setOpaque(true);
                        tablero[k][l].setSiguienteOcaEn(5);
                    }

                    case 5,14,23,32,41,50,59 -> {
                        tablero[k][l].setText(tablero[k][l].getText() + " Oca");
                        tablero[k][l].setBackground(Color.yellow);
                        tablero[k][l].setEsCasillaOca(true);
                        tablero[k][l].setOpaque(true);
                        tablero[k][l].setSiguienteOcaEn(4);
                    }

                    case 42 -> {
                        tablero[k][l].setText(tablero[k][l].getText() + " Laberinto");
                        tablero[k][l].setBackground(darkgreen);
                        tablero[k][l].setOpaque(true);
                        tablero[k][l].setEsLaberinto(true);
                    }
                    case 6,12 -> {
                        tablero[k][l].setText(tablero[k][l].getText() + " Puente");
                        tablero[k][l].setBackground(waterblue);
                        tablero[k][l].setOpaque(true);
                        tablero[k][l].setEsCasillaPuente(true);
                    }

                    case 63 -> {
                        tablero[k][l].setBackground(Color.cyan);
                        tablero[k][l].setBorder(BorderFactory.createLineBorder(Color.cyan));
                        tablero[k][l].setText("");
                        tablero[k][l].setOpaque(true);
                        tablero[k][l].setEsMeta(true);
                    }
                    case 26,53 -> {
                        tablero[k][l].setText(tablero[k][l].getText() + " Dado");
                        tablero[k][l].setBackground(Color.pink);
                        tablero[k][l].setOpaque(true);
                        tablero[k][l].setEsCasillaDado(true);
                    }

                    case 19 -> {
                        tablero[k][l].setText(tablero[k][l].getText() + " Posada");
                        tablero[k][l].setBackground(Color.green);
                        tablero[k][l].setOpaque(true);
                        tablero[k][l].setEsCasillaMala(true);
                        tablero[k][l].setNumeroTurnosEspera(1);
                    }

                    case 31 -> {
                        tablero[k][l].setText(tablero[k][l].getText() + " Pozo");
                        tablero[k][l].setBackground(purple);
                        tablero[k][l].setOpaque(true);
                        tablero[k][l].setEsCasillaMala(true);
                        tablero[k][l].setNumeroTurnosEspera(2);
                    }

                    case 52 -> {
                        tablero[k][l].setText(tablero[k][l].getText() + " Cárcel");
                        tablero[k][l].setBackground(brown);
                        tablero[k][l].setOpaque(true);
                        tablero[k][l].setEsCasillaMala(true);
                        tablero[k][l].setNumeroTurnosEspera(3);
                    }

                    case 58 -> {
                        tablero[k][l].setText(tablero[k][l].getText() + " Muerte");
                        tablero[k][l].setBackground(Color.black);
                        tablero[k][l].setOpaque(true);
                        tablero[k][l].setEsMuerte(true);
                    }

                }
                for (int w = 0; w < numerosCasilla[0].length; w++) {
                    //System.out.println(tablero[k][l].getNumeroCasilla() + " " + ficha.getCasillaActual());
                    if (tablero[k][l].getNumeroCasilla() == 1) {
                        ficha1.setBounds(0, 0, 90, 90);
                        tablero[k][l].add(ficha1);
                        ficha2.setBounds(0, 0, 90, 90);
                        tablero[k][l].add(ficha2);
                        ficha3.setBounds(0, 0, 90, 90);
                        tablero[k][l].add(ficha3);
                        ficha4.setBounds(0, 0, 90, 90);
                        tablero[k][l].add(ficha4);

                        repaint();

                    }

                }
            }
        }

    }

    public int getJugadorActual() {
        return jugadorActual;
    }

    public void setJugadorActual(int jugadorActual) {
        this.jugadorActual = jugadorActual;
    }

    public void siguienteTurno() {
        if (jugadorActual == 4) {
            jugadorActual = 1;
        } else {
            jugadorActual++;

        }
    }

    public boolean isPartidaTerminada() {
        return partidaTerminada;
    }

    public void setPartidaTerminada(boolean partidaTerminada) {
        this.partidaTerminada = partidaTerminada;
    }

    public int getCasillaActual() {
        return casillaActual;
    }

    public void setCasillaActual(int casillaActual) {
        this.casillaActual = casillaActual;
    }

    private void actualizarCasilla(Ficha ficha, int casillaActual) {

        ficha.setCasillaActual(casillaActual);
        if (casillaActual > 63) {
            ficha.setCasillaActual(63);
        }
        for (int k = 0; k < numerosCasilla.length; k++) {
            for (int l = 0; l < numerosCasilla[0].length; l++) {
                if (tablero[k][l].getNumeroCasilla() == ficha.getCasillaActual()) {
                    ficha.setBounds(0, 0, 90, 90);
                    tablero[k][l].add(ficha);
                    repaint();
                    if (tablero[k][l].esCasillaOca()) {
                        ocaNumCasillasActual = tablero[k][l].getSiguienteOcaEn();
                        moverOca(ficha);
                        tirada(ficha);
                    }

                    if (tablero[k][l].esLaberinto()) {
                        moverLaberinto(ficha);
                        tirada(ficha);
                    }

                    if (tablero[k][l].esMuerte()) {
                        moverMuerte(ficha);
                    }

                    if (tablero[k][l].esCasillaDado()) {
                        moverDado(ficha);
                        tirada(ficha);
                    }

                    if (tablero[k][l].esCasillaPuente()) {
                        moverPuente(ficha);
                        tirada(ficha);
                    }

                    if (tablero[k][l].esCasillaMala() && ficha.getTurnosEspera() < 1) {
                        int turnos = tablero[k][l].getNumeroTurnosEspera();
                        casillaMalaColocar(ficha, turnos);

                    }

                    if (tablero[k][l].getNumeroCasilla() == 63) {
                        terminarPartida(ficha);
                    }

                }
            }
        }
    }

    private void moverOca(Ficha ficha) {
        nuevaCasilla = ficha.getCasillaActual() + ocaNumCasillasActual;
        ficha.setCasillaActual(nuevaCasilla);
        for (int k = 0; k < numerosCasilla.length; k++) {
            for (int l = 0; l < numerosCasilla[0].length; l++) {
                if (tablero[k][l].getNumeroCasilla() == ficha.getCasillaActual()) {
                    if (tablero[k][l].getNumeroCasilla() == 63) {
                        terminarPartida(ficha);
                    } else {
                        JOptionPane.showMessageDialog(null, "De oca a oca y tiro porque me toca.");
                        ficha.setBounds(0, 0, 90, 90);
                        tablero[k][l].add(ficha);
                        repaint();
                    }

                }
            }
        }
    }

    private void moverLaberinto(Ficha ficha) {
        for (int k = 0; k < numerosCasilla.length; k++) {
            for (int l = 0; l < numerosCasilla[0].length; l++) {
                if (tablero[k][l].getNumeroCasilla() == 5) {
                    ficha.setCasillaActual(5);
                    JOptionPane.showMessageDialog(null, "De laberinto a 5 y vuelvo a tirar.");
                    ficha.setBounds(0, 0, 90, 90);
                    tablero[k][l].add(ficha);
                    repaint();
                }
            }
        }
    }

    private void moverMuerte(Ficha ficha) {
        for (int k = 0; k < numerosCasilla.length; k++) {
            for (int l = 0; l < numerosCasilla[0].length; l++) {
                if (tablero[k][l].getNumeroCasilla() == 1) {
                    ficha.setCasillaActual(1);
                    JOptionPane.showMessageDialog(null, "Has Muerto, vuelves a la salida");
                    ficha.setBounds(0, 0, 90, 90);
                    tablero[k][l].add(ficha);
                    repaint();
                }
            }

        }
    }

    private void moverDado(Ficha ficha) {
        if (ficha.getCasillaActual() == 26) {
            for (int k = 0; k < numerosCasilla.length; k++) {
                for (int l = 0; l < numerosCasilla[0].length; l++) {

                    if (tablero[k][l].getNumeroCasilla() == 53) {
                        ficha.setCasillaActual(53);
                        JOptionPane.showMessageDialog(null, "De dado a dado y tiro porque me ha tocado");
                        ficha.setBounds(0, 0, 90, 90);
                        tablero[k][l].add(ficha);
                        repaint();
                    }
                }

            }
        } else if (ficha.getCasillaActual() == 53) {
            for (int k = 0; k < numerosCasilla.length; k++) {
                for (int l = 0; l < numerosCasilla[0].length; l++) {

                    if (tablero[k][l].getNumeroCasilla() == 26) {
                        ficha.setCasillaActual(26);
                        JOptionPane.showMessageDialog(null, "De dado a dado y tiro porque me ha tocado");
                        ficha.setBounds(0, 0, 90, 90);
                        tablero[k][l].add(ficha);
                        repaint();
                    }
                }
            }
        }

    }

    private void moverPuente(Ficha ficha) {
        if (ficha.getCasillaActual() == 6) {
            for (int k = 0; k < numerosCasilla.length; k++) {
                for (int l = 0; l < numerosCasilla[0].length; l++) {

                    if (tablero[k][l].getNumeroCasilla() == 12) {
                        ficha.setCasillaActual(12);
                        JOptionPane.showMessageDialog(null, "De puente a puente y tiro porque me lleva la corriente");
                        ficha.setBounds(0, 0, 90, 90);
                        tablero[k][l].add(ficha);
                        repaint();
                    }
                }

            }
        } else if (ficha.getCasillaActual() == 12) {
            for (int k = 0; k < numerosCasilla.length; k++) {
                for (int l = 0; l < numerosCasilla[0].length; l++) {

                    if (tablero[k][l].getNumeroCasilla() == 6) {
                        ficha.setCasillaActual(6);
                        JOptionPane.showMessageDialog(null, "De puente a puente y tiro porque me lleva la corriente");
                        ficha.setBounds(0, 0, 90, 90);
                        tablero[k][l].add(ficha);
                        repaint();
                    }
                }
            }
        }
    }

    private void casillaMalaColocar(Ficha ficha, int turnos) {
        ficha.setTurnosEspera(turnos);
        JOptionPane.showMessageDialog(null, "Al jugador " + ficha.getJugador() + " le toca esperar " + ficha.getTurnosEspera() + " turnos");
    }

    private void casillaMalaActualizar(Ficha ficha) {
        ficha.setTurnosEspera(ficha.getTurnosEspera() - 1);
        if (ficha.getTurnosEspera() == 0) {
            JOptionPane.showMessageDialog(null, "El jugador " + ficha4.getJugador() + " podrá tirar el siguiente turno");
        } else {
            JOptionPane.showMessageDialog(null, "Al jugador " + ficha.getJugador() + " le toca esperar " + ficha.getTurnosEspera() + " turnos");
        }

    }

    private void terminarPartida(Ficha ficha) {

        int resultado = JOptionPane.showConfirmDialog(null, "Ha ganado el jugador " + ficha.getJugador() + " ¿Quieres jugar otra partida?", "Salir", JOptionPane.YES_NO_OPTION,
                JOptionPane.QUESTION_MESSAGE);
        if (resultado == JOptionPane.YES_OPTION) {
            for (int k = 0; k < numerosCasilla.length; k++) {
                for (int l = 0; l < numerosCasilla[0].length; l++) {
                    if (tablero[k][l].getNumeroCasilla() == 1) {
                        ficha1.setCasillaActual(1);
                        ficha1.setTurnosEspera(0);
                        ficha1.setBounds(0, 0, 90, 90);
                        tablero[k][l].add(ficha1);
                        ficha2.setTurnosEspera(0);
                        ficha2.setCasillaActual(1);
                        ficha2.setBounds(0, 0, 90, 90);
                        tablero[k][l].add(ficha2);
                        ficha3.setTurnosEspera(0);
                        ficha3.setBounds(0, 0, 90, 90);
                        ficha3.setCasillaActual(1);
                        tablero[k][l].add(ficha3);
                        ficha4.setTurnosEspera(0);
                        ficha4.setCasillaActual(1);
                        ficha4.setBounds(0, 0, 90, 90);
                        tablero[k][l].add(ficha4);
                        repaint();
                        jugadorActual = 1;

                    }
                }
            }
        } else {
            System.exit(0);
        }
    }

    private void tirarDado(Ficha ficha) {
        n = (int) (Math.random() * (0 - 6)) + 6;
        nuevaCasilla = ficha.getCasillaActual();
        nuevaCasilla = nuevaCasilla + n;
        ficha.setCasillaActual(nuevaCasilla);
    }

    private void tirada(Ficha ficha) {
        tirarDado(ficha);
        JOptionPane.showMessageDialog(null, "El jugador " + ficha.getJugador() + " ha sacado un " + n);
        actualizarCasilla(ficha, nuevaCasilla);
    }

    public void nuevoTurno() {

        switch (jugadorActual) {
            case 0 -> {
                break;
            }

            case 1 -> {
                if (ficha1.getTurnosEspera() < 1) {
                    tirada(ficha1);
                } else {
                    casillaMalaActualizar(ficha1);

                }

            }
            case 2 -> {
                if (ficha2.getTurnosEspera() < 1) {
                    tirada(ficha2);
                } else {
                    casillaMalaActualizar(ficha2);
                }
            }
            case 3 -> {
                if (ficha3.getTurnosEspera() < 1) {
                    tirada(ficha3);
                } else {
                    casillaMalaActualizar(ficha3);

                }
            }
            case 4 -> {
                if (ficha4.getTurnosEspera() < 1) {
                    tirada(ficha4);
                } else {
                    casillaMalaActualizar(ficha4);
                }
            }
        }

        siguienteTurno();

    }

}
