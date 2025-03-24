package hu.szamalk.modell;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.text.Collator;
import java.util.*;

public class Szak implements Comparator<Tantargy> {
    private String nev;
    private UUID azonosito;

    public ArrayList<Tantargy> targyak;

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
        sz1.ujIdGeneralas();
        System.out.println(sz1);
    }

    /*public List<Tantargy> getTargyakNevSzerint() {
        *//* Be kell importálni valahogy a komparátort *//*
    }

    public List<Tantargy> getTargyakKreditSzerint() {
        *//* Be kell importálni valahogy a komparátort *//*
    }*/

    public void statisztika() throws IOException {
        String irhato = "statisztika.txt";
        String szoveg = "";
        int kulonbTargy = 0;
        int osszKredit = 0;
        int minKredit = targyak.getFirst().getKredit();
        int maxKredit = targyak.getFirst().getKredit();
        for (Tantargy tantargy : targyak) {
            if (tantargy.getNev() != "NÉV") {
               if (tantargy.getKredit() < minKredit) {
                   minKredit = tantargy.getKredit();
               }

               if (tantargy.getKredit() > maxKredit) {
                   maxKredit = tantargy.getKredit();
               }
               osszKredit += tantargy.getKredit();
            }
        }

        Files.write(Path.of(irhato), szoveg.getBytes());
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
