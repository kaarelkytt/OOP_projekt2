package projekt;

import java.util.ArrayList;

public class M��gis�steem {
    public static void m��(Buss buss, String nimi, String email, ArrayList<Integer> kohad){
        // M��akse antud bussist kindlad kohad ostjale
        Piletiostja ostja = new Piletiostja(nimi, email);
        ostja.osta(kohad.size(), buss);
        buss.ost(kohad, ostja);
    }
}
