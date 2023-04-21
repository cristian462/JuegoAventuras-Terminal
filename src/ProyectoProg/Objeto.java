/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoProg;

import java.util.Random;

/**
 *
 * @author Cristian Porras
 */
public class Objeto {

    private TipoObjeto nombre;
    private final int x;

    public Objeto() {
        Random rd = new Random();
        x = rd.nextInt(6);
        if (x < 2) {
            this.nombre = TipoObjeto.palo;
        } else if (x > 1 && x < 4) {
            this.nombre = TipoObjeto.pocion;
        } else if (x == 4) {
            this.nombre = TipoObjeto.arma;
        } else if (x < 7 && x > 4) {
            this.nombre = TipoObjeto.armadura;
        }
    }

    public TipoObjeto getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        if (nombre==TipoObjeto.palo){
            return " No hace nada";
        }
        if (nombre==TipoObjeto.arma){
            return " Aumenta Ataque";
        }
        if (nombre==TipoObjeto.armadura){
            return " Aumenta Vida";
        }
        if (nombre==TipoObjeto.pocion){
            return " Puedes curarte hasta 5 de vida o aumentar tu ataque hasta 2 putnos";
        }
        return "";
    }
}
