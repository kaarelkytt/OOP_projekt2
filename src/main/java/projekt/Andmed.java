package projekt;

import java.io.*;
import java.util.ArrayList;
import java.util.List;

public class Andmed {
    public static ArrayList<Buss> failist(String tee) throws IOException {
        File fail = new File(tee);
        ArrayList<Buss> bussid = new ArrayList<>();

        try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(fail), StandardCharsets.UTF_8))) {
            String rida = br.readLine();
            String[] andmed = rida.split(",");
            Buss buss = new Buss(Integer.parseInt(andmed[1]), Double.parseDouble(andmed[2]), andmed[3]);

            while (rida != null) {

                andmed = rida.split(",");
                if (andmed[0].equals("buss")) {
                    buss = new Buss(Integer.parseInt(andmed[1]), Double.parseDouble(andmed[2]), andmed[3]);
                    bussid.add(buss);
                } else {
                    List<Integer> kohad = new ArrayList<>();
                    String[] kk = andmed[3].split(";");
                    for (String k : kk) {
                        int koht = Integer.parseInt(k);
                        kohad.add(koht);
                        buss.koht_kinni(koht);
                    }
                    Piletiostja ostja = new Piletiostja(andmed[1], andmed[2], kohad, Double.parseDouble(andmed[4]), Boolean.parseBoolean(andmed[5]));
                    buss.lisaReisija(ostja);
                }
                rida = br.readLine();
            }
        }

        return bussid;
    }

    public static void salvesta(String tee, ArrayList<Buss> bussid) throws IOException {
        File fail = new File(tee);

        try (BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(fail)))) {
            for (Buss buss : bussid) {
                bw.write("buss," + buss.getRidade_arv() + "," + buss.getPiletiHind() + "," + buss.getLiin() + "\n");
                List<Piletiostja> reisijad = buss.getReisijad();
                for (Piletiostja reisija : reisijad) {
                    List<Integer> k = reisija.getKohad();
                    StringBuilder kohad = new StringBuilder();
                    for (int koht : k) {
                        kohad.append(koht).append(";");
                    }
                    kohad.deleteCharAt(kohad.lastIndexOf(";"));

                    bw.write("reisija," + reisija.getNimi() + "," + reisija.getEmail() + "," + kohad.toString() + "," + reisija.getSumma() + "," + reisija.isVõit() + "\n");
                }
            }
        }
    }
}
