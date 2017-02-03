package collectorgame;

import java.util.*;

public class Menu {

    public Scanner scanner;

    public void start() {
        scanner = new Scanner(System.in);

        while (true) {
            System.out.println("Pelaa \n" + "Tulokset \n" + "Tulosta \n" + "Lopeta?");
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
            } else if (vastaus.toLowerCase().equals("tulosta")) {
                printMap();
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

    public void score() {
        //tulosta huipputulokset
    }
    
    public void printMap() {
        System.out.println("");
        CollectorGame peli = new CollectorGame(scanner);
        peli.printMap();
        System.out.println("\n Tässä on esimerkkikartta, oikeassa pelissä esineiden sijainnit ovat erilaiset \n"); 
    }

}
