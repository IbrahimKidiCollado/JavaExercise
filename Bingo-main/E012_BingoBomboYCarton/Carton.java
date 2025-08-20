package E012_BingoBomboYCarton;

import java.util.Random;

public class Carton {
    // Variables
    private final int[] numerosCarton;
    private final boolean[] marcas;
    private final static Random rand = new Random();

    //Constructors
    Carton(int numerosCarton) {
        this.numerosCarton = new int[numerosCarton];
        this.marcas = new boolean[numerosCarton];
        rellenarCarton();
    }

    //Getters and Setters


    //Methods


    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();

        builder.append("Carton: ");

        for (int j : numerosCarton) builder.append(j == 0 ? "X\t" : j + "\t");

        return builder.toString();
    }

    private void rellenarCarton() {
        int numero;
        boolean esta;

        for (int i = 0; i < numerosCarton.length; i++) {
            do {
                numero = rand.nextInt(1, Bombo.getBombo() + 1); // Genera un número aleatorio en el rango del bombo
                esta = false;

                // Verifica si el número ya está en el cartón
                for (int j = 0; j < i; j++) {
                    if (numerosCarton[j] == numero) {
                        esta = true; // Marca como duplicado
                        break;
                    }
                }
            } while (esta); // Repite hasta que se genere un número único

            // Agrega el número al cartón
            numerosCarton[i] = numero;
        }
    }


    public void comprobarCarton(int bola) {
        for (int i = 0; i < numerosCarton.length; i++) {
            if (numerosCarton[i] == bola) {
                marcas[i] = true;
                numerosCarton[i] = 0;
            }
        }
    }

    public void hayBingo() {
        int victoria = 0;

        for (boolean marca : marcas) if (marca) victoria++;

        if (victoria == marcas.length) {
            System.out.println("Bingo!!");
            System.exit(0);
        }

    }


}
