/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package ProyectoProg;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Random;
import java.util.Scanner;

/**
 *
 * @author Cristian Porras
 */
public class App {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        int bucle = 0;
        int menu;
        int contador = 0;
        Personaje personaje = new Personaje();
        Habitacion[] habitaciones;
        habitaciones = numeroHabitaciones();
        while (bucle == 0) {
            System.out.println("____________________________________");
            System.out.println("Personaje: \n" + personaje);
            System.out.println("____________________________________");
            System.out.println("Elije una opcion: ");
            System.out.println("1. Entrar en la habitacion");
            System.out.println("2. Utilizar pocion");
            System.out.println("3. Instrucciones");
            System.out.println("4. Salir");
            menu = sc.nextInt();
            switch (menu) {
                case 1:
                    if (habitaciones[contador].getClass() == HabitacionEnemigo.class) {
                        System.out.println("___________________________");
                        System.out.println("Es una habitacion con enemigo");
                        personaje.recibirDaño(habitaciones[contador].enfrentar(personaje.getAtaque()));
                        if (personaje.getVida() > 0) {
                            System.out.println("Recogiendo objeto...");
                            personaje.recogerObjetos(habitaciones[contador].getObjeto());
                            System.out.println("___________________________");
                        } else {
                            System.out.println("Perdiste :(");
                            bucle = 1;
                        }
                        contador++;
                    } else if (habitaciones[contador].getClass() == HabitacionSegura.class) {
                        System.out.println("__________________________________________________");
                        System.out.println("La habitacion parece vacia, hay un objeto:\n1. Recoger objeto\n2. Continuar sin recoger");
                        menu = sc.nextInt();
                        if (menu == 1) {
                            personaje.recogerObjetos(habitaciones[contador++].getObjeto());
                            System.out.println("__________________________________________________");
                            menu = rd.nextInt(2);
                            if (menu == 0) {
                                System.out.println("Ha aparecido un enemigo escondido!");
                                personaje.recibirDaño(habitaciones[contador++].enfrentar(personaje.getAtaque()));
                                if (personaje.getVida() <= 0) {
                                    System.out.println("Perdiste :(");
                                    bucle = 1;
                                }
                            }
                        }
                        contador++;
                    } else if (habitaciones[contador].getClass() == HabitacionFinal.class) {
                        System.out.println("___________________________");
                        System.out.println("Has entrado en la habitacion final");
                        personaje.recibirDaño(habitaciones[contador].enfrentar(personaje.getAtaque()));
                        if (personaje.getVida() > 0) {
                            System.out.println("Enhorabuena te has pasado el juego! :)");
                            System.out.println(personaje);
                            bucle = 1;
                        } else {
                            System.out.println("Perdiste :(");
                            bucle = 1;
                        }
                    }
                    break;
                case 2:
                    personaje.usarPocion();
                    break;
                case 3:
                    leer();
                    break;
                case 4:
                    bucle = 1;
            }
        }
    }

    public static Habitacion[] numeroHabitaciones() {
        Scanner sc = new Scanner(System.in);
        Random rd = new Random();
        int h;
        System.out.println("Cuantas habitaciones quieres que tenga la mazmorra?");
        h = sc.nextInt();
        Habitacion[] habitaciones = new Habitacion[h];
        for (int i = 0; i < h - 1; i++) {
            if (rd.nextInt(2) == 0) {
                habitaciones[i] = new HabitacionSegura();
            } else {
                habitaciones[i] = new HabitacionEnemigo();
            }
        }
        habitaciones[habitaciones.length - 1] = new HabitacionFinal();
        return habitaciones;
    }

    public static void leer() {
        String fichero = "instrucciones.txt";
        FileReader fr = null;
        try {
            fr = new FileReader(fichero);
            int caracter = fr.read();
            while (caracter != -1) {
                System.out.print((char) caracter);
                caracter = fr.read();
            }
        } catch (FileNotFoundException e) {
            System.out.println("Error: fichero no encontrado");
            System.out.println(e.getMessage());
        } catch (IOException e) {
            System.out.println("Errorn en la lectura del fichero");
            System.out.println(e.getMessage());
        } finally {
            try {
                if (fr != null) {
                    fr.close();
                }
            } catch (IOException e) {
                System.out.println("Error al cerrar el fichero");
                System.out.println(e.getMessage());
            }
        }
    }

}
