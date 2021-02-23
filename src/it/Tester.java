package it;

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class Tester {

    public static void main(String[] args) {
        int top;
        Random rnd = new Random();
        Scanner sc = new Scanner(System.in);
        String[] semi = {"H", "C", "S", "D"};
        String[] valore = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "0", "J", "Q", "K"};
        ArrayList<String> carteGiocatore = new ArrayList<String>();
        ArrayList<String> carteBanco = new ArrayList<String>();
        final int BLACKJACK = 21;

        Tester player1 = new Tester();

        boolean t = true;
        int creditiIniziali = 0;
        int creditiScommessi = 0;
        int creditiFinali = 0;
        int totaleGiocatore = 0;
        int totaleBanco = 0;
        int puntiGiocatore = 0;

        boolean stai;

        int lunghezzaMax = semi.length * valore.length * 2;
        String[] mazzo = new String[lunghezzaMax];
        top = mazzo.length - 1;

        player1.creaMazzo(semi, valore, mazzo);
        player1.mescola(rnd, mazzo);

        while(creditiFinali<5){
            System.out.println("Quanti crediti vuoi caricare? (numero minimo 5)");
            creditiFinali = sc.nextInt();
        }

        while(creditiFinali>0){
            System.out.println("Quanti crediti vuoi puntare?");
            creditiScommessi = sc.nextInt();
            System.out.println("Hai puntato: "+ creditiScommessi + " crediti, Buona Fortuna!");

            for(int i = 0; i<2; i++) {
                carteGiocatore.add(player1.pescaCarta(mazzo, top));
                puntiGiocatore = player1.sommaPunti(player1.pescaCarta(mazzo, top), puntiGiocatore);
                top--;
            }

            stai = true;

            do{

                System.out.println("Possiedi "+ puntiGiocatore +" punti, vuoi pescare una carta o stare? (1/2)");
                if(sc.nextInt()==1) {
                    carteGiocatore.add(player1.pescaCarta(mazzo, top));
                    puntiGiocatore = player1.sommaPunti(player1.pescaCarta(mazzo, top), puntiGiocatore);
                    top--;
                }
                else stai = false;

            }while(stai&&puntiGiocatore<=21);

            System.out.println("Hai pescato: " + carteGiocatore);
            carteGiocatore.clear();
            puntiGiocatore=0;
        }
    }

    private void creaMazzo(String[] semi, String[] valore, String[] mazzo) {
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

    private void mescola(Random rnd, String[] mazzo) {
        int scambia = 5000;

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

    public String pescaCarta(String[] mazzo, int top) {
        String cartaPescata = null;
        if (mazzo.length==0)
            throw new IllegalStateException("Impossibile pescare una dal mazzo");
        else
            cartaPescata = mazzo[top];
        return cartaPescata;
    }

    public int sommaPunti(String carta, int puntiGiocatore){
        Scanner sc = new Scanner(System.in);
        if(carta.contains("A")){
            if(puntiGiocatore<11) {
                System.out.println("Attualmente hai " + puntiGiocatore + " vuoi far valere la carta 1 o 11?");
                if (sc.nextInt() == 1)
                    puntiGiocatore += 1;
                else puntiGiocatore += 11;
            } else puntiGiocatore+=1;

        } else if (carta.contains("2")){
            puntiGiocatore+=2;
        } else if (carta.contains("3")){
            puntiGiocatore+=3;
        } else if (carta.contains("4")){
            puntiGiocatore+=4;
        } else if (carta.contains("5")){
            puntiGiocatore+=5;
        } else if (carta.contains("6")){
            puntiGiocatore+=6;
        } else if (carta.contains("7")){
            puntiGiocatore+=7;
        } else if (carta.contains("8")){
            puntiGiocatore+=8;
        } else if (carta.contains("9")){
            puntiGiocatore+=9;
        } else{
            puntiGiocatore+=10;
        }

        return puntiGiocatore;
    }
}