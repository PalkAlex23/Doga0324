package hu.szamalk.modell;

import java.io.*;
import java.text.Collator;
import java.util.*;

public class Szak implements Comparator<Tantargy> {
    private String nev;
    private UUID azonosito;

    private ArrayList<Tantargy> targyak;

    public Szak(String nev) {
        this.nev = nev;
        this.targyak = new ArrayList<>();
    }

    public void ujIdGeneralas() {
        azonosito = UUID.randomUUID();
    }

    public String getNev() {
        return nev;
    }

    public void szakKiirasa() throws IOException {
        Szak sz1 = new Szak("Egy szak neve");
        sz1.ujIdGeneralas();
        ObjectOutputStream objBe = new ObjectOutputStream(new FileOutputStream("targyak.dat"));
        objBe.writeObject(sz1);
        System.out.println(sz1);
    }

    public void szakBeolvasasa() throws IOException, ClassNotFoundException {
        ObjectInputStream objKi = new ObjectInputStream(new FileInputStream("targyak.dat"));
        Szak sz1 = (Szak) objKi.readObject();
    }

    public List<Tantargy> getTargyakNevSzerint() {
        return new List<Tantargy>() {
            @Override
            public void sort(Comparator<Tantargy>) {
                List.super.sort(c);
            }
        }
    }

    public List<Tantargy> getTargyakKreditSzerint() {

    }

    public ArrayList<Tantargy> getTargyak() {
        return new ArrayList<>(targyak);
    }

    @Override
    public int compare(Tantargy egyik, Tantargy masik) {
        return egyik.getKredit() - masik.getKredit();
    }

    public static class NevKomparator implements Comparator<Tantargy> {
        @Override
        public int compare(Tantargy egyik, Tantargy masik) {
            Collator collator = Collator.getInstance();
            return collator.compare(egyik.getNev(), masik.getNev());
        }
    }

    public static class KreditKomparator implements Comparator<Tantargy> {
        @Override
        public int compare(Tantargy egyik, Tantargy masik) {
            return egyik.getKredit() - masik.getKredit();
        }
    }
}
