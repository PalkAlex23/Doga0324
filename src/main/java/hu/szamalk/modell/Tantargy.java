package hu.szamalk.modell;

import java.io.Serializable;
import java.util.Objects;

public class Tantargy implements Serializable, Comparable<Tantargy> {
    private String nev, tanar1, tanar2, csakVizsga;
    private int kredit, felev;

    public Tantargy() {
        this("matematika", "Kovács István", "Teller Ede", "igen", 2, 3);
    }

    public Tantargy(String nev, String tanar1, String tanar2, String csakVizsga, int kredit, int felev) {
        this.nev = nev;
        this.tanar1 = tanar1;
        this.tanar2 = tanar2;
        ellenorzo(this.tanar2);
        this.csakVizsga = csakVizsga;
        if (kredit < 1 || kredit > 5) {
            throw new KreditKorlatException();
        }
        this.kredit = kredit;
        this.felev = felev;
    }

    public Tantargy(String sor) {
        String[] adatok = sor.split(";");
        this.nev = adatok[0];
        this.kredit = Integer.parseInt(adatok[1]);
        this.tanar1 = adatok[2];
        this.tanar2 = adatok[3];
        this.felev = Integer.parseInt(adatok[4]);
        this.csakVizsga = adatok[5];
    }

    public String getNev() {
        return nev;
    }

    public int getKredit() {
        return kredit;
    }

    public String getTanar1() {
        return tanar1;
    }

    public String getTanar2() {
        return tanar2;
    }

    public void ellenorzo(String tanar) {
        if (Objects.equals(tanar, this.tanar1)) {
            this.tanar2 = "-";
        }
    }

    @Override
    public String toString() {
        return "Tantargy{" +
                "tantargy='" + nev + '\'' +
                ", tanar1='" + tanar1 + '\'' +
                ", tanar2='" + tanar2 + '\'' +
                ", csakVizsga='" + csakVizsga + '\'' +
                ", kredit=" + kredit +
                ", felev=" + felev +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Tantargy tantargy = (Tantargy) o;
        return kredit == tantargy.kredit && felev == tantargy.felev && Objects.equals(nev, tantargy.nev);
    }

    @Override
    public int hashCode() {
        return Objects.hash(nev, kredit, felev);
    }

    @Override
    public int compareTo(Tantargy masik) {
        return this.kredit - masik.kredit;
    }
}
