/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoProg;

/**
 *
 * @author Cristian Porras
 */
public class HabitacionFinal extends HabitacionEnemigo {

    public HabitacionFinal() {
        super.ataquenemigo = 5;
        super.vidaenemigo = 15;
    }

    @Override
    public int getVidaenemigo() {
        return vidaenemigo;
    }

    @Override
    public int getAtaquenemigo() {
        return ataquenemigo;
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
