/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package vectores_logicos_juan_armijos;

/**
 *
 * @author juanc
 */
public class Vectores_Logicos_Juan_Armijos {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //valores
        int pr1[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        int pr2[][] = {{0, 0, 0}, {0, 0, 0}};
        int pr3[][] = {{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};

        //Procesos
        String p1[] = {"a", "b", "c"};
        String p2[] = {"d", "e","f"};
        String p3[] = {"g", "h", "i"};

        //val iniciales
        int pp1 = 0;
        int pp2 = 0;
        int pp3 = 0;

        /*
        a, h
        b, d
        f, c
        e, g
         */
        // iniciar a, b, f
        if (pp1 == 0 && pr1[0][0] == 0) {
            pr1[0][0] = 1;
        }

        if (pp3 == 0 && pr3[0][2] == 0) {
            pr3[0][2] = 1;
        }

        if (pr1[0][0] != 0) {
            pr1[1][0] = pr1[0][0] + 1;
        }


        System.out.print("Proceso Uno: ");
        for (int j = 0; j < 3; j++) {
            System.out.print(p1[j]);
            for (int i = 0; i < p1.length; i++) {
                System.out.print(pr1[j][i]);
            }
        }
        
        System.out.println("");

    }

}
