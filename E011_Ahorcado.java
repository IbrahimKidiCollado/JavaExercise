import java.util.Scanner;

public class E011_Ahorcado {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        char intento;
        String palabraSecreta;
        int numFallos = 0;
        String palabraOculta = "";
        boolean acierto = false;

        System.out.println("Esto es el juego del ahorcado");
        System.out.println("---Jugador 1---");
        System.out.print("Dime una palabra: ");
        palabraSecreta = teclado.nextLine();

        char[] palabraSecretaArray = new char[palabraSecreta.length()];
        boolean[] aciertos = new boolean[palabraSecreta.length()];

        for (int i = 0; i < palabraSecreta.length(); i++) {
            palabraSecretaArray[i] = palabraSecreta.toLowerCase().charAt(i);
            palabraOculta += "*";
        }

        do {
            System.out.println("---Jugador 2---");
            System.out.print("Dime una letra: ");
            intento = teclado.next().charAt(0);

            for (int i = 0; i < palabraSecretaArray.length; i++) {
                if (intento == palabraSecretaArray[i]) {
                     aciertos[i] = true;
                     acierto = true;
                }
            }

            if (!acierto) numFallos++;
            acierto = false;

            System.out.println(" ____");
            switch (numFallos) {
                case 0 -> {
                    System.out.println(" |");
                    System.out.println(" |");
                    System.out.println(" |");
                }
                case 1 -> {
                    System.out.println(" |  0");
                    System.out.println(" |");
                    System.out.println(" |");
                }
                case 2 -> {
                    System.out.println(" |  0");
                    System.out.println(" |  |");
                    System.out.println(" |");
                }
                case 3 -> {
                    System.out.println(" |  0");
                    System.out.println(" | -|");
                    System.out.println(" |");
                }
                case 4 -> {
                    System.out.println(" |  0");
                    System.out.println(" | -|-");
                    System.out.println(" |");
                }
                case 5 -> {
                    System.out.println(" |  0");
                    System.out.println(" | -|-");
                    System.out.println(" | /");
                }
                case 6 -> {
                    System.out.println(" |  0");
                    System.out.println(" | -|-");
                    System.out.println(" | / \\ ");
                }
            }
            System.out.println("_|_");
            System.out.println();

            for (int i = 0; i < palabraSecretaArray.length; i++) {
                if (aciertos[i]) {
                    palabraOculta =   palabraOculta.substring(0, i)
                                    + palabraSecretaArray[i]
                                    + palabraOculta.substring(i + 1);
                }
            }
            System.out.println(palabraOculta);

            if (numFallos == 6) {
                System.out.println("Jugador 1 Gana!!");
                break;
            }

            if (palabraOculta.equals(palabraSecreta)) {
                System.out.println("Jugador 2 Gana!!");
                break;
            }
        } while(true);
    }
}
