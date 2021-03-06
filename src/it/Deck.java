package it;

import java.util.ArrayList;
import java.util.Random;


public class Deck {
    private ArrayList<Card> Deck;

    String[] suit = {"H", "C", "S", "D"};
    String[] value = {"A", "2", "3", "4", "5", "6", "7", "8", "9", "0", "J", "Q", "K"};

    public void buildDeck() {

        Deck = new ArrayList<Card>();

        int k = 0;
        int j = 0;
        for (int l = 0; l != 2; l++) {
            for (int i = 0; i < 4; i++) {
                do {
                    Card card = new Card(value[j], suit[i]);
                    Deck.add(card);
                    j++;
                    k++;
                } while (j < 13);
                j = 0;
            }
        }

        Deck.add(Deck.get(1));
    }

    public void printDeck() {
        for (int i = 0; i < 104; i++) {
            System.out.println(Deck.get(i).getValue()+Deck.get(i).getSuit());
        }
    }

    public void shuffle() {
        int scambia = 1000000;

        int indiceUno;
        int indiceDue;
        String variabileSupporto;
        Random rnd = new Random();

        for (int i = 0; i != scambia; i++) {
            indiceUno = rnd.nextInt(Deck.size() - 1);
            indiceDue = rnd.nextInt(Deck.size() - 1);

            //usato indice 104 come supporto
            Deck.set(104, Deck.get(indiceUno));
            Deck.set(indiceUno, Deck.get(indiceDue));
            Deck.set(indiceDue, Deck.get(104));
        }

    }

}
