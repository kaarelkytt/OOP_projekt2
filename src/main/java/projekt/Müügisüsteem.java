package projekt;

import java.util.List;
import java.util.Scanner;

public class Müügisüsteem {
    public static void müü(Buss buss, int kohtadeArv){
        // Müüakse antud bussist kindel arv kohti piletiostjale ning
        // väljastatakse ostu informatsioon (kohad, hind).
        // Kui bussis pole piisavalt kohti, väljastatakse vastav teade
        // ja müügitehing jääb katki.
        if (buss.piisavalt_kohti(kohtadeArv)){
            Piletiostja ostja = uusOstja();
            ostja.osta(kohtadeArv, buss);
            buss.lisaReisija(ostja);
            List<Integer> kohad = ostja.getKohad();

            /*
            if (kohtadeArv == 1)
                System.out.print(ostja.getNimi() + ", teie koht on kinnitatud. Koha number on: ");
            else
                System.out.print(ostja.getNimi() + ", teie kohad on kinnitatud. Kohtade numbrid on: ");

             */

            for (int koht: kohad)
                System.out.print(koht + " ");
            if (ostja.isVõit())
                System.out.printf("\nTasuda tuleb: %.2f \u001B[31m- %.2f\u001B[0m = %.2f eurot\n",
                        ostja.getSumma()+buss.getPiletiHind(), buss.getPiletiHind(), ostja.getSumma());
            else
                System.out.printf("\nTasuda tuleb: %.2f eurot\n", ostja.getSumma());
            System.out.println("Arve on saadetud emailile: " + ostja.getEmail());
        }
        else
            System.out.println("Pole piisavalt vabu kohti");
    }

    public static Piletiostja uusOstja(){
        // Loob uue ostja vastavalt kliendilt saadud andmetele (nimi ja email)
        Scanner sc = new Scanner(System.in);

        System.out.print("Sisestage oma nimi: ");
        String nimi = sc.nextLine();
        System.out.print("Sisestage oma email'i aadress: ");
        String email = sc.nextLine();

        Piletiostja ostja = new Piletiostja(nimi, email);
        return ostja;
    }
}
