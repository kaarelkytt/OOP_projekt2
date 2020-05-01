package projekt;

import java.util.ArrayList;

public class Müügisüsteem {
    public static void müü(Buss buss, String nimi, String email, ArrayList<Integer> kohad){
        // Müüakse antud bussist kindlad kohad ostjale
        Piletiostja ostja = new Piletiostja(nimi, email);
        ostja.osta(kohad.size(), buss);
        buss.ost(kohad, ostja);
    }
}
