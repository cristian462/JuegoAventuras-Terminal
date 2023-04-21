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
public class HabitacionSegura extends Habitacion {

    private int vidaenemigo = 5;
    private final int ataquenemigo = 3;
    Random rd = new Random();

    public HabitacionSegura() {

    }

    @Override
    public Objeto getObjeto() {
        System.out.println("Encontraste " + objeto.getNombre() + "!");
        return objeto;
    }

    @Override
    public int enfrentar(int ataque) {
        int daño = 0;
        while (vidaenemigo > 0) {
            vidaenemigo -= ataque;
            daño += ataquenemigo;
        }
        return daño;
    }

    public int fuente() {
        return rd.nextInt(5);
    }
}
