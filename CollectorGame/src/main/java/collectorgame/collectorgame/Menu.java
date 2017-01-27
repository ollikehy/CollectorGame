package collectorgame.collectorgame;

import java.util.*;

public class Menu {

    public Scanner scanner;

    public void start() {
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Pelaa \n" + "Tulokset \n" + "Lopeta?");
            System.out.print(">");
            String vastaus = scanner.nextLine();
            if (vastaus.toLowerCase().equals("pelaa")) {
                gameOn();
                System.out.println("");
            } else if (vastaus.toLowerCase().equals("tulokset")) {
                score();
                System.out.println("");
            } else if (vastaus.toLowerCase().equals("lopeta")) {
                System.out.println("Moikka pitää mennä");
                break;
            } else {
                System.out.println("Komentoa ei tunnistettu, yritä uudelleen");
                System.out.println("");
            }
        }
    }

    public void gameOn() {
        CollectorGame peli = new CollectorGame(scanner);
        peli.start();
    }

    public static void score() {
        //tee jotain
    }

}
