package projekt;

import java.util.Scanner;

public class Peaklass {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Buss b1 = new Buss(5, 12);

        System.out.println("\nTeretulemast piletiostu keskkonda!\n");
        System.out.println("Ostes v�hemalt 4 piletit on teil v�imalus saada �ks pilet tasuta!");
        System.out.println("Mida rohkem pileteid ostate seda suurem on v�idu v�imalus.");

        while (b1.vabad_kohad() != 0) {
            // Kuni on vabu kohti saab neid ka osta.
            System.out.println("\n" + "\u001B[36mJ�rgmine ostja\u001B[0m");
            b1.bussiplaan();
            System.out.println("Mitu piletit soovite?");
            int arv = Integer.parseInt(sc.nextLine());  // Kasutajalt k�sitakse kohtade arv, mida ta soovib osta
            M��gis�steem.m��(b1, arv);                  // Ostjale m��jakse bussis b1 vastav arv kohti
        }

        System.out.println("\n\u001B[36mRohkem vabu kohti ei ole!\u001B[0m\n");
        // Kui k�ik kohad on m��dud, v�ljastatakse reisi andmed
        System.out.println("Bussireisi tulu: " + b1.tulu() + " eurot");
        System.out.println("Reisijad:");
        for (Piletiostja reisija: b1.getReisijad()) {
            System.out.println("    " + reisija);
        }
    }
}
