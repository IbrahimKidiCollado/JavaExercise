package E012_BingoBomboYCarton;

public class Main {
    public static void main(String[] args) {
        Bombo bombo = new Bombo(89);
        Carton carton1 = new Carton(8);
        Carton carton2 = new Carton(8);

        for (int i = 0; i < 89; i++) {
            int bola = Bombo.dameBola();
            System.out.println("Bola: " + bola);
            carton1.comprobarCarton(bola);
            carton2.comprobarCarton(bola);
            System.out.println(carton1);
            System.out.println(carton2);
            carton1.hayBingo();
            carton2.hayBingo();
            System.out.println(bombo);
        }
    }
}
