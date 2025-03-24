package hu.szamalk.modell;

import java.io.Serializable;

public class Tantargy implements Serializable, Comparable<Tantargy> {
    private String nev, tanar1, tanar2, csakVizsga;
    private int kredit, felev;

    public Tantargy() {
        this("tantargyak.txt");
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
    public int compareTo(Tantargy o) {
        return 0;
    }
}
