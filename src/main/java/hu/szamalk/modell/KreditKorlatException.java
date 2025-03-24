package hu.szamalk.modell;

public class KreditKorlatException extends RuntimeException {
    public KreditKorlatException() {
        System.out.print("A kredit szám nem 1 és 5 között van!");
    }
}
