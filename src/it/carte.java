package it;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class carte {
    private static int top;
    public static void main(String[] args) {

        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        String[] semi = {"H", "C", "S", "D"};
        String[] valore = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "0", "J", "Q", "K"};
        ArrayList<String> carteGiocatore = new ArrayList<String>();
        ArrayList<String> carteBanco = new ArrayList<String>();
        final int BLACKJACK = 21;

        boolean t = true;
        int creditiIniziali = 0;
        int creditiScommessi = 0;
        int creditiFinali = 0;
        int totaleGiocatore = 0;
        int totaleBanco = 0;

        int lunghezzaMax = semi.length * valore.length * 2;
        String[] mazzo = new String[lunghezzaMax];
        top = mazzo.length - 1;

        creaMazzo(semi, valore, mazzo);
        mescola(rnd, mazzo);

        while(creditiFinali<5){
            System.out.println("Quanti crediti vuoi caricare? (numero minimo 5)");
            creditiFinali = sc.nextInt();
        }

        while(creditiFinali>0){
            System.out.println("Quanti crediti vuoi puntare?");
            creditiScommessi = sc.nextInt();
            System.out.println("Hai puntato: "+ creditiScommessi + " crediti, Buona Fortuna!");

            for(int i = 0; i<2; i++)
            {
                carteGiocatore.add(pescaCarta(mazzo, top));
                top--;
            }
            System.out.println("Hai pescato: " + carteGiocatore);
        }
    }

    private static void creaMazzo(String[] semi, String[] valore, String[] mazzo) {
        int k = 0;
        int j = 0;
        for (int l = 0; l != 2; l++) {
            for (int i = 0; i < 4; i++) {
                do {
                    mazzo[k] = valore[j] + semi[i];
                    j++;
                    k++;
                } while (j < 13);
                j = 0;
            }
        }

        /*System.out.println("STAMPO IL MAZZO");
        System.out.println("");

        for (int i = 0; i < 104; i++) {
            System.out.println(mazzo[i]);
        }*/
    }

    private static void mescola(Random rnd, String[] mazzo) {
        int scambia = 2000;

        int indiceUno;
        int indiceDue;
        String variabileSupporto;

        for (int i = 0; i != scambia; i++) {
            indiceUno = rnd.nextInt(mazzo.length - 1);
            indiceDue = rnd.nextInt(mazzo.length - 1);

            variabileSupporto = mazzo[indiceUno];
            mazzo[indiceUno] = mazzo[indiceDue];
            mazzo[indiceDue] = variabileSupporto;
        }

        /*System.out.println("");
        System.out.println("MESCOLO LE CARTE");
        System.out.println("");

        for (int i = 0; i < mazzo.length; i++) {
            System.out.println(mazzo[i]);
        }*/
    }

    public static String pescaCarta(String[] mazzo, int top) {
        String cartaPescata = null;
        if (mazzo.length==0)
            throw new IllegalStateException("Impossibile pescare una dal mazzo");
        else
            cartaPescata = mazzo[top--];
        return cartaPescata;
    }
}

/*
    carteGiocatore.add(pescaCarta(mazzo, top));
    top--;
    carteGiocatore.add(pescaCarta(mazzo, top));
    System.out.println(carteGiocatore);
*/
