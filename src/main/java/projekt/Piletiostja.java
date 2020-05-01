package projekt;

import java.util.ArrayList;
import java.util.List;

public class Piletiostja {
    private String nimi;
    private String email;
    private List<Integer> kohad = new ArrayList<>();
    private double summa;
    private boolean v�it;

    public Piletiostja(String nimi, String email) {
        this.nimi = nimi;
        this.email = email;
    }

    public Piletiostja(String nimi, String email, List<Integer> kohad, double summa, boolean v�it) {
        this.nimi = nimi;
        this.email = email;
        this.kohad = kohad;
        this.summa = summa;
        this.v�it = v�it;
    }

    public List<Integer> getKohad() {
        return kohad;
    }

    public String getEmail() {
        return email;
    }

    public String getNimi() {
        return nimi;
    }

    public double getSumma() {
        return summa;
    }

    public boolean isV�it() {
        return v�it;
    }

    @Override
    public String toString() {
        return "Piletiostja(" +
                "nimi: " + nimi +
                ", email: " + email +
                ", kohad: " + kohad +
                ", summa: " + summa + " eurot" +
                ", v�it: " + v�it +
                ')';
    }

    public void osta(List<Integer> kohad, Buss buss) {
        // Fikseerib piletiostja piletite maksumuse
        // ja loosib, kas ta on v�itnud tasuta pileti
        this.kohad = kohad;
        int piletiteArv = kohad.size();
        if (piletiteArv > 3 && Math.random() < 0.05 * (piletiteArv - 3)) {
            this.summa = (piletiteArv - 1) * buss.getPiletiHind();
            this.v�it = true;
        } else {
            this.summa = piletiteArv * buss.getPiletiHind();
            this.v�it = false;
        }
    }
}
