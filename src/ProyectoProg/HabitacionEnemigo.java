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
public class HabitacionEnemigo extends Habitacion {

    protected int vidaenemigo;
    protected int ataquenemigo;
    private final Random rd = new Random();

    public HabitacionEnemigo() {
        this.vidaenemigo = rd.nextInt(4) + 1;
        this.ataquenemigo = rd.nextInt(2) + 1;
    }

    public int getVidaenemigo() {
        return vidaenemigo;
    }

    public int getAtaquenemigo() {
        return ataquenemigo;
    }

    public boolean recogerObjeto() {
        return rd.nextInt(1) == 0;
    }

    @Override
    public Objeto getObjeto() {
        System.out.println("Encontraste " + super.objeto.getNombre() + "!");
        return super.objeto;
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
}
