import java.util.Scanner;

public class Calculadora {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String operacion = null;
        double num1 = 0;
        double num2 = 0;
        char op;
        int posicion = 0;
        double resultado = 0;


        while (true) {
            System.out.print("Introduzca la operacion: ");
            operacion = sc.nextLine();
            if (operacion.equals("s")) {
                System.out.println("Saliendo..");
                break;
            }
            for (int i = 0; i < operacion.length(); i++) {
                if (operacion.charAt(i) == '+' || operacion.charAt(i) == '-' || operacion.charAt(i) == '*' || operacion.charAt(i) == '/') {
                    posicion = i;
                }
            }

            num1 = Double.parseDouble(operacion.substring(0, posicion));
            num2 = Double.parseDouble(operacion.substring(posicion + 1));
            op = operacion.charAt(posicion);

            if (op == '+') resultado = num1 + num2;
            else if (op == '-') resultado = num1 - num2;
            else if (op == '*') resultado = num1 * num2;
            else if (op == '/') resultado = num1 / num2;
            System.out.println("El resultado es: " + resultado);
        }
    }
}

