/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package lamport_juan_armijos;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author juanc
 */
public class Lamport_Juan_Armijos {

    private static final int N = 10;
    private volatile static int numeros[] = new int[N]; // inicializa a 0
    private volatile static boolean eligiendoNum[] = new boolean[N]; // inicializa a falso

    public static Thread crearHilo(final int i) {
        Thread th1 = new Thread(new Runnable() {

            @Override
            public void run() {

                // calcular el numero de turno
                eligiendoNum[i] = true;
                numeros[i] = 1 + maximo(numeros);
                eligiendoNum[i] = false;
                //comparar el turno con todos los hilos
                for (int j = 0; j < N; j++) {
                    while (eligiendoNum[j]); // se espera a que haya elegido

                    while ((numeros[j] != 0) && ((numeros[j] < numeros[i]) || ((numeros[j] == numeros[i]) && (j < i))));
                    /* Se espera si:
					 * -el numero es mayor que el nuestro (i)
					 * -el numero es igual al nuestro pero nuestro indice (i) es mayor
					 *  * la primera parte es para evitarle consultar todo esto si ya es igual a 0
                     */
                }// fin for
                // SECCIÓN CRÍTICA
                System.out.println("(" + i + ")SC 1 ");
                System.out.println("(" + i + ")SC 2 ");
                System.out.println("(" + i + ")SC 3 ");

                //SECCIÓN NO CRÍTICA
                numeros[i] = 0;
                System.out.println("(" + i + ")No SC 1 ");
                System.out.println("(" + i + ")No SC 2 ");

            }
        }, "Hilo" + i);
        return th1;
    }
    // Fin Thread

    public static int maximo(int[] numeros) { // Calcular maximo
        int maxi = 0;
        for (int i = 0; i < numeros.length; i++) {
            maxi += numeros[i];
        }
        return maxi;

    }

    public static void main(String[] args) {
        System.out.println("Algoritmo de Lamport");
        List<Thread> lista = new ArrayList<Thread>(); // list es una interfaz mas generica que la clase ArrayList
        for (int i = 0; i < N; i++) {
            Thread th = crearHilo(i);
            lista.add(th);
        }

        for (int i = 0; i < N; i++) {
            Thread th = lista.get(i);
            th.start();

        }

    }

}