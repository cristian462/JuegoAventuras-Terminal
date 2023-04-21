/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoProg;

/**
 *
 * @author Cristian Porras
 */
public abstract class Habitacion {

    protected final Objeto objeto;

    public Habitacion() {
        this.objeto = new Objeto();
    }

    public abstract Objeto getObjeto();

    public abstract int enfrentar(int ataque);

}
