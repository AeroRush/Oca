/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.oca;

import javax.swing.JLabel;

/**
 *
 * @author Ezequiel
 */
public class Casilla extends JLabel {

    private boolean esCasillaSalida;
    private boolean esCasillaOca;
    private boolean esCasillaPuente;
    private boolean esCasillaDado;
    private boolean esCasillaMala;
    private boolean esLaberinto;
    private boolean esMuerte;
    private boolean esMeta;
    private int numeroTurnosEspera;
    private int numeroCasilla;
    private int siguienteOcaEn;

    public Casilla(int numeroCasilla, String text) {
        super(text);
        this.numeroCasilla = numeroCasilla;
    }

    public int getNumeroCasilla() {
        return numeroCasilla;
    }

    public void setEsCasillaSalida(boolean esCasillaSalida) {
        this.esCasillaSalida = esCasillaSalida;
    }

    public void setEsCasillaOca(boolean esCasillaOca) {
        this.esCasillaOca = esCasillaOca;
    }

    public void setEsCasillaPuente(boolean esCasillaPuente) {
        this.esCasillaPuente = esCasillaPuente;
    }

    public void setEsCasillaDado(boolean esCasillaDado) {
        this.esCasillaDado = esCasillaDado;
    }

    public void setEsCasillaMala(boolean esCasillaMala) {
        this.esCasillaMala = esCasillaMala;
    }

    public void setEsLaberinto(boolean esLaberinto) {
        this.esLaberinto = esLaberinto;
    }

    public void setEsMuerte(boolean esMuerte) {
        this.esMuerte = esMuerte;
    }

    public boolean esCasillaSalida() {
        return esCasillaSalida;
    }

    public boolean esCasillaOca() {
        return esCasillaOca;
    }

    public boolean esCasillaPuente() {
        return esCasillaPuente;
    }

    public boolean esCasillaDado() {
        return esCasillaDado;
    }

    public boolean esCasillaMala() {
        return esCasillaMala;
    }

    public boolean esLaberinto() {
        return esLaberinto;
    }

    public boolean esMuerte() {
        return esMuerte;
    }

    public int getNumeroTurnosEspera() {
        return numeroTurnosEspera;
    }

    public int getSiguienteOcaEn() {
        return siguienteOcaEn;
    }

    public void setSiguienteOcaEn(int siguienteOcaEn) {
        this.siguienteOcaEn = siguienteOcaEn;
    }

    public void setNumeroTurnosEspera(int numeroTurnosEspera) {
        this.numeroTurnosEspera = numeroTurnosEspera;
    }

    public boolean isEsMeta() {
        return esMeta;
    }

    public void setEsMeta(boolean esMeta) {
        this.esMeta = esMeta;
    }

    @Override
    public String toString() {
        return "Casilla{" + "numeroCasilla=" + numeroCasilla + '}';
    }

}
