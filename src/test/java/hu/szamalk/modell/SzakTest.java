package hu.szamalk.modell;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.List;

class SzakTest {
    Szak szak;
    @BeforeEach
    void ini(){
        szak = new Szak("egy szak neve");
    }

    @Test
    void testSzakTargyNevek(){
        for (Tantargy tantargy : szak.targyak) {
            Assertions.assertTrue(tantargy.getNev().length() > 3);
        }
    }

    @Test
    void testGetTargyak(){
        List<Tantargy> targyak = szak.getTargyak();
        int eredeti = targyak.size();
        targyak.add(new Tantargy());
        Assertions.assertTrue(eredeti == szak.getTargyak().size());
    }

    @Test
    void testAzonosTanar() {
        System.out.println("Egy tantárgyon belül nem lehet kettő ugyanolyan tanár");

        Tantargy tantargy = new Tantargy("fizika", "Németh Sándor", "Németh Sándor", "nem", 3, 4);
        Assertions.assertTrue(tantargy.getTanar1() != tantargy.getTanar2(), "Ugyanaz a tanár van beírva mind a két helyen!");
    }

    @Test
    void testSajatKivetel() {
        System.out.println("A tantárgy kreditje 1 és 5 közé essen");

        Assertions.assertThrows(KreditKorlatException.class, () -> new Tantargy("fizika", "Ónodi Elza", "Németh Sándor", "nem", 6, 3), "Nem megfelelő expection érkezett");
    }
}