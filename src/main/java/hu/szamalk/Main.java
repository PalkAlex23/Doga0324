package hu.szamalk;

import hu.szamalk.modell.Szak;
import hu.szamalk.modell.Tantargy;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.List;

public class Main {
    private List<Tantargy> tantargyak;

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        new Main();
    }

    public Main() throws IOException, ClassNotFoundException {
        beolvasas();
        Szak sz1 = new Szak("Egy bizonyos szak neve");
        sz1.ujIdGeneralas();
        sz1.szakKiirasa();
        sz1.szakBeolvasasa();
    }

    private void beolvasas() {
        String fn = "tantargyak.txt";
        List<String> sorok = null;
        try {
            sorok = Files.readAllLines(Path.of(fn));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
        sorok.forEach(t -> {
            Tantargy tantargy = new Tantargy(t);
            tantargyak.add(tantargy);
        });
    }
}