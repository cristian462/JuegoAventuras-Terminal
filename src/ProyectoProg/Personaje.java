/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoProg;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Cristian Porras
 */
public class Personaje {

    private int vida;
    private int ataque;
    private final Map objetos = new HashMap();

    public Personaje() {
        this.vida = 10;
        this.ataque = 2;
    }

    public int getAtaque() {
        return ataque;
    }

    public int getVida() {
        return vida;
    }

    public void setVida(int vida) {
        this.vida = vida;
    }

    public void setAtaque(int ataque) {
        this.ataque = ataque;
    }

    public void recogerObjetos(Objeto o) {
        objetos.put(o.getNombre(), o);
        if (o.getNombre() == TipoObjeto.arma) {
            ataque += 2;
        } else if (o.getNombre() == TipoObjeto.armadura) {
            vida += 4;
        }
    }

    public void usarPocion() {
        int apoyo;
        Random rd = new Random();
        Scanner sc = new Scanner(System.in);
        
            if (objetos.containsKey(TipoObjeto.pocion)) {
                System.out.println("Selecciona una opcion:");
                System.out.println("1. Recuperacion de vida");
                System.out.println("2. Aumento de ataque");
                if (sc.nextInt() == 1) {
                    apoyo=rd.nextInt(5);
                    System.out.println("Enhorabuena, te has curado "+apoyo+" puntos de vida");
                    vida += apoyo;
                    if (vida > 10){
                        vida=10;
                    }
                    objetos.remove(TipoObjeto.pocion);
                } else {
                    apoyo=rd.nextInt(2);
                    System.out.println("Enhorabuena, tu daño aumenta en "+apoyo+" puntos");
                    ataque += apoyo;
                    objetos.remove(TipoObjeto.pocion);
                }
            } else {
                System.out.println("No tienes pociones");
            }
        
    }

    public void recibirDaño(int daño) {
        vida -= daño;
    }

    @Override
    public String toString() {
        String cadena = "Vida: " + vida + "\t\tAtaque: " + ataque + "\nObjetos: ";
        cadena += objetos;
        return cadena;
    }
}
