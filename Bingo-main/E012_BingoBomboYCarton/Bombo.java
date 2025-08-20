package E012_BingoBomboYCarton;

import java.util.*;

public class Bombo {
    // Variables
    public static int[] bombo;
    private static int[] bolasUsadas;
    private final static Random rand = new Random();
    private static int bolasBombo;
    private static int usadas;


    //Contructors

    Bombo(int cantidadBolas) {
        bombo = new int[cantidadBolas];
        for (int i = 0; i < bombo.length; i++) bombo[i] = i + 1;
        bolasUsadas = new int[cantidadBolas];
    }

    //Getters and Setters

    public static int getBombo() {
        return bombo.length;
    }

    //Methods

    @Override
    public String toString() {
        return "A bombo le quedan " + Bombo.bolasBombo + " bolas y han salido " + Bombo.usadas + " bolas.";
    }

    public static int dameBola() {
        int bola;

        do {
            bola = rand.nextInt(1, bombo.length + 1);
        } while (!comprobarBola(bola));

        for (int i = 0; i < bombo.length; i++) {
            if (bombo[i] == bola) {
                bombo[i] = 0;
                bolasUsadas[i] = bola;
            }
        }
        cuantasBolasDentroBombo();
        bolasUsadas();
        return bola;
    }

    private static void cuantasBolasDentroBombo() {
        int bolaBombo = 0;

        for (int j : bombo) if (j != 0) bolaBombo++;
        Bombo.bolasBombo = bolaBombo;
    }

    private static void bolasUsadas() {
        int usadas = 0;

        for (int bolasUsada : bolasUsadas) if (bolasUsada != 0) usadas++;

        Bombo.usadas = usadas;
    }

    public static void terminar() {
        if (usadas == 10) {
            System.out.println("No quedan mas bolas.");
            System.exit(0);
        }
    }

    private static boolean comprobarBola(int bola) {
        boolean comprobar = true;
        for (int value : bolasUsadas) {
            if (value == bola) {
                comprobar = false;
            }
        }
        return comprobar;
    }
}
