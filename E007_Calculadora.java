import java.util.Scanner;

public class E007_Calculadora {
    public static void main(String[] args) {
        try (Scanner sc = new Scanner(System.in)) {
            String operacion;
            double num1;
            double num2;
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
                
                switch (op) {
                    case '+' -> resultado = num1 + num2;
                    case '-' -> resultado = num1 - num2;
                    case '*' -> resultado = num1 * num2;
                    case '/' -> resultado = num1 / num2;
                    default -> {
                    }
                }
                System.out.println("El resultado es: " + resultado);
            }
        }
    }
}

